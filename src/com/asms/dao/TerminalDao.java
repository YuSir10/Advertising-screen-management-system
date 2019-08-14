package com.asms.dao;

import java.sql.SQLException;

import com.asms.res.IP;
import com.asms.tool.DButils;

public class TerminalDao {

	public void addIp(IP saveIp) throws SQLException {
		// TODO Auto-generated method stub
		DButils db=new DButils();
		String sql="insert into Terminal(IP) values(?)";
		db.preUpdate(sql, saveIp.getIp());
		
	}

}
