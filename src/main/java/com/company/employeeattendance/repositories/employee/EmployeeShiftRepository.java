package com.company.employeeattendance.repositories.employee;

import com.company.employeeattendance.entities.employee.EmployeeShift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface EmployeeShiftRepository extends JpaRepository<EmployeeShift, Integer> {
    @Query(value = "SELECT e FROM EmployeeShift e WHERE e.active = :active ")
    List<EmployeeShift> findAllActiveIs(@Param("active") boolean active);

    @Query(value = " select * from `employee_shift` es where \n" +
            " ( ?1 between es.`start_date` and es.`end_date` \n" +
            " OR \n" +
            " es.`start_date` <= ?1 ) \n" +
            " AND es.employee_id in ?2 \n" +
            "GROUP BY es.employee_id having MAX(es.id)  ", nativeQuery = true)
    List<EmployeeShift> findAllByDateAndEmployeeIds(Date date, List<Integer> employeeIds);


}
