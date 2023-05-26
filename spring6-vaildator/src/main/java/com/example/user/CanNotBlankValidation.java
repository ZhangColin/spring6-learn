package com.example.user;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CanNotBlankValidation implements ConstraintValidator<CanNotBlank,String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        //null时不进行校验
        if (value != null && value.contains(" ")) {
            //获取默认提示信息
            String defaultConstraintMessageTemplate = context.getDefaultConstraintMessageTemplate();
            System.out.println("default message :" + defaultConstraintMessageTemplate);
            //禁用默认提示信息
            context.disableDefaultConstraintViolation();
            //设置提示语
            context.buildConstraintViolationWithTemplate("can not contains blank").addConstraintViolation();
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MethodValidationConfig.class);

        MyService service = context.getBean(MyService.class);

        User user = new User();
        user.setName("zhang colin");

        service.testMethod(user);
    }
}
