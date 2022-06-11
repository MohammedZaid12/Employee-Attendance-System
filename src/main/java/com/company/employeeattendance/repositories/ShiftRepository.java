package com.company.employeeattendance.repositories;

import com.company.employeeattendance.entities.Holiday;
import com.company.employeeattendance.entities.Shift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShiftRepository extends JpaRepository<Shift, Integer> {

    @Query(value = "SELECT s FROM Shift s WHERE s.active = :active ")
    List<Shift> findAllActiveIs(@Param("active") boolean active);

}
