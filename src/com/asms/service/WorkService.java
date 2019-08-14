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
		 
		return alist;
	}
	 /**
	  * 删除
	 * @param ip 
	 * @param selectRow 
	 * @throws SQLException 
	  */
	public void delete(String name, String ip) throws SQLException {
		// TODO Auto-generated method stub
		int no=0;
		if (no>1) {
			//一次只能删除一行
			JOptionPane.showMessageDialog(null, "一次只能删一行");
		}else if(no==0){
	    	  // 请选择要删除的行
			int noo = JOptionPane.showConfirmDialog(null, "确定要删除吗?");
	    	no=instructionDAO.delete(name,ip);
	    	 
	    } else{
	    	 JOptionPane.showMessageDialog(null, "请选择要删除的行");
	    }
		
	}
	

}
