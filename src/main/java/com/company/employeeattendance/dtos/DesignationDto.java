package com.company.employeeattendance.dtos;

import com.company.employeeattendance.entities.Department;

public class DesignationDto {
    private Integer id;
    private String designationName;
    private Integer employeeCapacity;
    private Department department;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDesignationName() {
        return designationName;
    }

    public void setDesignationName(String designationName) {
        this.designationName = designationName;
    }

    public Integer getEmployeeCapacity() {
        return employeeCapacity;
    }

    public void setEmployeeCapacity(Integer employeeCapacity) {
        this.employeeCapacity = employeeCapacity;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
