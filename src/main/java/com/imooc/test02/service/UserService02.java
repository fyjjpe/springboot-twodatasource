package com.imooc.test02.service;

import com.imooc.test02.mapper.UserMapper02;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yuanjie.fang on 2017/11/17.
 */
@Service
public class UserService02 {
    @Autowired
    private UserMapper02 userMapper02;

    public int addUser(String name, Integer age) {
        return userMapper02.addUser(name, age);
    }
}
