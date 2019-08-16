/**
 * 
 */
package com.asms.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.ArrayList;

/**
 * @author �ԧ�ԧ�ԧ�
 *
 */
public class ScreenThread implements Runnable {
	private Socket socket;
	

	public ScreenThread(Socket socket) {
		// TODO Auto-generated constructor stub
		this.socket = socket;

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			
			FileOutputStream fos = new FileOutputStream("d:\\jietu.jpg");
			InputStream is = socket.getInputStream();
			byte[] buff = new byte[1024];
			int len = 0;
			while ((len = is.read(buff)) != -1) {
				System.out.println(new String(buff,0,len));
				fos.write(buff,0,len);
				fos.flush();
			}
			fos.close();
			is.close();
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

