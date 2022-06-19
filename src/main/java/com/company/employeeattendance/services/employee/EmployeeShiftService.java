package com.company.employeeattendance.services.employee;

import com.company.employeeattendance.dtos.employee.EmployeeShiftDto;
import com.company.employeeattendance.entities.employee.EmployeeShift;
import com.company.employeeattendance.services.BaseService;

import java.sql.Date;
import java.util.List;
import java.util.Map;

public interface EmployeeShiftService extends BaseService<EmployeeShift, EmployeeShiftDto> {
    Map<Integer, EmployeeShift> getMapOfEmployeeOnDate(Date date, List<Integer> employeeIds);
}
