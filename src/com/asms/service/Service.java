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
		ServerSocket ss=new ServerSocket(9900);//���ն�����
		Socket s=ss.accept();//���������ܵ����׽��ֵ�����
		InputStream is=s.getInputStream();//��ȡ�������ļ�
		FileOutputStream fos=new FileOutputStream("d:\\����.jpg");//д�ֽ����ļ�
		BufferedOutputStream bos=new BufferedOutputStream(fos);//��ȡ�ֽ���������
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
