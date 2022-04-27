package jgui.awt;

import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class TestListener implements MouseMotionListener, MouseListener, WindowListener{
	private Frame f;
	private TextField tf;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestListener two = new TestListener();
		two.go();
	}
	
	public void go() {
		f = new Frame("����������");
		f.add(new Label("�����϶����"), "North");
		tf = new TextField(30);
		f.add(tf, "South");
		f.addMouseListener(this);
		f.addMouseMotionListener(this);
		f.addWindowListener(this);
		f.setSize(300, 200);
		f.setVisible(true);
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		System.exit(1);
		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		String s = "�������";
		tf.setText(s);
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		String s = "����ƿ�"+"X="+arg0.getXOnScreen()+"Y="+arg0.getYOnScreen();
		tf.setText(s);
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
	public void mouseDragged(MouseEvent arg0) {
		String s = "������꣺X="+arg0.getX()+"Y="+arg0.getY();
		tf.setText(s);
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
