/**********************************************************
  * File:GridLayout1.java
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
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * @author	JiaweiM
 * @date	Sep 11, 2015 2:05:32 PM
 */
public class GridLayout1 {

	private JFrame frame;

	final static int maxGap = 20;
	private JPanel compsToExperiment;
	static final String gapList[] = { "0", "10", "15", "20" };
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GridLayout1 window = new GridLayout1();
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
	public GridLayout1() {
		initialize();
		frame.pack();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		compsToExperiment = new JPanel();
		
		JButton bb = new JButton();
		Dimension di = bb.getPreferredSize();
		compsToExperiment.setPreferredSize(new Dimension((int)(di.getWidth()*2.5) + maxGap, (int)(di.getHeight()*3.5 + maxGap*2)));
		
		frame.getContentPane().add(compsToExperiment, BorderLayout.NORTH);
		GridLayout expLayout = new GridLayout(0, 2);
		compsToExperiment.setLayout(expLayout);
		
		JButton btnNewButton = new JButton("Button 1");
		compsToExperiment.add(btnNewButton);
		
		JButton btnButton = new JButton("Button 2");
		compsToExperiment.add(btnButton);
		
		JButton btnButton_1 = new JButton("Button 3");
		compsToExperiment.add(btnButton_1);
		
		JButton btnLongnamedButton = new JButton("Long-Named Button 4");
		compsToExperiment.add(btnLongnamedButton);
		
		JButton button = new JButton("5");
		compsToExperiment.add(button);
		
		JPanel controls = new JPanel();
		frame.getContentPane().add(controls, BorderLayout.SOUTH);
		controls.setLayout(new GridLayout(2, 3, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Horizontal gap:");
		controls.add(lblNewLabel);
		
		JLabel lblVerticalGap = new JLabel("Vertical gap:");
		controls.add(lblVerticalGap);
		
		JLabel label = new JLabel(" ");
		controls.add(label);
		
		JComboBox<String> horGapComboBox = new JComboBox<>();
		horGapComboBox.setModel(new DefaultComboBoxModel<String>(gapList));
		controls.add(horGapComboBox);
		
		JComboBox<String> verGapComboBox = new JComboBox<String>();
		verGapComboBox.setModel(new DefaultComboBoxModel<String>(gapList));
		controls.add(verGapComboBox);
		
		JButton btnApplyGaps = new JButton("Apply gaps");
		btnApplyGaps.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String hValue = (String)horGapComboBox.getSelectedItem();
				String vValue = (String) verGapComboBox.getSelectedItem();
				expLayout.setHgap(Integer.parseInt(hValue));
				expLayout.setVgap(Integer.parseInt(vValue));
				expLayout.layoutContainer(compsToExperiment);
			}
		});
		controls.add(btnApplyGaps);
		
		JSeparator separator = new JSeparator();
		frame.getContentPane().add(separator, BorderLayout.CENTER);
	}

}
