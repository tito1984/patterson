package com.patterson.forms.dtos;

public class FormDto {

    private String question;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public FormDto() {
    }

    public FormDto(String question) {
        this.question = question;
    }
}
