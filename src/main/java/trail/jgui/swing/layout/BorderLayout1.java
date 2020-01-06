/**********************************************************
  * File:BorderLayout1.java
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

package trail.jgui.swing.layout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JButton;

/**
 * 
 * @author	JiaweiM
 * @date	Sep 11, 2015 12:51:53 PM
 */
public class BorderLayout1 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BorderLayout1 window = new BorderLayout1();
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
	public BorderLayout1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JButton button = new JButton("生活");
		frame.getContentPane().add(button, BorderLayout.NORTH);
		
		JButton button_1 = new JButton("购物");
		frame.getContentPane().add(button_1, BorderLayout.WEST);
		
		JButton button_2 = new JButton("饮食");
		frame.getContentPane().add(button_2, BorderLayout.CENTER);
		
		JButton button_3 = new JButton("睡觉");
		frame.getContentPane().add(button_3, BorderLayout.EAST);
		
		JButton button_4 = new JButton("工作");
		frame.getContentPane().add(button_4, BorderLayout.SOUTH);
	}

}
