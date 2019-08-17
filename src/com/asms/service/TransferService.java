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
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class TransferService {

	public  void pushPictrue(String ipString ,ArrayList<String> pictreArrayList) throws UnknownHostException, IOException {
		//∑¢ÀÕÕº∆¨
		
		//FileOutputStream fos = null;
		Socket socket = new Socket(ipString,7766);

		OutputStream os = socket.getOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(os);
		oos.writeObject(pictreArrayList);
		oos.flush();
		oos.close();
		socket.close();

	}
 
	
	public  void pushVideo(String ip,ArrayList<String > videoFilePath) throws UnknownHostException, IOException {
		//∑¢ÀÕ ”∆µ
		
		//FileOutputStream fos = null;
		Socket socket = new Socket(ip,7788);
		OutputStream os = socket.getOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(os);
		oos.writeObject(videoFilePath);
		oos.flush();
		oos.close();
		socket.close();
	
	}
	
}


