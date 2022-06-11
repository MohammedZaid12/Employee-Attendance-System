package com.company.employeeattendance.entities.employee;

import com.company.employeeattendance.entities.BaseEntity;
import com.company.employeeattendance.entities.User;
import com.company.employeeattendance.enums.Religion;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "employee")
public class Employee extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "join_date")
    private Date joinDate;

    @Column(name = "religion")
    @Enumerated(EnumType.STRING)
    private Religion religion;

    @Column(name = "initial_salary", columnDefinition = "DOUBLE DEFAULT 0")
    private Double initialSalary;

    @Column(name = "current_salary", columnDefinition = "DOUBLE DEFAULT 0")
    private Double currentSalary;

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
}
