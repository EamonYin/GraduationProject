package com.mcyy.service;

import com.mcyy.entity.User;
import com.mcyy.entity.UserExample;

import java.util.List;

public interface UserService {
    //查询所有用户
    List<User> SelectUser(UserExample userExample);
    //插入用户
    int InsertUser(User user);

}
