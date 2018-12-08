package com.prince.demo.service.impl;

import com.prince.demo.dao.UserDao;
import com.prince.demo.entity.User;
import com.prince.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * todo
 *
 * @author 陈树峰
 * @version 1.0
 * @date 2018/11/27
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getUserList() {
        return userDao.queryUserList();
    }
}
