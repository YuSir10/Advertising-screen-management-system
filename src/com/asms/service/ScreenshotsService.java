package com.asms.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ScreenshotsService {

	public void look() throws IOException {
		// TODO Auto-generated method stub
		ServerSocket ss = new ServerSocket(1000);

		// 1����ָ��
		// *****

		// 2����
		// ��ȡͼƬ
		Socket sk = ss.accept();
		InputStream is = sk.getInputStream();
		byte[] bt = new byte[1024 * 4];
		int len = 0;
		while ((len = is.read(bt)) != -1) {
        //	    new String(bt, 0, len);
		// ��ͼƬд�ڱ����ļ���
        FileOutputStream fs = new FileOutputStream("d://tupian.png");
		fs.write(bt, 0, len);
		fs.flush();
	}
		}
		
		

	public void stop() {
		// TODO Auto-generated method stub

	}

}
