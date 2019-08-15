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
 * ��־����
 * @author Фٻ
 *
 */
public class WorkFrame extends JFrame {

	private JTable table;
	private JTextField empnoText;
	private JTextField empnameText;
	private JTextField text_time;
	private JTextField text_ip;
	private DefaultTableModel tm = new DefaultTableModel();
	private WorkService workService = new WorkService();

	public WorkFrame() {
		
		setSize(new Dimension(718, 538));
		setTitle("\u8868\u683C\u6A21\u578B");
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 64, 682, 295);
		getContentPane().add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
	
		tm.addColumn("�������˺�");
		tm.addColumn("ִ�е�ָ��");
		tm.addColumn("ִ��ʱ��");
		tm.addColumn("ִ�е��ն�ip");
		
		table.setModel(tm);
//		scrollPane.setColumnHeaderView(table);
		scrollPane.setViewportView(table); //��ʾ��ͷ
		JPanel panel = new JPanel();
		panel.setBounds(10, 369, 682, 91);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel label = new JLabel("\u64CD\u4F5C\u7684\u7BA1\u7406\u8005");
		label.setBounds(10, 10, 92, 15);
		panel.add(label);

		JLabel label_1 = new JLabel("\u6267\u884C\u6307\u4EE4");
		label_1.setBounds(249, 10, 54, 15);
		panel.add(label_1);

		JLabel label_2 = new JLabel("\u6267\u884C\u65F6\u95F4");
		label_2.setBounds(10, 41, 75, 15);
		panel.add(label_2);

		JLabel lblip = new JLabel("\u64CD\u4F5C\u7684\u7EC8\u7AEFip");
		lblip.setBounds(245, 41, 83, 15);
		panel.add(lblip);
	

		empnoText = new JTextField();
		empnoText.setEditable(false);
		empnoText.setBounds(108, 6, 114, 21);
		panel.add(empnoText);
		empnoText.setColumns(10);

		empnameText = new JTextField();
		empnameText.setColumns(10);
		empnameText.setBounds(334, 6, 98, 21);
		panel.add(empnameText);

		text_time = new JTextField();
		text_time.setColumns(10);
		text_time.setBounds(107, 37, 114, 21);
		panel.add(text_time);

		text_ip = new JTextField();
		text_ip.setColumns(10);
		text_ip.setBounds(334, 37, 98, 21);
		panel.add(text_ip);
		
		JButton addButton = new JButton("\u641C\u7D22");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				clearTable();//����
			String time=text_time.getText();
			String ip=text_ip.getText();
			
			try {
				ArrayList<Worked> workedList = workService.select(time,ip);
				for (Worked worked : workedList) {
					tm.addRow(new Object[]{worked.getManagername(),worked.getInstructname(),worked.getAdvtime(),worked.getIpadress()});
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				//����
//				 try {
//					showTable();
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				WorkService ws = new WorkService();
//				ArrayList<Worked> list;
//				try {
//					list = ws.queryAll();
//					for (Worked wd : list) {
//						tm.addRow(new Object[]{wd.getManagername(),wd.getInstructname(),wd.getAdvtime(),wd.getIpadress()});
//						
//					}
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
				
				
			}
		});
		addButton.setBounds(543, 6, 93, 23);
		panel.add(addButton);
		
		JButton delButton = new JButton("\u5220\u9664");
		delButton.setBounds(543, 37, 93, 23);
		panel.add(delButton);
		
		JLabel lblNewLabel = new JLabel("\u5DE5\u4F5C\u65E5\u5FD7");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 22));
		lblNewLabel.setBounds(300, 13, 93, 32);
		getContentPane().add(lblNewLabel);
		
		setLocationRelativeTo(null);
		
		
		/**
		 * һ���������ִ�в�ѯ
		 */
		try {
			showTable();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		/**
		 * ���pane�ļ����¼�,�����ѡ�е�
		 */
		scrollPane.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event){
				clearTest();
				table.clearSelection();
			}
		});


	
		

		/**
		 * ɾ����ť�ļ����¼�
		 */
		delButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int no = table.getSelectedRowCount();
				if(no>1){
			    	 // һ��ֻ��ɾһ��
			    	JOptionPane.showMessageDialog(null, "һ��ֻ��ɾһ��");
			    }else if(no==0){
			    	  // ��ѡ��Ҫɾ������
			    	JOptionPane.showMessageDialog(null, "��ѡ��Ҫɾ������");
			    }else{
			    	// ɾ
			    	int rowNo =  table.getSelectedRow();
			    	int confirmNo =  JOptionPane.showConfirmDialog(null, "ȷ��Ҫɾ����"+(rowNo+1)+"����?");
			    	if(confirmNo==0){
			    		 // ��ɾ
			    		   // ��ȡ�е�����
			    		
			    		String advtime = (String) table.getValueAt( rowNo,2);
			    		String ipadress = (String) table.getValueAt( rowNo,3);

			    		try {
			    			workService.delete(advtime, ipadress);;
							JOptionPane.showMessageDialog(null, "��Ϣ�ɹ�ɾ��");
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
			 * ���������ȡָ���еļ����¼�
			 */
			public void mouseClicked(MouseEvent event) {
				int rowNo =  table.getSelectedRow(); 				
				empnoText.setText((String) table.getValueAt( rowNo,0));
				empnameText.setText((String) table.getValueAt(rowNo,1));
				text_time.setText((String) table.getValueAt(rowNo,2));
				text_ip.setText(table.getValueAt(rowNo,3).toString());
			}
			
		});
		
	}

	public void clearTable() { // ��ձ����������
		int rowCount = tm.getRowCount();
		for (int i = 0; i < rowCount; i++) {
			tm.removeRow(0);
		}
	}


	public void clearTest() { //��������
		empnoText.setText("");
		empnameText.setText("");
		text_time.setText("");
		text_ip.setText("");
	}

	public void showTable() throws Exception  { //�����ʾ����
		ArrayList<Worked> rs = workService.queryAll();
		for (Worked work : rs) {
			//System.out.println(work.getManagername()+work.getInstructname()+work.getAdvtime()+work.getIpadress());
			tm.addRow(new Object[]{work.getManagername(),work.getInstructname(),work.getAdvtime(),work.getIpadress()});
		}
	}
	
	
    
}
