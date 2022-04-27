package jgui.awt;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ToolbarFrame2 extends JFrame{
	
	JButton cutButton, copyButton, pasteButton;
	JButton javaButton, macButton, motifButton, winButton;
	
	public ToolbarFrame2() {
		super("Toolbar Example (Swing)");
		setSize(450,250);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		
		ActionListener printListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				System.out.println(ae.getActionCommand());
			}
		};
		
		JPanel toolbar = new JPanel();
		toolbar.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		cutButton = new JButton("Cut");
		cutButton.addActionListener(printListener);
		toolbar.add(cutButton);
		
		copyButton = new JButton("Copy");
		copyButton.addActionListener(printListener);
		toolbar.add(copyButton);
		
		pasteButton = new JButton("Paste");
		pasteButton.addActionListener(printListener);
		toolbar.add(pasteButton);
		
		add(toolbar,BorderLayout.NORTH);
		
		JPanel lnfPanel = new JPanel();
		LnFListener lnfListener = new LnFListener(this);
		macButton = new JButton("Mac");
		macButton.addActionListener(lnfListener);
		lnfPanel.add(macButton);
		javaButton = new JButton("Metal");
		javaButton.addActionListener(lnfListener);
		lnfPanel.add(javaButton);
		motifButton = new JButton("Motif");
		motifButton.addActionListener(lnfListener);
		lnfPanel.add(motifButton);
		winButton = new JButton("Windows");
		winButton.addActionListener(lnfListener);
		lnfPanel.add(winButton);
		add(lnfPanel,BorderLayout.SOUTH);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ToolbarFrame2 tf2 = new ToolbarFrame2();
		tf2.setVisible(true);

	}

}


