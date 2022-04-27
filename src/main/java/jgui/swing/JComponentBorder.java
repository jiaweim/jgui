/**********************************************************
  * File:JComponentBorder.java
  *
  * Author:	Jiawei Mao                     
  *
  * Created on Nov 17, 2015
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

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 * @author	JiaweiM
 * @date	Nov 17, 2015 3:09:29 PM
 */
public class JComponentBorder {
	
	public static void main(String[] args) {
		JFrame jf = new JFrame("Test Border");
		jf.setSize(200, 150);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		jf.setContentPane(panel);
	}

}
