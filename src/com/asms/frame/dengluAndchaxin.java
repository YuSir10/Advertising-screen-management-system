package com.asms.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class dengluAndchaxin extends JFrame{
	public dengluAndchaxin() {
		super();
		setSize(439,309);
		getContentPane().setLayout(null);

		final JButton button = new JButton();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				ceshidenglu c=new ceshidenglu();
			    c.setVisible(true);
			
			}
		});
		button.setText("ÐÞ¸Ä");
		button.setBounds(61, 132, 106, 28);
		getContentPane().add(button);

		final JButton button_1 = new JButton();
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				shanchu s=new shanchu();
				s.setVisible(true);
			
			}
		});
		button_1.setText("×¢²á");
		button_1.setBounds(243, 132, 106, 28);
		getContentPane().add(button_1);
	}

}
