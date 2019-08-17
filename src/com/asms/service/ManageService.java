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
public class ManageService {
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
		int no=managerDao.delete(name);
		if (no == 0) {
			throw new RuntimeException("用户没有注销成功");
		}
		return 0;
		
	}
	
	/**
	 * 修改 密码
	 * @param password1 
	 * @param password0 
	 * @param password1 
	 * @param password12 
	 * @param password0 
	 * @throws SQLException 
	 */
	public void  update(String name,String password, String password0, String password1) throws SQLException{
		if ("".equals(name)) {
			throw new RuntimeException("用户名不能为空");
		}
		if ("".equals(password)) {
			throw new RuntimeException("旧密码不能为空");
		}
		if ("".equals(password0)) {
			throw new RuntimeException("修改密码不能为空");
		}
		if ("".equals(password1)) {
			throw new RuntimeException("确认密码不能为空");
		}
		User reg = managerDao.select(name);//数据库用户名校验
		if (reg==null){
			throw new RuntimeException("该用户尚未注册");
		}else{
			String pass=managerDao.selectPass(name);
			if (password.equals(pass)) {
				if (password0.equals(password1)) {
					managerDao.update(name,password1);
				}else{
					throw new RuntimeException("您输入的两次密码不一致");	
				}
			}else{
				throw new RuntimeException("您的旧密码有误");
			}
			
		}
		
	}
	
	
	
	
	
	
}
