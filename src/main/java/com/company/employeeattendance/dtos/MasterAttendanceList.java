package com.company.employeeattendance.dtos;

import java.util.List;

public class MasterAttendanceList {

    private List<AttendanceDto> attendanceList;

    public List<AttendanceDto> getAttendanceList() {
        return attendanceList;
    }

    public void setAttendanceList(List<AttendanceDto> attendanceList) {
        this.attendanceList = attendanceList;
    }
}
