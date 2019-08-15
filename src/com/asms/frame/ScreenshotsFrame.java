package com.asms.frame;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.image.BufferedImage;
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
import javax.swing.JPanel;

import com.asms.service.ScreenshotsService;

import com.jgoodies.forms.factories.DefaultComponentFactory;

public class ScreenshotsFrame extends JFrame{
	private JComboBox comboBox;
	private Component lblImage;
	ScreenshotsService wk=new ScreenshotsService();
	public ScreenshotsFrame() throws FileNotFoundException, IOException {
		super();
		setSize(600,600);
		getContentPane().setLayout(new GridLayout(2, 1));

		final JPanel panel = new JPanel();
		panel.setLayout(null);
		getContentPane().add(panel);

		final JLabel label_1 = new JLabel();
		label_1.setText("�豸�������");
		label_1.setBounds(105, 25, 86, 18);
		panel.add(label_1);

		final JLabel label = DefaultComponentFactory.getInstance().createLabel("ѡ��۲��豸");
		label.setBounds(10, 70, 86, 18);
		panel.add(label);

		comboBox = new JComboBox();
		comboBox.setBounds(105, 68, 91, 23);
//		  comboboxType.addItem("ĸ��");
		ArrayList<String> list =new ArrayList<String>();
		list.add("123");
		list.add("456");
		list.add("789");
		for (String s : list) {
			comboBox.addItem(s);
		}
		
		panel.add(comboBox);
//		getSelectedItem() ��ȡ�������ֵ
	

		final JButton start = new JButton();
		start.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				
				try {
					wk.look();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		start.setText("��ʼ");
		start.setBounds(214, 65, 73, 23);
		panel.add(start);

		final JButton stop = new JButton();
		stop.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				wk.stop();
			}
		});
		stop.setText("ֹͣ");
		stop.setBounds(293, 65, 73, 23);
		panel.add(stop);

		final JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1);
//		   String path = "d://tupian.png";  
//		   ImageIcon pic1 = new ImageIcon(ClassLoader.getSystemResource(path));
//		   ((AbstractButton) lblImage).setIcon(pic1);
//	        lblImage.setBounds(50, 50, pic1.getIconWidth(), pic1.getIconHeight());
//
//		
	}
	
		
	

}
