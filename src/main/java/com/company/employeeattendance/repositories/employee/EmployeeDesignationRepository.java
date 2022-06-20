package com.company.employeeattendance.repositories.employee;

import com.company.employeeattendance.entities.employee.EmployeeDesignation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface EmployeeDesignationRepository extends JpaRepository<EmployeeDesignation, Integer> {
    @Query(value = "SELECT e FROM EmployeeDesignation e WHERE e.active = :active ")
    List<EmployeeDesignation> findAllActiveIs(@Param("active") boolean active);

    @Query(value = "select ed.* from `employee_designation` ed where \n" +
            "(?2 between ed.`start_date` and ed.`end_date` \n" +
            "OR \n" +
            "ed.`start_date` <= ?2 ) \n" +
            "AND \n" +
            "ed.employee_id = ?1 ", nativeQuery = true)
    EmployeeDesignation findByEmployeeIdAndDate(Integer employeeId, Date date);


}
