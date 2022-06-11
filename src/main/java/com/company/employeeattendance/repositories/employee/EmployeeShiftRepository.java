package com.company.employeeattendance.repositories.employee;

import com.company.employeeattendance.entities.employee.EmployeeShift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeShiftRepository extends JpaRepository<EmployeeShift, Integer> {
    @Query(value = "SELECT e FROM EmployeeShift e WHERE e.active = :active ")
    List<EmployeeShift> findAllActiveIs(@Param("active") boolean active);
}
