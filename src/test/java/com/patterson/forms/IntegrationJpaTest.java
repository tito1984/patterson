package com.patterson.forms;

import com.patterson.forms.repositories.dtos.AnswerRepository;
import com.patterson.forms.repositories.dtos.FormRepository;
import com.patterson.forms.repositories.dtos.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

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

    }

    @Test
    void testFindAllForm() {

    }

    @Test
    void testSaveAnswer() {

    }
}
