/**********************************************************
  * File:SizedFrame.java
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
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * @author  JiaweiMao
 * @date	Jan 8, 2016 10:18:23 PM
 */
public class SizedFrame extends JFrame{

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				JFrame frame = new SizedFrame();
				frame.setTitle("SizedFrame");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
	
	public SizedFrame(){
		// get screen dimensions
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension sceenSize = toolkit.getScreenSize();
		int screenHeight = sceenSize.height;
		int screenWidth = sceenSize.width;
		
		//set frame width, height and let platform pick screen location
		setSize(screenWidth/2, screenHeight/2);
		setLocationByPlatform(true);
		
		// set frame icon
		Image image = new ImageIcon(SizedFrame.class.getResource("icon.gif")).getImage();
		setIconImage(image);
	}
}
