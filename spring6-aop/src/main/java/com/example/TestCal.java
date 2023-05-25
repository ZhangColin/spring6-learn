package com.example;

public class TestCal {
    public static void main(String[] args) {
        ProxyFactory factory = new ProxyFactory(new CalculatorImpl());
        Calculator calculator = (Calculator) factory.getProxy();

        int result = calculator.add(1, 1);

        System.out.println(result);
    }
}
