package com.patterson.forms;

import com.patterson.forms.entities.Answer;
import com.patterson.forms.entities.Form;
import com.patterson.forms.entities.User;

import java.util.Optional;

public class Data {

    public static Optional<User> user001() {
        return Optional.of(new User(1L, "Pere", User.Role.ADM, null));
    }
    public static Optional<User> user002() {
        return Optional.of(new User(1L, "David", User.Role.USR, null));
    }
    public static Optional<User> user003() {
        return Optional.of(new User(1L, "Oscar", User.Role.USR, null));
    }

    public static Optional<Form> form001() {
        return Optional.of(new Form(1L, "What is your favorite position?",null));
    }
    public static Optional<Form> form002() {
        return Optional.of(new Form(1L, "Are you right hand or left hand?",null));
    }

    public static Optional<Answer> answer001() {
        return Optional.of(new Answer(1L, "Right", user001().orElseThrow(),form001().get().getQuestion()));
    }
    public static Optional<Answer> answer002() {
        return Optional.of(new Answer(1L, "Left", user001().orElseThrow(),form002().get().getQuestion()));
    }
}
