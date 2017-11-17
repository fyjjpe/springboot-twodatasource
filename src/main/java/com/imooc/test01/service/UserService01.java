package com.imooc.test01.service;

import com.imooc.test01.mapper.UserMapper01;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yuanjie.fang on 2017/11/17.
 */
@Service
public class UserService01 {
    @Autowired
    private UserMapper01 userMapper01;

    public int addUser(String name, Integer age) {
        return userMapper01.addUser(name, age);
    }
}
