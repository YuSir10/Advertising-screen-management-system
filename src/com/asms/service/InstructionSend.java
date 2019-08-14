/**
 * 
 */
package com.asms.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.net.Socket;
import java.net.UnknownHostException;

import org.omg.CORBA.PRIVATE_MEMBER;

/**
 * @author гугугу
 *
 */
public class InstructionSend {
	private String ip ;
	private static final int INStRUCTINON_PORT = 7755;
	private static final String SENDPICTURE = "send_picture";
	private static final String SENDVIDEO = "send_video";
	private static final String STARTPLAY = "start";
	private static final String STOPPLAY = "stop";
	private static final String SCREENSTART = "screen_start";
	private static final String SCREENSTOP = "screen_stop";
	
	private Instruction instruction ;
	
	

	public InstructionSend(String managerName,String ipAdress) {
		// TODO Auto-generated constructor stub
		instruction = new Instruction(managerName, ipAdress);
	}
	
	
	public String  sendPictureInstruction() throws UnknownHostException, IOException {
		Socket socket = new Socket(ip,INStRUCTINON_PORT);
		OutputStream os = socket.getOutputStream();
		os.write(SENDPICTURE.getBytes());
		os.flush();
		
		InputStream is = socket.getInputStream();
		byte[] buff = new byte[20];
		int len = is.read(buff);
		String Instruction = new String(buff,0,len);
		os.close();
		is.close();
		
		try {
			instruction.addInstruction(SENDPICTURE);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			//e.printStackTrace();
		}
		return Instruction;
	}
	
	public String sendVideoInstruction() throws UnknownHostException, IOException {
		Socket socket = new Socket(ip,INStRUCTINON_PORT);
		OutputStream os = socket.getOutputStream();
		os.write(SENDVIDEO.getBytes());
		os.flush();
		
		InputStream is = socket.getInputStream();
		byte[] buff = new byte[20];
		int len = is.read(buff);
		String Instruction = new String(buff,0,len);
		os.close();
		is.close();
		
		try {
			instruction.addInstruction(SENDVIDEO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			//e.printStackTrace();
		}
		return Instruction;
	}
	
	public String screenStart() throws UnknownHostException, IOException {
		Socket socket = new Socket(ip,INStRUCTINON_PORT);
		OutputStream os = socket.getOutputStream();
		os.write(SCREENSTART.getBytes());
		os.flush();
		
		InputStream is = socket.getInputStream();
		byte[] buff = new byte[20];
		int len = is.read(buff);
		String Instruction = new String(buff,0,len);
		os.close();
		is.close();
		
		try {
			instruction.addInstruction(SCREENSTART);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			//e.printStackTrace();
		}
		return Instruction;
	}
	
	public String screenStop() throws UnknownHostException, IOException {
		Socket socket = new Socket(ip,INStRUCTINON_PORT);
		OutputStream os = socket.getOutputStream();
		os.write(SCREENSTOP.getBytes());
		os.flush();

		InputStream is = socket.getInputStream();
		byte[] buff = new byte[20];
		int len = is.read(buff);
		String Instruction = new String(buff,0,len);
		os.close();
		is.close();
		
		try {
			instruction.addInstruction(SCREENSTOP);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			//e.printStackTrace();
		}
		return Instruction;
	}
	
	public String startPlay() throws UnknownHostException, IOException {
		Socket socket = new Socket(ip,INStRUCTINON_PORT);
		OutputStream os = socket.getOutputStream();
		os.write(STARTPLAY.getBytes());
		os.flush();
		
		InputStream is = socket.getInputStream();
		byte[] buff = new byte[20];
		int len = is.read(buff);
		String Instruction = new String(buff,0,len);
		os.close();
		is.close();
		
		try {
			instruction.addInstruction(STARTPLAY);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			//e.printStackTrace();
		}
		return Instruction;
	}
	
	public String stopPlay() throws UnknownHostException, IOException {
		Socket socket = new Socket(ip,INStRUCTINON_PORT);
		OutputStream os = socket.getOutputStream();
		os.write(STOPPLAY.getBytes());
		os.flush();

		InputStream is = socket.getInputStream();
		byte[] buff = new byte[20];
		int len = is.read(buff);
		String Instruction = new String(buff,0,len);
		os.close();
		is.close();
		
		try {
			instruction.addInstruction(STOPPLAY);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			//e.printStackTrace();
		}
		return Instruction;
	}
	

}
