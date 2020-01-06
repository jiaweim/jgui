package trail.jgui.awt.event;
/*
 * BlankArea.java is used by: MouseEventDemo.java. MouseMotionEventDemo.java
 */

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class BlankArea extends JLabel {
	
	Dimension minSize = new Dimension(100, 50);

	public BlankArea(Color color) {
		setBackground(color);
		setOpaque(true);
		setBorder(BorderFactory.createLineBorder(Color.black));
	}

	@Override
	public Dimension getMinimumSize() {
		return minSize;
	}

	@Override
	public Dimension getPreferredSize() {
		return minSize;
	}
}
