package com.company.employeeattendance.services;

import com.company.employeeattendance.dtos.AttendanceDto;
import com.company.employeeattendance.dtos.AttendanceReportModel;
import com.company.employeeattendance.dtos.MasterAttendanceList;
import com.company.employeeattendance.entities.Attendance;

import java.sql.Date;
import java.util.List;

public interface AttendanceService extends BaseService<Attendance, AttendanceDto> {
    MasterAttendanceList generateAttendanceList(Date date, Integer deptId);

    List<Attendance> saveAttendance(MasterAttendanceList masterAttendanceList);

    List<AttendanceReportModel> generateAttendanceReport(Integer deptId, String month, Integer year, Integer employeeId,
                                                         Date startDate, Date endDate);
}
