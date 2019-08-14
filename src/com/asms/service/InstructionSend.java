/**
 * 
 */
package com.asms.service;

import java.io.IOException;
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
	public  InstructionSend(String ipString) {
		ip = ipString;
	}
	
	public void sendPictureInstruction() throws UnknownHostException, IOException {
		Socket socket = new Socket(ip,INStRUCTINON_PORT);
		socket.getOutputStream();
		
	}

}
