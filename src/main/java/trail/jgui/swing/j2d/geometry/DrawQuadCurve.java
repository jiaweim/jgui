/**********************************************************
 * File:DrawQuadCurve.java
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

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.QuadCurve2D;
import java.awt.geom.Rectangle2D;
import java.util.Vector;

import javax.swing.JApplet;
import javax.swing.JFrame;

/**
 * 
 * @author JiaweiM
 * @date Nov 26, 2015 10:09:33 AM
 */
public class DrawQuadCurve extends JApplet {
	
	@Override
	public void init(){
		getContentPane().add(new DrawingCanvas());
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Drawing Quad Curve");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		DrawQuadCurve curve = new DrawQuadCurve();
		curve.init();
		frame.getContentPane().add(curve);
		frame.setSize(650, 250);
		frame.setVisible(true);
	}

	class DrawingCanvas extends Canvas {

		Vector<QuadCurve2D> quadCurves;

		QuadCurve2D selectedCurve = null;
		Rectangle2D boundingRec = null;

		/**
		 * 
		 */
		public DrawingCanvas() {
			setBackground(Color.white);
			setSize(400, 200);

			quadCurves = new Vector<>();
			quadCurves.addElement(new QuadCurve2D.Float(20, 20, 80, 160, 120, 20));
			quadCurves.addElement(new QuadCurve2D.Float(120, 100, 160, 40, 200, 180));
			quadCurves.addElement(new QuadCurve2D.Float(240, 20, 220, 60, 260, 120));
			quadCurves.addElement(new QuadCurve2D.Float(250, 160, 260, 140, 280, 180));
			quadCurves.addElement(new QuadCurve2D.Float(300, 180, 340, 40, 380, 120));
			quadCurves.addElement(new QuadCurve2D.Float(20, 180, 80, 170, 120, 190));
			
		}
		
		@Override
		public void paint(Graphics g){
			Graphics2D g2 = (Graphics2D)g;
			
			for(int i=0; i< quadCurves.size(); i++){
				g2.draw(quadCurves.elementAt(i));
			}
		}
	}

}
