package com.asms.dao;

import java.sql.SQLException;

import com.asms.res.IP;
import com.asms.tool.DButils;

public class TerminalDao {

	public int addIp(String ipname) throws SQLException {
		// TODO Auto-generated method stub
		DButils db=new DButils();
		String sql="insert into Terminal(IP) values(?)";
		int no = db.preUpdate(sql, ipname);
		db.close();
		return no;
	}

}
