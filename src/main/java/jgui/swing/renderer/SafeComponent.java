package jgui.swing.renderer;

import java.awt.*;
import javax.swing.*;

/**
 * @author Romain Guy
 */
public class SafeComponent extends JLabel {
	public SafeComponent() {
		super("Safe Repaint");
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		System.out.println(SwingUtilities.isEventDispatchThread());
	}
}