package com.asms.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;

import com.asms.dao.TerminalDao;
import com.asms.res.IP;
import com.asms.res.TerminalThread;

public class TCPServer {
	private static  ArrayList<IP> ipList = new ArrayList<IP>();
	private TerminalDao td = new TerminalDao();
	
	public IP getIp() throws IOException, Exception {
		ServerSocket serverSocket = new ServerSocket(7744);// 创建服务器，等待客户端连接
		// 实现多个客户端连接服务器
		while (true) {
			IP saveIp = new IP();
			Socket clientSocket = serverSocket.accept();
			InputStream is = clientSocket.getInputStream();
			byte[] ipbuff = new byte[1024];
			int len = is.read(ipbuff);
			String ipname = new String (ipbuff,0,len);
			saveIp.setIp(ipname);
			
			int no = td.addIp(ipname);
			if (no == 0) {
				throw new RuntimeException("ip未更新");
			}
			addip(saveIp);
			

			return saveIp;
		}
		
	}
	
	public void  addip(IP ip){
		ipList.add(ip);
	}
	
	public ArrayList<IP> getIpList() {
		return ipList;
	}
	
	public IP getip(String ipname) {
		for (IP ip : ipList) {
			if(ip.getIp().equals(ipname)) {
				return ip;
			}
		}
		return null;
	}

}
