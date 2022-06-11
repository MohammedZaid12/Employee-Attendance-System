package com.company.employeeattendance.controllers;

import com.company.employeeattendance.dtos.ShiftDto;
import com.company.employeeattendance.entities.Shift;
import com.company.employeeattendance.services.ShiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/shift")
public class ShiftController extends BaseController<Shift, ShiftDto> {

    private final ShiftService shiftService;

    public ShiftController(ShiftService shiftService) {
        this.shiftService = shiftService;
    }

    @Override
    public String findAll(Model model) throws Exception {
        model.addAttribute("shifts", shiftService.findAll());
        return "shift/list-shift";
    }

    @Override
    public String findAllActive(Model model) throws Exception {
        model.addAttribute("shifts", shiftService.findAllActive());
        return "shift/list-shift";
    }

    @GetMapping(value = "/add")
    public String addShift(Model model) {
        model.addAttribute("shiftDto", new ShiftDto());
        return "shift/add-shift";
    }

    @Override
    public String getById(@PathVariable Integer id, Model model) {
        model.addAttribute("shifts", shiftService.findById(id));
        model.addAttribute("shiftDto", shiftService.findByIdDto(id));
        return "shift/edit-shift";
    }

    @Override
    public String saveOrUpdate(@ModelAttribute("shiftDto") ShiftDto shiftDto, Model model) {
        shiftService.saveByDto(shiftDto);
        return "redirect:/shift";
    }
}
