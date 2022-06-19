package com.company.employeeattendance.dtos;

import com.company.employeeattendance.converters.StringListConverter;
import com.company.employeeattendance.entities.employee.Employee;
import com.company.employeeattendance.enums.ExemptionType;

import javax.persistence.*;
import java.util.List;

public class ExemptionDto {
    private Integer id;

    private Employee employee;

    private String reason;

    private int count;

    private String month;

    private int year;

    private List<String> exemptionDates;

    private ExemptionType exemptionType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<String> getExemptionDates() {
        return exemptionDates;
    }

    public void setExemptionDates(List<String> exemptionDates) {
        this.exemptionDates = exemptionDates;
    }

    public ExemptionType getExemptionType() {
        return exemptionType;
    }

    public void setExemptionType(ExemptionType exemptionType) {
        this.exemptionType = exemptionType;
    }
}
