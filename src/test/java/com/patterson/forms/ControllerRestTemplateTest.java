package com.patterson.forms;

import static org.junit.jupiter.api.Assertions.*;

import com.patterson.forms.dtos.AnswerDto;
import com.patterson.forms.dtos.FormDto;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ControllerRestTemplateTest {

    @Autowired
    private TestRestTemplate client;

    @Test
    void testFindAllForms() {
        ResponseEntity<FormDto[]> response = client.getForEntity("/forms",FormDto[].class);
        List<FormDto> forms = Arrays.asList(response.getBody());

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON, response.getHeaders().getContentType());
        assertEquals(2, forms.size());
    }

    @Test
    void testSaveAnswer() {
        AnswerDto answerDto = new AnswerDto("Whats your name?", "Pere");
        Map<String,Long> pathVariable = new HashMap<>();
        pathVariable.put("id", 1L);

        ResponseEntity<AnswerDto> response = client.postForEntity(
                "/answers/1", answerDto, AnswerDto.class,pathVariable);
        AnswerDto answerDtoResponse = response.getBody();

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON, response.getHeaders().getContentType());
        assertEquals("Whats your name?",answerDtoResponse.getQuestion());
        assertEquals("Pere",answerDtoResponse.getAnswer());
    }

}
