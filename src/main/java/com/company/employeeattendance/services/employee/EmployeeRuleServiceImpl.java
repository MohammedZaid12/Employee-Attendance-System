package com.company.employeeattendance.services.employee;

import com.company.employeeattendance.dtos.employee.EmployeeRuleDto;
import com.company.employeeattendance.entities.Rule;
import com.company.employeeattendance.entities.employee.EmployeeRule;
import com.company.employeeattendance.repositories.employee.EmployeeRuleRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public Map<Integer, EmployeeRule> getMapOfEmployeeRuleByDate(List<Integer> employeeIds, Date date) {
        Map<Integer, EmployeeRule> employeeRuleMap = new HashMap<>();
        for (EmployeeRule employeeRule : employeeRuleRepository.findByEmployeeIdsAndDate(employeeIds, date)) {
            employeeRuleMap.put(employeeRule.getEmployee().getId(), employeeRule);
        }
        return employeeRuleMap;
    }

    @Override
    public boolean isWorkingDay(EmployeeRule employeeRule, Date date) {
        String dayName = date.toLocalDate().getDayOfWeek().name();
        Rule rule = employeeRule.getRule();
        switch (dayName) {
            case "MONDAY":
                return rule.isMonday();
            case "TUESDAY":
                return rule.isTuesday();
            case "WEDNESDAY":
                return rule.isWednesday();
            case "THURSDAY":
                return rule.isThursday();
            case "FRIDAY":
                return rule.isFriday();
            case "SATURDAY":
                return rule.isSaturday();
            case "SUNDAY":
                return rule.isSunday();
            default:
                return false;
        }
    }
}
