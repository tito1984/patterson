package com.patterson.forms.entities;

import com.patterson.forms.dtos.AnswerDto;

import javax.persistence.*;

@Entity
@Table(name = "answers")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String answerQuestion;

    private String question;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Answer(Long id, String answer, User user, String question) {
        this.id = id;
        this.answerQuestion = answer;
        this.user = user;
        this.question = question;
    }

    public Answer() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public java.lang.String getAnswerQuestion() {
        return answerQuestion;
    }


    public User getUser() {
        return user;
    }

    public String getQuestion() {
        return question;
    }

    public Answer(User user, AnswerDto answerDto) {
        this.answerQuestion = answerDto.getAnswer();
        this.question = answerDto.getQuestion();
        this.user = user;
    }
}
