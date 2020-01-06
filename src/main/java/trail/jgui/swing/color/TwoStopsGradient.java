package trail.jgui.swing.color;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * 
 * @author JiaweiMao
 * @version 2014��6��17�� ����3:36:17
 */
public class TwoStopsGradient extends JFrame {

	/** Creates a new instance of TwoStopsGradient */
	public TwoStopsGradient() {
		super("Two Stops Gradient");

		JPanel panel = new JPanel(new GridBagLayout());
		JButton button;
		panel.add(button = new DepthButton("New"), new GridBagConstraints(0, 0,
				1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(3, 3, 3, 3), 0, 0));
		button.setFocusPainted(false);
		panel.add(button = new DepthButton("Open"), new GridBagConstraints(1,
				0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(3, 3, 3, 3), 0, 0));
		button.setFocusPainted(false);
		panel.add(button = new DepthButton("Save"), new GridBagConstraints(2,
				0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(3, 3, 3, 3), 0, 0));
		button.setFocusPainted(false);

		add(panel);
		setSize(320, 240);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public static void main(String... args) {
		try {
			UIManager.setLookAndFeel(UIManager
					.getCrossPlatformLookAndFeelClassName());
		} catch (IllegalAccessException ex) {
			ex.printStackTrace();
		} catch (InstantiationException ex) {
			ex.printStackTrace();
		} catch (UnsupportedLookAndFeelException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new TwoStopsGradient().setVisible(true);
			}
		});
	}
}
