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
import com.asms.service.ScreenshotsService;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

public class ScreenshotsFrame extends JFrame{
	private Component lblImage;
	private ArrayList<IpAdress> iplist = new ArrayList<IpAdress>();
	ScreenshotsService screenshotsService =new ScreenshotsService();
	private static boolean  flag = true;
	
	public ScreenshotsFrame()  {
		this.iplist = iplist;
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
		
		final JPanel panel = new JPanel();
		panel.setBounds(14, 152, 468, 241);
		getContentPane().add(panel,BorderLayout.CENTER);
		panel.setLayout(null);
		


		for (IpAdress ipAdress : iplist) {
			ip_comboBox.addItem(ipAdress.getIp());
		}

		start_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
//					String ip=(String)ip_comboBox.getSelectedItem();
//					ScreenshotsService 
				ScreenshotsService.getPictrue(ip_comboBox.getSelectedItem().toString());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				new Thread(new Runnable() {
					@Override
					public void run() {
						File pictrue = new File("d:\\jitu.jpg");
						while(flag) {
							if (pictrue.exists()) {
								JPanel p = new JPanel() {
						            public void paintComponent(Graphics g) {
						            	String url = "d:\\jitu.jpg";
						                super.paintComponent(g);
						                ImageIcon ii = new ImageIcon(url);
						                g.drawImage(ii.getImage(), 0,0, getSize().width, getSize().height, this);
						            }
						        };
						        p.setBounds(200, 152, 300, 241);
						        p.add(panel);//如果覆盖的是pain()方法，按钮会被
						        getContentPane().add(p);
						        setVisible(true);
							}
						}
						
					}
				}).start();
				
				

//				try {
//					screenshotsService.getPictrue((String) ip_comboBox.getSelectedItem());
//				} catch (IOException e) {
//					JOptionPane.showMessageDialog(null, e.getMessage());
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
			}
		});
	}
}
