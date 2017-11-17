package com.imooc.test01.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

/**
 * Created by yuanjie.fang on 2017/11/17.
 */
public interface UserMapper01 {

    @Insert("insert into user (name,age) values (#{name},#{age})")
    public int addUser(@Param("name") String name, @Param("age") Integer age);
}
