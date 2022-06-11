package com.company.employeeattendance.repositories;

import com.company.employeeattendance.entities.Holiday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HolidayRepository extends JpaRepository<Holiday, Integer> {

    @Query(value = "SELECT h FROM Holiday h WHERE h.active = :active ")
    List<Holiday> findAllActiveIs(@Param("active") boolean active);

}
