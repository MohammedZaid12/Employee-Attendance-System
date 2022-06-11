package com.company.employeeattendance.repositories.employee;

import com.company.employeeattendance.entities.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query(value = "SELECT e FROM Employee e WHERE e.active = :active ")
    List<Employee> findAllActiveIs(@Param("active") boolean active);
}
