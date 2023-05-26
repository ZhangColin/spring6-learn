package com.example.person;

import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;

public class TestPerson {
    public static void main(String[] args) {
        Person person = new Person();

        DataBinder binder = new DataBinder(person);

        binder.setValidator(new PersonValidator());

        binder.validate();

        BindingResult bindingResult = binder.getBindingResult();

        System.out.println(bindingResult.getAllErrors());
    }
}
