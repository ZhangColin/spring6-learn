package com.example;

import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;

public class ClassPathResourceDemo {
    public static void main(String[] args) {
        loadClasspathResource("hello.txt");
    }
    public static void loadClasspathResource(String path) {
        ClassPathResource classPathResource = new ClassPathResource(path);

        System.out.println(classPathResource.getFilename());
        System.out.println(classPathResource.getDescription());

        try {
            InputStream inputStream = classPathResource.getInputStream();
            byte[] b = new byte[1024];
            while (inputStream.read(b)!=-1){
                System.out.println(new String(b));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
