/**
 * 
 */
package com.asms.frame;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JToggleButton;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.asms.res.IpAdress;
import com.asms.service.InstructionSend;
import com.asms.service.ManageUser;
import com.asms.service.ScreenshotsService;
import com.asms.service.Terminal;
import com.asms.service.Transfer;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * @author 鱼鱼鱼
 *
 */
public class MainFrame extends JFrame {
	private ArrayList<String> videoArrayList = new ArrayList<String>();
	private ArrayList<String> pictureArrayList = new ArrayList<String>();
	private ArrayList<IpAdress> Iplist = new ArrayList<IpAdress>();

	private ManageUser manageUser = new ManageUser();
	private String nameString;
	private String passwordString;
	private Terminal terminal = new Terminal(); // 获取ip
	private Transfer transfer = new Transfer(); // 做传输的业务
	private InstructionSend instructionSend = new InstructionSend(nameString); // 发送指令的业务
	private ScreenshotsService screenshotsService = new ScreenshotsService(); // 获取截图的业务

	public MainFrame(String name, String password) {
		this.nameString = name;
		this.passwordString = password;
		setSize(new Dimension(823, 534));
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		JButton improt_video = new JButton("\u5BFC\u5165\u89C6\u9891\u8D44\u6E90");
		improt_video.setBounds(226, 238, 123, 29);
		getContentPane().add(improt_video);

		JButton video_dele = new JButton("\u5220\u9664");
		video_dele.setBounds(582, 238, 63, 29);
		getContentPane().add(video_dele);

		JButton pictrue_deleAll = new JButton("\u91CD\u9009");
		pictrue_deleAll.setBounds(659, 186, 63, 29);
		getContentPane().add(pictrue_deleAll);

		JButton import_pic = new JButton("\u5BFC\u5165\u56FE\u7247\u8D44\u6E90");
		import_pic.setBounds(226, 186, 123, 29);
		getContentPane().add(import_pic);

		JButton pictrue_dele = new JButton("\u5220\u9664");
		pictrue_dele.setBounds(582, 186, 63, 29);
		getContentPane().add(pictrue_dele);

		JButton video_deleAll = new JButton("\u91CD\u9009");
		video_deleAll.setBounds(659, 238, 63, 29);
		getContentPane().add(video_deleAll);

		JButton apply = new JButton("\u5E94\u7528");

		apply.setBounds(356, 403, 81, 29);
		getContentPane().add(apply);

		final JComboBox video_comboBox = new JComboBox();
		video_comboBox.setBounds(366, 240, 202, 24);
		getContentPane().add(video_comboBox);

		final JComboBox pictrue_combobox = new JComboBox();
		pictrue_combobox.setBounds(363, 188, 205, 24);
		getContentPane().add(pictrue_combobox);

		JButton dele_button = new JButton("\u6CE8\u9500\u672C\u8D26\u53F7");
		dele_button.setBounds(14, 13, 113, 27);
		getContentPane().add(dele_button);

		JButton update_button = new JButton("\u4FEE\u6539\u5BC6\u7801");
		update_button.setBounds(141, 13, 113, 27);
		getContentPane().add(update_button);

		JLabel label = new JLabel("\u76EE\u524D\u5728\u7EBF\u7684\u7EC8\u7AEF");
		label.setBounds(22, 85, 105, 18);
		getContentPane().add(label);

		// 将ip传入到当前终端下拉框中
		final JComboBox ip_combobox = new JComboBox();
		ip_combobox.setEditable(true);
		ip_combobox.setBounds(141, 82, 174, 24);

		new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					terminal.getIp(ip_combobox);
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
					// TODO Auto-generated catch block
					// e.printStackTrace();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
					// TODO Auto-generated catch block
					// e.printStackTrace();
				}
			}
		}).start();

		for (IpAdress ip : Iplist) {
			ip_combobox.addItem(ip);
		}
		final String IP = (String) ip_combobox.getSelectedItem();// 当前下拉框中的ip

		getContentPane().add(ip_combobox);

		JLabel label_1 = new JLabel("\u64AD\u653E\u6A21\u5F0F");
		label_1.setBounds(277, 298, 72, 18);
		getContentPane().add(label_1);

		final JComboBox model_comboBox = new JComboBox();
		model_comboBox.setBounds(366, 295, 113, 24);
		getContentPane().add(model_comboBox);

		JButton work_button = new JButton("\u67E5\u770B\u5DE5\u4F5C\u65E5\u5FD7");
		work_button.setBounds(14, 239, 167, 27);
		getContentPane().add(work_button);

		JButton screen_button = new JButton("\u67E5\u770B\u7EC8\u7AEF\u5DE5\u4F5C\u60C5\u51B5");
		screen_button.setBounds(14, 187, 167, 27);
		getContentPane().add(screen_button);

		
		model_comboBox.addItem("单曲循环");
		model_comboBox.addItem("随机播放");

		JButton play_button = new JButton("\u64AD\u653E");
		play_button.setBounds(356, 81, 113, 27);
		getContentPane().add(play_button);

		JButton stop_button = new JButton("\u6682\u505C");
		stop_button.setBounds(500, 81, 113, 27);
		getContentPane().add(stop_button);

		import_pic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser("D:\\");
				FileNameExtensionFilter filter = new FileNameExtensionFilter("图像文件（JPG/GIF）", "JPG", "JPEG", "GIF");// 设置文件过滤器，只列出JPG或GIF格式的图片
				fileChooser.setFileFilter(filter);
				fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int returnVal = fileChooser.showOpenDialog(fileChooser);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					String filePath = fileChooser.getSelectedFile().getAbsolutePath();// 这个就是你选择的文件夹的路径
					videoArrayList.add(filePath);
					pictrue_combobox.addItem(filePath);

				}
			}
		});

		improt_video.addActionListener(new ActionListener() {
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
					video_comboBox.addItem(filePath);
				}
			}
		});

		video_deleAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				videoArrayList.clear();
				video_comboBox.removeAllItems();
			}
		});

		pictrue_deleAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pictureArrayList.clear();
				pictrue_combobox.removeAllItems();
			}
		});

		pictrue_dele.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = pictrue_combobox.getSelectedIndex();
				System.out.println(index);
				pictureArrayList.remove(index);
				pictrue_combobox.removeItemAt(index);
			}
		});

		video_dele.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = video_comboBox.getSelectedIndex();
				System.out.println(index);
				videoArrayList.remove(index);
				video_comboBox.removeItemAt(index);
			}
		});

		dele_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int confirmNo = JOptionPane.showConfirmDialog(null, "确定要删除注销这个账户吗?");
				if (confirmNo == 0) {
					// 真删
					// 获取行的索引
					try {
						manageUser.delete(nameString, passwordString);
						LogInFrame logInFrame = new LogInFrame();
						logInFrame.setVisible(true);
						dispose();

					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
						// TODO Auto-generated catch block
						// e.printStackTrace();
					}

				}
			}
		});

		update_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UserUpdate userUpdate = new UserUpdate();
				userUpdate.setVisible(true);
			}
		});

		screen_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
