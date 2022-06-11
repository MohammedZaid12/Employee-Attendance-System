package com.company.employeeattendance.controllers;

import com.company.employeeattendance.dtos.ShiftDto;
import com.company.employeeattendance.entities.Shift;
import com.company.employeeattendance.services.ShiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "shift/")
public class ShiftController extends BaseController<Shift, ShiftDto> {

    @Autowired
    private ShiftService shiftService;

    @Override
    public String findAll(Model model) throws Exception {
        model.addAttribute("shifts", shiftService.findAll());
        return null;
    }

    @Override
    public String findAllActive(Model model) throws Exception {
        model.addAttribute("shifts", shiftService.findAllActive());
        return null;
    }

    @Override
    public String getById(Integer id, Model model) {
        model.addAttribute("shifts", shiftService.findById(id));
        return null;
    }

    @Override
    public String saveOrUpdate(ShiftDto shiftDto, Model model) {
        shiftService.saveByDto(shiftDto);
        return null;
    }
}
