package com.mcyy.service;

import com.mcyy.entity.User;
import com.mcyy.entity.UserExample;

/**
 * @Author XiaoMing
 * @create 2020/3/18 21:05
 */
public interface EditAdminService {

    //根据id查询用户
    User SelectUserById(Integer uId);
    //更新指定用户信息
    int UpdateUserById(User record, UserExample example);
    //删除指定ID用户
    int DeleteUserById(Integer uId);

}
