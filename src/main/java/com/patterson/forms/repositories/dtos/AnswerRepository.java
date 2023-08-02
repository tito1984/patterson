package com.patterson.forms.repositories.dtos;

import com.patterson.forms.entities.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer,Long> {
}
