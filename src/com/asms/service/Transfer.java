package com.asms.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Transfer {

	public static void GetFile() {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		 try {
				fis=new FileInputStream("d:\\1.gif");
				 fos=new FileOutputStream("d:\\3.gif");
				 int len=0;
				 byte[] buf=new byte[1024*500];
				 while ((len=fis.read(buf))!=-1) {
					fos.write(buf,0,len);
				 }
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				if (fos!=null) {
					fos.close();
				}
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				if (fis!=null) {
					fis.close();
				}
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		

	}

	public static void IPAccept() {
		//Socket s=new Socket("192.168.0.108",);
		
	}

	

}
