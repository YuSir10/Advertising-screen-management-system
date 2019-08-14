/**
 * 
 */
package com.asms.dao;

import java.sql.Date;
import java.sql.SQLException;

import com.asms.tool.DButils;

import oracle.net.TNSAddress.Address;

/**
 * @author гугугу
 *
 */
public class InstructionDAO {
	
	
	public int add (String name,String intructionName,Date timeDate,String ip) throws SQLException {
		DButils db = new DButils();
		String sqlString = "insert into table valuse (?,?,?,?)";
		int no = db.preUpdate(sqlString, name,intructionName,timeDate,ip);
		db.close();
		return 0;
	}

}

