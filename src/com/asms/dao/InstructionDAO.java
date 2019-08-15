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
		String sqlString = "insert into advinstruct values (advnumber.nextval,?,?,?,?)";
		int no = db.preUpdate(sqlString, name,intructionName,timeDate,ip);
		db.close();
		return no;
	}
	
	public ArrayList<Worked> queryAll() throws SQLException {
		/**
		 * 查询
		 */
		DButils db = new DButils();
		String sql = "select managername,instructname,advtime,ipadress from advinstruct order by advno";
		ResultSet rs = db.preQuery(sql);// 返回的结果集
		Worked wk = null;
		ArrayList<Worked> list = new ArrayList<Worked>();
		while (rs.next()) {
			wk = new Worked();
			wk.setName(rs.getString("managername"));
			wk.setIp(rs.getString("ipadress"));
			wk.setOrd(rs.getString("instructname"));
			wk.setTime(rs.getString("advtime"));
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

	public int delete(String time, String ip) throws SQLException {
		DButils db = new DButils();
		String sql = "delete from advinstruct where advtime=? and ipadress=?";
		int no = db.preUpdate(sql, time, ip);
		db.close();
		return no;
	}


}

