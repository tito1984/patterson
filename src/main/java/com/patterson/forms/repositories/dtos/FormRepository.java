package com.patterson.forms.repositories.dtos;

import com.patterson.forms.entities.Form;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormRepository extends JpaRepository<Form,Long> {
}
