package trail.jgui.awt.event;

import java.awt.EventQueue;

import javax.swing.*;

/**
 * A frame containing a panel for testing mouse operations
 */
public class MouseFrame extends JFrame {
	
	public MouseFrame() {
		add(new MouseComponent());
		pack();
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new MouseFrame();
				frame.setTitle("MouseTest");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}
