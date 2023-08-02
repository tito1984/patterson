package com.patterson.forms.repositories;

import com.patterson.forms.entities.Form;
import com.patterson.forms.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FormRepository extends JpaRepository<Form,Long> {

    List<Form> findByToUser(User toUser);

    Optional<Form> findByToUserAndQuestion(User toUser, String question);
}
