/**********************************************************
  * File:HelloWorld.java
  *
  * Author:	Jiawei Mao                     
  *
  * Created on Jul 16, 2015
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

package jgui.swing;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import javax.swing.JTextField;

/**
 * 创建一个登录窗口界面，这个界面中有文本组件、普通按钮组件、标签组件，它们按照网格组布局管理方式布局。
 * 
 * @Class	HelloWorld
 * @author	JiaweiM
 * @date	Jul 16, 2015 3:17:22 PM
 */
public class HelloWorld extends JPanel {
	
	JFrame loginFrame;
	private JTextField menuINput;
	private JTextField passwordinput;

	/**
	 * Create the panel.
	 */
	public HelloWorld() {
		loginFrame = new JFrame("欢迎进入Java世界");
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		setLayout(gridBagLayout);
		
		loginFrame.getContentPane().add(this, BorderLayout.CENTER);
		loginFrame.setSize(430, 367);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		loginFrame.setLocation(screenSize.width/2-200, screenSize.height/2-150);
		
		JLabel lbljava = new JLabel("欢迎进入Java世界");
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.weightx = 3;
		gbc.weighty = 4;
		
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(lbljava, gbc);
		
		JLabel label = new JLabel("用户名");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.EAST;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 1;
		add(label, gbc_label);
		
		menuINput = new JTextField(15);
		GridBagConstraints gbc_menuINput = new GridBagConstraints();
		gbc_menuINput.weighty = 4.0;
		gbc_menuINput.weightx = 3.0;
		gbc_menuINput.anchor = GridBagConstraints.EAST;
		gbc_menuINput.insets = new Insets(0, 0, 5, 5);
		gbc_menuINput.gridx = 2;
		gbc_menuINput.gridy = 1;
		add(menuINput, gbc_menuINput);
		
		JLabel label_1 = new JLabel("密码");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 2;
		add(label_1, gbc_label_1);
		
		passwordinput = new JTextField(15);
		GridBagConstraints gbc_passwordinput = new GridBagConstraints();
		gbc_passwordinput.insets = new Insets(0, 0, 5, 5);
		gbc_passwordinput.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordinput.gridx = 2;
		gbc_passwordinput.gridy = 2;
		add(passwordinput, gbc_passwordinput);
		
		JButton ok = new JButton("登录");
		GridBagConstraints gbc_ok = new GridBagConstraints();
		gbc_ok.insets = new Insets(0, 0, 0, 5);
		gbc_ok.gridx = 0;
		gbc_ok.gridy = 3;
		add(ok, gbc_ok);
		
		JButton cancel = new JButton("放弃");
		GridBagConstraints gbc_cancel = new GridBagConstraints();
		gbc_cancel.gridx = 2;
		gbc_cancel.gridy = 3;
		add(cancel, gbc_cancel);

		loginFrame.setResizable(false);
		loginFrame.setVisible(true);
	}
	
	public static void main(String[] args) {
		HelloWorld h = new HelloWorld();
	}

}
