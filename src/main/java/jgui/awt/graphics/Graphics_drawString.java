package jgui.awt.graphics;

import java.applet.Applet;
import java.awt.Graphics;

public class Graphics_drawString extends Applet {
	
	@Override
	public void paint(Graphics g){
		g.drawString("Hello Graphics", 75, 100);
	}
}
