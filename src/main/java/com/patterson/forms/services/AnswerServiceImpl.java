package com.patterson.forms.services;

import com.patterson.forms.dtos.AnswerDto;
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
    public AnswerDto save(Long id, AnswerDto answerDto) {
        User user = userRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(id));
        answerRepository.save(new Answer(user, answerDto));
        return answerDto;
    }
}
