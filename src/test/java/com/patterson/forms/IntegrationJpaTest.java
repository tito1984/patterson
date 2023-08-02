package com.patterson.forms;

import static org.junit.jupiter.api.Assertions.*;

import com.patterson.forms.entities.User;
import com.patterson.forms.repositories.dtos.AnswerRepository;
import com.patterson.forms.repositories.dtos.FormRepository;
import com.patterson.forms.repositories.dtos.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
public class IntegrationJpaTest {

    @Autowired
    UserRepository userRepository;
    @Autowired
    FormRepository formRepository;
    @Autowired
    AnswerRepository answerRepository;

    @Test
    void testFindUserById() {
        Optional<User> user = userRepository.findById(1L);

        assertTrue(user.isPresent());
    }

    @Test
    void testFindAllForm() {

    }

    @Test
    void testSaveAnswer() {

    }
}
