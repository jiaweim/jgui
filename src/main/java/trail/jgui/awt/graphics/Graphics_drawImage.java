package trail.jgui.awt.graphics;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Graphics_drawImage extends Applet {
	@Override
	public void paint(Graphics g) {
		Image img = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("th.png"));
		g.drawImage(img, 0, 0, 400, 340, this);
	}
}
