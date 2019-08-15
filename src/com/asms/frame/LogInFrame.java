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
import javax.swing.WindowConstants;

import com.asms.service.ManageUser;

/**
 *  ��½����
 * @author Administrator
 *
 */
public class LogInFrame extends JFrame{
	private JPasswordField text_password;
	private JTextField text_name;
	public LogInFrame() {
		super();
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(520,402);
		setTitle("��½����");
		getContentPane().setLayout(null);

		final JLabel label = new JLabel();
		label.setText("�û���");
		label.setBounds(84, 83, 66, 18);
		getContentPane().add(label);

		final JLabel label_1 = new JLabel();
		label_1.setText("����");
		label_1.setBounds(84, 153, 66, 18);
		getContentPane().add(label_1);

		text_name = new JTextField();
		text_name.setBounds(170, 81, 169, 22);
		getContentPane().add(text_name);

		text_password = new JPasswordField();
		text_password.setBounds(170, 151, 169, 22);
		getContentPane().add(text_password);

		final JButton button = new JButton();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
			/**
			 * ��½����¼�
			 */
				String name=text_name.getText();
				String password=text_password.getText();
				ManageUser ls=new ManageUser();
				  try {
					int no= ls.login(name,password);
					JOptionPane.showMessageDialog(null, "��½�ɹ�");
					MainFrame mainFrame = new MainFrame(name, password);
					mainFrame.setVisible(true);
					dispose();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,e1.getMessage());
					//e1.printStackTrace();
				}
				  
				 
				
				  
				  
			}
		});
		button.setText("��½");
		button.setBounds(72, 252, 106, 28);
		getContentPane().add(button);

		final JButton button_1 = new JButton();
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				/**
				 * ע�����¼�
				 */
				RegisterFrame rf=new RegisterFrame();
				rf.setVisible(true);
				
			}
		});
		button_1.setText("ע��");
		button_1.setBounds(250, 252, 106, 28);
		getContentPane().add(button_1);
		
		setLocationRelativeTo(null);
	}
	


}
