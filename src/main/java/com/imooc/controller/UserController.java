package com.imooc.controller;

import com.imooc.test01.mapper.UserMapper01;
import com.imooc.test01.service.UserService01;
import com.imooc.test02.service.UserService02;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
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
    @Autowired
    private UserMapper01 userMapper01;
    @Autowired
    private CacheManager cacheManager;

    @Value("${name}")//获取自定义参数的注解
    private String name;

    @RequestMapping("/addUser")
    @Transactional
    public String add() {
        userService02.addUser("test002", 20);
        int i = 1 / 0;
        userService01.addUser("test001", 19);
        return "success";
    }

    //测试将数据cache加入缓存
    @RequestMapping("/getUserName")
    public String getUserName(Integer id) {
        return userMapper01.selectUser(id).toString();
    }

    //测试将数据从cache缓存中删除
    @RequestMapping("/removeCache")
    public void remove() {
        cacheManager.getCache("baseCache").clear();
    }

    //测试异步执行注解 @Async
    @RequestMapping("/sendMsg")
    public void sendMsg() {
        System.out.println("#sendMsg  1");
        userService01.sendMsg();
        System.out.println("#sendMsg  4");
    }

    @RequestMapping("/getName")
    public String getName() {
        return name;
    }

}
