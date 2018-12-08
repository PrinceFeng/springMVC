package com.prince.demo.controller;

import com.prince.demo.entity.User;
import com.prince.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * todo
 *
 * @author 陈树峰
 * @version 1.0
 * @date 2018/11/27
 **/
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/listuser", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> listUser() {

        Map<String, Object> modelMap = new HashMap<>();
        List<User> userList = userService.getUserList();

        modelMap.put("userList", userList);

        return modelMap;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String userList() {
        return "userlist";
    }
}
