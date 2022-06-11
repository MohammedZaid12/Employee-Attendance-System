package com.company.employeeattendance.services.employee;

import com.company.employeeattendance.dtos.employee.EmployeeDto;
import com.company.employeeattendance.entities.employee.Employee;
import com.company.employeeattendance.repositories.employee.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
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
        return null;
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public EmployeeDto saveByDto(EmployeeDto employeeDto) {
        Employee employee = employeeDto.getId() == null ? new Employee() : findById(employeeDto.getId());
        BeanUtils.copyProperties(employeeDto, employee);
        Employee saved = save(employee);
        employeeDto.setId(saved.getId());
        return employeeDto;
    }
}
