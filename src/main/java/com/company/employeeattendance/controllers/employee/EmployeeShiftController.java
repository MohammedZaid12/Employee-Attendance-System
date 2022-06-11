package com.company.employeeattendance.controllers.employee;


import com.company.employeeattendance.controllers.BaseController;
import com.company.employeeattendance.dtos.employee.EmployeeShiftDto;
import com.company.employeeattendance.entities.employee.EmployeeShift;
import com.company.employeeattendance.services.employee.EmployeeShiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/employee-shift/")
public class EmployeeShiftController extends BaseController<EmployeeShift, EmployeeShiftDto> {

    private final EmployeeShiftService employeeShiftService;

    public EmployeeShiftController(EmployeeShiftService employeeShiftService) {
        this.employeeShiftService = employeeShiftService;
    }

    @Override
    public String findAll(Model model) throws Exception {
        model.addAttribute("employeeShifts", employeeShiftService.findAll());
        return null;
    }

    @Override
    public String findAllActive(Model model) throws Exception {
        model.addAttribute("employeeShifts", employeeShiftService.findAllActive());
        return null;
    }

    @Override
    public String getById(Integer id, Model model) {
        model.addAttribute("employeeShift", employeeShiftService.findById(id));
        return null;
    }

    @Override
    public String saveOrUpdate(EmployeeShiftDto employeeShiftDto, Model model) {
        employeeShiftService.saveByDto(employeeShiftDto);
        return null;
    }
}
