package com.patterson.forms;

import static org.junit.jupiter.api.Assertions.*;
import static com.patterson.forms.Data.*;

import com.patterson.forms.entities.Answer;
import com.patterson.forms.entities.Form;
import com.patterson.forms.entities.User;
import com.patterson.forms.repositories.dtos.AnswerRepository;
import com.patterson.forms.repositories.dtos.FormRepository;
import com.patterson.forms.repositories.dtos.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
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
        assertEquals(user.get().getName(), "Pere");
    }

    @Test
    void testFindAllForm() {
        List<Form> forms = formRepository.findAll();

        assertFalse(forms.isEmpty());
        assertEquals(forms.size(), 2);
    }

    @Test
    void testSaveAnswer() {
        Answer answerToSave = new Answer(null, "Right",
                user001().orElseThrow(),form001().get().getQuestion());

        Answer answer = answerRepository.save(answerToSave);

        assertEquals("Right", answer.getAnswer());
        assertEquals(form001().get().getQuestion(), answer.getQuestion());
        assertEquals(user001().get().getId(), answer.getUser().getId());
    }
}
