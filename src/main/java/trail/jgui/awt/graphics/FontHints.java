package trail.jgui.awt.graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class FontHints extends JComponent {

	Map desktopHints = null;

	/** Creates a new instance of FontHints */
	public FontHints() {
		Toolkit tk = Toolkit.getDefaultToolkit();
		desktopHints = (Map) (tk.getDesktopProperty("awt.font.desktophints"));
	}

	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.WHITE);
		g2d.fillRect(0, 0, getWidth(), getHeight());
		g2d.setColor(Color.BLACK);

		g2d.drawString("Unhinted string", 10, 20);
		if (desktopHints != null) {
			g2d.addRenderingHints(desktopHints);
		}
		g2d.drawString("Desktop-hinted string", 10, 40);
	}

	private static void createAndShowGUI() {
		JFrame f = new JFrame("FontHints");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(200, 90);
		FontHints component = new FontHints();
		f.add(component);
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
