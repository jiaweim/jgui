/**********************************************************
  * File:TopLeveldemo.java
  *
  * Author:	Jiawei Mao                     
  *
  * Created on Sep 14, 2015
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

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;

/**
 * 
 * @author	JiaweiM
 * @date	Sep 14, 2015 4:56:23 PM
 */
public class TopLeveldemo {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TopLeveldemo window = new TopLeveldemo();
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
	public TopLeveldemo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setPreferredSize(new Dimension(200, 20));
		menuBar.setBackground(new Color(154, 165, 127));
		frame.setJMenuBar(menuBar);
		
		JLabel lblNewLabel = new JLabel("Yellow");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setPreferredSize(new Dimension(200, 180));
		lblNewLabel.setBackground(new Color(255, 255, 0));
		frame.getContentPane().add(lblNewLabel, BorderLayout.CENTER);
	}

}
