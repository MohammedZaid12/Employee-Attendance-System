package com.company.employeeattendance.controllers;

import com.company.employeeattendance.dtos.ExemptionDto;
import com.company.employeeattendance.entities.Exemption;
import com.company.employeeattendance.services.ExemptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/exemption/")
public class ExemptionController extends BaseController<Exemption, ExemptionDto> {
    @Autowired
    private ExemptionService exemptionService;

    @Override
    public String findAll(Model model) throws Exception {
        model.addAttribute("exemptionList", exemptionService.findAll());
        return null;
    }

    @Override
    public String findAllActive(Model model) throws Exception {
        model.addAttribute("exemptionList", exemptionService.findAllActive());
        return null;
    }

    @Override
    public String getById(Integer id, Model model) {
        model.addAttribute("exemptionList", exemptionService.findById(id));
        return null;
    }

    @Override
    public String saveOrUpdate(ExemptionDto exemptionDto, Model model) {
        exemptionService.saveByDto(exemptionDto);
        return null;
    }
}
