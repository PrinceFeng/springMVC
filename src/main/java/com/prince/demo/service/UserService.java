package com.prince.demo.service;

import com.prince.demo.entity.User;

import java.util.List;

/**
 * todo
 *
 * @author 陈树峰
 * @version 1.0
 * @date 2018/11/27
 **/
public interface UserService {

    /**
     * 获取用户信息列表
     * @return userList
     */
    List<User> getUserList();
}
