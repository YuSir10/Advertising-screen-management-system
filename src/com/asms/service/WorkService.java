package com.asms.service;

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
		 ArrayList<Worked> alist = instructionDAO.queryAll();
		 
		return alist;
	}
	 /**
	  * ɾ��
	 * @param ip 
	 * @param selectRow 
	 * @throws SQLException 
	  */
	public void delete(String name, String ip) throws SQLException {
		// TODO Auto-generated method stub
		int no=0;
		if (no>1) {
			//һ��ֻ��ɾ��һ��
			JOptionPane.showMessageDialog(null, "һ��ֻ��ɾһ��");
		}else if(no==0){
	    	  // ��ѡ��Ҫɾ������
			int noo = JOptionPane.showConfirmDialog(null, "ȷ��Ҫɾ����?");
	    	no=instructionDAO.delete(name,ip);
	    	 
	    } else{
	    	 JOptionPane.showMessageDialog(null, "��ѡ��Ҫɾ������");
	    }
		
	}
	

}
