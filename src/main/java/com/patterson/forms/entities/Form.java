package com.patterson.forms.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "forms")
public class Form {

    public enum Type {  }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String code;

    private Type type;

    @JsonBackReference
    @OneToOne(mappedBy = "form", cascade = CascadeType.ALL, orphanRemoval = true)
    private Answer answer;

    public Form(Long id, String code, Type type, Answer answer) {
        this.id = id;
        this.code = code;
        this.type = type;
        this.answer = answer;
    }

    public Form() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }
}
