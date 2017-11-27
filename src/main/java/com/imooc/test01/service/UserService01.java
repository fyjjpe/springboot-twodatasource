package com.imooc.test01.service;

import com.imooc.test01.mapper.UserMapper01;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
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

    @Async
    public void sendMsg() {
        System.out.println("#sendMsg 开始  2");
        for (int i = 0; i < 5; i++) {
            try {
                System.out.println("i:" + i);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("#sendMsg 结束  3");
    }
}
