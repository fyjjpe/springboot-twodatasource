package com.imooc.controller;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by yuanjie.fang on 2017/11/20.
 */
@Component
public class ScheduledTasks {

    @Scheduled(fixedRate = 1000)
    public void add(){
        System.out.println("我正在执行.."+System.currentTimeMillis());
    }
}
