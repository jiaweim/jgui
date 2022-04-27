/**********************************************************
  * File:BoxLayout1.java
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
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Box;
import java.awt.Component;
import javax.swing.JButton;
import java.awt.BorderLayout;

/**
 * 
 * @author	JiaweiM
 * @date	Sep 11, 2015 10:53:26 PM
 */
public class BoxLayout1 {

	private JFrame frmBoxlayout;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BoxLayout1 window = new BoxLayout1();
					window.frmBoxlayout.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BoxLayout1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBoxlayout = new JFrame();
		frmBoxlayout.setTitle("BoxLayout测试");
		frmBoxlayout.setBounds(100, 100, 400, 301);
		frmBoxlayout.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBoxlayout.getContentPane().setLayout(new BorderLayout(0, 0));
		
		Box verticalBox = Box.createVerticalBox();
		frmBoxlayout.getContentPane().add(verticalBox);
		
		Box horizontalBox = Box.createHorizontalBox();
		verticalBox.add(horizontalBox);
		
		JLabel label = new JLabel("  姓名：");
		horizontalBox.add(label);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalBox.add(horizontalStrut);
		
		textField = new JTextField();
		horizontalBox.add(textField);
		textField.setColumns(10);
		
		Box horizontalBox_1 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_1);
		
		JLabel label_1 = new JLabel("  密码：");
		horizontalBox_1.add(label_1);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		horizontalBox_1.add(horizontalStrut_1);
		
		textField_1 = new JTextField();
		horizontalBox_1.add(textField_1);
		textField_1.setColumns(10);
		
		Component verticalGlue = Box.createVerticalGlue();
		verticalBox.add(verticalGlue);
		
		Box horizontalBox_2 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_2);
		
		JButton button = new JButton("确定");
		horizontalBox_2.add(button);
		
		JButton button_1 = new JButton("取消");
		horizontalBox_2.add(button_1);
	}

}
