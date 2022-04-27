/**********************************************************
 * File:JFileChooserTest.java
 *
 * Author: Jiawei Mao
 *
 * Created on Jul 15, 2015
 * 
 * Copyright (c) Dalian Institute of Chemical Physics Chinese Academy of
 * Sciences
 * 
 * Contact: jiawei@dicp.ac.cn
 * 
 *******************************************************/

/**
 * 
 * @version 1.00
 */

package jgui.swing;

import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.BorderLayout;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.SwingConstants;

import java.awt.Dimension;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 
 * @author	JiaweiM
 * @date	Sep 17, 2015 11:07:43 AM
 */
public class JFileChooserTest {

	private JFrame frame;
	private JFileChooser fileChooser;
	JTextArea textArea_1;
	private File file;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFileChooserTest window = new JFileChooserTest();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JFileChooserTest() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("FileChooser Example");

		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.SOUTH);

		JButton btnNewButton = new JButton("新建文件");

		panel_1.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("存储文件");

		panel_1.add(btnNewButton_1);

		JLabel lblNewLabel = new JLabel(" ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblNewLabel, BorderLayout.NORTH);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setPreferredSize(new Dimension(350, 300));
		frame.getContentPane().add(scrollPane_1, BorderLayout.CENTER);

		textArea_1 = new JTextArea();
		scrollPane_1.setViewportView(textArea_1);

		fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File("E:\\downloads"));
		
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				fileChooser.setApproveButtonText("确定");
				fileChooser.setDialogTitle("打开文件");
				int result = fileChooser.showOpenDialog(frame);
				textArea_1.setText("");
				if (result == JFileChooser.APPROVE_OPTION) {
					file = fileChooser.getSelectedFile();
					lblNewLabel.setText("您选择打开的文件名称为： " + file.getName());
				} else if (result == JFileChooser.CANCEL_OPTION) {
					lblNewLabel.setText("您没有选择任何文件");
				}

				FileInputStream fis = null;
				if (file != null) {
					try {
						// 利用FileInputStream将文件内容放入此数据流中以便读取.
						fis = new FileInputStream(file);
					} catch (FileNotFoundException fe) {
						lblNewLabel.setText("File Not Found");
						return;
					}
					int readbyte;
					try {
						// 以read()方法读取FileInputStream对象内容,当返回值为-1时代表读完此数据流.将所读到的字符显示
						// 在textarea中.
						while ((readbyte = fis.read()) != -1) {
							textArea_1.append(String.valueOf((char) readbyte));
						}
					} catch (IOException ioe) {
						lblNewLabel.setText("读取文件错误");
					} finally {// 回收FileInputStream对象,避免资源的浪费.
						try {
							if (fis != null)
								fis.close();
						} catch (IOException ioe2) {
						}
					}
				}
			}
		});

		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = fileChooser.showSaveDialog(frame);
				file = null;
				String fileName;
				if (result == JFileChooser.APPROVE_OPTION) {
					file = fileChooser.getSelectedFile();
					lblNewLabel.setText("您选择存储的文件名称为：" + file.getName());
				} else if (result == JFileChooser.CANCEL_OPTION) {
					lblNewLabel.setText("您没有选择任何文件");
				}
				
				FileOutputStream fos = null;
				if(file != null){
					try {
						fos = new FileOutputStream(file);
						
					} catch (Exception e2) {
						lblNewLabel.setText("File Not Found");
						return;
					}
					String content = textArea_1.getText();
					try {
						fos.write(content.getBytes());
					} catch (Exception e2) {
						lblNewLabel.setText("写入文件错误");
					}finally{
						try {
							if(fos != null){
								fos.close();
							}
						} catch (Exception e3) {
						}
					}
				}
			}
		});

		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
