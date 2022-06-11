package com.company.employeeattendance.repositories;

import com.company.employeeattendance.entities.Attendance;
import com.company.employeeattendance.entities.Rule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RuleRepository extends JpaRepository<Rule, Integer> {
    @Query(value = "SELECT r FROM Rule r WHERE r.active = :active ")
    List<Rule> findAllActiveIs(@Param("active") boolean active);

}
