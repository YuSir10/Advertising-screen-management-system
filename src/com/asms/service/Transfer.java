package com.asms.service;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Transfer {

	public  void pushPictrue(String pictrueFilePath) throws UnknownHostException, IOException {
		//发送图片
		
		//FileOutputStream fos = null;
		Socket socket = new Socket("192.168.1.64",7766);
		FileInputStream fis =new FileInputStream(pictrueFilePath);//读取本地文件
		OutputStream os = socket.getOutputStream();
		byte[] buff = new byte[1024];
		int len = 0;
		while ((len=fis.read(buff))!=-1) {
			os.write(buff,0,len);
		}
			os.flush();
			os.close();
			fis.close();
			socket.close();

	}
  /**
   * 获取ip
   * @throws IOException
   */
	public  void IPAccept() throws IOException {
		ServerSocket ss=new ServerSocket(7744);//服务端
		Socket s=ss.accept();//等待命令
		InputStream is=s.getInputStream();//获取ip
	
	}
	public  void pushVideo(String videoFilePath) throws UnknownHostException, IOException {
		//发送图片
		
		//FileOutputStream fos = null;
		Socket socket = new Socket("192.168.1.64",7766);
		FileInputStream fis =new FileInputStream(videoFilePath);//读取本地文件
		OutputStream os = socket.getOutputStream();
		byte[] buff = new byte[1024];
		int len = 0;
		while ((len=fis.read(buff))!=-1) {
			os.write(buff,0,len);
		}
			os.flush();
			os.close();
			fis.close();
			socket.close();
	

	}
	
}


