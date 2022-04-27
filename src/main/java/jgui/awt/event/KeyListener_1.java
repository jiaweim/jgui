/**********
  * File:KeyListener_1.java
  * Author: Jiawei Mao
  *	Created on 2014��5��7��
  * Copyright (c) Dalian Institute of Chemical Physics
  *	Chinese Academy of Sciences
  * Contact: jiawei@dicp.ac.cn
  */
package jgui.awt.event;

import java.applet.Applet;
import java.awt.TextField;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author JiaweiMao
 * @version 2014��5��7�� ����10:45:29
 */
public class KeyListener_1 extends Applet{
	private TextField tf = new TextField(10);
	public void init(){
		tf.addKeyListener(new TextFieldListener());
		add(tf);
	}
	class TextFieldListener implements KeyListener{
		private void report(KeyEvent e){
			int keyCode = e.getKeyCode();
			char keyChar = e.getKeyChar();
			String modes = KeyEvent.getKeyModifiersText(keyCode);
			String txt = KeyEvent.getKeyText(keyCode);
			if(keyCode != KeyEvent.VK_UNDEFINED){
				 System.out.println("Code:"+keyCode);
			}
			if(keyCode != KeyEvent.CHAR_UNDEFINED){
				System.out.println("Char:"+keyChar);
			}
			System.out.println("Modifiers:"+modes);
			System.out.println("Text:"+txt);
			if(e.isActionKey()){
				System.out.println("ACTION");
			}
			System.out.println();
			
		}

		/* (non-Javadoc)
		 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
		 */
		@Override
		public void keyTyped(KeyEvent e) {
			System.out.println("KEY_TYPED");
			report(e);			
		}

		/* (non-Javadoc)
		 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
		 */
		@Override
		public void keyPressed(KeyEvent e) {
			System.out.println("KEY_PRESSED");
			report(e);
		}

		/* (non-Javadoc)
		 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
		 */
		@Override
		public void keyReleased(KeyEvent e) {
			System.out.println("KEY_RELEASED");
			report(e);			
		}
		
	}
}
