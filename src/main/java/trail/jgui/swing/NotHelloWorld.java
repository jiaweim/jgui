/**********************************************************
  * File:NotHelloWorld.java
  *
  * Author:	Jiawei Mao                     
  *
  * Created on Jan 8, 2016
  *                       
  * Copyright (c) Dalian Institute of Chemical Physics
  *	Chinese Academy of Sciences
  * 
  * Contact: jiawei@dicp.ac.cn                   
  *                                              
  *******************************************************/
package trail.jgui.swing;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 * @author  JiaweiMao
 * @date	Jan 8, 2016 10:42:06 PM
 */
public class NotHelloWorld extends JFrame{

	/**
	 * 
	 */
	public NotHelloWorld() {
		add(new NotHelloWorldComponent());
		pack();
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				
				JFrame frame = new NotHelloWorld();
				frame.setTitle("NotHelloWorld");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

class NotHelloWorldComponent extends JComponent{
	public static final int MESSAGE_X = 75;
	public static final int MESSAGE_Y = 100;
	
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 200;
	
	@Override
	public void paintComponent(Graphics g){
		g.drawString("Not a Hello, World program", MESSAGE_X, MESSAGE_Y);
	}
	
	@Override
	public Dimension getPreferredSize(){
		return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
}
