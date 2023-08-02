package com.patterson.forms.repositories.dtos;

import com.patterson.forms.entities.Form;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FormRepository extends JpaRepository<Form,Long> {
}
