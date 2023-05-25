package com.example.dao;

import com.example.annotation.B;

@B
public class UserDaoImpl implements UserDao{
    @Override
    public void add() {
        System.out.println("Dao ...");
    }
}
