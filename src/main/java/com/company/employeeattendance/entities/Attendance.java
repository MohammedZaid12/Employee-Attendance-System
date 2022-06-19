package com.company.employeeattendance.entities;

import com.company.employeeattendance.entities.employee.Employee;
import com.company.employeeattendance.enums.AttendanceStatus;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "attendance")
public class Attendance extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "attendance_date")
    private Date attendanceDate;

    @Column(name = "check_in")
    private String checkIn;

    @Column(name = "check_out")
    private String checkOut;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(name = "attendance_status")
    @Enumerated(value = EnumType.STRING)
    private AttendanceStatus attendanceStatus;

    @Column(name = "overtime_hours", columnDefinition = "INT DEFAULT 0")
    private Integer overtimeHours;

    @Column(name = "working_hours", columnDefinition = "INT DEFAULT 0")
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
}
