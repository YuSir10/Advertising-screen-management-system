/**
 * 
 */
package com.asms.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.asms.res.Worked;
import com.asms.tool.DButils;

import oracle.net.TNSAddress.Address;

/**
 * @author 鱼鱼鱼
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
	
	public ArrayList<Worked> queryAll() throws SQLException {
		/**
		 * 查询
		 */
		DButils db = new DButils();
		String sql = "select * from WORK";
		ResultSet rs = db.preQuery(sql);// 返回的结果集
		Worked wk = null;
		ArrayList<Worked> list = new ArrayList<Worked>();
		while (rs.next()) {
			wk = new Worked();
			wk.setName(rs.getString("name"));
			wk.setIp(rs.getString("ip"));
			wk.setOrd(rs.getString("ord"));
			wk.setTime(rs.getString("time"));
			list.add(wk);
		}
		db.close();
		return list;
	}

	/**
	 * 删除
	 * 
	 * @param selectRow
	 */

	public int delete(String name, String ip) throws SQLException {
		DButils db = new DButils();
		String sql = "delete from work where name=? and ip=?";
		int no = db.preUpdate(sql, name, ip);
		db.close();
		return 0;
	}


}

