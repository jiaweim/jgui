/**********************************************************
  * File:GroupLayout1.java
  *
  * Author:	Jiawei Mao                     
  *
  * Created on Sep 13, 2015
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
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

/**
 * 
 * @author	JiaweiM
 * @date	Sep 13, 2015 9:38:23 AM
 */
public class GroupLayout1 {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GroupLayout1 window = new GroupLayout1();
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
	public GroupLayout1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 320);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblYourName = new JLabel("Your Name");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblOrganization = new JLabel("Organization");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel lblEmailAddress = new JLabel("Email Address");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Attach this signature");
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JButton btnChoose = new JButton("Choose...");
		
		JCheckBox chckbxComoseMessagesIn = new JCheckBox("Comose messages in HTML format");
		
		JButton btnAdvanced = new JButton("Advanced");
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(37)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(chckbxComoseMessagesIn)
							.addContainerGap())
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(chckbxNewCheckBox)
									.addContainerGap())
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblEmailAddress)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(textField_2))
										.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(lblYourName)
												.addComponent(lblOrganization))
											.addGap(27)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
												.addComponent(textField_1)
												.addComponent(textField, GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE))))
									.addGap(84)))
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(22)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addComponent(btnAdvanced)
									.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addComponent(btnChoose)
								.addGap(21)))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(16)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblYourName)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblOrganization)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmailAddress)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(chckbxNewCheckBox)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnChoose))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(chckbxComoseMessagesIn)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnAdvanced)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
