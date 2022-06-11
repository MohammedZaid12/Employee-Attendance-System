package com.company.employeeattendance.services.employee;

import com.company.employeeattendance.dtos.employee.EmployeeShiftDto;
import com.company.employeeattendance.entities.employee.Employee;
import com.company.employeeattendance.entities.employee.EmployeeShift;
import com.company.employeeattendance.repositories.employee.EmployeeShiftRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeShiftServiceImpl implements EmployeeShiftService {

    private final EmployeeShiftRepository employeeShiftRepository;

    public EmployeeShiftServiceImpl(EmployeeShiftRepository employeeShiftRepository) {
        this.employeeShiftRepository = employeeShiftRepository;
    }

    @Override
    public List<EmployeeShift> findAll() {
        return employeeShiftRepository.findAll();
    }

    @Override
    public List<EmployeeShift> findAllActive() {
        return employeeShiftRepository.findAllActiveIs(true);
    }

    @Override
    public EmployeeShift findById(Integer id) {
        return employeeShiftRepository.getById(id);
    }

    @Override
    public EmployeeShiftDto findByIdDto(Integer id) {
        return null;
    }

    @Override
    public EmployeeShift save(EmployeeShift employeeShift) {
        return employeeShiftRepository.save(employeeShift);
    }

    @Override
    public EmployeeShiftDto saveByDto(EmployeeShiftDto employeeShiftDto) {
        EmployeeShift employeeShift = employeeShiftDto.getId() == null ? new EmployeeShift() : findById(employeeShiftDto.getId());
        BeanUtils.copyProperties(employeeShiftDto, employeeShift);
        EmployeeShift saved = save(employeeShift);
        employeeShiftDto.setId(saved.getId());
        return employeeShiftDto;
    }
}
