/**********************************************************
  * File:EmptyFrame.java
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

import javax.swing.JFrame;

/**
 * @author  JiaweiMao
 * @date	Jan 8, 2016 9:55:20 PM
 */
public class EmptyFrame extends JFrame{

	public EmptyFrame(){
		setSize(300, 200);
	}
	
	public static void main(String[] args) {
		EmptyFrame frame = new EmptyFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
