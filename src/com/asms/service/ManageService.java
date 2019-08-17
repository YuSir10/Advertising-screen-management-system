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
public class ManageService {
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
		int no=managerDao.delete(name);
		if (no == 0) {
			throw new RuntimeException("�û�û��ע���ɹ�");
		}
		return 0;
		
	}
	
	/**
	 * �޸� ����
	 * @param password1 
	 * @param password0 
	 * @param password1 
	 * @param password12 
	 * @param password0 
	 * @throws SQLException 
	 */
	public void  update(String name,String password, String password0, String password1) throws SQLException{
		if ("".equals(name)) {
			throw new RuntimeException("�û�������Ϊ��");
		}
		if ("".equals(password)) {
			throw new RuntimeException("�����벻��Ϊ��");
		}
		if ("".equals(password0)) {
			throw new RuntimeException("�޸����벻��Ϊ��");
		}
		if ("".equals(password1)) {
			throw new RuntimeException("ȷ�����벻��Ϊ��");
		}
		User reg = managerDao.select(name);//���ݿ��û���У��
		if (reg==null){
			throw new RuntimeException("���û���δע��");
		}else{
			String pass=managerDao.selectPass(name);
			if (password.equals(pass)) {
				if (password0.equals(password1)) {
					managerDao.update(name,password1);
				}else{
					throw new RuntimeException("��������������벻һ��");	
				}
			}else{
				throw new RuntimeException("���ľ���������");
			}
			
		}
		
	}
	
	
	
	
	
	
}
