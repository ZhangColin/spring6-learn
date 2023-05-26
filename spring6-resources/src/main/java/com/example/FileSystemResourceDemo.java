package com.example;

import org.springframework.core.io.FileSystemResource;

import java.io.IOException;
import java.io.InputStream;

public class FileSystemResourceDemo {
    public static void main(String[] args) {
        loadFileSystemResource("/Users/colin/workspace/spring6-learn/spring6-resources/src/main/resources/hello.txt");
    }
    public static void loadFileSystemResource(String path) {
        FileSystemResource fileSystemResource = new FileSystemResource(path);

        System.out.println(fileSystemResource.getFilename());
        System.out.println(fileSystemResource.getDescription());

        try {
            InputStream inputStream = fileSystemResource.getInputStream();
            byte[] b = new byte[1024];
            while (inputStream.read(b)!=-1){
                System.out.println(new String(b));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
