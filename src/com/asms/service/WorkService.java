package com.asms.service;

import java.lang.annotation.Retention;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.asms.dao.InstructionDAO;

import com.asms.res.Worked;

public class WorkService {
	private InstructionDAO instructionDAO  = new InstructionDAO();
	/**
	 * ��ѯ
	 * @return
	 * @throws SQLException
	 */
	 public  ArrayList<Worked> queryAll() throws SQLException {
		ArrayList<Worked> list = instructionDAO.queryAll();
		
		if (list == null) {
			throw new RuntimeException("��û��������");
		}
		 
		return list;
	}
	 
	 
	 /**
	  * ɾ��
	 * @param ip 
	 * @param selectRow 
	 * @throws SQLException 
	  */
	public void delete(String time, String ip) throws SQLException {
		int no = instructionDAO.delete(time, ip);
		if (no == 0 ) {
			throw new RuntimeException("��¼û��ɾ���ɹ�");
		}
	}


	public ArrayList<Worked> select(String time, String ip) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<Worked> list = instructionDAO.Select(time,ip);
		return list;
		
		
	}
	

}

