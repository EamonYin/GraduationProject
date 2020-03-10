package com.mcyy.service.impl;

import com.mcyy.dao.mapper.UserMapper;
import com.mcyy.entity.User;
import com.mcyy.entity.UserExample;
import com.mcyy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> SelectUser(UserExample userExample) {
        return userMapper.selectByExample(userExample);
    }

    @Override
    public int InsertUser(User user) {
        return userMapper.insert(user);
    }



}
