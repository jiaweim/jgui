/**********
  * File:FocusListener_1.java
  * Author: Jiawei Mao
  *	Created on 2014��5��7��
  * Copyright (c) Dalian Institute of Chemical Physics
  *	Chinese Academy of Sciences
  * Contact: jiawei@dicp.ac.cn
  */
package trail.jgui.awt.event;

import java.applet.Applet;
import java.awt.Button;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * 
 * @author	JiaweiM
 * @date	Nov 17, 2015 1:55:21 PM
 */
public class FocusListener_1 extends Applet{
	
	public void init(){
		Button b1 = new Button("Button #1"), b2 = new Button("Button #2");
		ButtonFocusListener listener = new ButtonFocusListener();
		b1.addFocusListener(listener);
		b2.addFocusListener(listener);
		add(b1);
		add(b2);
	}
	class ButtonFocusListener implements FocusListener{
		private void report(FocusEvent event){
			Button b = (Button)event.getComponent();
			if(event.getID() == FocusEvent.FOCUS_GAINED)
				System.out.print(b.getLabel()+" gained focus");
			else if(event.getID() == FocusEvent.FOCUS_LOST)
				System.out.print(b.getLabel()+" lost focus");
			
			if(event.isTemporary())
				System.out.println(": temporary");
			else {
				System.out.println();
			}
		}

		/* (non-Javadoc)
		 * @see java.awt.event.FocusListener#focusGained(java.awt.event.FocusEvent)
		 */
		@Override
		public void focusGained(FocusEvent e) {
			report(e);
		}

		/* (non-Javadoc)
		 * @see java.awt.event.FocusListener#focusLost(java.awt.event.FocusEvent)
		 */
		@Override
		public void focusLost(FocusEvent e) {
			report(e);
		}
		
	}
}
