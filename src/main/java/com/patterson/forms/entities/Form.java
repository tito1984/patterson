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

    public Form(Long id, String question, User toUser) {
        this.id = id;
        this.question = question;
        this.toUser = toUser;
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
