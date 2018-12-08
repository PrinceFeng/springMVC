package com.prince.demo.dao;

import com.prince.demo.entity.User;

import java.util.List;

/**
 * todo
 *
 * @author 陈树峰
 * @version 1.0
 * @date 2018/11/26
 **/
public interface UserDao {

    /**
     * 查询用户信息列表
     *
     * @return userList
     */
    List<User> queryUserList();
}
