/**********
  * File:MouseListener_1.java
  * Author: Jiawei Mao
  *	Created on 2014��5��7��
  * Copyright (c) Dalian Institute of Chemical Physics
  *	Chinese Academy of Sciences
  * Contact: jiawei@dicp.ac.cn
  */
package jgui.awt.event;

import java.applet.Applet;
import java.awt.Point;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * 
 * @author	JiaweiM
 * @date	Nov 17, 2015 1:51:44 PM
 */
public class MouseListener_1 extends Applet{
	public void init(){
	}
	
	public void report(MouseEvent e){
		int clickCount = e.getClickCount();
		int mods = e.getModifiers();
		Point p = e.getPoint();
		boolean isPopupTrigger = e.isPopupTrigger();
		String s = "mouse";
		
		if((mods & InputEvent.BUTTON3_MASK) != 0){
			
		}
	}
	
	class AMouseMotionListener implements MouseMotionListener{

		/* (non-Javadoc)
		 * @see java.awt.event.MouseMotionListener#mouseDragged(java.awt.event.MouseEvent)
		 */
		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		/* (non-Javadoc)
		 * @see java.awt.event.MouseMotionListener#mouseMoved(java.awt.event.MouseEvent)
		 */
		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
}
