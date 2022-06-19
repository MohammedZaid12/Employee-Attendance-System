package com.company.employeeattendance.repositories;

import com.company.employeeattendance.entities.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {

    @Query(value = "SELECT a FROM Attendance a WHERE a.active = :active ")
    List<Attendance> findAllActiveIs(@Param("active") boolean active);

    Attendance findByEmployeeIdAndAttendanceDate(Integer employeeId, Date attendanceDate);

}
