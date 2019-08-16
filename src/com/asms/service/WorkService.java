package com.asms.service;

import java.lang.annotation.Retention;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.omg.PortableInterceptor.INACTIVE;

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
	public int delete(String advtime, String ipadress) throws SQLException {
		int no = instructionDAO.delete(advtime, ipadress);
//		if (no == 0 ) {
//			throw new RuntimeException("��¼û��ɾ���ɹ�");
//		}
		return no;
	}


	public ArrayList<Worked> select(String advtime, String ipadress) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<Worked> list = instructionDAO.Select(advtime,ipadress);
		return list;
		
		
	}



	

}


