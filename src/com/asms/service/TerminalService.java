package com.asms.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JComboBox;

import com.asms.dao.TerminalDao;
import com.asms.res.IpAdress;


public class TerminalService {
	private static  ArrayList<IpAdress> ipList = new ArrayList<IpAdress>();
	 
	private TerminalDao terminalDao = new TerminalDao();
	
	public void getIp(JComboBox comboBox) throws IOException, Exception {
		
		ServerSocket serverSocket = new ServerSocket(7744);// 创建服务器，等待客户端连接
		// 实现多个客户端连接服务器
		while (true) {
			IpAdress terminalIp  = new IpAdress();
			Socket clientSocket = serverSocket.accept();
			System.out.println("连接");
			InputStream is = clientSocket.getInputStream();
			byte[] ipbuff = new byte[1024];
			int len = is.read(ipbuff);
			String ipname = new String (ipbuff,0,len);
			terminalIp.setIp(ipname);
			comboBox.addItem(ipname);
			System.out.println(	terminalIp.getIp());
		
			int no = terminalDao.addIp(ipname);
			if (no == 0) {
				throw new RuntimeException("ip未更新");
			}
			addip(terminalIp);
			
		}
		
	}
	
	public void  addip(IpAdress ip){
	
		ipList.add(ip);	
		
		
	}
	
	
	

	
	public IpAdress getip(String ipname) {
		for (IpAdress ip : ipList) {
			if(ip.getIp().equals(ipname)) {
				return ip;
			}
		}
		return null;
	}
	
	public void IpExit(IpAdress ipAdress) throws Exception {
		String ipname = ipAdress.getIp();
		int no = terminalDao.deleteIp(ipname);
		if (no == 0) {
			throw new RuntimeException("ip没有更新成功");
		}
	}

	
	}

	


