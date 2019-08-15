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
	private JPasswordField text_password;
	private JTextField text_name;
	public UserUpdate() {
		super();
		setSize(462,348);
		setTitle("�޸�ҳ��");
		getContentPane().setLayout(null);

		final JButton button = new JButton();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				String name=text_name.getText();
				String password=text_password.getText();
				ManageUser m=new ManageUser();
				try {
					m.update(name, password);
					JOptionPane.showMessageDialog(null, "�޸ĳɹ�");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,e1.getMessage());
					e1.printStackTrace();
				}
				dispose();
			}
		});
		button.setText("ȷ���޸�");
		button.setBounds(132, 211, 106, 28);
		getContentPane().add(button);


		final JLabel label = new JLabel();
		label.setText("�û���");
		label.setBounds(67, 51, 66, 18);
		getContentPane().add(label);

		final JLabel label_1 = new JLabel();
		label_1.setText("������");
		label_1.setBounds(67, 139, 66, 18);
		getContentPane().add(label_1);

		text_name = new JTextField();
		text_name.setBounds(175, 49, 129, 22);
		getContentPane().add(text_name);

		text_password = new JPasswordField();
		text_password.setBounds(172, 137, 132, 22);
		getContentPane().add(text_password);
	}

}