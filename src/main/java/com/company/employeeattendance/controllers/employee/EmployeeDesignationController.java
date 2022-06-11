package com.company.employeeattendance.controllers.employee;

import com.company.employeeattendance.controllers.BaseController;
import com.company.employeeattendance.dtos.employee.EmployeeDesignationDto;
import com.company.employeeattendance.entities.employee.EmployeeDesignation;
import com.company.employeeattendance.services.employee.EmployeeDesignationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/employee-designation/")
public class EmployeeDesignationController extends BaseController<EmployeeDesignation, EmployeeDesignationDto> {

    private final EmployeeDesignationService employeeDesignationService;

    public EmployeeDesignationController(EmployeeDesignationService employeeDesignationService) {
        this.employeeDesignationService = employeeDesignationService;
    }

    @Override
    public String findAll(Model model) throws Exception {
        model.addAttribute("employeeDesignationList", employeeDesignationService.findAll());
        return null;
    }

    @Override
    public String findAllActive(Model model) throws Exception {
        model.addAttribute("employeeDesignationList", employeeDesignationService.findAllActive());
        return null;
    }

    @Override
    public String getById(Integer id, Model model) {
        model.addAttribute("employeeDesignation", employeeDesignationService.findById(id));
        return null;
    }

    @Override
    public String saveOrUpdate(EmployeeDesignationDto employeeDesignationDto, Model model) {
        employeeDesignationService.saveByDto(employeeDesignationDto);
        return null;
    }
}
