package com.company.employeeattendance.services;

import com.company.employeeattendance.dtos.HolidayDto;
import com.company.employeeattendance.entities.Holiday;
import com.company.employeeattendance.repositories.HolidayRepository;
import com.company.employeeattendance.utils.DateUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HolidayServiceImpl implements HolidayService {
    private final HolidayRepository holidayRepository;

    public HolidayServiceImpl(HolidayRepository holidayRepository) {
        this.holidayRepository = holidayRepository;
    }


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
        return holidayRepository.findById(id).orElse(null);
    }

    @Override
    public HolidayDto findByIdDto(Integer id) {
        HolidayDto holidayDto = new HolidayDto();
        BeanUtils.copyProperties(findById(id), holidayDto);
        return holidayDto;
    }

    @Override
    public Holiday save(Holiday holiday) {
        return holidayRepository.save(holiday);
    }

    @Override
    public HolidayDto saveByDto(HolidayDto holidayDto) {
        Holiday holiday = holidayDto.getId() == null ? new Holiday() : findById(holidayDto.getId());
        BeanUtils.copyProperties(holidayDto, holiday);
        holiday.setCurrentUser();
        holiday.setDayCount(DateUtils.getDifferenceBetweenTwoDates(holidayDto.getStartDate(), holidayDto.getEndDate()).getDays() + 1);
        Holiday saved = save(holiday);
        holidayDto.setId(saved.getId());
        return holidayDto;
    }
}
