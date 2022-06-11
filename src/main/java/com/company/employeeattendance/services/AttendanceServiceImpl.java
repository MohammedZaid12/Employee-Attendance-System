package com.company.employeeattendance.services;

import com.company.employeeattendance.dtos.AttendanceDto;
import com.company.employeeattendance.entities.Attendance;
import com.company.employeeattendance.repositories.AttendanceRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    private final AttendanceRepository attendanceRepository;

    public AttendanceServiceImpl(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
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
}
