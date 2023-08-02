package com.patterson.forms.services;

import com.patterson.forms.dtos.FormDto;

import java.util.List;

public interface FormService {

    List<FormDto> findByToUser(Long id);
}
