package com.company.employeeattendance.services.employee;

import com.company.employeeattendance.dtos.employee.EmployeeDesignationDto;
import com.company.employeeattendance.entities.employee.EmployeeDesignation;
import com.company.employeeattendance.services.BaseService;

import java.sql.Date;

public interface EmployeeDesignationService extends BaseService<EmployeeDesignation, EmployeeDesignationDto> {
    EmployeeDesignation findByEmployeeIdAndDate(Integer employeeId, Date date);
}
