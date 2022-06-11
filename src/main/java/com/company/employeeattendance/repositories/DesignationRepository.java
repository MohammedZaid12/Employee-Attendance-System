package com.company.employeeattendance.repositories;

import com.company.employeeattendance.entities.Designation;
import com.company.employeeattendance.entities.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DesignationRepository extends JpaRepository<Designation, Integer> {

    @Query(value = "SELECT d FROM Designation d WHERE d.active = :active ")
    List<Designation> findAllActiveIs(@Param("active") boolean active);

    Designation findDesignationById(Integer id);

}
