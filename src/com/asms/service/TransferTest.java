package com.asms.service;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.asms.frame.TransferFrame;

public class TransferTest {
       public static void main(String[] args) {
//    	   try {
//               int i=0;
//               ServerSocket serverSocket=new ServerSocket(9992);
//               while(true){
//                   System.out.println("服务器已启动！");
//                   Socket socket =serverSocket.accept();
//                   Thread thread=new Thread(new ThreadHandler(socket),"Thread-"+i++);
////                   thread.start();
//               }
    
//           } catch (IOException e) {
//               e.printStackTrace();
//           }

  
   
		TransferFrame ts=new TransferFrame();
		ts.setVisible(true);
	}
}
