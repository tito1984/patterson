package com.patterson.forms.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "forms")
public class Form {

    public enum Type { PADEL_POS, PREF_ARM }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String code;

    private Type type;

    @JsonBackReference
    @OneToMany(mappedBy = "form", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Answer> answers = new ArrayList<>();

    public Form(Long id, String code, Type type, List<Answer> answers) {
        this.id = id;
        this.code = code;
        this.type = type;
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

    public List<Answer> getAnswer() {
        return answers;
    }

    public void setAnswer(List<Answer> answers) {
        this.answers = answers;
    }

    public static String createToUser(Long userId, Type type) {
        return type.name()+userId;
    }
}
