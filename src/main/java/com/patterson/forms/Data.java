package com.patterson.forms;

import com.patterson.forms.entities.Form;
import com.patterson.forms.entities.User;

import java.util.Optional;

public class Data {

    private Data() {
    }

    public static Optional<User> user001() {
        return Optional.of(new User(1L, "Pere", null, null));
    }
    public static Optional<Form> form001() {
        return Optional.of(new Form(1L, "What is your favorite position?", user001().orElseThrow()));
    }
    public static Optional<Form> form002() {
        return Optional.of(new Form(1L, "Are you right hand or left hand?", user001().orElseThrow()));
    }
}
