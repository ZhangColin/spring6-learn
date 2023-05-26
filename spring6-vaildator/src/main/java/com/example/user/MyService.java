package com.example.user;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class MyService {
    public String testMethod(@NotNull @Valid User user){
        return user.toString();
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MethodValidationConfig.class);

        MyService service = context.getBean(MyService.class);

        User user = new User();

        service.testMethod(user);
    }
}
