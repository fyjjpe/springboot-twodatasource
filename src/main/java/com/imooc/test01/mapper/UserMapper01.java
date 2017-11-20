package com.imooc.test01.mapper;

import com.imooc.entity.User1Entity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

/**
 * Created by yuanjie.fang on 2017/11/17.
 */
@CacheConfig(cacheNames = "baseCache")
public interface UserMapper01 {

    @Insert("insert into user (name,age) values (#{name},#{age})")
    public int addUser(@Param("name") String name, @Param("age") Integer age);

    @Select("select * from user where id=#{id}")
    @Cacheable
    public User1Entity selectUser(@Param("id") Integer id);
}
