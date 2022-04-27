/**********
  * File:Button_MouseAdapter.java
  * Author: Jiawei Mao
  *	Created on 2014��5��7��
  * Copyright (c) Dalian Institute of Chemical Physics
  *	Chinese Academy of Sciences
  * Contact: jiawei@dicp.ac.cn
  */
package jgui.awt.event;

import java.applet.Applet;
import java.awt.Button;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author JiaweiMao
 * @version 2014��5��7�� ����9:19:21
 */
public class Button_MouseAdapter extends Applet{
	public void init(){
		Button button = new Button("Press Me");
		button.addMouseListener(new ButtonMouseAdapter());
		add(button);
	}
	class ButtonMouseAdapter extends MouseAdapter{
	    /**
	     * {@inheritDoc}
	     */
	    public void mouseEntered(MouseEvent e) {
	    	System.out.println("Mouse Evtered Button");
	    }

	    /**
	     * {@inheritDoc}
	     */
	    public void mouseExited(MouseEvent e) {
	    	System.out.println("Mouse Exited Button");
	    }
	}
}
