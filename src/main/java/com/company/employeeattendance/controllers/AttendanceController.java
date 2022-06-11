package com.company.employeeattendance.controllers;

import com.company.employeeattendance.dtos.AttendanceDto;
import com.company.employeeattendance.entities.Attendance;
import com.company.employeeattendance.services.AttendanceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/attendance/")
public class AttendanceController extends BaseController<Attendance, AttendanceDto> {

    private final AttendanceService attendanceService;

    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
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
}
