/**********************************************************
 * File:GeneralPath.java
 *
 * Author: Jiawei Mao
 *
 * Created on Nov 26, 2015
 * 
 * Copyright (c) Dalian Institute of Chemical Physics Chinese Academy of
 * Sciences
 * 
 * Contact: jiawei@dicp.ac.cn
 * 
 *******************************************************/

/**
 * 
 * @version 1.00
 */

package trail.jgui.swing.j2d.geometry;

import java.applet.Applet;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;

import javax.swing.JApplet;
import javax.swing.JFrame;

/**
 * 
 * @author JiaweiM
 * @date Nov 26, 2015 2:00:33 PM
 */
public class DrawGeneralPath extends JApplet {

	@Override
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(4.0f));
		g2.setPaint(Color.GREEN);

		int[] xPoints = { 10, 50, 100, 150, 200, 250, 300, 350 };
		int[] yPoints = { 10, 50, 10, 50, 10, 50, 10, 50 };

		GeneralPath polyline = new GeneralPath(GeneralPath.WIND_EVEN_ODD, xPoints.length);
		polyline.moveTo(xPoints[0], yPoints[0]);

		for (int i = 1; i < xPoints.length; i++) {
			polyline.lineTo(xPoints[i], yPoints[i]);
		}
		polyline.curveTo(150, 150, 300, 300, 50, 250);
		polyline.closePath();

		g2.draw(polyline);

		g2.setPaint(Color.RED);

		g2.setStroke(new BasicStroke(2.0f));
		polyline = new GeneralPath(GeneralPath.WIND_NON_ZERO);
		polyline.moveTo(200, 50);
		polyline.lineTo(270, 300);
		polyline.lineTo(100, 120);
		polyline.lineTo(300, 120);
		polyline.lineTo(130, 300);
		polyline.closePath();
		g2.draw(polyline);
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Draw GeneralPath");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JApplet applet = new DrawGeneralPath();
		frame.getContentPane().add(applet);
		frame.pack();
		frame.setSize(800, 800);
		frame.setVisible(true);
	}
}
