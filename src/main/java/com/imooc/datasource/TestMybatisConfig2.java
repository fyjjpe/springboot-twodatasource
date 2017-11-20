package com.imooc.datasource;


import com.imooc.config.DBConfig2;
import com.mysql.jdbc.jdbc2.optional.MysqlXADataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * Created by yuanjie.fang on 2017/11/20.
 * 测试分布式事务控制
 */
@Configuration //注入到spring容器中
@MapperScan(basePackages = "com.imooc.test02", sqlSessionTemplateRef = "test2SqlSessionTemplate")
public class TestMybatisConfig2 {

    //配置数据源
    @Bean(name = "test2DataSource")
    public DataSource testDataSource(DBConfig2 testConfig) throws Exception {
        MysqlXADataSource mysqlXADataSource = new MysqlXADataSource();
        mysqlXADataSource.setUrl(testConfig.getUrl());
        mysqlXADataSource.setPinGlobalTxToPhysicalConnection(true);
        mysqlXADataSource.setPassword(testConfig.getPassword());
        mysqlXADataSource.setUser(testConfig.getUsername());

        AtomikosDataSourceBean atomikosDataSourceBean = new AtomikosDataSourceBean();
        atomikosDataSourceBean.setXaDataSource(mysqlXADataSource);
        atomikosDataSourceBean.setUniqueResourceName("test2DataSource");
        atomikosDataSourceBean.setMinPoolSize(testConfig.getMinPoolSize());
        atomikosDataSourceBean.setMaxPoolSize(testConfig.getMaxPoolSize());
        atomikosDataSourceBean.setMaxLifetime(testConfig.getMaxLifetime());
        atomikosDataSourceBean.setBorrowConnectionTimeout(testConfig.getBorrowConnectionTimeout());
        atomikosDataSourceBean.setLoginTimeout(testConfig.getLoginTimeout());
        atomikosDataSourceBean.setMaintenanceInterval(testConfig.getMaintenanceInterval());
        atomikosDataSourceBean.setMaxIdleTime(testConfig.getMaxIdleTime());
        atomikosDataSourceBean.setTestQuery(testConfig.getTestQuery());

        return atomikosDataSourceBean;
    }

    @Bean(name = "test2SqlSessionFactory")
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("test2DataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();
    }

    @Bean(name = "test2SqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("test2SqlSessionFactory")SqlSessionFactory sqlSessionFactory) throws Exception{
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
