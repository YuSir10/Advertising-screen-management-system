package com.asms.frame;

import java.awt.ComponentOrientation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.asms.service.ManageUser;

/**
 *注册界面
 * @author Administrator
 *
 */

public class RegisterFrame extends JFrame{
	private JPasswordField text_password;
	private JTextField text_name;
	public RegisterFrame() {
		super();
		setSize(440,361);
		setTitle("注册窗口");
		getContentPane().setLayout(null);

		final JLabel label = new JLabel();
		label.setText("新用户名");
		label.setBounds(78, 89, 66, 18);
		getContentPane().add(label);

		final JLabel label_1 = new JLabel();
		label_1.setText("新密码");
		label_1.setBounds(78, 166, 66, 18);
		getContentPane().add(label_1);

		text_name = new JTextField();
		text_name.setBounds(175, 87, 156, 22);
		getContentPane().add(text_name);

		text_password = new JPasswordField();
		text_password.setBounds(175, 164, 156, 22);
		getContentPane().add(text_password);

		final JButton button = new JButton();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				String name=text_name.getText();
				String password=text_password.getText();
				ManageUser ls=new ManageUser(); 
				try {
					int no=ls.registered(name, password);
					JOptionPane.showMessageDialog(null, "注册成功");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,e1.getMessage());
					e1.printStackTrace();
				}
				
			}
		});
		button.setText("确认注册");
		button.setBounds(150, 259, 106, 28);
		getContentPane().add(button);
	}

	
	
}
