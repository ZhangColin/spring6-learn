package com.example.user;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class MyValidation1 {
    @Autowired
    private Validator validator;

    public boolean validate(User user){
        Set<ConstraintViolation<User>> result = validator.validate(user);

        return result.isEmpty();
    }
}
