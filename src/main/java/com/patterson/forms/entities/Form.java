package com.patterson.forms.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "forms")
public class Form {

        @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String question;


    @JsonBackReference
    @OneToMany(mappedBy = "form", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Answer> answers = new ArrayList<>();

    public Form(Long id, String question, List<Answer> answers) {
        this.id = id;
        this.question = question;
        this.answers = answers;
    }

    public Form() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Answer> getAnswer() {
        return answers;
    }

    public void setAnswer(List<Answer> answers) {
        this.answers = answers;
    }

    public String getPartialCode() {
        return this.question.substring(0,4);
    }

}
