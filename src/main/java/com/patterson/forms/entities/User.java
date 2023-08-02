package com.patterson.forms.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    public enum Role { ADM, USR };

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Form name;

    private Role role;

    @JsonBackReference
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Answer> answers = new ArrayList<>();

    public User(Long id, Form name, Role role, List<Answer> answers) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.answers = answers;
    }

    public User(long id, java.lang.String pere, Role adm, Object answers) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Form getName() {
        return name;
    }

    public void setName(Form name) {
        this.name = name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Answer> getAnswer() {
        return answers;
    }

    public void setAnswer(List<Answer> answers) {
        this.answers = answers;
    }
}
