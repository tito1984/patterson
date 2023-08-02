package com.patterson.forms.controllers;

import com.patterson.forms.dtos.FormDto;
import com.patterson.forms.exceptions.ResourceNotFoundException;
import com.patterson.forms.services.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/forms")
public class FormController {

    @Autowired
    private FormService formService;

    @GetMapping("/{id}")
    public ResponseEntity<List<FormDto>> findByToUser(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(formService.findByToUser(id), HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
