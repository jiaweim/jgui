package jgui.swing.color;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import javax.swing.JButton;

/**
 * @author JiaweiMao
 * @version 2014��6��17�� ����3:36:03
 */
public class DepthButton extends JButton {

	/** Creates a new instance of DepthButton */
	public DepthButton(String text) {
		super(text);
		setContentAreaFilled(false);
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		GradientPaint p;
		p = new GradientPaint(0, 0, new Color(0xFFFFFF), 0, getHeight(),
				new Color(0x0033FF));

		Paint oldPaint = g2.getPaint();
		g2.setPaint(p);
		g2.fillRect(0, 0, getWidth(), getHeight());
		g2.setPaint(oldPaint);

		super.paintComponent(g);
	}
}