package com.example.health.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.alibaba.fastjson.JSON;
import com.example.health.bean.user;
import com.example.health.dao.UserDao;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class LoginController {
    // private static final Logger logger =
    // LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private final UserDao userDao;

    public LoginController(UserDao userDao) {
        this.userDao = userDao;
    }

    @RequestMapping("/login")
    public String login(@RequestBody user user) {
        String flag = "error";
        user us = userDao.getUserByMassage(user.getusername(), user.getpassword());
        // System.out.println(us);
        HashMap<String, Object> res = new HashMap<>();
        if (us != null) {
            flag = "ok";
        }
        res.put("flag", flag);
        res.put("user", user);
        String res_json = JSON.toJSONString(res);
        return res_json;

    }

}