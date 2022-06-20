package com.company.employeeattendance.controllers.employee;

import com.company.employeeattendance.controllers.BaseController;
import com.company.employeeattendance.dtos.employee.EmployeeDto;
import com.company.employeeattendance.entities.employee.Employee;
import com.company.employeeattendance.enums.Gender;
import com.company.employeeattendance.enums.Religion;
import com.company.employeeattendance.services.DesignationService;
import com.company.employeeattendance.services.RuleService;
import com.company.employeeattendance.services.ShiftService;
import com.company.employeeattendance.services.employee.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController extends BaseController<Employee, EmployeeDto> {

    private final EmployeeService employeeService;
    private final RuleService ruleService;
    private final ShiftService shiftService;
    private final DesignationService designationService;

    public EmployeeController(EmployeeService employeeService, RuleService ruleService,
                              ShiftService shiftService, DesignationService designationService) {
        this.employeeService = employeeService;
        this.ruleService = ruleService;
        this.shiftService = shiftService;
        this.designationService = designationService;
    }

    @Override
    public String findAll(Model model) throws Exception {
        model.addAttribute("employees", employeeService.findAll());
        return "employee/list-employee";
    }

    @Override
    public String findAllActive(Model model) throws Exception {
        model.addAttribute("employees", employeeService.findAllActive());
        return "employee/list-employee";
    }

    @GetMapping(value = "/add")
    public String addEmployee(Model model) {
        model.addAttribute("employeeDto", new EmployeeDto());
        model.addAttribute("religions", Religion.values());
        model.addAttribute("designations", designationService.findAll());
        model.addAttribute("rules", ruleService.findAll());
        model.addAttribute("shifts", shiftService.findAll());
        model.addAttribute("genders", Gender.values());
        return "employee/add-employee";
    }

    @Override
    public String getById(@PathVariable Integer id, Model model) {
        model.addAttribute("employeeDto", employeeService.findByIdDto(id));
        model.addAttribute("religions", Religion.values());
        model.addAttribute("genders", Gender.values());
        return "employee/edit-employee";
    }

    @Override
    public String saveOrUpdate(@ModelAttribute("employee") EmployeeDto employee, Model model) {
        employeeService.saveByDto(employee);
        return "redirect:/employee";
    }

    @GetMapping(value = "/generate-list-for-dropdown")
    @ResponseBody
    public Map<Integer, String> generateEmployeeList(@RequestParam("deptId") Integer deptId,
                                                     @RequestParam("month") String month, @RequestParam("year") Integer year,
                                                     @RequestParam("startDate") Date startDate, @RequestParam("endDate") Date endDate) {
        Map<Integer, String> employeeMap = new HashMap<>();
        for (Employee employee : employeeService.findAllByDepartmentId(deptId, startDate)) {
            employeeMap.put(employee.getId(), employee.getUser().getFullName());
        }
        return employeeMap;
    }
}
