package com.mcyy.service.impl;

import com.mcyy.dao.mapper.UserMapper;
import com.mcyy.entity.User;
import com.mcyy.entity.UserExample;
import com.mcyy.service.EditAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author XiaoMing
 * @create 2020/3/18 21:05
 */
@Service
public class EditAdminServiceImpl  implements EditAdminService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User SelectUserById(Integer uId) {
        return userMapper.selectByPrimaryKey(uId);
    }

    @Override
    public int UpdateUserById(User record, UserExample example) {
        return userMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int DeleteUserById(Integer uId) {
        return userMapper.deleteByPrimaryKey(uId);
    }
}
