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

import com.asms.service.ManageService;
import java.awt.Font;

/**
 *  登陆界面
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
		setTitle("登陆窗口");
		getContentPane().setLayout(null);

		final JLabel label = new JLabel();
		label.setText("用户名");
		label.setBounds(112, 148, 66, 18);
		getContentPane().add(label);

		final JLabel label_1 = new JLabel();
		label_1.setText("密码");
		label_1.setBounds(112, 194, 66, 18);
		getContentPane().add(label_1);

		text_name = new JTextField();
		text_name.setBounds(203, 147, 169, 22);
		getContentPane().add(text_name);

		text_password = new JPasswordField();
		text_password.setBounds(203, 193, 169, 22);
		getContentPane().add(text_password);

		final JButton button = new JButton();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
			/**
			 * 登陆点击事件
			 */
				String name=text_name.getText();
				String password=text_password.getText();
				ManageService ls=new ManageService();
				  try {
					int no= ls.login(name,password);
					JOptionPane.showMessageDialog(null, "登陆成功");
					MainFrame mainFrame = new MainFrame(name, password);
					mainFrame.setVisible(true);
					dispose();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,e1.getMessage());
					text_name.setText("");
					text_password.setText("");
					//e1.printStackTrace();
				}
				  
				 
				
				  
				  
			}
		});
		button.setText("登陆");
		button.setBounds(104, 252, 106, 28);
		getContentPane().add(button);

		final JButton button_1 = new JButton();
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				/**
				 * 注册点击事件
				 */
				RegisterFrame rf=new RegisterFrame();
				rf.setVisible(true);
				
			}
		});
		button_1.setText("注册");
		button_1.setBounds(266, 252, 106, 28);
		getContentPane().add(button_1);
		
		JLabel label_2 = new JLabel("\u6B22\u8FCE\u4F7F\u7528\"\u4E94\u9669\u4E00\u91D1\"\u96C6\u56E2\u7684\u5E7F\u544A\u5C4F\u7BA1\u7406\u7CFB\u7EDF");
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		label_2.setBounds(80, 62, 341, 61);
		getContentPane().add(label_2);
		
		setLocationRelativeTo(null);
	}
}
