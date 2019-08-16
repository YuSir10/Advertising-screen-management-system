package com.asms.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ScreenshotsService {
	

	public static void getPictrue(String string) throws IOException {
		// TODO Auto-generated method stub
		Socket socket = null;
		ServerSocket ss = new ServerSocket(7777);
		while (true) {
			socket = ss.accept();

			System.out.println("спа╢╫с");
			ScreenThread screenThread = new ScreenThread(socket);
			Thread thread = new Thread(screenThread);
			thread.start();

		}

	}

	public void stop() {
		// TODO Auto-generated method stub
		//
		File picFile = new File("d:\\jietu\\jitu.jpg");
		picFile.delete();
	}

}
