package com.asms.service;

import java.sql.SQLException;

import com.asms.dao.ManagerDao;
import com.asms.res.User;

/**
 * ��½�����ҵ��
 * 
 * @author Administrator
 *
 */
public class ManageUser {
	ManagerDao managerDao = new ManagerDao();
	/**
	 * ע���˺����
	 * 
	 * @throws SQLException
	 */
	public int registered(String name, String password) throws SQLException {
		// TODO Auto-generated method stub
		if ("".equals(name)) {
			throw new RuntimeException("�û�������Ϊ��");
		}
		if ("".equals(password)) {
			throw new RuntimeException("���벻��Ϊ��");
		}
		User reg = managerDao.select(name);//���ݿ��û���У��
		int no = managerDao.add(name, password);
		
		if (reg!=null) {
			throw new RuntimeException("�û����Ѵ���");
		}
		return 0;
	}
/**
 *  ��½
 * @param name
 * @param password
 * @throws SQLException 
 */
	public int login(String name, String password) throws SQLException {
		// TODO Auto-generated method stub
		if ("".equals(name)) {
			throw new RuntimeException("�û�������Ϊ��");
		}
		if ("".equals(password)) {
			throw new RuntimeException("���벻��Ϊ��");
		}
		User reg = managerDao.select(name);//���ݿ�У��
		if (reg==null) {
			throw new RuntimeException("���û���δע��");
		}
		if (!(reg.getPassword().equals(password))) {
			throw new RuntimeException("�û��������������");
		}
		return 0;
		
	}
	/**
	 * ע�� ɾ��
	 * @throws SQLException 
	 */
	public int  delete(String name,String password) throws SQLException{
		if ("".equals(name)) {
			throw new RuntimeException("�û�������Ϊ��");
		}
		if ("".equals(password)) {
			throw new RuntimeException("���벻��Ϊ��");
		}
		int no=managerDao.delete(name);
		return 0;
		
	}
	
	/**
	 * �޸� ����
	 * @throws SQLException 
	 */
	public int  update(String name,String password) throws SQLException{
		if ("".equals(name)) {
			throw new RuntimeException("�û�������Ϊ��");
		}
		if ("".equals(password)) {
			throw new RuntimeException("���벻��Ϊ��");
		}
		int no=managerDao.update(name,password);
		
		return 0;
	}
	
	
	
	
	
	
}
