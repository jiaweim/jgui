package trail.jgui.awt.graphics;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.QuadCurve2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class Graphics_draw_rectangle extends JComponent{
	
	public void paintComponent(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		
		Ellipse2D ellipse2d = new Ellipse2D.Double(10, 10, 210, 110);
		g2d.draw(ellipse2d);
	}
	
	private static void createAndShowGui(){
		JFrame frame = new JFrame("Draw line demo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(200, 100);
		frame.add(new Graphics_draw_rectangle());
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				createAndShowGui();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

}
