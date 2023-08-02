package com.patterson.forms.services;

import com.patterson.forms.entities.Form;
import com.patterson.forms.entities.User;

public interface AnswerService {

    void answerForm(String code, String answer, User user, Form form);
}
