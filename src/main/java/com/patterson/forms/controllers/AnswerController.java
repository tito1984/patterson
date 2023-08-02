package com.patterson.forms.controllers;

import com.patterson.forms.dtos.AnswerDto;
import com.patterson.forms.entities.Answer;
import com.patterson.forms.exceptions.ResourceNotFoundException;
import com.patterson.forms.services.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/answers")
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @PostMapping("/{id}")
    public ResponseEntity<AnswerDto> save(@PathVariable Long id, @RequestBody AnswerDto answerDto) {
        try {
            return new ResponseEntity<>(answerService.save(id, answerDto),HttpStatus.CREATED);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
