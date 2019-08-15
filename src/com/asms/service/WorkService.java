package com.asms.service;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.asms.dao.InstructionDAO;

import com.asms.res.Worked;

public class WorkService {
	private InstructionDAO instructionDAO  = new InstructionDAO();
	/**
	 * 查询
	 * @return
	 * @throws SQLException
	 */
	 public  ArrayList<Worked> queryAll() throws SQLException {
		ArrayList<Worked> alist = instructionDAO.queryAll();
		
		if (alist == null) {
			throw new RuntimeException("还没有数据呢");
		}
		 
		return alist;
	}
	 
	 
	 /**
	  * 删除
	 * @param ip 
	 * @param selectRow 
	 * @throws SQLException 
	  */
	public void delete(String time, String ip) throws SQLException {
		int no = instructionDAO.delete(time, ip);
		if (no == 0 ) {
			throw new RuntimeException("记录没有删除成功");
		}
	}
	

}
