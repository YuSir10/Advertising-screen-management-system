package com.asms.bin;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;

import com.asms.service.Service;

import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.Component;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class MainFrame extends JFrame {
	private JTextField text_photo;
	String video;//获取video文本框
	ArrayList list;//创建集合存储视频
	ArrayList list2;//创建集合存储图片
	FileInputStream fis=null;
	FileOutputStream fos=null;
	private JTextField text_video;
	public MainFrame() {
		getContentPane().setLayout(null);
		setSize(1000,1000);
		JButton btnNewButton = new JButton("\u5BFC\u5165\u89C6\u9891\u8D44\u6E90");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 //video=text_video.getText();//获取文本框
				list=new ArrayList();
				list.add("d:\\广告1.mp4视频");
				list.add("d:\\广告2.mp4视频");
				text_video.setText("d:\\广告1.mp4视频");
				text_video.setText("d:\\广告2.mp4视频");
				Service.GetFile();
			}
		});
		btnNewButton.setBounds(28, 63, 212, 29);
		getContentPane().add(btnNewButton);
		
		JButton btn_del = new JButton("\u5220\u9664");
		btn_del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i <list.size(); i++) {
					list.remove(i);
					text_video.setText("");
				}
			}
		});
		btn_del.setBounds(546, 63, 123, 41);
		getContentPane().add(btn_del);
		
		JButton btn_chose = new JButton("\u91CD\u9009");
		btn_chose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i <list.size(); i++) {
				list.clear();
				text_video.setText("");
				}
			}
		});
		btn_chose.setBounds(732, 63, 123, 41);
		getContentPane().add(btn_chose);
		
		JButton btnNewButton_1 = new JButton("\u5BFC\u5165\u56FE\u7247\u8D44\u6E90");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				list2=new ArrayList();
				list2.add("d:\\1.gif");
				list2.add("d:\\2.gif");
				text_photo.setText("d:\\1.gif");
				text_photo.setText("d:\\2.gif");
				
					
			}
		});
		btnNewButton_1.setBounds(28, 161, 212, 29);
		getContentPane().add(btnNewButton_1);
		
		text_photo = new JTextField();
		text_photo.setBounds(212, 228, 524, 222);
		getContentPane().add(text_photo);
		text_photo.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("\u5220\u9664");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i <list2.size(); i++) {
					list2.remove(i);
					text_photo.setText("");
				}
			}
		});
		btnNewButton_2.setBounds(833, 257, 123, 41);
		getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\u91CD\u9009");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i <list2.size(); i++) {
					list2.clear();
					text_photo.setText("");
					
				}
			}
		});
		btnNewButton_3.setBounds(833, 361, 123, 41);
		getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("\u5E94\u7528");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Service.IPAccept();
			}
		});
		btnNewButton_4.setBounds(416, 529, 123, 41);
		getContentPane().add(btnNewButton_4);
		
		text_video = new JTextField();
		text_video.setBounds(304, 64, 158, 27);
		getContentPane().add(text_video);
		text_video.setColumns(10);
	}
}
