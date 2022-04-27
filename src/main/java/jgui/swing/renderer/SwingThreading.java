package jgui.swing.renderer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * @author JiaweiMao
 * @version 2014��6��12�� ����9:19:43
 */
public class SwingThreading extends JFrame implements ActionListener {
	private JLabel counter;
	private int tickCounter = 0;
	private static SwingThreading edt;

	public SwingThreading() {
		super("Swing Threading");

		JButton freezer = new JButton("Increment");
		freezer.addActionListener(this);

		counter = new JLabel("0");

		add(freezer, BorderLayout.CENTER);
		add(counter, BorderLayout.SOUTH);

		pack();
		setLocationRelativeTo(null);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e) {
		incrementLabel();
	}

	private void incrementLabel() {
		tickCounter++;
		Runnable code = new Runnable() {
			public void run() {
				counter.setText(String.valueOf(tickCounter));
			}
		};

		if (SwingUtilities.isEventDispatchThread()) {
			code.run();
		} else {
			SwingUtilities.invokeLater(code);
		}
	}

	public static void main(String... args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				edt = new SwingThreading();
				edt.setVisible(true);

				new Thread(new Runnable() {
					public void run() {
						while (true) {
							try {
								Thread.sleep(300);
							} catch (InterruptedException e) {
							}
							edt.incrementLabel();
						}
					}
				}).start();
			}
		});
	}
}