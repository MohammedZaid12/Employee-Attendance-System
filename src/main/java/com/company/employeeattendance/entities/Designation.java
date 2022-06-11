package com.company.employeeattendance.entities;

import javax.persistence.*;

@Entity
@Table(name = "designation")
public class Designation extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "designation_name")
    private String designationName;

    @Column(name = "employee_capacity")
    private Integer employeeCapacity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dept_id")
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
