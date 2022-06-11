package com.company.employeeattendance.controllers;

import com.company.employeeattendance.dtos.HolidayDto;
import com.company.employeeattendance.entities.Holiday;
import com.company.employeeattendance.services.HolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/holiday/")
public class HolidayController extends BaseController<Holiday, HolidayDto> {

    @Autowired
    private HolidayService holidayService;

    @Override
    public String findAll(Model model) throws Exception {
        model.addAttribute("holidays", holidayService.findAll());
        return null;
    }

    @Override
    public String findAllActive(Model model) throws Exception {
        model.addAttribute("holidays", holidayService.findAllActive());
        return null;
    }

    @Override
    public String getById(Integer id, Model model) {
        model.addAttribute("holiday", holidayService.findById(id));
        return null;
    }

    @Override
    public String saveOrUpdate(HolidayDto holidayDto, Model model) {
        holidayService.saveByDto(holidayDto);
        return null;
    }
}
