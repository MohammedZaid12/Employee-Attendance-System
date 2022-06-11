package com.company.employeeattendance.dtos.employee;

import com.company.employeeattendance.dtos.UserDto;
import com.company.employeeattendance.enums.Religion;

import java.sql.Date;

public class EmployeeDto {
    private Integer id;
    private UserDto user;
    private Date joinDate;
    private Religion religion;
    private Double initialSalary;
    private Double currentSalary;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public Religion getReligion() {
        return religion;
    }

    public void setReligion(Religion religion) {
        this.religion = religion;
    }

    public Double getInitialSalary() {
        return initialSalary;
    }

    public void setInitialSalary(Double initialSalary) {
        this.initialSalary = initialSalary;
    }

    public Double getCurrentSalary() {
        return currentSalary;
    }

    public void setCurrentSalary(Double currentSalary) {
        this.currentSalary = currentSalary;
    }
}
