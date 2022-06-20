package com.company.employeeattendance.services.employee;

import com.company.employeeattendance.dtos.employee.EmployeeDto;
import com.company.employeeattendance.entities.employee.Employee;
import com.company.employeeattendance.services.BaseService;

import java.sql.Date;
import java.util.List;

public interface EmployeeService extends BaseService<Employee, EmployeeDto> {


    List<Employee> findAllByDepartmentId(Integer deptId, Date date);

    List<Employee> findAllByDepartmentId(Integer deptId, Integer employeeId,
                                         Date startDate);
}
