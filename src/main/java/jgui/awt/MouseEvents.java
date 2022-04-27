package jgui.awt;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseEvents extends Applet implements MouseListener, MouseMotionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String msg = "";
	int mouseX = 0;
	int mouseY = 0;
	
	public void init() {
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		mouseX = 0;
		mouseY = 10;
		msg="*";
		showStatus("Dragging mouse at"+mouseX+","+mouseY);
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		showStatus("Moving mouse at "+e.getX()+", "+e.getY());
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		mouseX = 5;
		mouseY = 5;
		msg="click!";
		repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		mouseX = 3;
		mouseY =2;
		msg="enter!";
		repaint();
	}

	@Override
	public void mouseExited(MouseEvent e) {
		mouseX = 5;
		mouseY = 5;
		msg="exit";
		repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		msg = "press";
		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		msg="release";
		repaint();
	}
	
	public void paint(Graphics g){
		g.drawString(msg, mouseX, mouseY);
	}

}
