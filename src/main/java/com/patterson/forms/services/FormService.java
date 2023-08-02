package com.patterson.forms.services;

import com.patterson.forms.entities.Form;

import java.util.Optional;

public interface FormService {

    Optional<Form> getForm(String code);
}
