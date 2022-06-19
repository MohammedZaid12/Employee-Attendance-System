package com.company.employeeattendance.repositories.employee;

import com.company.employeeattendance.entities.employee.EmployeeRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface EmployeeRuleRepository extends JpaRepository<EmployeeRule, Integer> {
    @Query(value = "SELECT e FROM EmployeeRule e WHERE e.active = :active ")
    List<EmployeeRule> findAllActiveIs(@Param("active") boolean active);

    @Query(value = " select * from `employee_rule` er where \n" +
            " (?2 between er.`start_date` and er.`end_date` \n" +
            " OR \n" +
            " er.`start_date` <= ?2 ) \n" +
            " AND\n" +
            " er.employee_id in ?1 \n" +
            " GROUP BY er.employee_id having MAX(er.id) ", nativeQuery = true)
    List<EmployeeRule> findByEmployeeIdsAndDate(List<Integer> employeeIds, Date date);
}
