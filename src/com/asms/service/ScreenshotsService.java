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

		// 1发送指令
		// *****

		// 2接收
		// 读取图片
		Socket sk = ss.accept();
		InputStream is = sk.getInputStream();
		byte[] bt = new byte[1024 * 4];
		int len = 0;
		while ((len = is.read(bt)) != -1) {
        //	    new String(bt, 0, len);
		// 把图片写于本地文件夹
        FileOutputStream fs = new FileOutputStream("d://tupian.png");
		fs.write(bt, 0, len);
		fs.flush();
	}
		}
		
		

	public void stop() {
		// TODO Auto-generated method stub

	}

}
