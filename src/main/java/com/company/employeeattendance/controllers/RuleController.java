package com.company.employeeattendance.controllers;

import com.company.employeeattendance.dtos.RuleDto;
import com.company.employeeattendance.entities.Rule;
import com.company.employeeattendance.services.RuleService;
import com.company.employeeattendance.utils.DateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/rule")
public class RuleController extends BaseController<Rule, RuleDto> {
    private final RuleService ruleService;

    public RuleController(RuleService ruleService) {
        this.ruleService = ruleService;
    }

    @Override
    public String findAll(Model model) throws Exception {
        model.addAttribute("rules", ruleService.findAll());
        model.addAttribute("daysOfWeek", DateUtils.getDaysOfWeek());
        return "rule/list-rule";
    }

    @Override
    public String findAllActive(Model model) throws Exception {
        model.addAttribute("rules", ruleService.findAllActive());
        model.addAttribute("daysOfWeek", DateUtils.getDaysOfWeek());
        return "rule/list-rule";
    }

    @GetMapping(value = "/add")
    public String addRule(Model model) {
        model.addAttribute("ruleDto", new RuleDto());
        return "rule/add-rule";
    }

    @Override
    public String getById(@PathVariable Integer id, Model model) {
        model.addAttribute("ruleDto", ruleService.findByIdDto(id));
        return "rule/edit-rule";
    }

    @Override
    public String saveOrUpdate(@ModelAttribute("ruleDto") RuleDto ruleDto, Model model) {
        ruleService.saveByDto(ruleDto);
        return "redirect:/rule";
    }
}
