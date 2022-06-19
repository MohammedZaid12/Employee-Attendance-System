package com.company.employeeattendance.services;

import com.company.employeeattendance.dtos.ExemptionDto;
import com.company.employeeattendance.entities.Exemption;

import java.sql.Date;
import java.util.List;

public interface ExemptionService extends BaseService<Exemption, ExemptionDto> {
    List<Exemption> findAllByExemptionDate(Date exemptionDate);
}
