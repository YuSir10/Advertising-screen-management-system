package com.asms.frame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.jar.Attributes.Name;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.asms.res.Worked;
import com.asms.service.WorkService;
import com.asms.tool.DButils;



/**
 * 日志界面
 * @author 肖倩
 *
 */
public class WorkFrame extends JFrame {

	//表模型对象
		DefaultTableModel dtm = new DefaultTableModel();
		final JTable table = new JTable();
	
	public WorkFrame() {
		
		super();
		getContentPane().setLayout(null);
		setSize(500, 376);
		final JButton seek = new JButton();
		seek.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				//先清空
				int rowCount = dtm.getRowCount();
				for (int i = 0; i < rowCount; i++) {
					dtm.removeRow(0);
				}
				WorkService  js = new WorkService();
				ArrayList<Worked> list;
				try {
					list = js.queryAll();
					for (Worked w : list) {
						dtm.addRow(new Object[]{w.getName(),w.getIp(),w.getOrd(),w.getTime()});						
					}
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
		
		
		seek.setText("查找");
		seek.setBounds(10, 0, 106, 28);
		getContentPane().add(seek);

		final JButton del = new JButton();
		del.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
			/**
			 * 删除
			 */
				//先清空
//				int rowCount = dtm.getRowCount();
//				for (int i = 0; i < rowCount; i++) {
//					dtm.removeRow(0);
//				}
				WorkService js=	new WorkService();
				int selectRow =table.getSelectedRow();
				
				int in = table.getSelectedRow();
				Object name = table.getValueAt(selectRow, 0);	
				Object ip = table.getValueAt(selectRow, 1);
				try {
					js.delete(name.toString(),ip.toString());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				dtm.removeRow(selectRow);
				
			}
		});
		del.setText("删除");
		del.setBounds(184, 0, 106, 28);
		getContentPane().add(del);

		final JButton add_1 = new JButton();
		add_1.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
			
				//先清空
				int rowCount = dtm.getRowCount();
				for (int i = 0; i < rowCount; i++) {
					dtm.removeRow(0);
				}
				
				// 添加数据
				
				 // 需要添加界面的点击事件对象； 
				 
				
				
				
			}
		});
		add_1.setText("增加");
		add_1.setBounds(350, 0, 106, 28);
		getContentPane().add(add_1);

		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(53, 49, 431, 245);
		getContentPane().add(scrollPane);

	
		table.setModel(dtm);
		dtm.addColumn("用户名");
		dtm.addColumn("IP地址");
		dtm.addColumn("指令");
		dtm.addColumn("时间");
		
		
		
		scrollPane.setViewportView(table);
	}


    
}
