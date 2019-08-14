/**
 * 
 */
package com.asms.dao;


import java.sql.SQLException;
import java.util.Date;

import com.asms.tool.DButils;

import oracle.net.TNSAddress.Address;

/**
 * @author гугугу
 *
 */
public class InstructionDAO {
	
	
	public int add (String name,String intructionName,String timeDate,String ip) throws SQLException {
		DButils db = new DButils();
		String sqlString = "insert into advinstruct values (?,?,?,?)";
		int no = db.preUpdate(sqlString, name,intructionName,timeDate,ip);
		db.close();
		return no;
	}

}

