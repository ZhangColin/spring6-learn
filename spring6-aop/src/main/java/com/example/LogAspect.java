package com.example;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class LogAspect {

    @Pointcut("execution(public int com.example.Calculator.*(..))")
    public void pointCut(){}


    @Before(value = "pointCut()")
    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        System.out.println("Logger-->前置通知 方法名：" + methodName + ", 参数：" + args);
    }

    @After(value = "pointCut()")
    public void afterMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();

        System.out.println("Logger-->后置通知 方法名：" + methodName + "");
    }

    @AfterReturning(value = "execution(public int com.example.Calculator.*(..))", returning = "result")
    public void afterReturningMethod(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();

        System.out.println("Logger-->返回通知 方法名：" + methodName + ", 结果：" + result);
    }

    @AfterThrowing(value = "execution(public int com.example.Calculator.*(..))", throwing = "ex")
    public void afterThrowingMethod(JoinPoint joinPoint, Throwable ex) {
        String methodName = joinPoint.getSignature().getName();

        System.out.println("Logger-->异常通知 方法名：" + methodName + "，异常：" + ex.getMessage());
    }

    @Around(value = "execution(public int com.example.Calculator.*(..))")
    public Object aroundMethod(ProceedingJoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        Object result = null;
        try {
            System.out.println("Logger-->前置通知 方法名：" + methodName + ", 参数：" + args);

            result = joinPoint.proceed();

            System.out.println("Logger-->返回通知 方法名：" + methodName + ", 结果：" + result);
        } catch (Throwable ex) {
            ex.printStackTrace();
            System.out.println("Logger-->异常通知 方法名：" + methodName + "，异常：" + ex.getMessage());
        } finally {
            System.out.println("Logger-->后置通知 方法名：" + methodName + "");
        }
        return result;
    }

}
