package com.company.employeeattendance.controllers.employee;

import com.company.employeeattendance.controllers.BaseController;
import com.company.employeeattendance.dtos.employee.EmployeeDto;
import com.company.employeeattendance.entities.employee.Employee;
import com.company.employeeattendance.services.employee.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController extends BaseController<Employee, EmployeeDto> {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public String findAll(Model model) throws Exception {
        model.addAttribute("employees", employeeService.findAll());
        return "employee";
    }

    @Override
    public String findAllActive(Model model) throws Exception {
        model.addAttribute("activeEmployees", employeeService.findAllActive());
        return "";
    }

    @Override
    public String getById(Integer id, Model model) {
        model.addAttribute("employee", employeeService.findById(id));
        return "";
    }

    @Override
    public String saveOrUpdate(EmployeeDto employee, Model model) {
        employeeService.saveByDto(employee);
        return "";
    }
}
