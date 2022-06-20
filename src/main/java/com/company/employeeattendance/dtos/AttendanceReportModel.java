package com.company.employeeattendance.dtos;

import com.company.employeeattendance.entities.Designation;
import com.company.employeeattendance.entities.employee.Employee;

import java.util.List;

public class AttendanceReportModel {
    private Employee employee;

    private Designation designation;
    private List<AttendanceDto> attendanceDtoList;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<AttendanceDto> getAttendanceDtoList() {
        return attendanceDtoList;
    }

    public void setAttendanceDtoList(List<AttendanceDto> attendanceDtoList) {
        this.attendanceDtoList = attendanceDtoList;
    }

    public Designation getDesignation() {
        return designation;
    }

    public void setDesignation(Designation designation) {
        this.designation = designation;
    }
}
