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
	private static final String SINGLELOOP = "single_loop";
	private static final String SHUFFLE = "shuffle";

	private String managerName;
	private String ipAdress;
	private InstructionDAO instructionDAO = new InstructionDAO();

	public InstructionSend(String managerName) {
		// TODO Auto-generated constructor stub
		this.managerName = managerName;
		
	}

	public String sendPictureInstruction(String ipString) throws UnknownHostException, IOException {
		this.ipAdress = ipString;
		Socket socket = new Socket(ipString, INStRUCTINON_PORT);
		OutputStream os = socket.getOutputStream();
		os.write(SENDPICTURE.getBytes());
		os.flush();

		InputStream is = socket.getInputStream();
		byte[] buff = new byte[20];
		int len = is.read(buff);
		String Instruction = new String(buff, 0, len);
		os.close();
		is.close();

		return Instruction;
	}

	public String sendVideoInstruction(String ipString) throws UnknownHostException, IOException {
		this.ipAdress = ipString;
		Socket socket = new Socket(ipString, INStRUCTINON_PORT);
		OutputStream os = socket.getOutputStream();
		os.write(SENDVIDEO.getBytes());
		os.flush();

		InputStream is = socket.getInputStream();
		byte[] buff = new byte[20];
		int len = is.read(buff);
		String Instruction = new String(buff, 0, len);
		os.close();
		is.close();

		return Instruction;
	}

	public String screenStart(String ipString) throws UnknownHostException, IOException {
		Socket socket = new Socket(ipString, INStRUCTINON_PORT);
		OutputStream os = socket.getOutputStream();
		os.write(SCREENSTART.getBytes());
		os.flush();

		InputStream is = socket.getInputStream();
		byte[] buff = new byte[20];
		int len = is.read(buff);
		String Instruction = new String(buff, 0, len);
		os.close();
		is.close();

		return Instruction;
	}

	public String screenStop(String ipString) throws UnknownHostException, IOException {
		this.ipAdress = ipString;
		Socket socket = new Socket(ipString, INStRUCTINON_PORT);
		OutputStream os = socket.getOutputStream();
		os.write(SCREENSTOP.getBytes());
		os.flush();

		InputStream is = socket.getInputStream();
		byte[] buff = new byte[20];
		int len = is.read(buff);
		String Instruction = new String(buff, 0, len);
		os.close();
		is.close();

		return Instruction;
	}

	public String startPlay(String ipString) throws UnknownHostException, IOException {
		this.ipAdress = ipString;
		Socket socket = new Socket(ipString, INStRUCTINON_PORT);
		OutputStream os = socket.getOutputStream();
		os.write(STARTPLAY.getBytes());
		os.flush();

		InputStream is = socket.getInputStream();
		byte[] buff = new byte[20];
		int len = is.read(buff);
		String Instruction = new String(buff, 0, len);
		os.close();
		is.close();

		return Instruction;
	}

	public String stopPlay(String ipString) throws UnknownHostException, IOException {
		this.ipAdress = ipString;
		Socket socket = new Socket(ipString, INStRUCTINON_PORT);
		OutputStream os = socket.getOutputStream();
		os.write(STOPPLAY.getBytes());
		os.flush();

		InputStream is = socket.getInputStream();
		byte[] buff = new byte[20];
		int len = is.read(buff);
		String Instruction = new String(buff, 0, len);
		os.close();
		is.close();


		return Instruction;
	}

	public String playModel(String ipString,int index) throws UnknownHostException, IOException {
		this.ipAdress = ipString;
		Socket socket = new Socket(ipString, INStRUCTINON_PORT);
		OutputStream os = socket.getOutputStream();
		if (index == 1) {
			os.write(SINGLELOOP.getBytes());
		}else {
			os.write(SHUFFLE.getBytes());
		}
		
		os.flush();

		InputStream is = socket.getInputStream();
		byte[] buff = new byte[20];
		int len = is.read(buff);
		String Instruction = new String(buff, 0, len);
		os.close();
		is.close();

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

	public static String getSendpicture() {
		return SENDPICTURE;
	}

	public static String getSendvideo() {
		return SENDVIDEO;
	}

	public static String getStartplay() {
		return STARTPLAY;
	}

	public static String getStopplay() {
		return STOPPLAY;
	}

	public static String getScreenstart() {
		return SCREENSTART;
	}

	public static String getScreenstop() {
		return SCREENSTOP;
	}
	
	

}
