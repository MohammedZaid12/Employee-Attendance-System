package com.company.employeeattendance.controllers;

import com.company.employeeattendance.dtos.DesignationDto;
import com.company.employeeattendance.entities.Designation;
import com.company.employeeattendance.services.DepartmentService;
import com.company.employeeattendance.services.DesignationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/designation")
public class DesignationController extends BaseController<Designation, DesignationDto> {

    private final DesignationService designationService;
    private final DepartmentService departmentService;

    public DesignationController(DesignationService designationService, DepartmentService departmentService) {
        this.designationService = designationService;
        this.departmentService = departmentService;
    }

    @Override
    public String findAll(Model model) throws Exception {
        model.addAttribute("designations", designationService.findAll());
        return "designation/list-designation";
    }

    @Override
    public String findAllActive(Model model) throws Exception {
        model.addAttribute("designations", designationService.findAllActive());
        return "designation/list-designation";
    }

    @GetMapping(value = "/add")
    public String addDesignation(Model model) {
        model.addAttribute("designationDto", new DesignationDto());
        model.addAttribute("departments", departmentService.findAll());
        return "designation/add-designation";
    }

    @Override
    public String getById(@PathVariable  Integer id, Model model) {
        model.addAttribute("designationDto", designationService.findByIdDto(id));
        model.addAttribute("departments", departmentService.findAll());
        return "designation/edit-designation";
    }

    @Override
    public String saveOrUpdate(@ModelAttribute("designationDto") DesignationDto designationDto, Model model) {
        designationService.saveByDto(designationDto);
        return "redirect:/designation";
    }
}
