/**********************************************************
  * File:FlowLayout1.java
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
import java.awt.FlowLayout;
import javax.swing.JButton;

/**
 * 
 * @author	JiaweiM
 * @date	Sep 11, 2015 1:29:38 PM
 */
public class FlowLayout1 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FlowLayout1 window = new FlowLayout1();
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
	public FlowLayout1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, 5, 5);
		frame.getContentPane().setLayout(flowLayout);
		
		JButton button = new JButton("港币");
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("人名币");
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("美元");
		frame.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("欧元");
		frame.getContentPane().add(button_3);
		
		JButton button_4 = new JButton("英镑");
		frame.getContentPane().add(button_4);
		
		JButton button_5 = new JButton("日元");
		frame.getContentPane().add(button_5);
		
		JButton btnNewButton = new JButton("马元");
		frame.getContentPane().add(btnNewButton);
		
		JButton button_6 = new JButton("泰铢");
		frame.getContentPane().add(button_6);
	}

}
