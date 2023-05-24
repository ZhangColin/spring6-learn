package com.example.auto;

public class UserController {
    private UserService userService;

    public void addUser(){
        System.out.println("userController 执行了...");
        userService.addUser();
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
