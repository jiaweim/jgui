/**********************************************************
 * File:AlphaCompositesApplication.java
 *
 * Author: Jiawei Mao
 *
 * Created on Nov 30, 2015
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

package jgui.swing.j2d.composition;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.lang.reflect.Field;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

/**
 * 
 * @author JiaweiM
 * @date Nov 30, 2015 5:16:38 PM
 */
public class AlphaCompositesApplication extends JFrame {

	private CompositePainter painter;
	private JSlider opacity;
	private JComboBox composites;

	/**
	 * 
	 */
	public AlphaCompositesApplication() {
		super("Alpha Composites");
		add(painter = new CompositePainter(), BorderLayout.CENTER);
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEADING));
		panel.add(buildCompositeSelector());
		panel.add(buildOpacitySelector());
		
		add(panel, BorderLayout.SOUTH);
		
		setSize(400, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private Component buildOpacitySelector() {
		opacity = new JSlider(0, 100, 50);
		opacity.addChangeListener(event -> changeComposite());
		JPanel panel = new JPanel();
		panel.add(new JLabel("0%"));
		panel.add(opacity);
		panel.add(new JLabel("100%"));
		return panel;
	}

	private Component buildCompositeSelector() {
		composites = new JComboBox(new String[] { "CLEAR", "DST", "DST_ATOP", "DST_IN", "DST_OUT", "DST_OVER", "SRC",
				"SRC_ATOP", "SRC_IN", "SRC_OUT", "SRC_OVER", "XOR" });
		composites.setSelectedItem("SRC");
		composites.addActionListener(actionEvent -> changeComposite());
		return composites;
	}

	private void changeComposite() {
		String rule = composites.getSelectedItem().toString();
		try {
			Field ruleField = AlphaComposite.class.getDeclaredField(rule);
			AlphaComposite composite = AlphaComposite.getInstance(ruleField.getInt(null),
					(float) opacity.getValue() / 100.0f);
			painter.setComposite(composite);
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

	}

	private final class CompositePainter extends JComponent {
		private AlphaComposite composite = AlphaComposite.getInstance(AlphaComposite.SRC, 0.5f);

		/*
		 * (non-Javadoc)
		 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
		 */
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
			Graphics2D g2 = image.createGraphics();
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

			g2.setColor(Color.BLUE);
			g2.fillRect(4 + (getWidth() / 4), 4, getWidth() / 2, getHeight() - 8);
			g2.setColor(Color.RED);
			g2.setComposite(composite);
			g2.fillOval(40, 40, getWidth() - 80, getHeight() - 80);
			g2.dispose();

			g2.drawImage(image, 0, 0, null);
		}

		private void setComposite(AlphaComposite composite) {
			this.composite = composite;
			repaint();
		}
	}
}
