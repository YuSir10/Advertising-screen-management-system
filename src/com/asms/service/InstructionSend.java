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
import java.text.SimpleDateFormat;
import java.util.Date;

import org.omg.CORBA.PRIVATE_MEMBER;

import com.asms.dao.InstructionDAO;

/**
 * @author 鱼鱼鱼
 *
 */
public class InstructionSend {
	private String ip;
	private static final int INStRUCTINON_PORT = 7755;
	private static final String SENDPICTURE = "send_picture";
	private static final String SENDVIDEO = "send_video";
	private static final String STARTPLAY = "start";
	private static final String STOPPLAY = "stop";
	private static final String SCREENSTART = "screen_start";
	private static final String SCREENSTOP = "screen_stop";

	private String managerName;
	private String ipAdress;
	private InstructionDAO instructionDAO = new InstructionDAO();

	public InstructionSend(String managerName, String ipAdress) {
		// TODO Auto-generated constructor stub
		this.managerName = managerName;
		this.ipAdress = ipAdress;
	}

	public String sendPictureInstruction() throws UnknownHostException, IOException {
		Socket socket = new Socket(ip, INStRUCTINON_PORT);
		OutputStream os = socket.getOutputStream();
		os.write(SENDPICTURE.getBytes());
		os.flush();

		InputStream is = socket.getInputStream();
		byte[] buff = new byte[20];
		int len = is.read(buff);
		String Instruction = new String(buff, 0, len);
		os.close();
		is.close();

		try {
			this.addInstruction(SENDPICTURE);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			// e.printStackTrace();
		}
		return Instruction;
	}

	public String sendVideoInstruction() throws UnknownHostException, IOException {
		Socket socket = new Socket(ip, INStRUCTINON_PORT);
		OutputStream os = socket.getOutputStream();
		os.write(SENDVIDEO.getBytes());
		os.flush();

		InputStream is = socket.getInputStream();
		byte[] buff = new byte[20];
		int len = is.read(buff);
		String Instruction = new String(buff, 0, len);
		os.close();
		is.close();

		try {
			this.addInstruction(SENDVIDEO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			// e.printStackTrace();
		}
		return Instruction;
	}

	public String screenStart() throws UnknownHostException, IOException {
		Socket socket = new Socket(ip, INStRUCTINON_PORT);
		OutputStream os = socket.getOutputStream();
		os.write(SCREENSTART.getBytes());
		os.flush();

		InputStream is = socket.getInputStream();
		byte[] buff = new byte[20];
		int len = is.read(buff);
		String Instruction = new String(buff, 0, len);
		os.close();
		is.close();

		try {
			this.addInstruction(SCREENSTART);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			// e.printStackTrace();
		}
		return Instruction;
	}

	public String screenStop() throws UnknownHostException, IOException {
		Socket socket = new Socket(ip, INStRUCTINON_PORT);
		OutputStream os = socket.getOutputStream();
		os.write(SCREENSTOP.getBytes());
		os.flush();

		InputStream is = socket.getInputStream();
		byte[] buff = new byte[20];
		int len = is.read(buff);
		String Instruction = new String(buff, 0, len);
		os.close();
		is.close();

		try {
			this.addInstruction(SCREENSTOP);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			// e.printStackTrace();
		}
		return Instruction;
	}

	public String startPlay() throws UnknownHostException, IOException {
		Socket socket = new Socket(ip, INStRUCTINON_PORT);
		OutputStream os = socket.getOutputStream();
		os.write(STARTPLAY.getBytes());
		os.flush();

		InputStream is = socket.getInputStream();
		byte[] buff = new byte[20];
		int len = is.read(buff);
		String Instruction = new String(buff, 0, len);
		os.close();
		is.close();

		try {
			this.addInstruction(STARTPLAY);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			// e.printStackTrace();
		}
		return Instruction;
	}

	public String stopPlay() throws UnknownHostException, IOException {
		Socket socket = new Socket(ip, INStRUCTINON_PORT);
		OutputStream os = socket.getOutputStream();
		os.write(STOPPLAY.getBytes());
		os.flush();

		InputStream is = socket.getInputStream();
		byte[] buff = new byte[20];
		int len = is.read(buff);
		String Instruction = new String(buff, 0, len);
		os.close();
		is.close();

		try {
			this.addInstruction(STOPPLAY);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			// e.printStackTrace();
		}
		return Instruction;
	}

	public void addInstruction(String instructionName) throws Exception {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(" yyyy-MM-dd HH:mm:ss ");
		String nowTime = sdf.format(date);
		int no = instructionDAO.add(managerName, instructionName, nowTime, ipAdress);
		if (no == 0) {
			throw new RuntimeException("数据没有插入");
		}
	}

}
