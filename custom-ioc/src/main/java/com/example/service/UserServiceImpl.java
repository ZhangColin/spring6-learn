package com.example.service;

import com.example.annotation.B;
import com.example.annotation.Di;
import com.example.dao.UserDao;

@B
public class UserServiceImpl implements UserService{
    @Di
    private UserDao userDao;

    @Override
    public void add() {
        System.out.println("Service ...");
        userDao.add();
    }
}
