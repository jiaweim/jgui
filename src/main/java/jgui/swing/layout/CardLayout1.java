/**********************************************************
  * File:CardLayout1.java
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
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.UIManager;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * @author	JiaweiM
 * @date	Sep 11, 2015 9:47:59 PM
 */
public class CardLayout1 {

	private JFrame frmCardlayouttest;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CardLayout1 window = new CardLayout1();
					window.frmCardlayouttest.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CardLayout1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCardlayouttest = new JFrame();
		frmCardlayouttest.setSize(new Dimension(300, 200));
		frmCardlayouttest.setTitle("CardLayoutTest");
		frmCardlayouttest.setBounds(100, 100, 419, 344);
		frmCardlayouttest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCardlayouttest.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frmCardlayouttest.getContentPane().add(panel, BorderLayout.CENTER);
		CardLayout card = new CardLayout(5, 5);
		
		panel.setLayout(card);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.BLUE);
		panel.add(panel_3, "p1");
		
		JLabel lblPanel = new JLabel("Panel 1");
		panel_3.add(lblPanel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.RED);
		panel.add(panel_2, "p2");
		
		JLabel lblJlable = new JLabel("Panel 2");
		panel_2.add(lblJlable);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.GREEN);
		panel.add(panel_4, "p3");
		
		JLabel lblPanel_1 = new JLabel("Panel 3");
		panel_4.add(lblPanel_1);
		
		JPanel panel_1 = new JPanel();
		frmCardlayouttest.getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		JButton button = new JButton("<上一步");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.previous(panel);
			}
		});
		panel_1.add(button);
		
		JButton button_1 = new JButton("1");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(panel, "p1");
			}
		});
		button_1.setMargin(new Insets(2, 2, 2, 2));
		panel_1.add(button_1);
		
		JButton button_2 = new JButton("2");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(panel, "p2");
			}
		});
		button_2.setMargin(new Insets(2, 2, 2, 2));
		panel_1.add(button_2);
		
		JButton button_3 = new JButton("3");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(panel, "p3");
			}
		});
		button_3.setMargin(new Insets(2, 2, 2, 2));
		panel_1.add(button_3);
		
		JButton button_4 = new JButton("下一步>");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.next(panel);
			}
		});
		panel_1.add(button_4);
	}

}
