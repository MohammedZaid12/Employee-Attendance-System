package com.company.employeeattendance.enums;

import java.util.Arrays;
import java.util.List;

public enum AttendanceStatus {
    PRESENT, ABSENT, LATE, HALF_DAY, EXEMPTED, OFF_DAY_PRESENT, REST_DAY, NONE;

    public static List<AttendanceStatus> getListForMarkingAttendance() {
        return Arrays.asList(PRESENT, ABSENT, EXEMPTED);
    }
}
