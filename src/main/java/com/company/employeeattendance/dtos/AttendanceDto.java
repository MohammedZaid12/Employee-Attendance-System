package com.company.employeeattendance.dtos;

import com.company.employeeattendance.entities.employee.Employee;
import com.company.employeeattendance.enums.AttendanceStatus;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

public class AttendanceDto {
    private Integer id;

    private Date attendanceDate;

    private String checkIn;

    private String checkOut;

    private Employee employee;

    private Integer employeeId;

    private AttendanceStatus attendanceStatus;

    private Integer overtimeHours;

    private Integer totalWorkingHours;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(Date attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public AttendanceStatus getAttendanceStatus() {
        return attendanceStatus;
    }

    public void setAttendanceStatus(AttendanceStatus attendanceStatus) {
        this.attendanceStatus = attendanceStatus;
    }

    public Integer getOvertimeHours() {
        return overtimeHours;
    }

    public void setOvertimeHours(Integer overtimeHours) {
        this.overtimeHours = overtimeHours;
    }

    public Integer getTotalWorkingHours() {
        return totalWorkingHours;
    }

    public void setTotalWorkingHours(Integer totalWorkingHours) {
        this.totalWorkingHours = totalWorkingHours;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }
}
