package com.patterson.forms.dtos;

public class AnswerDto {

    private String question;
    private String answer;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public AnswerDto() {
    }

    public AnswerDto(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }
}
