package com.company.employeeattendance.services;

import com.company.employeeattendance.dtos.ShiftDto;
import com.company.employeeattendance.entities.Shift;
import com.company.employeeattendance.entities.Shift;
import com.company.employeeattendance.repositories.ShiftRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShiftServiceImpl implements ShiftService {

    @Autowired
    private ShiftRepository shiftRepository;

    @Override
    public List<Shift> findAll() {
        return shiftRepository.findAll();
    }

    @Override
    public List<Shift> findAllActive() {
        return shiftRepository.findAllActiveIs(true);
    }

    @Override
    public Shift findById(Integer id) {
        return shiftRepository.getById(id);
    }

    @Override
    public ShiftDto findByIdDto(Integer id) {
        return null;
    }

    @Override
    public Shift save(Shift shift) {
        return shiftRepository.save(shift);
    }

    @Override
    public ShiftDto saveByDto(ShiftDto shiftDto) {
        Shift shift = shiftDto.getId() == null ? new Shift() : findById(shiftDto.getId());
        BeanUtils.copyProperties(shiftDto, shift);
        Shift saved = save(shift);
        shiftDto.setId(saved.getId());
        return shiftDto;
    }
}
