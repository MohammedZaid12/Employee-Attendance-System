package com.company.employeeattendance.services.employee;

import com.company.employeeattendance.dtos.employee.EmployeeRuleDto;
import com.company.employeeattendance.entities.employee.EmployeeRule;
import com.company.employeeattendance.repositories.employee.EmployeeRuleRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeRuleServiceImpl implements EmployeeRuleService {

    private final EmployeeRuleRepository employeeRuleRepository;

    public EmployeeRuleServiceImpl(EmployeeRuleRepository employeeRuleRepository) {
        this.employeeRuleRepository = employeeRuleRepository;
    }

    @Override
    public List<EmployeeRule> findAll() {
        return employeeRuleRepository.findAll();
    }

    @Override
    public List<EmployeeRule> findAllActive() {
        return employeeRuleRepository.findAllActiveIs(true);
    }

    @Override
    public EmployeeRule findById(Integer id) {
        return employeeRuleRepository.getById(id);
    }

    @Override
    public EmployeeRuleDto findByIdDto(Integer id) {
        return null;
    }

    @Override
    public EmployeeRule save(EmployeeRule employeeRule) {
        return employeeRuleRepository.save(employeeRule);
    }

    @Override
    public EmployeeRuleDto saveByDto(EmployeeRuleDto employeeRuleDto) {
        EmployeeRule employeeRule = employeeRuleDto.getId() == null ? new EmployeeRule() : findById(employeeRuleDto.getId());
        BeanUtils.copyProperties(employeeRuleDto, employeeRule);
        EmployeeRule saved = save(employeeRule);
        employeeRuleDto.setId(saved.getId());
        return null;
    }
}
