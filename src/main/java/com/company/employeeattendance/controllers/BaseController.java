package com.company.employeeattendance.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

public abstract class BaseController<Type, Dto> {

    @GetMapping(value = "")
    public abstract String findAll(Model model) throws Exception;

    @GetMapping(value = "/active")
    public abstract String findAllActive(Model model) throws Exception;

    @GetMapping(value = "/getById/{id}")
    public abstract String getById(@PathVariable Integer id, Model model);

    @PostMapping(value = "/saveOrUpdate")
    public abstract String saveOrUpdate(@ModelAttribute Dto dto, Model model);


}
