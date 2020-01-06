/**********
  * File:WindowEvent_1.java
  * Author: Jiawei Mao
  *	Created on 2014��5��7��
  * Copyright (c) Dalian Institute of Chemical Physics
  *	Chinese Academy of Sciences
  * Contact: jiawei@dicp.ac.cn
  */
package trail.jgui.awt.event;

import java.awt.Frame;
import java.awt.Window;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * @author JiaweiMao
 * @version 2014��5��7�� ����2:16:44
 */
public class WindowEvent_1 extends Frame{
	
	public WindowEvent_1(){
		super("WindowListener test");
	}
	
	public static void main(String[] args){
		final Frame f = new WindowEvent_1();
		f.setBounds(100, 100, 500, 300);
		f.setVisible(true);
		f.addWindowListener(new AWindowListener());
	}
}
class AWindowListener implements WindowListener{

	/* (non-Javadoc)
	 * @see java.awt.event.WindowListener#windowOpened(java.awt.event.WindowEvent)
	 */
	@Override
	public void windowOpened(WindowEvent e) {
		System.out.println(e.getNewState());
	}

	/* (non-Javadoc)
	 * @see java.awt.event.WindowListener#windowClosing(java.awt.event.WindowEvent)
	 */
	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("Window closing...");
		Window window = e.getWindow();
		window.dispose();
	}

	/* (non-Javadoc)
	 * @see java.awt.event.WindowListener#windowClosed(java.awt.event.WindowEvent)
	 */
	@Override
	public void windowClosed(WindowEvent e) {
		System.out.println("Window Closed");
		System.exit(0);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.WindowListener#windowIconified(java.awt.event.WindowEvent)
	 */
	@Override
	public void windowIconified(WindowEvent e) {
		System.out.println("window iconified");
	}

	/* (non-Javadoc)
	 * @see java.awt.event.WindowListener#windowDeiconified(java.awt.event.WindowEvent)
	 */
	@Override
	public void windowDeiconified(WindowEvent e) {
		System.out.println("window deiconified");
	}

	/* (non-Javadoc)
	 * @see java.awt.event.WindowListener#windowActivated(java.awt.event.WindowEvent)
	 */
	@Override
	public void windowActivated(WindowEvent e) {
		System.out.println("Window activated");
	}

	/* (non-Javadoc)
	 * @see java.awt.event.WindowListener#windowDeactivated(java.awt.event.WindowEvent)
	 */
	@Override
	public void windowDeactivated(WindowEvent e) {
		System.out.println("window deactivated");
	}
	
}
