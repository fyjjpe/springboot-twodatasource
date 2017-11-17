package com.imooc.controller;

import com.imooc.test01.service.UserService01;
import com.imooc.test02.service.UserService02;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yuanjie.fang on 2017/11/17.
 * 测试操作多数据源，即同时操作两个数据库
 */
@RestController
public class UserController {
    @Autowired
    private UserService01 userService01;
    @Autowired
    private UserService02 userService02;

    @RequestMapping("/addUser")
    @Transactional
    public String add() {
        userService02.addUser("test002", 20);
        int i = 1 / 0;
        userService01.addUser("test001", 19);
        return "success";
    }
}
