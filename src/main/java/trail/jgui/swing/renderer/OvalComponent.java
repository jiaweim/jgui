package trail.jgui.swing.renderer;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class OvalComponent extends JComponent {

	public void paintComponent(Graphics g) {
		g.setColor(getBackground());
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.GRAY);
		g.fillOval(0, 0, getWidth(), getHeight());
	}

	private static void createAndShowGUI() {
		JFrame f = new JFrame("Oval");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(200, 200);
		f.add(new OvalComponent());
		f.setVisible(true);
	}

	public static void main(String args[]) {
		Runnable doCreateAndShowGUI = new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		};
		SwingUtilities.invokeLater(doCreateAndShowGUI);
	}
}
