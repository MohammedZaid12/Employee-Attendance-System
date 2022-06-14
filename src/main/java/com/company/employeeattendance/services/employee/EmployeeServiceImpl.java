package com.company.employeeattendance.services.employee;

import com.company.employeeattendance.dtos.employee.EmployeeDto;
import com.company.employeeattendance.entities.User;
import com.company.employeeattendance.entities.employee.Employee;
import com.company.employeeattendance.entities.employee.EmployeeDesignation;
import com.company.employeeattendance.entities.employee.EmployeeRule;
import com.company.employeeattendance.entities.employee.EmployeeShift;
import com.company.employeeattendance.enums.UserRole;
import com.company.employeeattendance.repositories.employee.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeRuleService employeeRuleService;
    private final EmployeeShiftService employeeShiftService;
    private final EmployeeDesignationService employeeDesignationService;


    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeRuleService employeeRuleService,
                               EmployeeShiftService employeeShiftService,
                               EmployeeDesignationService employeeDesignationService) {
        this.employeeRepository = employeeRepository;
        this.employeeRuleService = employeeRuleService;
        this.employeeShiftService = employeeShiftService;
        this.employeeDesignationService = employeeDesignationService;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> findAllActive() {
        return employeeRepository.findAllActiveIs(true);
    }

    @Override
    public Employee findById(Integer id) {
        return employeeRepository.getById(id);
    }

    @Override
    public EmployeeDto findByIdDto(Integer id) {
        EmployeeDto employeeDto = new EmployeeDto();
        BeanUtils.copyProperties(findById(id), employeeDto);
        return employeeDto;
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public EmployeeDto saveByDto(EmployeeDto employeeDto) {
        Employee employee = employeeDto.getId() == null ? new Employee() : findById(employeeDto.getId());
        BeanUtils.copyProperties(employeeDto, employee);
        employee.getUser().setUserRole(UserRole.EMPLOYEE);
        employee.setCurrentUser();
        Employee saved = save(employee);
        if (employeeDto.getId() == null) {
            createEmployeeShift(saved, employeeDto);
            createEmployeeRule(saved, employeeDto);
            createEmployeeDesignation(saved, employeeDto);
        }
        employeeDto.setId(saved.getId());
        return employeeDto;
    }

    private void createEmployeeShift(Employee employee, EmployeeDto employeeDto) {
        EmployeeShift shift = new EmployeeShift();
        shift.setEmployee(employee);
        shift.setShift(employeeDto.getShift());
        shift.setRemarks("At Employee Creation");
        shift.setStartDate(Date.valueOf(LocalDate.now()));
        shift.setStatus("active");
        employeeShiftService.save(shift);
    }

    private void createEmployeeRule(Employee employee, EmployeeDto employeeDto) {
        EmployeeRule employeeRule = new EmployeeRule();
        employeeRule.setEmployee(employee);
        employeeRule.setRule(employeeDto.getRule());
        employeeRule.setRemarks("At Employee Creation");
        employeeRule.setStartDate(Date.valueOf(LocalDate.now()));
        employeeRule.setStatus("active");
        employeeRuleService.save(employeeRule);
    }

    private void createEmployeeDesignation(Employee employee, EmployeeDto employeeDto) {
        EmployeeDesignation designation = new EmployeeDesignation();
        designation.setEmployee(employee);
        designation.setDesignation(employeeDto.getDesignation());
        designation.setRemarks("At Employee Creation");
        designation.setStartDate(Date.valueOf(LocalDate.now()));
        designation.setStatus("active");
        employeeDesignationService.save(designation);
    }
}
