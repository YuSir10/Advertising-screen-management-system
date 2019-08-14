package com.asms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.asms.res.User;
import com.asms.tool.DButils;

/**
 * 登陆界面访问数据库
 * @author Administrator
 *
 */
public class ManagerDao {
	DButils db= new DButils();
	/**
	 * 查找
	 * @param password 
	 * @param name 
	 * @throws SQLException 
	 */
	public 	User  select(String name) throws SQLException{
		String sql="select *from advuser where name=?";
		ResultSet rs= db.preQuery(sql,name);
		User reg=null;
		while(rs.next()){
			reg=new User();
			String name1=rs.getString("name");
			String password1=rs.getString("password");
			reg.setName(name1);
			reg.setPassword(password1);
		}
		return reg;
		
	}
	/**
	 * 添加数据库
	 * @param name
	 * @param password
	 * @return
	 * @throws SQLException
	 */
	public int add(String name, String password) throws SQLException {
		// TODO Auto-generated method stub
		String sql="insert into advuser(name,password) values(?,?)";
		int no=db.preUpdate(sql,name,password);
		return 0;
		
	}
	
/**
 * 删
 * @throws SQLException 
 */
	public int  delete(String name) throws SQLException{
		String sql="delete from advuser name=?";
		int no=db.preUpdate(sql,name);
		return 0;
	}
	
	
	/**
	 * 修改
	 * @throws SQLException 
	 */
	public int  update(String name, String password) throws SQLException{
		
		String sql="update advuser set password=? where id=?";
		int no=db.preUpdate(sql,name,password);
		
		return 0;
	}
	
	
	
}
