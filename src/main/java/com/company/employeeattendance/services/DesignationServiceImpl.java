package com.company.employeeattendance.services;

import com.company.employeeattendance.dtos.DesignationDto;
import com.company.employeeattendance.entities.Designation;
import com.company.employeeattendance.repositories.DesignationRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DesignationServiceImpl implements DesignationService {

    private final DesignationRepository designationRepository;

    public DesignationServiceImpl(DesignationRepository designationRepository) {
        this.designationRepository = designationRepository;
    }

    @Override
    public List<Designation> findAll() {
        return designationRepository.findAll();
    }

    @Override
    public List<Designation> findAllActive() {
        return designationRepository.findAllActiveIs(true);
    }

    @Override
    public Designation findById(Integer id) {
        return designationRepository.findDesignationById(id);
    }

    @Override
    public DesignationDto findByIdDto(Integer id) {
        DesignationDto designationDto = new DesignationDto();
        BeanUtils.copyProperties(findById(id), designationDto);
        return designationDto;
    }

    @Override
    public Designation save(Designation designation) {
        return designationRepository.save(designation);
    }

    @Override
    public DesignationDto saveByDto(DesignationDto designationDto) {
        Designation designation = designationDto.getId() == null ? new Designation() : findById(designationDto.getId());
        designation.setCurrentUser();
        BeanUtils.copyProperties(designationDto, designation);
        Designation saved = save(designation);
        designationDto.setId(saved.getId());
        return null;
    }
}
