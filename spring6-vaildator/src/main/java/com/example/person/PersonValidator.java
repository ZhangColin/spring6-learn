package com.example.person;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class PersonValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person p = (Person) target;
        ValidationUtils.rejectIfEmpty(errors, "name", "name.empty", "name is null.");

        if (p.getAge() <= 0) {
            errors.rejectValue("age", "age.value.min", "age <= 0");
        }
        else if (p.getAge() > 200) {
            errors.rejectValue("age", "age.value.max", "age > 200");
        }
    }
}
