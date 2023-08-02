package com.patterson.forms.services;

import com.patterson.forms.entities.Answer;
import com.patterson.forms.repositories.dtos.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    @Override
    public Answer save(Answer answer) {

        return answerRepository.save(answer);
    }
}
