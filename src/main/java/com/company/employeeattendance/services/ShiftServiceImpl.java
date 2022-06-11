package com.company.employeeattendance.services;

import com.company.employeeattendance.constants.DateFormats;
import com.company.employeeattendance.dtos.ShiftDto;
import com.company.employeeattendance.entities.Shift;
import com.company.employeeattendance.entities.Shift;
import com.company.employeeattendance.repositories.ShiftRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
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
        ShiftDto shiftDto = new ShiftDto();
        BeanUtils.copyProperties(findById(id), shiftDto);
        return shiftDto;
    }

    @Override
    public Shift save(Shift shift) {
        return shiftRepository.save(shift);
    }

    @Override
    public ShiftDto saveByDto(ShiftDto shiftDto) {
        Shift shift = shiftDto.getId() == null ? new Shift() : findById(shiftDto.getId());
        shift.setCurrentUser();
        BeanUtils.copyProperties(shiftDto, shift);
        shift.setTimeStart(setShiftTimeFormat(shiftDto.getTimeStart()));
        shift.setTimeEnd(setShiftTimeFormat(shiftDto.getTimeEnd()));
        shift.setDefaultCheckIn(setShiftTimeFormat(shiftDto.getDefaultCheckIn()));
        shift.setDefaultCheckout(setShiftTimeFormat(shiftDto.getDefaultCheckout()));
        shift.setHalfDayTime(setShiftTimeFormat(shiftDto.getHalfDayTime()));
        shift.setLastTimeAllowed(setShiftTimeFormat(shiftDto.getLastTimeAllowed()));
        shift.setLateTime(setShiftTimeFormat(shiftDto.getLateTime()));
        Shift saved = save(shift);
        shiftDto.setId(saved.getId());
        return shiftDto;
    }
    private String setShiftTimeFormat(String time) {
        if (time.length() != 8 && !time.isEmpty()) {
            time = DateFormats.HH_mm_ss.format(LocalTime.parse(time, DateFormats.HH_mm));
        }
        if (time.isEmpty()) {
            time = "00:00:00";
        }
        return time;
    }
}
