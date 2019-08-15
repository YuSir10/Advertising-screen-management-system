package com.asms.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.asms.service.ManageUser;

public class shanchu extends JFrame{
	private JTextField textField;
	public shanchu() {
		super();
		setSize(512,245);
		getContentPane().setLayout(null);
		setTitle("注销网页");

		final JLabel label = new JLabel();
		label.setText("注销用户名");
		label.setBounds(44, 93, 66, 18);
		getContentPane().add(label);

		textField = new JTextField();
		textField.setBounds(134, 91, 154, 22);
		getContentPane().add(textField);

		final JButton button = new JButton();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				String name=textField.getText();
				ManageUser m=new ManageUser();
				try {
					m.delete(name);
				JOptionPane.showMessageDialog(null, "注销成功");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,e1.getMessage());
					e1.printStackTrace();
				}
			 
			}
		});
		button.setText("确认注销");
		button.setBounds(338, 88, 106, 28);
		getContentPane().add(button);
	}

}
