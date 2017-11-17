package com.imooc.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.imooc.controller", "com.imooc.test01", "com.imooc.test02","com.imooc.datasource"})
@EnableAutoConfiguration
public class SpringbootTwodatasourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootTwodatasourceApplication.class, args);
	}
}
