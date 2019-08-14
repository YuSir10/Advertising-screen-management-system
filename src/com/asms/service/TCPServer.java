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
		   
		          
		ServerSocket serverSocket=new ServerSocket(7744);//�������������ȴ��ͻ�������
		          //ʵ�ֶ���ͻ������ӷ�����
		while(true){        final TerminalDao td=new TerminalDao ();
			                final IP saveIp=new IP();
			                final Socket clientSocket = serverSocket.accept();
			 new Thread(){
				          public void run(){
				        	 InetAddress ipObj = clientSocket.getInetAddress();//�õ�ip��ַ
				        	 String ip  =ipObj.getHostAddress();  //�õ��ַ�����ʽ��ip        
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
