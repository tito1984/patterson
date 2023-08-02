package com.patterson.forms;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static com.patterson.forms.Data.*;

import com.patterson.forms.dtos.AnswerDto;
import com.patterson.forms.dtos.FormDto;
import com.patterson.forms.entities.Answer;
import com.patterson.forms.entities.Form;
import com.patterson.forms.exceptions.ResourceNotFoundException;
import com.patterson.forms.repositories.AnswerRepository;
import com.patterson.forms.repositories.FormRepository;
import com.patterson.forms.repositories.UserRepository;
import com.patterson.forms.services.AnswerService;
import com.patterson.forms.services.FormService;
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
	void testGetAllFromUser() {
		Form form1 = form001().orElseThrow();
		Form form2 = form002().orElseThrow();
		List<Form> data = Arrays.asList(form1, form2);
		when(userRepository.findById(1L)).thenReturn(user001());
		when(formRepository.findByToUser(any())).thenReturn(data);

		List<FormDto> forms = formService.findByToUser(user001().orElseThrow().getId());

		assertFalse(forms.isEmpty());
		assertEquals(2,forms.size());
		assertEquals(forms.get(0).getQuestion(), form1.getQuestion());
		assertEquals(forms.get(1).getQuestion(), form2.getQuestion());
		verify(formRepository).findByToUser(any());
	}

	@Test
	void testSaveAnswers() {
		AnswerDto newAnswer = new AnswerDto(form001().orElseThrow().getQuestion(), "Left");
		when(userRepository.findById(1L)).thenReturn(user001());
		when(formRepository.findByToUserAndQuestion(any(),any())).thenReturn(form002());
		when(answerRepository.save(any())).then(invocation -> {
			Answer a = invocation.getArgument(0);
			a.setId(1L);
			return a;
		});

		AnswerDto answerDto = answerService.save(user001().orElseThrow().getId(), newAnswer);

		assertEquals("Left",answerDto.getAnswer());
		assertEquals(answerDto.getQuestion(), form001().orElseThrow().getQuestion());
		verify(answerRepository).save(any());
		verify(userRepository).findById(user001().orElseThrow().getId());
		verify(formRepository).findByToUserAndQuestion(any(),any());
	}

	@Test
	void testSaveAnswersUserNotFoundExceptionById() {
		AnswerDto newAnswer = new AnswerDto("Left",form001().orElseThrow().getQuestion());

		when(userRepository.findById(1L)).thenThrow(new ResourceNotFoundException(1L));

		assertThrows(ResourceNotFoundException.class,() -> answerService.save(1L, newAnswer));
		verify(userRepository).findById(1L);
	}

	@Test
	void testSaveAnswersUserNotFoundExceptionByQuestion() {
		AnswerDto newAnswer = new AnswerDto("Left",form001().orElseThrow().getQuestion());

		when(userRepository.findById(1L)).thenReturn(user001());
		when(formRepository.findByToUserAndQuestion(any(),any())).thenThrow(new ResourceNotFoundException("User or Question"));

		assertThrows(ResourceNotFoundException.class,() -> answerService.save(1L, newAnswer));
		verify(userRepository).findById(1L);
		verify(formRepository).findByToUserAndQuestion(any(),any());
	}
}
