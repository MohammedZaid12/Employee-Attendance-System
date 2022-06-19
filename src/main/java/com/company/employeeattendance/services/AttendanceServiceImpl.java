package com.company.employeeattendance.services;

import com.company.employeeattendance.constants.DateFormats;
import com.company.employeeattendance.dtos.AttendanceDto;
import com.company.employeeattendance.dtos.MasterAttendanceList;
import com.company.employeeattendance.entities.Attendance;
import com.company.employeeattendance.entities.Exemption;
import com.company.employeeattendance.entities.Shift;
import com.company.employeeattendance.entities.employee.Employee;
import com.company.employeeattendance.entities.employee.EmployeeRule;
import com.company.employeeattendance.entities.employee.EmployeeShift;
import com.company.employeeattendance.enums.AttendanceStatus;
import com.company.employeeattendance.repositories.AttendanceRepository;
import com.company.employeeattendance.services.employee.EmployeeRuleService;
import com.company.employeeattendance.services.employee.EmployeeService;
import com.company.employeeattendance.services.employee.EmployeeShiftService;
import com.company.employeeattendance.utils.DateUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    private final AttendanceRepository attendanceRepository;
    private final EmployeeService employeeService;
    private final EmployeeShiftService employeeShiftService;
    private final EmployeeRuleService employeeRuleService;
    private final ExemptionService exemptionService;

    public AttendanceServiceImpl(AttendanceRepository attendanceRepository, EmployeeService employeeService, EmployeeShiftService employeeShiftService,
                                 EmployeeRuleService employeeRuleService, ExemptionService exemptionService) {
        this.attendanceRepository = attendanceRepository;
        this.employeeService = employeeService;
        this.employeeRuleService = employeeRuleService;
        this.employeeShiftService = employeeShiftService;
        this.exemptionService = exemptionService;
    }

    @Override
    public List<Attendance> findAll() {
        return attendanceRepository.findAll();
    }

    @Override
    public List<Attendance> findAllActive() {
        return attendanceRepository.findAllActiveIs(true);
    }

    @Override
    public Attendance findById(Integer id) {
        return attendanceRepository.getById(id);
    }

    @Override
    public AttendanceDto findByIdDto(Integer id) {
        return null;
    }

    @Override
    public Attendance save(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    @Override
    public AttendanceDto saveByDto(AttendanceDto attendanceDto) {
        Attendance attendance = attendanceDto.getId() == null ? new Attendance() : findById(attendanceDto.getId());
        BeanUtils.copyProperties(attendanceDto, attendance);
        Attendance saved = save(attendance);
        attendanceDto.setId(saved.getId());
        return attendanceDto;
    }

    @Override
    public MasterAttendanceList generateAttendanceList(Date date, Integer deptId) {
        MasterAttendanceList masterAttendanceList = new MasterAttendanceList();
        List<AttendanceDto> attendanceDtoList = new ArrayList<>();
        for (Employee employee : employeeService.findAllByDepartmentId(deptId, date)) {
            AttendanceDto attendanceDto = new AttendanceDto();
            attendanceDto.setEmployee(employee);
            attendanceDto.setAttendanceDate(date);
            attendanceDtoList.add(attendanceDto);
        }
        masterAttendanceList.setAttendanceList(attendanceDtoList);
        return masterAttendanceList;
    }

    @Override
    public List<Attendance> saveAttendance(MasterAttendanceList masterAttendanceList) {
        List<Attendance> attendances = new ArrayList<>();
        Date attendanceDate = masterAttendanceList.getAttendanceList().get(0).getAttendanceDate();

        List<Integer> employeeIds = masterAttendanceList.getAttendanceList()
                .stream().map(attendanceDto -> attendanceDto.getEmployeeId()).collect(Collectors.toList());

        Map<Integer, EmployeeShift> mapOfEmployeeOnDate = employeeShiftService.getMapOfEmployeeOnDate(attendanceDate, employeeIds);

        Map<Integer, EmployeeRule> employeeRuleMap = employeeRuleService.getMapOfEmployeeRuleByDate(employeeIds, attendanceDate);

        List<Exemption> exemptionList = exemptionService.findAllByExemptionDate(attendanceDate);

        for (AttendanceDto attendanceDto : masterAttendanceList.getAttendanceList()) {

            Shift shift = mapOfEmployeeOnDate.get(attendanceDto.getEmployeeId()).getShift();
            EmployeeRule employeeRule = employeeRuleMap.get(attendanceDto.getEmployeeId());
            Attendance attendance = attendanceRepository.findByEmployeeIdAndAttendanceDate(attendanceDto.getEmployeeId(),
                    attendanceDto.getAttendanceDate()) != null ? attendanceRepository.findByEmployeeIdAndAttendanceDate(attendanceDto.getEmployeeId(),
                    attendanceDto.getAttendanceDate()) : new Attendance();

            attendance.setAttendanceDate(attendanceDto.getAttendanceDate());
            attendance.setEmployee(employeeService.findById(attendanceDto.getEmployeeId()));
            attendance.setCurrentUser();

            LocalTime shiftStartTime = LocalTime.parse(shift.getTimeStart(), DateFormats.HH_mm_ss);
            LocalTime shiftEndTime = LocalTime.parse(shift.getTimeEnd(), DateFormats.HH_mm_ss);
            LocalTime shiftLateTime = LocalTime.parse(shift.getLateTime(), DateFormats.HH_mm_ss);
            LocalTime shiftHalfDayTime = LocalTime.parse(shift.getHalfDayTime(), DateFormats.HH_mm_ss);
            LocalTime shiftLastTimeAllowed = LocalTime.parse(shift.getLastTimeAllowed(), DateFormats.HH_mm_ss);

            LocalTime checkIn = null;
            if (!attendanceDto.getCheckIn().isEmpty() && attendanceDto.getCheckIn() != null) {
                checkIn = LocalTime.parse(attendanceDto.getCheckIn(), DateFormats.HH_mm);
            } else {
                checkIn = LocalTime.parse(shift.getDefaultCheckIn(), DateFormats.HH_mm_ss);
            }

            LocalTime checkOut = null;
            if (!attendanceDto.getCheckOut().isEmpty() && attendanceDto.getCheckOut() != null) {
                checkOut = LocalTime.parse(attendanceDto.getCheckOut(), DateFormats.HH_mm);
            } else {
                checkOut = LocalTime.parse(shift.getDefaultCheckout(), DateFormats.HH_mm_ss);
            }
            if (attendanceDto.getAttendanceStatus().equals(AttendanceStatus.PRESENT)) {
                checkEmployeeIsPresent(attendance, checkIn, checkOut, shiftLateTime, shiftHalfDayTime, shiftLastTimeAllowed, shiftStartTime, shiftEndTime, employeeRule, shift);
            } else if (attendanceDto.getAttendanceStatus().equals(AttendanceStatus.EXEMPTED)) {
                exemptionList.stream().filter(exemption -> exemption.getEmployee().getId() == attendanceDto.getEmployeeId())
                        .findFirst().ifPresentOrElse(exemption -> {
                            attendance.setAttendanceStatus(AttendanceStatus.EXEMPTED);
                        }, () -> {
                            attendance.setAttendanceStatus(AttendanceStatus.ABSENT);
                        });
            } else {
                if (!employeeRuleService.isWorkingDay(employeeRule, attendanceDate)) {
                    attendance.setAttendanceStatus(AttendanceStatus.REST_DAY);
                } else {
                    attendance.setAttendanceStatus(AttendanceStatus.ABSENT);
                }
            }
            attendances.add(attendance);
        }
        return attendanceRepository.saveAll(attendances);
    }

    private void checkEmployeeIsPresent(Attendance attendance, LocalTime checkIn,
                                        LocalTime checkOut, LocalTime shiftLateTime, LocalTime shiftHalfDayTime,
                                        LocalTime shiftLastTimeAllowed, LocalTime shiftStartTime, LocalTime shiftEndTime, EmployeeRule employeeRule, Shift shift) {

        if (checkIn.isBefore(shiftLateTime)) {
            attendance.setAttendanceStatus(AttendanceStatus.PRESENT);
        } else if (checkIn.equals(shiftLateTime) || (checkIn.isAfter(shiftLateTime) && checkIn.isBefore(shiftHalfDayTime))) {
            attendance.setAttendanceStatus(AttendanceStatus.LATE);
        } else if (checkIn.equals(shiftHalfDayTime) || (checkIn.isAfter(shiftHalfDayTime) && checkIn.isBefore(shiftLastTimeAllowed))) {
            attendance.setAttendanceStatus(AttendanceStatus.HALF_DAY);
        } else if (checkIn.equals(shiftLastTimeAllowed) || checkIn.isAfter(shiftLastTimeAllowed)) {
            attendance.setAttendanceStatus(AttendanceStatus.ABSENT);
        }
        attendance.setTotalWorkingHours(DateUtils.getDifferenceBetweenTwoTime(checkIn, checkOut));
        if (!employeeRuleService.isWorkingDay(employeeRule, attendance.getAttendanceDate())) {
            attendance.setAttendanceStatus(AttendanceStatus.OFF_DAY_PRESENT);
            attendance.setOvertimeHours(attendance.getTotalWorkingHours());
        } else {
            if (attendance.getTotalWorkingHours() > shift.getShiftDuration()) {
                attendance.setOvertimeHours(DateUtils.getDifferenceBetweenTwoTime(checkIn, shiftStartTime) +
                        DateUtils.getDifferenceBetweenTwoTime(shiftEndTime, checkOut));
            }
        }
        attendance.setCheckIn(checkIn.format(DateFormats.HH_mm));
        attendance.setCheckOut(checkOut.format(DateFormats.HH_mm));
    }

}
