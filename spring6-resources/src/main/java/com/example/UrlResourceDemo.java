package com.example;

import org.springframework.core.io.UrlResource;

import java.net.MalformedURLException;

public class UrlResourceDemo {
    public static void main(String[] args) {
//        loadUrlResource("http://www.baidu.com");
        loadUrlResource("file:.gitignore");
    }
    public static void loadUrlResource(String path){
        try {
            UrlResource urlResource = new UrlResource(path);

            System.out.println(urlResource.getFilename());
            System.out.println(urlResource.getURI());
            System.out.println(urlResource.getDescription());
            System.out.println(urlResource.getInputStream().read());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
