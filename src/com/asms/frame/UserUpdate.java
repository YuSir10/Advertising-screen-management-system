package com.asms.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.asms.dao.ManagerDao;
import com.asms.service.ManageUser;

public class UserUpdate extends JFrame{
	private JPasswordField text_password1;
	private JPasswordField text_password0;
	private JPasswordField text_password;
	private JTextField text_name;
	public UserUpdate() {
		super();
		setSize(462,348);
		setTitle("修改页面");
		getContentPane().setLayout(null);

		final JButton button = new JButton();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				String name=text_name.getText();
				String password=text_password.getText();
				String password0=text_password0.getText();
				String password1=text_password1.getText();
				ManageUser m=new ManageUser();
				try {
					m.update(name, password,password0,password1);
					JOptionPane.showMessageDialog(null, "修改成功");
					dispose();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,e1.getMessage());
				}
			
			}
		});
		button.setText("确认修改");
		button.setBounds(127, 247, 106, 28);
		getContentPane().add(button);


		final JLabel label = new JLabel();
		label.setText("用户名");
		label.setBounds(67, 51, 66, 18);
		getContentPane().add(label);

		final JLabel label_1 = new JLabel();
		label_1.setText("旧密码");
		label_1.setBounds(67, 106, 66, 18);
		getContentPane().add(label_1);

		text_name = new JTextField();
		text_name.setBounds(175, 49, 129, 22);
		getContentPane().add(text_name);

		text_password = new JPasswordField();
		text_password.setBounds(175, 106, 132, 22);
		getContentPane().add(text_password);

		final JLabel label_2 = new JLabel();
		label_2.setText("新密码");
		label_2.setBounds(67, 159, 66, 18);
		getContentPane().add(label_2);

		final JLabel label_3 = new JLabel();
		label_3.setText("确认新密码");
		label_3.setBounds(67, 206, 66, 18);
		getContentPane().add(label_3);

		text_password0 = new JPasswordField();
		text_password0.setBounds(175, 157, 129, 22);
		getContentPane().add(text_password0);

		text_password1 = new JPasswordField();
		text_password1.setBounds(175, 204, 129, 22);
		getContentPane().add(text_password1);
	}

}
