/**
 * 
 */
package com.asms.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import org.w3c.dom.ls.LSException;

import com.asms.res.Worked;
import com.asms.tool.DButils;

import oracle.net.TNSAddress.Address;

/**
 * @author ������
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
		 * ȫ��ѯ
		 */
		DButils db = new DButils();
		String sql = "select managername,instructname,advtime,ipadress from advinstruct order by advno";
		ResultSet rs = db.preQuery(sql);// ���صĽ����
		
		ArrayList<Worked> list = new ArrayList<Worked>();
		Worked worked = null;
		while (rs.next()) {
			worked = new Worked();
			worked.setManagername(rs.getString("managername"));
			worked.setInstructname(rs.getString("instructname"));
			worked.setAdvtime(rs.getString("advtime"));
			worked.setIpadress(rs.getString("ipadress"));
			list.add(worked);
		}
		db.close();
		return list;
	}

	
	/**
	 * ɾ��
	 * 
	 * @param selectRow
	 */

	public int delete(String advtime, String ipadress) throws SQLException {
		DButils db = new DButils();
		String sql = "delete from advinstruct where advtime=? and ipadress=?";
		int no = db.preUpdate(sql, advtime, ipadress);
		db.close();
		return no;
	}

	/**
	 * ����ѯ
	 * @param time
	 * @param ip
	 * @return
	 * @throws SQLException 
	 */
	public ArrayList<Worked> select(String advtime, String ipadress) throws SQLException {
		// TODO Auto-generated method stub
		DButils db=new DButils();
		String sql="select * from advinstruct where advtime=? and ipadress=? ";
		ResultSet rs= db.preQuery(sql,advtime,ipadress);
		ArrayList<Worked> list = new ArrayList<Worked>();
		Worked worked = null;
		while (rs.next()) {
			worked = new Worked();
			worked.setManagername(rs.getString("managername"));
			worked.setInstructname(rs.getString("instructname"));
			worked.setAdvtime(rs.getString("advtime"));
			worked.setIpadress(rs.getString("ipadress"));
			list.add(worked);
		}
		db.close();
		return list;
		
	}


}