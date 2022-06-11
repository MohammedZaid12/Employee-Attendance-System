package com.company.employeeattendance.controllers.employee;

import com.company.employeeattendance.controllers.BaseController;
import com.company.employeeattendance.dtos.employee.EmployeeRuleDto;
import com.company.employeeattendance.entities.employee.EmployeeRule;
import com.company.employeeattendance.services.employee.EmployeeRuleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/employee-rule")
public class EmployeeRuleController extends BaseController<EmployeeRule, EmployeeRuleDto> {

    private final EmployeeRuleService employeeRuleService;

    public EmployeeRuleController(EmployeeRuleService employeeRuleService) {
        this.employeeRuleService = employeeRuleService;
    }

    @Override
    public String findAll(Model model) throws Exception {
        model.addAttribute("employeeRuleList", employeeRuleService.findAll());
        return null;
    }

    @Override
    public String findAllActive(Model model) throws Exception {
        model.addAttribute("employeeRuleList", employeeRuleService.findAllActive());
        return null;
    }

    @Override
    public String getById(Integer id, Model model) {
        model.addAttribute("employeeRule", employeeRuleService.findById(id));
        return null;
    }

    @Override
    public String saveOrUpdate(EmployeeRuleDto employeeRuleDto, Model model) {
        employeeRuleService.saveByDto(employeeRuleDto);
        return null;
    }
}
