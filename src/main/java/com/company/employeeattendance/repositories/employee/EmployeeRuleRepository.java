package com.company.employeeattendance.repositories.employee;

import com.company.employeeattendance.entities.employee.EmployeeRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRuleRepository extends JpaRepository<EmployeeRule, Integer> {
    @Query(value = "SELECT e FROM EmployeeRule e WHERE e.active = :active ")
    List<EmployeeRule> findAllActiveIs(@Param("active") boolean active);
}
