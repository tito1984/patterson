package com.patterson.forms.services;

import com.patterson.forms.dtos.AnswerDto;

public interface AnswerService {

    AnswerDto save(Long id, AnswerDto answerDto);
}
