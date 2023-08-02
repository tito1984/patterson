package com.patterson.forms.services;

import com.patterson.forms.entities.Answer;
import com.patterson.forms.entities.User;
import com.patterson.forms.exceptions.ResourceNotFoundException;
import com.patterson.forms.repositories.dtos.AnswerRepository;
import com.patterson.forms.repositories.dtos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerRepository answerRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public Answer save(Answer answer) {
        Long id = answer.getUser().getId();
        userRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(answer.getUser().getId()));
        return answerRepository.save(answer);
    }
}
