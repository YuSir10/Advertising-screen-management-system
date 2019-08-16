package com.asms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.asms.res.User;
import com.asms.tool.DButils;

/**
 * ��½����������ݿ�
 * @author Administrator
 *
 */
public class ManagerDao {
	
	/**
	 * ����
	 * @param password 
	 * @param name 
	 * @throws SQLException 
	 */
	public 	User  select(String name) throws SQLException{
		DButils db= new DButils();
		String sql="select * from advuser where managername=?";
		ResultSet rs= db.preQuery(sql,name);
		User reg=null;
		while(rs.next()){
			reg=new User();
			String name1=rs.getString("managername");
			String password1=rs.getString("password");
			reg.setName(name1);
			reg.setPassword(password1);
		}
		db.close();
		return reg;
		
	}
	/**
	 * ������ݿ�
	 * @param name
	 * @param password
	 * @return
	 * @throws SQLException
	 */
	public int add(String name, String password) throws SQLException {
		DButils db= new DButils();
		String sql="insert into advuser(managername,password) values(?,?)";
		int no=db.preUpdate(sql,name,password);
		db.close();
		return 0;
		
	}
	
/**
 * ע��ɾ��
 * @throws SQLException 
 */
	public int  delete(String name) throws SQLException{
		DButils db= new DButils();
		String sql="delete from advuser where managername=?";
		int no=db.preUpdate(sql,name);
		db.close();
		return no;
	}
	
	
	/**
	 * �޸�
	 * @throws SQLException 
	 */
	public  void update(String name, String password1) throws SQLException{
		DButils db= new DButils();
		String sql="update advuser set password=? where managername=?";
		db.preUpdate(sql,password1,name);
		db.close();
	}
    /**
     * ��ѯ�����Ƿ���ȷ
     * @throws SQLException 
     */
	public String selectPass(String name) throws SQLException{
		DButils db= new DButils();
		String sql="select password from advuser where managername=?";
		ResultSet rs= db.preQuery(sql,name);
		String pass="";
		while(rs.next()){
			 pass=rs.getString("password");
		}
		db.close();
		return pass;
		
	}
	
	
	
}
