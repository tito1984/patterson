package com.patterson.forms.services;

import com.patterson.forms.dtos.FormDto;
import com.patterson.forms.entities.Form;
import com.patterson.forms.entities.User;
import com.patterson.forms.exceptions.ResourceNotFoundException;
import com.patterson.forms.repositories.FormRepository;
import com.patterson.forms.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FormServiceImpl implements FormService {

    @Autowired
    private FormRepository formRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<FormDto> findByToUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() ->
            new ResourceNotFoundException(id));
        List<Form> forms = formRepository.findByToUser(user);
        List<FormDto> formDtos = new ArrayList<>();
        for (Form form : forms) {
            FormDto formDto = new FormDto(form.getQuestion());
            formDtos.add(formDto);
        }
        return formDtos;
    }
}
