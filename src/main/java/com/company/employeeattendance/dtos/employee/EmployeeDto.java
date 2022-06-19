package com.company.employeeattendance.dtos.employee;

import com.company.employeeattendance.entities.Designation;
import com.company.employeeattendance.entities.Rule;
import com.company.employeeattendance.entities.Shift;
import com.company.employeeattendance.entities.User;
import com.company.employeeattendance.enums.Religion;

import java.sql.Date;

public class EmployeeDto {
    private Integer id;
    private User user;
    private Date joinDate;
    private Religion religion;
    private Double initialSalary;
    private Double currentSalary;

    private Designation designation;
    private Shift shift;
    private Rule rule;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
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

    public Designation getDesignation() {
        return designation;
    }

    public void setDesignation(Designation designation) {
        this.designation = designation;
    }

    public Shift getShift() {
        return shift;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
    }

    public Rule getRule() {
        return rule;
    }

    public void setRule(Rule rule) {
        this.rule = rule;
    }
}
