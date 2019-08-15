package com.asms.service;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * �����ļ�
 * @author admin
 *
 */
public class ThreadHandler implements Runnable{
	  private Socket socket;
	  
	    public ThreadHandler(Socket socket) {
	        this.socket = socket;
	    }

	@Override
	public void run() {
		  DataOutputStream dataOutputStream=null;
	        DataInputStream dataInputStream=null;
	        DataInputStream localRead =null;
	        try {
	            dataOutputStream=new DataOutputStream(socket.getOutputStream());
	            dataInputStream=new DataInputStream(new BufferedInputStream(socket.getInputStream()));
	 
	            String filePath = dataInputStream.readUTF();
	            File file=new File(filePath);
	            //�ж��ļ��Ƿ����
	            if(!file.exists()){
	                return;
	            }else{
	                //�ļ���
	                String fileName = file.getName();
	                dataOutputStream.writeUTF(fileName);
	                dataOutputStream.flush();
	                //�ļ���С
	                long length = file.length();
	                dataOutputStream.writeUTF(String.valueOf(length));
	                dataOutputStream.flush();
	 
	                System.out.println("��ʼ�� "+Thread.currentThread().getName()+
	                        " �����ļ����ļ�����"+fileName+"  �ļ���С"+length);
	                localRead =new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
	                byte[] bytes=new byte[4096];
	                while (true){
	                    int read=0;
	                    if(localRead!=null){
	                        read = localRead.read(bytes);
	                    }
	                    if(read==-1){
	                        break;
	                    }
	                    dataOutputStream.write(bytes,0,read);
	                    dataOutputStream.flush();
	                }
	                System.out.println("�� "+Thread.currentThread().getName()+" �����ļ���ϣ�");
	            }
	 
	        } catch (IOException e) {
	            e.printStackTrace();
	        }finally {
	            try {
	                localRead.close();
	                dataOutputStream.close();
	                dataInputStream.close();
	                socket.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }

	
		
	

}
