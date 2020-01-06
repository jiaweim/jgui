package trail.jgui.awt;

import java.awt.Canvas;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TestCanvas implements KeyListener, MouseListener{
	Canvas c;
	String s = "";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Frame f = new Frame("����Canvas");
		TestCanvas tc = new TestCanvas();
		tc.c = new Canvas();
		f.add("Center", tc.c);
		
		f.setSize(150,150);
		tc.c.addMouseListener(tc);
		tc.c.addKeyListener(tc);
		f.setVisible(true);

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		System.out.println("MouseClicked");
		c.requestFocus();
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		System.out.println("KeyTyped");
		s += arg0.getKeyChar();
		c.getGraphics().drawString(s,0,20);
		
	}

}
