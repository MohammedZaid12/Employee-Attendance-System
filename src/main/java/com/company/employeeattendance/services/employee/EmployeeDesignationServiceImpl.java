package com.company.employeeattendance.services.employee;

import com.company.employeeattendance.dtos.employee.EmployeeDesignationDto;
import com.company.employeeattendance.entities.employee.EmployeeDesignation;
import com.company.employeeattendance.repositories.employee.EmployeeDesignationRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeDesignationServiceImpl implements EmployeeDesignationService {

    @Autowired
    private EmployeeDesignationRepository employeeDesignationRepository;

    @Override
    public List<EmployeeDesignation> findAll() {
        return employeeDesignationRepository.findAll();
    }

    @Override
    public List<EmployeeDesignation> findAllActive() {
        return employeeDesignationRepository.findAllActiveIs(true);
    }

    @Override
    public EmployeeDesignation findById(Integer id) {
        return employeeDesignationRepository.getById(id);
    }

    @Override
    public EmployeeDesignationDto findByIdDto(Integer id) {
        return null;
    }

    @Override
    public EmployeeDesignation save(EmployeeDesignation employeeDesignation) {
        return employeeDesignationRepository.save(employeeDesignation);
    }

    @Override
    public EmployeeDesignationDto saveByDto(EmployeeDesignationDto employeeDesignationDto) {
        EmployeeDesignation employeeDesignation = employeeDesignationDto.getId() == null ? new EmployeeDesignation() : findById(employeeDesignationDto.getId());
        BeanUtils.copyProperties(employeeDesignationDto, employeeDesignation);
        EmployeeDesignation saved = save(employeeDesignation);
        employeeDesignationDto.setId(saved.getId());
        return employeeDesignationDto;
    }
}
