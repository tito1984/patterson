package com.patterson.forms.entities;


import javax.persistence.*;

@Entity
@Table(name = "forms")
public class Form {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String question;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User toUser;

    public Form(Long id, String question, User touser) {
        this.id = id;
        this.question = question;
        this.toUser = touser;
    }

    public Form() {

    }

    public User getToUser() {
        return toUser;
    }

    public String getQuestion() {
        return question;
    }

}
