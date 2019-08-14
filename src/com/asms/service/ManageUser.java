package com.asms.service;

import java.sql.SQLException;

import com.asms.dao.ManagerDao;
import com.asms.res.User;

/**
 * 登陆界面的业务
 * 
 * @author Administrator
 *
 */
public class ManageUser {
	ManagerDao managerDao = new ManagerDao();
	/**
	 * 注册账号添加
	 * 
	 * @throws SQLException
	 */
	public int registered(String name, String password) throws SQLException {
		// TODO Auto-generated method stub
		if ("".equals(name)) {
			throw new RuntimeException("用户名不能为空");
		}
		if ("".equals(password)) {
			throw new RuntimeException("密码不能为空");
		}
		User reg = managerDao.select(name);//数据库用户名校验
		int no = managerDao.add(name, password);
		
		if (reg!=null) {
			throw new RuntimeException("用户名已存在");
		}
		return 0;
	}
/**
 *  登陆
 * @param name
 * @param password
 * @throws SQLException 
 */
	public int login(String name, String password) throws SQLException {
		// TODO Auto-generated method stub
		if ("".equals(name)) {
			throw new RuntimeException("用户名不能为空");
		}
		if ("".equals(password)) {
			throw new RuntimeException("密码不能为空");
		}
		User reg = managerDao.select(name);//数据库校验
		if (reg==null) {
			throw new RuntimeException("该用户尚未注册");
		}
		if (!(reg.getPassword().equals(password))) {
			throw new RuntimeException("用户名或者密码错误");
		}
		return 0;
		
	}
	/**
	 * 注销 删除
	 * @throws SQLException 
	 */
	public int  delete(String name,String password) throws SQLException{
		if ("".equals(name)) {
			throw new RuntimeException("用户名不能为空");
		}
		if ("".equals(password)) {
			throw new RuntimeException("密码不能为空");
		}
		int no=managerDao.delete(name);
		return 0;
		
	}
	
	/**
	 * 修改 密码
	 * @throws SQLException 
	 */
	public int  update(String name,String password) throws SQLException{
		if ("".equals(name)) {
			throw new RuntimeException("用户名不能为空");
		}
		if ("".equals(password)) {
			throw new RuntimeException("密码不能为空");
		}
		int no=managerDao.update(name,password);
		
		return 0;
	}
	
	
	
	
	
	
}
