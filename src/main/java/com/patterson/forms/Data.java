package com.patterson.forms;

import com.patterson.forms.entities.Form;
import com.patterson.forms.entities.User;

import java.util.Optional;

public class Data {

    private Data() {
    }

    public static Optional<User> user001() {
        return Optional.of(new User(1L, "Pere", null));
    }
    public static Optional<Form> form001() {
        return Optional.of(new Form(1L, "What is your favorite position?"));
    }
    public static Optional<Form> form002() {
        return Optional.of(new Form(1L, "Are you right hand or left hand?"));
    }
}
