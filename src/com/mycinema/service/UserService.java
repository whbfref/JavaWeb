package com.mycinema.service;

import com.mycinema.dao.UserDao;
import com.mycinema.model.Book;
import com.mycinema.model.User;

import java.util.ArrayList;

public class UserService {
    UserDao userDao=new UserDao();
    public ArrayList<User> findAll()
    {
        return userDao.selectAll();
    }
    public int register(User user, String confirmPassword) {
        // 检查用户名是否已存在
        if (userDao.usernameExists(user.getUsername())) {
            throw new IllegalArgumentException("用户名已存在");
        }

        // 确认密码是否匹配
        if (!user.getPassword().equals(confirmPassword)) {
            throw new IllegalArgumentException("两次输入的密码不匹配");
        }

        // 进行注册
        return userDao.insertUser (user);
    }
    public User login(String username,String password,int role)
    {
        return userDao.selectByUsernameAndPassword(username,password,role);
    }
}
