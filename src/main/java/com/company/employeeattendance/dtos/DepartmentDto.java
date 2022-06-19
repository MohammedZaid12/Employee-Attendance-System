package com.company.employeeattendance.dtos;

public class DepartmentDto {
    private Integer id;
    private String name;
    private Double budget;
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
