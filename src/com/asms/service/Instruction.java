/**
 * 
 */
package com.asms.service;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.asms.dao.InstructionDAO;

/**
 * @author ������
 *
 */
public class Instruction {
	private String managerName ;
	private String ipAdress ;
	private InstructionDAO instructionDAO = new InstructionDAO();
	
	public Instruction(String managerName,String ipAdress) {
		this.managerName = managerName;
		this.ipAdress = ipAdress;
	}
	
	public void addInstruction(String instructionName) throws Exception {
		Date date=new Date();
		SimpleDateFormat sdf =   new SimpleDateFormat( " yyyy-MM-dd HH:mm:ss " );
		String nowTime = sdf.format(date);
		int no = instructionDAO.add(managerName, instructionName, nowTime, ipAdress);
		if (no == 0) {
			throw new RuntimeException("����û�в���");
		}
	}

}
