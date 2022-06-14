package com.company.employeeattendance.controllers;

import com.company.employeeattendance.dtos.HolidayDto;
import com.company.employeeattendance.entities.Holiday;
import com.company.employeeattendance.services.HolidayService;
import com.company.employeeattendance.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
@RequestMapping(value = "/holiday")
public class HolidayController extends BaseController<Holiday, HolidayDto> {

    private final HolidayService holidayService;

    public HolidayController(HolidayService holidayService) {
        this.holidayService = holidayService;
    }

    @Override
    public String findAll(Model model) throws Exception {
        model.addAttribute("holidays", holidayService.findAll());
        return "holiday/list-holiday";
    }

    @Override
    public String findAllActive(Model model) throws Exception {
        model.addAttribute("holidays", holidayService.findAllActive());
        return "holiday/list-holiday";

    }

    @GetMapping(value = "/add")
    public String addHoliday(Model model) {
        model.addAttribute("holidayDto", new HolidayDto());
        model.addAttribute("months", DateUtils.getMonths());
        model.addAttribute("years", DateUtils.getYearListFromYear(LocalDate.now().getYear()));
        return "holiday/add-holiday";

    }

    @Override
    public String getById(@PathVariable Integer id, Model model) {
        model.addAttribute("holidayDto", holidayService.findByIdDto(id));
        model.addAttribute("months", DateUtils.getMonths());
        model.addAttribute("years", DateUtils.getYearListFromYear(LocalDate.now().getYear()));
        return "holiday/edit-holiday";

    }

    @Override
    public String saveOrUpdate(@ModelAttribute("holidayDto") HolidayDto holidayDto, Model model) {
        holidayService.saveByDto(holidayDto);
        return "redirect:/holiday";

    }
}
