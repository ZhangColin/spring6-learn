package com.example;

import org.springframework.stereotype.Component;

@Component
public class CalculatorImpl implements Calculator{
    @Override
    public int add(int a, int b) {
        int result = a+b;
        System.out.println("add 方法内部 result="+result);
        return result;
    }

    @Override
    public int sub(int a, int b) {
        int result = a-b;
        System.out.println("sub 方法内部 result="+result);
        return result;
    }

    @Override
    public int mul(int a, int b) {
        int result = a*b;
        System.out.println("mul 方法内部 result="+result);
        return result;
    }

    @Override
    public int div(int a, int b) {
        int result = a/b;
        System.out.println("div 方法内部 result="+result);
        return result;
    }
}
