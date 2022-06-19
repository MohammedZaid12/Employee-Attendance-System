package com.company.employeeattendance.entities;

import javax.persistence.*;

@Entity
@Table(name = "shift")
public class Shift extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "shift_title")
    private String shiftTitle;

    // Hours at which shift time starts
    @Column(name = "shift_time_start")
    private String timeStart;

    // Hours at which shift time ends
    @Column(name = "shift_time_end")
    private String timeEnd;

    // Hours under which employee is marked late
    @Column(name = "shift_late_time")
    private String lateTime;

    // Hours under which half day is counted
    @Column(name = "shift_halfday_time")
    private String halfDayTime;

    // Time after which employee are not allowed
    @Column(name = "last_time_allowed")
    private String lastTimeAllowed;

    // If employee has not marked his attendance default check in will be considered
    @Column(name = "default_checkin")
    private String defaultCheckIn;

    // If employee has not marked his attendance default check out will be considered
    @Column(name = "default_checkout")
    private String defaultCheckout;

    @Column(name = "shift_duration")
    private Integer shiftDuration; // In hours

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShiftTitle() {
        return shiftTitle;
    }

    public void setShiftTitle(String shiftTitle) {
        this.shiftTitle = shiftTitle;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }

    public String getLateTime() {
        return lateTime;
    }

    public void setLateTime(String lateTime) {
        this.lateTime = lateTime;
    }

    public String getHalfDayTime() {
        return halfDayTime;
    }

    public void setHalfDayTime(String halfDayTime) {
        this.halfDayTime = halfDayTime;
    }

    public String getLastTimeAllowed() {
        return lastTimeAllowed;
    }

    public void setLastTimeAllowed(String lastTimeAllowed) {
        this.lastTimeAllowed = lastTimeAllowed;
    }

    public String getDefaultCheckIn() {
        return defaultCheckIn;
    }

    public void setDefaultCheckIn(String defaultCheckIn) {
        this.defaultCheckIn = defaultCheckIn;
    }

    public String getDefaultCheckout() {
        return defaultCheckout;
    }

    public void setDefaultCheckout(String defaultCheckout) {
        this.defaultCheckout = defaultCheckout;
    }

    public Integer getShiftDuration() {
        return shiftDuration;
    }

    public void setShiftDuration(Integer shiftDuration) {
        this.shiftDuration = shiftDuration;
    }
}
