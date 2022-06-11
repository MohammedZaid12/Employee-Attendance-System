package com.company.employeeattendance.entities;

import com.company.employeeattendance.converters.StringListConverter;
import com.company.employeeattendance.entities.employee.Employee;
import com.company.employeeattendance.enums.ExemptionType;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "exemption")
public class Exemption extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(name = "reason")
    private String reason;

    @Column(name = "count")
    private int count;

    @Column(name = "month")
    private String month;

    @Column(name = "year")
    private int year;

    @Column(name = "exemption_date")
    @Convert(converter = StringListConverter.class)
    private List<String> exemptionDates;

    @Column(name = "exemption_type")
    @Enumerated(value = EnumType.STRING)
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
