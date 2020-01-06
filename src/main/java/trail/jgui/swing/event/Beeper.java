/**********************************************************
 * File:Beeper.java
 *
 * Author: Jiawei Mao
 *
 * Created on Jul 17, 2015
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

package trail.jgui.swing.event;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * 
 * @Class Beeper
 * @author JiaweiM
 * @date Jul 17, 2015 8:51:34 AM
 */
public class Beeper extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	JButton button;

	public Beeper() {

		super(new BorderLayout());

		button = new JButton("Click Me!");

		button.setPreferredSize(new Dimension(200, 80));
		add(button, BorderLayout.CENTER);
		button.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Toolkit.getDefaultToolkit().beep();
	}

	private static void createAndShowGUI() {

		JFrame frame = new JFrame("Beeper");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JComponent newComponent = new Beeper();
		newComponent.setOpaque(true);
		frame.setContentPane(newComponent);

		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				createAndShowGUI();
			}
		});
	}
}
