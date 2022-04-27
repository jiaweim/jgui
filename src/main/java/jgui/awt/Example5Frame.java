package jgui.awt;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * ��ͼ��ض���Graphics2D��Rectangle2D��Ellipse2D��Line2D�ļ�Ӧ��ʵ��
 */
public class Example5Frame extends JFrame {
	/**
     * 
     */
	private static final long serialVersionUID = 1L;

	public Example5Frame() {
		setTitle("����ͼ��");// ���ô���ı���
		setSize(400, 400);// ���ô���Ĵ�С
		// �������DrawPanel������ӵ�����
		DrawPanel panel = new DrawPanel();
		add(panel);
	}

	public static void main(String[] args) {
		Example5Frame frame = new Example5Frame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

/**
 * ����һ��JPanel�������ڱ�����Ƶ�ͼ�ε�����
 */
class DrawPanel extends JPanel {
	/**
     * 
     */
	private static final long serialVersionUID = 1L;

	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;// ��Graphics����ת��ΪGraphics2D����
		// ���ƾ���
		double leftX = 100;// ���忪ʼ���Ƶ�����
		double topY = 100;
		double width = 200;// ������ƿ��
		double height = 150;// ������Ƹ߶�
		Rectangle2D rect = new Rectangle2D.Double(leftX, topY, width, height);// �������ζ���
		g2.draw(rect);// �����ζ��������Panel�����
		
		// ������Բ
		Ellipse2D ellipse = new Ellipse2D.Double();// ������Բ����
		ellipse.setFrame(rect);// ������Բ�Ļ��ƿ��Ϊ����ľ��Σ���������ڽӣ�
		g2.draw(ellipse);// ����Բ���������Panel�����
		// ��������
		Line2D line = new Line2D.Double(leftX, topY, leftX + width, topY + height);// ������������4��������ʾ�����˵����꣩
		g2.draw(line);// ���������������Panel�����
		// ����Բ
		double centerX = rect.getCenterX();// ����Բ�����꣨�Ծ��ε�����ΪԲ�ģ�
		double centerY = rect.getCenterY();
		double radius = 150;// ����Բ�İ뾶
		Ellipse2D circle = new Ellipse2D.Double();
		circle.setFrameFromCenter(centerX, centerY, centerX + radius, centerY + radius);// ����Բ�εĻ��ƿ�ܣ�4��������ʾ���ĵ�����ͽǵ����꣩
		g2.draw(circle);// ��Բ�ζ��������Panel�����
	}
}
