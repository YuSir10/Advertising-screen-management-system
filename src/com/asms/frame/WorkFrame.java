package com.asms.frame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.jar.Attributes.Name;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
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

	private JTable table;
	private JTextField empnoText;
	private JTextField empnameText;
	private JTextField empjobText;
	private JTextField empsalText;
	private DefaultTableModel tm = new DefaultTableModel();
	private WorkService workService = new WorkService();

	public WorkFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setSize(new Dimension(718, 538));
		setTitle("\u8868\u683C\u6A21\u578B");
		getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 64, 682, 295);
		getContentPane().add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
	
		tm.addColumn("管理者账号");
		tm.addColumn("执行的指令");
		tm.addColumn("执行时间");
		tm.addColumn("执行的终端ip");
		
		table.setModel(tm);
//		scrollPane.setColumnHeaderView(table);
		scrollPane.setViewportView(table); //显示表头
		JPanel panel = new JPanel();
		panel.setBounds(10, 369, 682, 91);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel label = new JLabel("\u64CD\u4F5C\u7684\u7BA1\u7406\u8005");
		label.setBounds(31, 10, 54, 15);
		panel.add(label);

		JLabel label_1 = new JLabel("\u6267\u884C\u6307\u4EE4");
		label_1.setBounds(216, 10, 54, 15);
		panel.add(label_1);

		JLabel label_2 = new JLabel("\u6267\u884C\u65F6\u95F4");
		label_2.setBounds(31, 41, 54, 15);
		panel.add(label_2);

		JLabel lblip = new JLabel("\u64CD\u4F5C\u7684\u7EC8\u7AEFip");
		lblip.setBounds(216, 41, 54, 15);
		panel.add(lblip);
	

		empnoText = new JTextField();
		empnoText.setEditable(false);
		empnoText.setBounds(95, 7, 98, 21);
		panel.add(empnoText);
		empnoText.setColumns(10);

		empnameText = new JTextField();
		empnameText.setColumns(10);
		empnameText.setBounds(280, 7, 98, 21);
		panel.add(empnameText);

		empjobText = new JTextField();
		empjobText.setColumns(10);
		empjobText.setBounds(95, 38, 98, 21);
		panel.add(empjobText);

		empsalText = new JTextField();
		empsalText.setColumns(10);
		empsalText.setBounds(280, 38, 98, 21);
		panel.add(empsalText);
		
		JButton addButton = new JButton("\u641C\u7D22");
		addButton.setBounds(543, 6, 93, 23);
		panel.add(addButton);
		
		JButton delButton = new JButton("\u5220\u9664");
		delButton.setBounds(543, 37, 93, 23);
		panel.add(delButton);
		
		JLabel lblNewLabel = new JLabel("\u5DE5\u4F5C\u65E5\u5FD7");
		lblNewLabel.setFont(new Font("楷体", Font.PLAIN, 22));
		lblNewLabel.setBounds(300, 13, 93, 32);
		getContentPane().add(lblNewLabel);
		
		setLocationRelativeTo(null);
		
		
		/**
		 * 一启动程序就执行查询
		 */
		try {
			showTable();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		/**
		 * 点击pane的监听事件,做清除选中的
		 */
		scrollPane.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event){
				clearTest();
				table.clearSelection();
			}
		});


	
		

		/**
		 * 删除按钮的监听事件
		 */
		delButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int no = table.getSelectedRowCount();
				if(no>1){
			    	 // 一次只能删一行
			    	JOptionPane.showMessageDialog(null, "一次只能删一行");
			    }else if(no==0){
			    	  // 请选择要删除的行
			    	JOptionPane.showMessageDialog(null, "请选择要删除的行");
			    }else{
			    	// 删
			    	int rowNo =  table.getSelectedRow();
			    	int confirmNo =  JOptionPane.showConfirmDialog(null, "确定要删除第"+(rowNo+1)+"条吗?");
			    	if(confirmNo==0){
			    		 // 真删
			    		   // 获取行的索引
			    		
			    		String advtime = (String) table.getValueAt( rowNo,2);
			    		String ipadress = (String) table.getValueAt( rowNo,3);

			    		try {
			    			workService.delete(advtime, ipadress);;
							JOptionPane.showMessageDialog(null, "信息成功删除");
							clearTable();
							showTable();
							clearTest();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, e.getMessage());
						}
			    		
			    	}	 
		    	}			
			}
		});


		table.addMouseListener(new MouseAdapter() {
			/**
			 * 鼠标点击表格获取指定行的监听事件
			 */
			public void mouseClicked(MouseEvent event) {
				int rowNo =  table.getSelectedRow(); 				
				empnoText.setText((String) table.getValueAt( rowNo,0));
				empnameText.setText((String) table.getValueAt(rowNo,1));
				empjobText.setText((String) table.getValueAt(rowNo,2));
				empsalText.setText(table.getValueAt(rowNo,3).toString());
			}
			
		});
		
	}

	public void clearTable() { // 清空表里面的数据
		int rowCount = tm.getRowCount();
		for (int i = 0; i < rowCount; i++) {
			tm.removeRow(0);
		}
	}


	public void clearTest() { //清空输入框
		empnoText.setText("");
		empnameText.setText("");
		empjobText.setText("");
		empsalText.setText("");
	}

	public void showTable() throws Exception  { //表格显示数据
		ArrayList<Worked> rs = workService.queryAll();
		for (Worked work : rs) {
			System.out.println(work.getName()+work.getOrd()+work.getIp()+work.getIp());
			tm.addRow(new Object[]{work.getName(),work.getOrd(),work.getTime(),work.getIp()});
		}
	}
	
	
    
}
