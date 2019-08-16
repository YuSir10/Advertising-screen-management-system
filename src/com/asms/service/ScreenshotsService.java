package com.asms.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JPanel;

public class ScreenshotsService {
	

	public  void getPictrue() throws IOException {
		// TODO Auto-generated method stub
		Socket socket = null;
		ServerSocket server = new ServerSocket(7777);
//		ServerSocket server2=new ServerSocket(7778);
		while (true) {
			socket = server.accept();
			System.out.println("спа╢╫с");
			ScreenThread screenThread = new ScreenThread(socket);
			Thread thread = new Thread(screenThread);
			thread.start();

		}
		
	}

	public void stop() {
		// TODO Auto-generated method stub
		//
		File picFile = new File("d:\\jietu.jpg");
		picFile.delete();
	}

}
