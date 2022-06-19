package com.company.employeeattendance.services.employee;

import com.company.employeeattendance.dtos.employee.EmployeeRuleDto;
import com.company.employeeattendance.entities.employee.EmployeeRule;
import com.company.employeeattendance.services.BaseService;

import java.sql.Date;
import java.util.List;
import java.util.Map;

public interface EmployeeRuleService extends BaseService<EmployeeRule, EmployeeRuleDto> {
    Map<Integer, EmployeeRule> getMapOfEmployeeRuleByDate(List<Integer> employeeIds, Date date);

    boolean isWorkingDay(EmployeeRule employeeRule, Date date);
}
