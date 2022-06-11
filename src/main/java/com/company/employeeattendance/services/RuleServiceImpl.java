package com.company.employeeattendance.services;

import com.company.employeeattendance.dtos.RuleDto;
import com.company.employeeattendance.entities.Rule;
import com.company.employeeattendance.repositories.RuleRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RuleServiceImpl implements RuleService {
    private final RuleRepository ruleRepository;

    public RuleServiceImpl(RuleRepository ruleRepository) {
        this.ruleRepository = ruleRepository;
    }

    @Override
    public List<Rule> findAll() {
        return ruleRepository.findAll();
    }

    @Override
    public List<Rule> findAllActive() {
        return ruleRepository.findAllActiveIs(true);
    }

    @Override
    public Rule findById(Integer id) {
        return ruleRepository.getById(id);
    }

    @Override
    public RuleDto findByIdDto(Integer id) {
        return null;
    }

    @Override
    public Rule save(Rule rule) {
        return ruleRepository.save(rule);
    }

    @Override
    public RuleDto saveByDto(RuleDto ruleDto) {
        Rule rule = ruleDto.getId() == null ? new Rule() : findById(ruleDto.getId());
        BeanUtils.copyProperties(ruleDto, rule);
        Rule saved = save(rule);
        ruleDto.setId(saved.getId());
        return ruleDto;
    }
}
