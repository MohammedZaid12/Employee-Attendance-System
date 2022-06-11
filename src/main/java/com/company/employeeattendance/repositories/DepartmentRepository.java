package com.company.employeeattendance.repositories;

import com.company.employeeattendance.entities.Department;
import com.company.employeeattendance.entities.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    @Query(value = "SELECT d FROM Department d WHERE d.active = :active ")
    List<Department> findAllActiveIs(@Param("active") boolean active);

    Department findDepartmentById(Integer id);

}
