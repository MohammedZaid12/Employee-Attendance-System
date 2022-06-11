package com.company.employeeattendance.repositories;

import com.company.employeeattendance.entities.Exemption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ExemptionRepository extends JpaRepository<Exemption, Integer> {

    @Query(value = "SELECT e FROM Exemption e WHERE e.active = :active ")
    List<Exemption> findAllActiveIs(@Param("active") boolean active);

}
