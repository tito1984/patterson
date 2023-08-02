package com.patterson.forms.services;

import com.patterson.forms.dtos.FormDto;
import com.patterson.forms.entities.Form;
import com.patterson.forms.repositories.dtos.FormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FormServiceImpl implements FormService {

    @Autowired
    private FormRepository formRepository;

    @Override
    public List<FormDto> findAll() {
        List<Form> forms = formRepository.findAll();
        List<FormDto> formDtos = new ArrayList<>();
        for (Form form : forms) {
            FormDto formDto = new FormDto(form.getQuestion());
            formDtos.add(formDto);
        }
        return formDtos;
    }
}
