/**********************************************************
  * File:AntiAliasingDemo.java
  *
  * Author:	Jiawei Mao                     
  *
  * Created on 2014��6��12��
  *                       
  * Copyright (c) Dalian Institute of Chemical Physics
  *	Chinese Academy of Sciences
  * 
  * Contact: jiawei@dicp.ac.cn                   
  *                                              
  *******************************************************/

package trail.jgui.awt.graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * @author JiaweiMao
 * @version 2014��6��12�� ����2:55:10
 */
public class AntiAliasingDemo extends JComponent{
	
	public void paintComponent(Graphics g){
		// we will need a Graphics2D Object to set the RenderingHint
		Graphics2D g2d = (Graphics2D)g;
		
		// Erase to white
		g2d.setBackground(Color.WHITE);
		g2d.clearRect(0, 0, getWidth(), getHeight());
		
		//Draw line with default setting.
		g2d.drawLine(0, 0, 50, 50);
		
		//Enable antialiasing
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		//Draw line with new setting
		g2d.drawLine(50, 0, 100, 50);
		
	}
	
	private static void createAndShowGui(){
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(150, 100);
		JComponent component = new AntiAliasingDemo();
		
		frame.add(component);
		frame.setVisible(true);
	}
	
	public static void main(String[] args){
		Runnable doCreateAndShowGui = new Runnable() {
			@Override
			public void run() {
				createAndShowGui();
			}
		};
		SwingUtilities.invokeLater(doCreateAndShowGui);
	}
}
