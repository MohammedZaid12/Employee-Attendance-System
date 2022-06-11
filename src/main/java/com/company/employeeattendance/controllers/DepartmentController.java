package com.company.employeeattendance.controllers;

import com.company.employeeattendance.dtos.DepartmentDto;
import com.company.employeeattendance.entities.Department;
import com.company.employeeattendance.services.DepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/department")
public class DepartmentController extends BaseController<Department, DepartmentDto> {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Override
    public String findAll(Model model) throws Exception {
        model.addAttribute("departments", departmentService.findAll());
        return "department/list-department";
    }

    @Override
    public String findAllActive(Model model) throws Exception {
        model.addAttribute("departments", departmentService.findAllActive());
        return null;
    }

    @Override
    public String getById(@PathVariable Integer id, Model model) {
        model.addAttribute("departmentDto", departmentService.findByIdDto(id));
        return "department/edit-department";
    }

    @GetMapping(value = "add")
    public String create(Model model) {
        model.addAttribute("departmentDto", new DepartmentDto());
        return "department/add-department";
    }

    @Override
    public String saveOrUpdate(@ModelAttribute("departmentDto") DepartmentDto departmentDto, Model model) {
        departmentService.saveByDto(departmentDto);
        return "redirect:/department";
    }
}
