package com.asms.frame;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.asms.service.Transfer;

import java.awt.event.ActionListener;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.awt.Component;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

public class TransferFrame extends JFrame {
	
	private static ArrayList<String> pictureArrayList = new ArrayList<String>();
	private static ArrayList<String> videoArrayList = new ArrayList<String>();
	Transfer transfer = new Transfer();
	
	public TransferFrame() {
		getContentPane().setLayout(null);
		setSize(1000, 1000);
		JButton btnNewButton = new JButton("\u5BFC\u5165\u89C6\u9891\u8D44\u6E90");
		btnNewButton.setBounds(28, 63, 212, 29);
		getContentPane().add(btnNewButton);

		JButton btn_del = new JButton("\u5220\u9664");
		btn_del.setBounds(568, 57, 123, 41);
		getContentPane().add(btn_del);

		JButton btn_chose = new JButton("\u91CD\u9009");
		btn_chose.setBounds(710, 57, 123, 41);
		getContentPane().add(btn_chose);

		JButton btnNewButton_1 = new JButton("\u5BFC\u5165\u56FE\u7247\u8D44\u6E90");
		btnNewButton_1.setBounds(28, 161, 212, 29);
		getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("\u5220\u9664");
		btnNewButton_2.setBounds(568, 155, 123, 41);
		getContentPane().add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("\u91CD\u9009");
		btnNewButton_3.setBounds(710, 155, 123, 41);
		getContentPane().add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("\u5E94\u7528");

		btnNewButton_4.setBounds(416, 529, 123, 41);
		getContentPane().add(btnNewButton_4);

		final JComboBox comboBox = new JComboBox();
		comboBox.setBounds(275, 65, 239, 24);
		getContentPane().add(comboBox);

		final JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(275, 163, 239, 24);
		getContentPane().add(comboBox_1);

		

		btn_del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = comboBox.getSelectedIndex();
				System.out.println(index);
				pictureArrayList.remove(index);
				comboBox.removeItemAt(index);
			}
		});

		btn_chose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pictureArrayList.clear();
				comboBox.removeAllItems();
			}
		});
		
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				videoArrayList.clear();
				comboBox_1.removeAllItems();
			}
		});

		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					
					try {
						transfer.IPAccept();
						transfer.pushPictrue((String)comboBox_1.getSelectedItem());//获取资源
						transfer.pushVideo((String)comboBox.getSelectedItem());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				
			}
		});
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser("D:\\");
				FileNameExtensionFilter filter = new FileNameExtensionFilter("图像文件（JPG/GIF）", "JPG", "JPEG", "GIF");// 设置文件过滤器，只列出JPG或GIF格式的图片
				fileChooser.setFileFilter(filter);
				fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int returnVal = fileChooser.showOpenDialog(fileChooser);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					String filePath = fileChooser.getSelectedFile().getAbsolutePath();// 这个就是你选择的文件夹的路径
					videoArrayList.add(filePath);
					comboBox_1.addItem(filePath);
					
				}
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser("D:\\");
				FileNameExtensionFilter filter = new FileNameExtensionFilter("视频文件（MP4）", "MP4");// 设置文件过滤器，只列出JPG或GIF格式的图片
				fileChooser.setFileFilter(filter);
				fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int returnVal = fileChooser.showOpenDialog(fileChooser);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					String filePath = fileChooser.getSelectedFile().getAbsolutePath();// 这个就是你选择的文件夹的路径
					System.out.println(filePath);
					pictureArrayList.add(filePath);
					comboBox.addItem(filePath);
				}
			}
		});

	}
}
