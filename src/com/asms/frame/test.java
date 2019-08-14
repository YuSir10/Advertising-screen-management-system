/**
 * 
 */
package com.asms.frame;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author гугугу
 *
 */
public class test {
public static void main(String[] args) throws FileNotFoundException, IOException {
	Screenshots ws = null;
	try {
		ws = new Screenshots();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	ws.setVisible(true);
}
}
