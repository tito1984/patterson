package com.patterson.forms.entities;

import javax.persistence.*;
import java.lang.String;

@Entity
@Table(name = "answers")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String answer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private String question;

    public Answer(Long id, String answer, User user, String question) {
        this.id = id;
        this.answer = answer;
        this.user = user;
        this.question = question;
    }

    public Answer(long id, java.lang.String right, User user, String question) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public java.lang.String getAnswer() {
        return answer;
    }

    public void setAnswer(java.lang.String answer) {
        this.answer = answer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
