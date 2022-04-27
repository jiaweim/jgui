package jgui.awt.graphics;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.QuadCurve2D;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class Graphics_draw_line extends JComponent{

	public void paintComponent(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
//		Line2D.Double line = new Line2D.Double(0, 0, getWidth()-1, getHeight()-1);
//		g2d.draw(line);
		
		QuadCurve2D qCurve2d = new QuadCurve2D.Float(357, 182, 414, 275, 546, 243);
		g2d.draw(qCurve2d);
	}
	
	private static void createAndShowGui(){
		JFrame frame = new JFrame("Draw line demo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(200, 100);
		frame.add(new Graphics_draw_line());
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					createAndShowGui();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
