package com.company.employeeattendance.controllers;

import com.company.employeeattendance.dtos.AttendanceDto;
import com.company.employeeattendance.dtos.MasterAttendanceList;
import com.company.employeeattendance.entities.Attendance;
import com.company.employeeattendance.enums.AttendanceStatus;
import com.company.employeeattendance.services.AttendanceService;
import com.company.employeeattendance.services.DepartmentService;
import com.company.employeeattendance.utils.DateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping(value = "/attendance")
public class AttendanceController extends BaseController<Attendance, AttendanceDto> {

    private final AttendanceService attendanceService;
    private final DepartmentService departmentService;

    public AttendanceController(AttendanceService attendanceService, DepartmentService departmentService) {
        this.attendanceService = attendanceService;
        this.departmentService = departmentService;
    }

    @Override
    public String findAll(Model model) throws Exception {
        model.addAttribute("attendanceList", attendanceService.findAll());
        return null;
    }

    @Override
    public String findAllActive(Model model) throws Exception {
        model.addAttribute("attendanceList", attendanceService.findAllActive());
        return null;
    }

    @Override
    public String getById(Integer id, Model model) {
        model.addAttribute("attendance", attendanceService.findById(id));
        return null;
    }

    @Override
    public String saveOrUpdate(AttendanceDto attendanceDto, Model model) {
        attendanceService.saveByDto(attendanceDto);
        return null;
    }

    @GetMapping(value = "/mark-attendance")
    public String markAttendance(Model model) {
        model.addAttribute("departments", departmentService.findAll());
        model.addAttribute("months", DateUtils.getMonths());
        model.addAttribute("years", DateUtils.getYearListFromYear(LocalDate.now().getYear()));
        return "attendance/mark-attendance";
    }

    @PostMapping(value = "/mark-attendance")
    public String markAttendancePost(Model model, @RequestParam("deptId") Integer deptId, @RequestParam("month") String month,
                                     @RequestParam("year") Integer year, @RequestParam("date") Date date) {
        model.addAttribute("departments", departmentService.findAll());
        model.addAttribute("months", DateUtils.getMonths());
        model.addAttribute("years", DateUtils.getYearListFromYear(LocalDate.now().getYear()));
        model.addAttribute("masterList", attendanceService.generateAttendanceList(date, deptId));
        model.addAttribute("attendanceStatus", AttendanceStatus.getListForMarkingAttendance());
        model.addAttribute("selectedDept", deptId);
        model.addAttribute("selectedMonth", month);
        model.addAttribute("selectedYear", year);
        model.addAttribute("selectedDate", date);
        return "attendance/mark-attendance";
    }

    @PostMapping(value = "/save-attendance")
    public String saveAttendance(Model model, @ModelAttribute("masterList") MasterAttendanceList masterAttendanceList) {
        model.addAttribute("departments", departmentService.findAll());
        model.addAttribute("months", DateUtils.getMonths());
        model.addAttribute("years", DateUtils.getYearListFromYear(LocalDate.now().getYear()));
        model.addAttribute("attendance", attendanceService.saveAttendance(masterAttendanceList));
        return "redirect:/attendance/mark-attendance";
    }
}
