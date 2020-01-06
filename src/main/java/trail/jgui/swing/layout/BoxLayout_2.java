package trail.jgui.swing.layout;

import java.awt.*;
import javax.swing.*;

public class BoxLayout_2 extends JApplet {
	private static final long serialVersionUID = 8946002030764483764L;

	public BoxLayout_2() {
		Container contentPane = getContentPane();
		ContainerWithBoxLayout yaxis = new ContainerWithBoxLayout(BoxLayout.Y_AXIS);

		ContainerWithBoxLayout xaxis = new ContainerWithBoxLayout(BoxLayout.X_AXIS);

		contentPane.setLayout(new FlowLayout());

		xaxis.add(new JButton(getIcon("reach.gif")));
		xaxis.add(new JButton(getIcon("punch.gif")));
		xaxis.add(new JButton(getIcon("open_hand.gif")));

		yaxis.add(new JButton(getIcon("ladybug.gif")));
		yaxis.add(new JButton(getIcon("crab.gif")));
		yaxis.add(new JButton(getIcon("frog.gif")));
		yaxis.add(new JButton(getIcon("snail.gif")));

		contentPane.add(xaxis);
		contentPane.add(yaxis);
	}

	public ImageIcon getIcon(String path) {
		return new ImageIcon(this.getClass().getResource(path));
	}
}

class ContainerWithBoxLayout extends JPanel {
	public ContainerWithBoxLayout(int orientation) {
		setLayout(new BoxLayout(this, orientation));
	}
}
