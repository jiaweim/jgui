/**********************************************************
 * File:DrawOval.java
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

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 * @author JiaweiM
 * @date Nov 26, 2015 3:36:58 PM
 */
public class DrawOval extends JPanel {

	/**
	 * Create the panel.
	 */
	public DrawOval() {

	}

	@Override
	public void paint(Graphics g) {
		// Dynamically calculate size information
		Dimension size = getSize();
		// diameter
		int d = Math.min(size.width, size.height);
		int x = (size.width - d) / 2;
		int y = (size.height - d) / 2;
		// draw circle (color already set to foreground)
//		g.fillOval(x, y, d, d);
		g.setColor(Color.black);

		g.drawOval(x, y, d, d);
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Draw Frame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(new DrawOval());
		frame.pack();
		frame.setSize(400, 400);
		
		frame.setVisible(true);
	}

}
