package com.company.employeeattendance.entities;

import javax.persistence.*;

@Entity
@Table(name = "department")
public class Department extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "dept_name")
    private String name;

    @Column(name = "budget")
    private Double budget;

    @Column(name = "employee_capacity")
    private Integer employeeCapacity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }

    public Integer getEmployeeCapacity() {
        return employeeCapacity;
    }

    public void setEmployeeCapacity(Integer employeeCapacity) {
        this.employeeCapacity = employeeCapacity;
    }
}
