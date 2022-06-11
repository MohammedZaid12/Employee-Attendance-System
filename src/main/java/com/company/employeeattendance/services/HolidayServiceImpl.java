package com.company.employeeattendance.services;

import com.company.employeeattendance.dtos.HolidayDto;
import com.company.employeeattendance.entities.Holiday;
import com.company.employeeattendance.repositories.HolidayRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HolidayServiceImpl implements HolidayService {
    @Autowired
    private HolidayRepository holidayRepository;


    @Override
    public List<Holiday> findAll() {
        return holidayRepository.findAll();
    }

    @Override
    public List<Holiday> findAllActive() {
        return holidayRepository.findAllActiveIs(true);
    }

    @Override
    public Holiday findById(Integer id) {
        return holidayRepository.getById(id);
    }

    @Override
    public HolidayDto findByIdDto(Integer id) {
        return null;
    }

    @Override
    public Holiday save(Holiday holiday) {
        return holidayRepository.save(holiday);
    }

    @Override
    public HolidayDto saveByDto(HolidayDto holidayDto) {
        Holiday holiday = holidayDto.getId() == null ? new Holiday() : findById(holidayDto.getId());
        BeanUtils.copyProperties(holidayDto, holiday);
        Holiday saved = save(holiday);
        holidayDto.setId(saved.getId());
        return holidayDto;
    }
}
