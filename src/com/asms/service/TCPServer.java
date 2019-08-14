package com.asms.service;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;

import com.asms.dao.TerminalDao;
import com.asms.res.IP;



public class TCPServer {
	  public static void main(String[] args) throws IOException {
		   
		          
		ServerSocket serverSocket=new ServerSocket(7744);//创建服务器，等待客户端连接
		          //实现多个客户端连接服务器
		while(true){        final TerminalDao td=new TerminalDao ();
			                final IP saveIp=new IP();
			                final Socket clientSocket = serverSocket.accept();
			 new Thread(){
				          public void run(){
				        	 InetAddress ipObj = clientSocket.getInetAddress();//得到ip地址
				        	 String ip  =ipObj.getHostAddress();  //得到字符串形式的ip        
				        	  saveIp.setIp(ip);
				        	try {
								td.addIp(saveIp);
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}  
				        	  
				          }
		 
			 }.start();
	
		}
		
		
	}
	

}
