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
	
	/**
	 * 查找
	 * @param password 
	 * @param name 
	 * @throws SQLException 
	 */
	public 	User  select(String name) throws SQLException{
		DButils db= new DButils();
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
		db.close();
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
		DButils db= new DButils();
		String sql="insert into advuser(name,password) values(?,?)";
		int no=db.preUpdate(sql,name,password);
		db.close();
		return 0;
		
	}
	
/**
 * 注销删除
 * @throws SQLException 
 */
	public int  delete(String name) throws SQLException{
		DButils db= new DButils();
		String sql="delete from advuser where name=?";
		int no=db.preUpdate(sql,name);
		db.close();
		return 0;
	}
	
	
	/**
	 * 修改
	 * @throws SQLException 
	 */
	public int  update(String name, String password) throws SQLException{
		DButils db= new DButils();
		String sql="update advuser set password=? where name=?";
		int no=db.preUpdate(sql,password,name);
		db.close();
		return 0;
	}
	
	
	
}
