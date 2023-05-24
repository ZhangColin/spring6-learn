package com.example.auto;

public class UserServiceImpl implements UserService{
    private UserDao userDao;
    @Override
    public void addUser() {
        System.out.println("userService 执行了...");
        userDao.addUser();
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
