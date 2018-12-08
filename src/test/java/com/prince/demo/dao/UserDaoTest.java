package com.prince.demo.dao;

import com.prince.demo.BaseTest;
import com.prince.demo.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * todo
 *
 * @author 陈树峰
 * @version 1.0
 * @date 2018/11/26
 **/
public class UserDaoTest extends BaseTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void testQueryUserList() {

        List<User> userList = userDao.queryUserList();
        assertEquals(3, userList.size());
        for(User user : userList) {
            System.out.println(user.getUserName() + "---" + user.getAddress());

        }

    }

}
