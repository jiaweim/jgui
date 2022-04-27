/**********
  * File:Event_1.java
  * Author: Jiawei Mao
  *	Created on 2014��5��6��
  * Copyright (c) Dalian Institute of Chemical Physics
  *	Chinese Academy of Sciences
  * Contact: jiawei@dicp.ac.cn
  */
package jgui.awt.event;

import java.applet.Applet;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author JiaweiMao
 * @version 2014��5��6�� ����10:36:09
 */
public class Event_1 extends Applet{
	public void init(){
		Button eventSource = new Button("Event Source");
		eventSource.addActionListener(new ButtonListener(this));
		add(eventSource);
	}
	class ButtonListener implements ActionListener{
		private Applet applet;
		public ButtonListener(Applet applet){
			this.applet = applet;
		}

		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			Button source = (Button) e.getSource();
			applet.showStatus(source.getLabel()+"activated");
		}
		
	}
}
