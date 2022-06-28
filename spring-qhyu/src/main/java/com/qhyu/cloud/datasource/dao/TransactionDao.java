package com.qhyu.cloud.datasource.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;

/**
 * All rights Reserved, Designed By http://xnky.travelsky.net/ <br>
 * Title：TransactionDao <br>
 * Package：com.qhyu.cloud.datasource.dao <br> 
 * Copyright © 2022 xnky.travelsky.net Inc. All rights reserved. <br>
 * Company：Aviation Cares Of Southwest Chen Du LTD  <br>
 * @author 于琦海 <br>
 * date 2022年 06月28日 10:27 <br>
 * @version v1.0 <br>
 */
@Component
public class TransactionDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;


	// id例子:0008cce0-3c92-45ea-957f-4f6dd568a3e2
	public Object UserQuery(String id){
		return jdbcTemplate.queryForMap("select * from skyworth_user where id = ?",id);
	}


	@SuppressWarnings({"divzero"})
	public int UserUpdate(String id,int flag) throws RuntimeException{
		int update = jdbcTemplate.update("update skyworth_user set is_first_login = ? where id ='0008cce0-3c92-45ea-957f-4f6dd568a3e2' ", flag);
		int i=1/0;
		return update;
	}

}