<<<<<<< HEAD
				ScreenshotsFrame screenshotsFrame = new ScreenshotsFrame(Iplist, IP);
=======
				ScreenshotsFrame screenshotsFrame = new ScreenshotsFrame(Iplist,nameString);
>>>>>>> 4988276213e6e875d4e69fa486d4e2d4ec7416ef
				screenshotsFrame.setVisible(true);
			}
		});

		work_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WorkFrame workFrame = new WorkFrame();
				workFrame.setVisible(true);
			}
		});

		apply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String ipString = ip_combobox.getSelectedItem().toString();
				try {
					String resultString = instructionSend.sendPictureInstruction(ipString);
					if (resultString.equals("OK")) {
						instructionSend.addInstruction(instructionSend.getSendpicture());
						String picturePath = pictrue_combobox.getSelectedItem().toString();
						transfer.pushPictrue(picturePath);
					}
					resultString = instructionSend.sendVideoInstruction(ipString);
					if (resultString.equals("OK")) {
						instructionSend.addInstruction(instructionSend.getSendvideo());
						String videoPath = video_comboBox.getSelectedItem().toString();
						transfer.pushVideo(videoPath);
					}
					// 发送播放模式
					String model = model_comboBox.getSelectedItem().toString();
					if (model.equals("单曲循环")) {
						instructionSend.playModel(ipString,1);
					}else {
						instructionSend.playModel(ipString, 2);
					}

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
					// TODO Auto-generated catch block
					// e.printStackTrace();
				}
			}
		});

		play_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String ipString = ip_combobox.getSelectedItem().toString();
				try {
					String resultString = instructionSend.startPlay(ipString);
					System.out.println(resultString);
					if (resultString.equals("OK")) {
						instructionSend.addInstruction(instructionSend.getStartplay());
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
					// TODO Auto-generated catch block
					// e.printStackTrace();
				}
			}
		});

		stop_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ipString = ip_combobox.getSelectedItem().toString();
				try {
					String resultString = instructionSend.stopPlay(ipString);
					if (resultString.equals("OK")) {
						instructionSend.addInstruction(instructionSend.getStopplay());
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
					// TODO Auto-generated catch block
					// e.printStackTrace();
				}

			}
		});

	}

}
