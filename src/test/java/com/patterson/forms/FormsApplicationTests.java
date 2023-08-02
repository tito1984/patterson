package com.patterson.forms;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static com.patterson.forms.Data.*;

import com.patterson.forms.entities.Answer;
import com.patterson.forms.entities.Form;
import com.patterson.forms.repositories.dtos.AnswerRepository;
import com.patterson.forms.repositories.dtos.FormRepository;
import com.patterson.forms.repositories.dtos.UserRepository;
import com.patterson.forms.services.AnswerService;
import com.patterson.forms.services.FormService;
import com.patterson.forms.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class FormsApplicationTests {

	@MockBean
	UserRepository userRepository;
	@MockBean
	FormRepository formRepository;
	@MockBean
	AnswerRepository answerRepository;

	@Autowired
	UserService userService;
	@Autowired
	FormService formService;
	@Autowired
	AnswerService answerService;

	@Test
	void contextLoads() {
	}

	@Test
	void testGetPersonalizedUrlForUser() {

	}

	@Test
	void testGetFormToAnswer() {
		List<Form> data = Arrays.asList(form001().orElseThrow(), form002().orElseThrow());
		when(formRepository.findAll()).thenReturn(data);

		List<Form> forms = formService.findAll();

		assertFalse(forms.isEmpty());
		assertEquals(forms.size(), 2);
		assertTrue(forms.contains(form001().orElseThrow()));
		assertTrue(forms.contains(form002().orElseThrow()));
		verify(formRepository).findAll();
	}

	@Test
	void testSaveAnswers() {
		Answer newAnswer = new Answer(null,"Left",
				user001().orElseThrow(),form001().get().getQuestion());
		when(answerRepository.save(any())).then(invocation -> {
			Answer a = invocation.getArgument(0);
			a.setId(1L);
			return a;
		});

		Answer answer = answerService.save(newAnswer);

		assertEquals(answer.getId(), 1);
		assertEquals(answer.getAnswer(), "Left");
		assertEquals(answer.getQuestion(), form001().get().getQuestion());
		verify(answerRepository).save(newAnswer);
	}

}
