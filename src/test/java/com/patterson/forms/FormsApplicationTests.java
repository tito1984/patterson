package com.patterson.forms;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static com.patterson.forms.Data.*;

import com.patterson.forms.entities.Answer;
import com.patterson.forms.entities.Form;
import com.patterson.forms.exceptions.ResourceNotFoundException;
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
	FormService formService;
	@Autowired
	AnswerService answerService;

	@Test
	void contextLoads() {
	}

	@Test
	void testGetAll() {
		Form form1 = form001().orElseThrow();
		Form form2 = form002().orElseThrow();
		List<Form> data = Arrays.asList(form1, form2);
		when(formRepository.findAll()).thenReturn(data);

		List<Form> forms = formService.findAll();

		assertFalse(forms.isEmpty());
		assertEquals(forms.size(), 2);
		assertTrue(forms.contains(form1));
		assertTrue(forms.contains(form2));
		verify(formRepository).findAll();
	}

	@Test
	void testSaveAnswers() {
		Answer newAnswer = new Answer(null,"Left",
				user001().get(),form001().get().getQuestion());
		when(userRepository.findById(1L)).thenReturn(user001());
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
		verify(userRepository).findById(user001().get().getId());
	}

	@Test
	void testSaveAnswersUserNotFoundException() {
		Answer newAnswer = new Answer(null,"Left",
				user001().orElseThrow(),form001().get().getQuestion());

		when(userRepository.findById(1L)).thenThrow(new ResourceNotFoundException(1L));

		assertThrows(ResourceNotFoundException.class,() -> {
			answerService.save(newAnswer);
		});
		verify(userRepository).findById(1L);
	}

}
