package com.asms.service;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;



public class Kehuduan {
public static void main(String[] args) throws UnknownHostException, IOException {
	Socket socket=new Socket("127.0.0.1",7777);
	FileInputStream fis=new FileInputStream("d:\\demo\\tu3.jpg");
	  BufferedInputStream bis=new BufferedInputStream(fis);
	  OutputStream   os   =socket.getOutputStream();
      byte[] buf=new byte[1024];
      int len=0;
      while((len=bis.read(buf))!=-1){
     	 //–¥»Î
     	os.write(buf, 0, len);;
      }
	 os.close();
	 socket.close();
	 bis.close();
	 fis.close();
	
	
}
}
