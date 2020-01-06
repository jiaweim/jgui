/**********************************************************
  * File:DrawLine.java
  *
  * Author:	Jiawei Mao                     
  *
  * Created on Nov 26, 2015
  *                       
  * Copyright (c) Dalian Institute of Chemical Physics
  *	Chinese Academy of Sciences
  * 
  * Contact: jiawei@dicp.ac.cn                   
  *                                              
  *******************************************************/

/**
 * 
 * @version 1.00
 */

package trail.jgui.swing.j2d.geometry;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.JApplet;
import javax.swing.JFrame;

/**
 * 
 * @author	JiaweiM
 * @date	Nov 26, 2015 9:55:36 AM
 */
public class DrawLine extends JApplet{
	
	@Override
	public void paint(Graphics g){
        // Draw a simple line using the Graphics2D draw() method.
		Graphics2D g2 = (Graphics2D)g;
		g2.setStroke(new BasicStroke(2f));
		g2.setColor(Color.RED);
		g2.draw(new Line2D.Double(50, 150, 250, 350));
		g2.setColor(Color.GREEN);
		g2.draw(new Line2D.Double(250, 350, 350, 250));
		g2.setColor(Color.BLUE);
		g2.draw(new Line2D.Double(350, 250, 150, 50));
		g2.setColor(Color.YELLOW);
		g2.draw(new Line2D.Double(150, 50, 50, 150));
		g2.setColor(Color.BLACK);
		g2.draw(new Line2D.Double(0, 0, 400, 400));
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Draw Line");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JApplet applet = new DrawLine();
		frame.getContentPane().add(applet);
		frame.pack();
		frame.setSize(420, 440);
		frame.setVisible(true);
	}
}
