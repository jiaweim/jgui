/**********************************************************
 * File:JTextField1.java
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

package trail.jgui.swing.text;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 * 
 * @Class JTextField1
 * @author JiaweiM
 * @date Jul 17, 2015 8:43:04 AM
 */
public class JTextField1 {

	public static void main(String[] args) {
		JFrame frame = new JFrame("JTextFieldDemo3");
		Container contentPane = frame.getContentPane();
		JPanel pl = new JPanel();
		pl.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.insets = new Insets(2, 2, 2, 2);
		pl.setBorder(BorderFactory.createTitledBorder("Students' Basic Data"));
		JLabel l1 = new JLabel("Name:");
		JLabel l2 = new JLabel("Sex:");
		JLabel l3 = new JLabel("Height");
		JLabel l4 = new JLabel("Weight:");

		JTextField t1 = new JTextField(new JTextFiledLength(10), "", 10);
		JTextField t2 = new JTextField(new JTextFiledLength(1), "", 1);
		JTextField t3 = new JTextField(new JTextFiledLength(5), "", 5);
		JTextField t4 = new JTextField(new JTextFiledLength(5), "", 5);

		gbc.gridy = 1;
		gbc.gridx = 0;
		pl.add(l1, gbc);

		gbc.gridx = 1;
		pl.add(t1, gbc);

		gbc.gridy = 2;
		gbc.gridx = 0;
		pl.add(l2, gbc);

		gbc.gridx = 1;
		pl.add(t2, gbc);

		gbc.gridy = 3;
		gbc.gridx = 0;
		pl.add(l3, gbc);

		gbc.gridx = 1;
		pl.add(t3, gbc);

		gbc.gridy = 4;
		gbc.gridx = 0;
		pl.add(l4, gbc);

		gbc.gridx = 1;
		pl.add(t4, gbc);

		contentPane.add(pl);

		frame.pack();
		frame.setVisible(true);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
}

class JTextFiledLength extends PlainDocument {
	private static final long serialVersionUID = -8822944252282627481L;
	private int maxLength;

	public JTextFiledLength(int length) {
		this.maxLength = length;
	}

	public void insertString(int offset, String str, AttributeSet att) throws BadLocationException {
		if (getLength() + str.length() > maxLength) {
			Toolkit.getDefaultToolkit().beep();
		} else {
			super.insertString(offset, str, att);
		}
	}
}
