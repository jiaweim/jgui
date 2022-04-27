/**********************************************************
  * File:GridBagLayout1.java
  *
  * Author:	Jiawei Mao                     
  *
  * Created on Sep 11, 2015
  *                       
  * Copyright (c) Dalian Institute of Chemical Physics
  *	Chinese Academy of Sciences
  * 
  * Contact: jiawei@dicp.ac.cn                   
  *                                              
  *******************************************************/

/**
 * 
 * @version 1.00
 */

package jgui.swing.layout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JButton;

/**
 * 
 * @author	JiaweiM
 * @date	Sep 11, 2015 3:24:45 PM
 */
public class GridBagLayout1 {

	private JFrame frame;
	private JTextField nameinput;
	private JTextField passwordinput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GridBagLayout1 window = new GridBagLayout1();
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
	public GridBagLayout1() {
		initialize();
		frame.pack();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("信息管理系统");
		frame.setBounds(100, 100, 530, 347);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		frame.setLocation((screenSize.width-frame.getWidth())/2, (screenSize.height-frame.getHeight())/2);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {4, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 17, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel title = new JLabel("布局管理器测试窗口");
		GridBagConstraints gbc_title = new GridBagConstraints();
		gbc_title.gridwidth = 4;
		gbc_title.insets = new Insets(0, 0, 5, 0);
		gbc_title.gridx = 0;
		gbc_title.gridy = 0;
		panel.add(title, gbc_title);
		
		JLabel name = new JLabel("用户名");
		GridBagConstraints gbc_name = new GridBagConstraints();
		gbc_name.anchor = GridBagConstraints.EAST;
		gbc_name.insets = new Insets(0, 0, 5, 5);
		gbc_name.fill = GridBagConstraints.VERTICAL;
		gbc_name.gridx = 0;
		gbc_name.gridy = 1;
		panel.add(name, gbc_name);
		
		nameinput = new JTextField();
		GridBagConstraints gbc_nameinput = new GridBagConstraints();
		gbc_nameinput.insets = new Insets(0, 0, 5, 5);
		gbc_nameinput.fill = GridBagConstraints.HORIZONTAL;
		gbc_nameinput.gridx = 2;
		gbc_nameinput.gridy = 1;
		panel.add(nameinput, gbc_nameinput);
		nameinput.setColumns(15);
		
		JLabel password = new JLabel("密码");
		GridBagConstraints gbc_password = new GridBagConstraints();
		gbc_password.anchor = GridBagConstraints.EAST;
		gbc_password.insets = new Insets(0, 0, 5, 5);
		gbc_password.gridx = 0;
		gbc_password.gridy = 2;
		panel.add(password, gbc_password);
		
		passwordinput = new JTextField();
		GridBagConstraints gbc_passwordinput = new GridBagConstraints();
		gbc_passwordinput.insets = new Insets(0, 0, 5, 5);
		gbc_passwordinput.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordinput.gridx = 2;
		gbc_passwordinput.gridy = 2;
		panel.add(passwordinput, gbc_passwordinput);
		passwordinput.setColumns(15);
		
		JButton ok = new JButton("确认");
		GridBagConstraints gbc_ok = new GridBagConstraints();
		gbc_ok.insets = new Insets(0, 0, 0, 5);
		gbc_ok.gridx = 0;
		gbc_ok.gridy = 3;
		panel.add(ok, gbc_ok);
		
		JButton cancel = new JButton("取消");
		GridBagConstraints gbc_cancel = new GridBagConstraints();
		gbc_cancel.insets = new Insets(0, 0, 0, 5);
		gbc_cancel.gridx = 2;
		gbc_cancel.gridy = 3;
		panel.add(cancel, gbc_cancel);
	}

}
