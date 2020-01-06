/**********************************************************
  * File:SwingWorkerFrameDemo.java
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

package trail.jgui.swing.renderer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * @author JiaweiMao
 * @version 2014��6��12�� ����10:21:16
 */
public class SwingWorkerFrameDemo extends JFrame{
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				
				new SwingWorkerFrameDemo().setVisible(true);
			}
		});
	}
}
