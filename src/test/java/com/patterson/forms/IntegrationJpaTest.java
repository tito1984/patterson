package com.patterson.forms;

import static org.junit.jupiter.api.Assertions.*;
import static com.patterson.forms.Data.*;

import com.patterson.forms.entities.Answer;
import com.patterson.forms.entities.Form;
import com.patterson.forms.entities.User;
import com.patterson.forms.repositories.AnswerRepository;
import com.patterson.forms.repositories.FormRepository;
import com.patterson.forms.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

@DataJpaTest
class IntegrationJpaTest {

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
        assertEquals("Pere", user.get().getName());
    }

    @Test
    void testFindAllFormFromUser() {
        List<Form> forms = formRepository.findByToUser(user001().orElseThrow());

        assertFalse(forms.isEmpty());
        assertEquals(2, forms.size());
    }

    @Test
    void testFindByToUserAndQuestion() {
        User user = user001().orElseThrow();
        Form form = formRepository.findByToUserAndQuestion(
                user, form001().orElseThrow().getQuestion()
        ).orElseThrow();

        assertEquals(form001().orElseThrow().getQuestion(), form.getQuestion());
        assertEquals(user.getName(),form.getToUser().getName());
        assertEquals(user.getId(),form.getToUser().getId());
    }

    @Test
    void testSaveAnswer() {
        Answer answerToSave = new Answer(null, "Right",
                user001().orElseThrow(),form001().orElseThrow().getQuestion());

        Answer answer = answerRepository.save(answerToSave);

        assertEquals("Right", answer.getAnswerQuestion());
        assertEquals(form001().orElseThrow().getQuestion(), answer.getQuestion());
        assertEquals(user001().orElseThrow().getId(), answer.getUser().getId());
    }
}
