package com.asms.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ScreenshotsService {
	

	public void getPictrue(String ipnameString) throws Exception {
		// TODO Auto-generated method stub
		Socket socket = null;
		ServerSocket ss = new ServerSocket(7777);
		while (true) {
			socket = ss.accept();
			ScreenThread screenThread = new ScreenThread(socket);
		}

	}

	public void stop() {
		// TODO Auto-generated method stub
		//
		File picFile = new File("F:\\jietu\\jitu.jpg");
		picFile.delete();
	}

}
