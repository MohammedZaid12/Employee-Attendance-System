package com.company.employeeattendance.services.employee;

import com.company.employeeattendance.dtos.employee.EmployeeDto;
import com.company.employeeattendance.entities.employee.Employee;
import com.company.employeeattendance.entities.employee.EmployeeDesignation;
import com.company.employeeattendance.entities.employee.EmployeeRule;
import com.company.employeeattendance.entities.employee.EmployeeShift;
import com.company.employeeattendance.enums.UserRole;
import com.company.employeeattendance.repositories.employee.EmployeeRepository;
import com.company.employeeattendance.services.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeRuleService employeeRuleService;
    private final EmployeeShiftService employeeShiftService;
    private final EmployeeDesignationService employeeDesignationService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserService userService;


    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeRuleService employeeRuleService,
                               EmployeeShiftService employeeShiftService,
                               EmployeeDesignationService employeeDesignationService, BCryptPasswordEncoder bCryptPasswordEncoder, UserService userService) {
        this.employeeRepository = employeeRepository;
        this.employeeRuleService = employeeRuleService;
        this.employeeShiftService = employeeShiftService;
        this.employeeDesignationService = employeeDesignationService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userService = userService;
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
        if (employeeDto.getId() == null) {
            employee.setCurrentSalary(employeeDto.getInitialSalary());
        }
        createUser(employee);
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
        shift.setCurrentUser();
        shift.setEmployee(employee);
        shift.setShift(employeeDto.getShift());
        shift.setRemarks("At Employee Creation");
        shift.setStartDate(Date.valueOf(LocalDate.now()));
        shift.setStatus("active");
        employeeShiftService.save(shift);
    }

    private void createEmployeeRule(Employee employee, EmployeeDto employeeDto) {
        EmployeeRule employeeRule = new EmployeeRule();
        employeeRule.setCurrentUser();
        employeeRule.setEmployee(employee);
        employeeRule.setRule(employeeDto.getRule());
        employeeRule.setRemarks("At Employee Creation");
        employeeRule.setStartDate(Date.valueOf(LocalDate.now()));
        employeeRule.setStatus("active");
        employeeRuleService.save(employeeRule);
    }

    private void createEmployeeDesignation(Employee employee, EmployeeDto employeeDto) {
        EmployeeDesignation designation = new EmployeeDesignation();
        designation.setCurrentUser();
        designation.setEmployee(employee);
        designation.setDesignation(employeeDto.getDesignation());
        designation.setRemarks("At Employee Creation");
        designation.setStartDate(Date.valueOf(LocalDate.now()));
        designation.setStatus("active");
        employeeDesignationService.save(designation);
    }

    public void createUser(Employee employee) {
        employee.getUser().setPassword(bCryptPasswordEncoder.encode(employee.getUser().getPassword()));
        employee.getUser().setUserRole(UserRole.EMPLOYEE);
        employee.getUser().setCurrentUser();
        employee.setUser(userService.save(employee.getUser()));
    }

    @Override
    public List<Employee> findAllByDepartmentId(Integer deptId, Date date) {
        return employeeRepository.findAllByDepartmentId(deptId, date);
    }

    @Override
    public List<Employee> findAllByDepartmentId(Integer deptId, Integer employeeId,
                                                Date startDate) {
        if (employeeId > 0) {
            return Arrays.asList(findById(employeeId));
        } else {
            return employeeRepository.findAllByDepartmentId(deptId, startDate);
        }
    }
}
