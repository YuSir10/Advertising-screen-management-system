package com.asms.service;

import java.sql.SQLException;

import com.asms.dao.LogFrameDao;
import com.asms.res.Register;

/**
 * ��½�����ҵ��
 * 
 * @author Administrator
 *
 */
public class LogService {
	LogFrameDao lfd = new LogFrameDao();
	/**
	 * ע���˺����
	 * 
	 * @throws SQLException
	 */
	public int add(String name, String password) throws SQLException {
		// TODO Auto-generated method stub
		if ("".equals(name)) {
			throw new RuntimeException("�û�������Ϊ��");
		}
		if ("".equals(password)) {
			throw new RuntimeException("���벻��Ϊ��");
		}
		Register reg = lfd.select(name);//���ݿ��û���У��
		int no = lfd.add(name, password);
		
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
		Register reg=lfd.select(name);//���ݿ�У��
		if (reg==null) {
			throw new RuntimeException("���û���δע��");
		}
		if (!(reg.getPassword().equals(password))) {
			throw new RuntimeException("�û��������������");
		}
		return 0;
		
	}
}
