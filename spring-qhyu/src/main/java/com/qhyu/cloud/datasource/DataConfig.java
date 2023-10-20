package com.qhyu.cloud.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * All rights Reserved, Designed By http://xnky.travelsky.net/ <br>
 * Title：DataConfig <br>
 * Package：com.qhyu.cloud.datasource <br> 
 * Copyright © 2022 xnky.travelsky.net Inc. All rights reserved. <br>
 * Company：Aviation Cares Of Southwest Chen Du LTD  <br>
 * @author 于琦海 <br>
 * date 2022年 06月24日 16:20 <br>
 * @version v1.0 <br>
 */
//@Configuration
// 开启事务管理
@EnableTransactionManagement
public class DataConfig {

	@Bean
	public DataSource dataSource(){
		// 使用阿里的连接池创建数据连接
		DruidDataSource druidDataSource = new DruidDataSource();
		druidDataSource.setUsername("skyworth");
		druidDataSource.setPassword("SkyWorth#2020");
		druidDataSource.setUrl("jdbc:mysql://192.168.17.103:3306/SkyWorth?characterEncoding=utf-8&useSSL=false&serverTimezone=Asia/Shanghai");
		druidDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		druidDataSource.setMinIdle(5);
		druidDataSource.setMaxActive(20);
		druidDataSource.setInitialSize(10);
		return druidDataSource;
	}

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource){
		return new JdbcTemplate(dataSource);
	}

	// 事务管理器
	@Bean
	public PlatformTransactionManager platformTransactionManager(DataSource dataSource){
		return new DataSourceTransactionManager(dataSource);
	}
}
