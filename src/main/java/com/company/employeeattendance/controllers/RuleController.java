package com.company.employeeattendance.controllers;

import com.company.employeeattendance.dtos.RuleDto;
import com.company.employeeattendance.entities.Rule;
import com.company.employeeattendance.services.RuleService;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class RuleController extends BaseController<Rule, RuleDto> {
    private final RuleService ruleService;

    public RuleController(RuleService ruleService) {
        this.ruleService = ruleService;
    }

    @Override
    public String findAll(Model model) throws Exception {
        model.addAttribute("rules", ruleService.findAll());
        return null;
    }

    @Override
    public String findAllActive(Model model) throws Exception {
        model.addAttribute("rules", ruleService.findAllActive());
        return null;
    }

    @Override
    public String getById(Integer id, Model model) {
        model.addAttribute("rule", ruleService.findById(id));
        return null;
    }

    @Override
    public String saveOrUpdate(RuleDto ruleDto, Model model) {
        ruleService.saveByDto(ruleDto);
        return null;
    }
}
