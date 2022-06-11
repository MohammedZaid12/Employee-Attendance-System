package com.company.employeeattendance.services;

import com.company.employeeattendance.dtos.ExemptionDto;
import com.company.employeeattendance.entities.Exemption;
import com.company.employeeattendance.repositories.ExemptionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExemptionServiceImpl implements ExemptionService {
    private final ExemptionRepository exemptionRepository;

    public ExemptionServiceImpl(ExemptionRepository exemptionRepository) {
        this.exemptionRepository = exemptionRepository;
    }

    @Override
    public List<Exemption> findAll() {
        return exemptionRepository.findAll();
    }

    @Override
    public List<Exemption> findAllActive() {
        return exemptionRepository.findAllActiveIs(true);
    }

    @Override
    public Exemption findById(Integer id) {
        return exemptionRepository.getById(id);
    }

    @Override
    public ExemptionDto findByIdDto(Integer id) {
        return null;
    }

    @Override
    public Exemption save(Exemption exemption) {
        return exemptionRepository.save(exemption);
    }

    @Override
    public ExemptionDto saveByDto(ExemptionDto exemptionDto) {
        Exemption exemption = exemptionDto.getId() == null ? new Exemption() : findById(exemptionDto.getId());
        BeanUtils.copyProperties(exemptionDto, exemption);
        Exemption saved = save(exemption);
        exemptionDto.setId(saved.getId());
        return exemptionDto;
    }
}
