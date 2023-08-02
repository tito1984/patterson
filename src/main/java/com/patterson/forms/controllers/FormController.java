package com.patterson.forms.controllers;

import com.patterson.forms.dtos.FormDto;
import com.patterson.forms.services.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/forms")
public class FormController {

    @Autowired
    private FormService formService;

    @GetMapping
    public List<FormDto> findAll() {
        return formService.findAll();
    }
}
