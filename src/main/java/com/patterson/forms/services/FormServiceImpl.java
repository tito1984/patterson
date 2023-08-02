package com.patterson.forms.services;

import com.patterson.forms.entities.Form;
import com.patterson.forms.repositories.dtos.FormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormServiceImpl implements FormService {

    @Autowired
    private FormRepository formRepository;

    @Override
    public List<Form> findAll() {
        return formRepository.findAll();
    }
}
