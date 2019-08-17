package com.asms.frame;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.asms.res.IpAdress;
import com.asms.res.PictrueLable;
import com.asms.service.InstructionService;
import com.asms.service.ScreenshotsService;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Color;

public class ScreenshotsFrame extends JFrame {
	private Component lblImage;
	private String username;
	private ArrayList<IpAdress> iplist = new ArrayList<IpAdress>();
	private ScreenshotsService screenshotsService = new ScreenshotsService();
	private InstructionService instructionSend = new InstructionService(username);
	private static boolean flag = true;

	public ScreenshotsFrame(ArrayList<IpAdress> iplist, String nameString)  {
		this.iplist = iplist;
		this.username = nameString;
		setLocationRelativeTo(null);
		setSize(666,482);
		getContentPane().setLayout(null);
		
		
		
		JLabel label = new JLabel("\u89C2\u5BDF\u7EC8\u7AEF\u5DE5\u4F5C\u60C5\u51B5");
		label.setFont(new Font("楷体", Font.PLAIN, 18));
		label.setBounds(244, 41, 158, 18);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u9009\u62E9\u89C2\u5BDF\u7EC8\u7AEF");
		label_1.setBounds(41, 91, 108, 18);
		getContentPane().add(label_1);
		
		final JComboBox ip_comboBox = new JComboBox();
		ip_comboBox.setEditable(true);
		ip_comboBox.setBounds(180, 88, 174, 24);
		getContentPane().add(ip_comboBox);
		
		JButton start_button = new JButton("\u5F00\u59CB");
		start_button.setBounds(377, 87, 113, 27);
		getContentPane().add(start_button);
		
		JButton stop_button = new JButton("\u505C\u6B62");
		stop_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				flag = false;
				
				//fasong
			}
		});
		stop_button.setBounds(504, 87, 113, 27);
		getContentPane().add(stop_button);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBackground(new Color(204, 102, 204));
		lblNewLabel.setBounds(96, 167, 444, 234);
		getContentPane().add(lblNewLabel);
		
	   
		


		for (IpAdress ipAdress : iplist) {
			ip_comboBox.addItem(ipAdress.getIp());
		}

		start_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				flag = true ;
//				
//				new Thread(new Runnable() {
//					@Override
//					public void run() {
//						File pictrue = new File("d:\\jietu.jpg");
//						while(flag) {
//							if (pictrue.exists()) {
//								JPanel pictrueLable = new PictrueLable();
//						        pictrue_panel.add(pictrueLable);
//						        pictrueLable.setVisible(true);
//						        try {
//									Thread.sleep(3000);
//								} catch (InterruptedException e) {
//									// TODO Auto-generated catch block
//									e.printStackTrace();
//								}
//						        System.out.println(flag);
//						        pictrue_panel.remove(pictrueLable);
//							}
//						}
//						
//					}
//				}).start();
				
//				File pictrue = new File("d:\\jietu.jpg");
//				if (pictrue.exists()) {
//					JPanel p = new JPanel() {
//			            public void paintComponent(Graphics g) {
//			            	String url = "d:\\jietu.jpg";
//			                super.paintComponent(g);
//			                ImageIcon ii = new ImageIcon(url);
//			                g.drawImage(ii.getImage(), 0,0, getSize().width, getSize().height, this);
//			            }
//			        };
//			        p.setBounds(200, 152, 300, 241);
//			        p.add(panel);//如果覆盖的是pain()方法，按钮会被
//			        getContentPane().add(p);
//			        setVisible(true);
				new Thread (new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						try {
							String resultString = instructionSend.screenStart(ip_comboBox.getSelectedItem().toString());
							if (resultString.equals("OK")) {
								screenshotsService.getPictrue();
							}
							} catch (Exception e) {
								JOptionPane.showMessageDialog(null, e.getMessage());
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					
					
				}).start();
				
				
				
			


			}
				
			
		});
	}
}
