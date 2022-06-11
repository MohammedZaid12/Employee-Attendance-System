package com.company.employeeattendance.dtos;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class ShiftDto {
    private Integer id;

    private String shiftTitle;

    // Hours at which shift time starts
    private String timeStart;

    // Hours at which shift time ends
    private String timeEnd;

    // Hours under which employee is marked late
    private String lateTime;

    // Hours under which half day is counted
    private String halfDayTime;

    // Time after which employee are not allowed
    private String lastTimeAllowed;

    // If employee has not marked his attendance default check in will be considered
    private String defaultCheckIn;

    // If employee has not marked his attendance default check out will be considered
    private String defaultCheckout;

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
}
