package com.asms.dao;

import java.sql.SQLException;

import com.asms.res.IpAdress;
import com.asms.tool.DButils;

public class TerminalDao {

	public int addIp(String ipname) throws SQLException {
		// TODO Auto-generated method stub
		DButils db=new DButils();
		String sql="insert into advterminal values(?)";
		int no = db.preUpdate(sql, ipname);
		db.close();
		return no;
	}
	
	public int deleteIp(String ipname ) throws SQLException {
		DButils db = new DButils();
		String sql = "delete advterminal where ipadrss = ?";
		int no = db.preUpdate(sql, ipname);
		db.close();
		return no;
	}

}
