package com.asms.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;

public class Service {
	public static void main(String[] args) throws IOException {
		ServerSocket ss=new ServerSocket(9900);//接收端网络
		Socket s=ss.accept();//侦听并接受到此套接字的连接
		InputStream is=s.getInputStream();//读取网络中文件
		FileOutputStream fos=new FileOutputStream("d:\\音乐.jpg");//写字节流文件
		BufferedOutputStream bos=new BufferedOutputStream(fos);//读取字节流缓冲区
		byte[] buf=new byte[1024];
		int len=0;
		while ((len=is.read(buf))!=-1) {
			bos.write(buf,0,len);
		}
		bos.close();
		fos.close();
		is.close();
		s.close();
		ss.close();

	
	}
     
}
