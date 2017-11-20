package com.imooc.app;

import com.imooc.config.DBConfig1;
import com.imooc.config.DBConfig2;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.imooc.config", "com.imooc.controller", "com.imooc.test01", "com.imooc.test02", "com.imooc.datasource"})
@EnableAutoConfiguration
@EnableConfigurationProperties(value = {DBConfig1.class, DBConfig2.class})//开启读取properties文件类(用于分布式事务控制测试)
public class SpringbootTwodatasourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootTwodatasourceApplication.class, args);
    }
}
