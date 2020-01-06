/**********************************************************
 * File:FontSelector.java
 *
 * Author:	Jiawei Mao                     
 *
 * Created on May 20, 2015
 *                       
 * Copyright (c) Dalian Institute of Chemical Physics
 *	Chinese Academy of Sciences
 * 
 * Contact: jiawei@dicp.ac.cn                   
 *                                              
 *******************************************************/

package trail.jgui.awt;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JApplet;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * @author JiaweiMao
 * @version May 20, 2015 5:04:36 PM
 */
public class FontSelector extends JApplet implements ChangeListener,
		ItemListener {

	TextTestPanel textTestPanel;
	JComboBox fonts, styles;
	JSpinner sizes;
	String fontChoice = "Dialog";
	int styleChoice = 0;
	int sizeChoice = 12;

	public void init() {

		try {
			String cn = UIManager.getSystemLookAndFeelClassName();
			UIManager.setLookAndFeel(cn);
		} catch (Exception e) {
			// TODO: handle exception
		}

		JPanel fontSelectorPanel = new JPanel();

		fontSelectorPanel.add(new JLabel("Font family:"));

		GraphicsEnvironment gEnv = GraphicsEnvironment
				.getLocalGraphicsEnvironment();
		
		fonts = new JComboBox(gEnv.getAvailableFontFamilyNames());
		fonts.setSelectedItem(fontChoice);
		fonts.setMaximumRowCount(5);
		fonts.addItemListener(this);
		fontSelectorPanel.add(fonts);

		fontSelectorPanel.add(new JLabel("Style:"));

		String[] styleNames = { "Plain", "Bold", "Italic", "Bold Italic" };
		styles = new JComboBox(styleNames);
		styles.addItemListener(this);
		fontSelectorPanel.add(styles);

		fontSelectorPanel.add(new JLabel("Size:"));

		sizes = new JSpinner(new SpinnerNumberModel(12, 6, 24, 1));
		sizes.addChangeListener(this);
		fontSelectorPanel.add(sizes);

		textTestPanel = new TextTestPanel();
		textTestPanel.setFont(new Font(fontChoice, styleChoice, sizeChoice));
		textTestPanel.setBackground(Color.white);

		add(BorderLayout.NORTH, fontSelectorPanel);
		add(BorderLayout.CENTER, textTestPanel);

	}
	 /*
     * Detect a state change in any of the settings and create a new
     * Font with the corresponding settings. Set it on the test component.
     */
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() != ItemEvent.SELECTED) {
            return;
        }
        if (e.getSource() == fonts) {
            fontChoice = (String)fonts.getSelectedItem();
        } else {
            styleChoice = styles.getSelectedIndex();
        }
        textTestPanel.setFont(new Font(fontChoice, styleChoice, sizeChoice));
    }

    public void stateChanged(ChangeEvent e) {
        try {
            String size = sizes.getModel().getValue().toString();
            sizeChoice = Integer.parseInt(size);
            textTestPanel.setFont(new Font(fontChoice,styleChoice,sizeChoice));
        } catch (NumberFormatException nfe) {
        }
    }

    public static void main(String s[]) {

        JFrame f = new JFrame("FontSelector");
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        JApplet fontSelector = new FontSelector();
        f.add(fontSelector, BorderLayout.CENTER);
        fontSelector.init();
        f.pack();
        f.setVisible(true);
    }


}

class TextTestPanel extends JComponent {

	public Dimension getPreferredSize() {
		return new Dimension(500, 200);
	}

	public void setFont(Font font) {
		super.setFont(font);
		repaint();
	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		g.setColor(Color.white);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.black);
		g.setFont(getFont());
		FontMetrics metrics = g.getFontMetrics();
		String text = "The quick brown fox jumped over the lazy dog";
		int x = getWidth() / 2 - metrics.stringWidth(text) / 2;
		int y = getHeight() - 80;
		g.drawString(text, x, y);
	}
}
