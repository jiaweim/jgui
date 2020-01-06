/**********************************************************
 * File:JFileChooserFilter.java
 *
 * Author: Jiawei Mao
 *
 * Created on Jul 15, 2015
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

package trail.jgui.swing;

import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.filechooser.FileFilter;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;

/**
 * 
 * @author JiaweiM
 * @date Jul 15, 2015 3:59:02 PM
 */
public class JFileChooserFilter {

	private JFrame frmFilefilterdemo;
	private JFileChooser fileChooser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFileChooserFilter window = new JFileChooserFilter();
					window.frmFilefilterdemo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JFileChooserFilter() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFilefilterdemo = new JFrame();
		frmFilefilterdemo.setTitle("FileFilterDemo");
		frmFilefilterdemo.setBounds(100, 100, 450, 300);
		frmFilefilterdemo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel label = new JLabel(" ");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setPreferredSize(new Dimension(150, 30));
		frmFilefilterdemo.getContentPane().add(label, BorderLayout.CENTER);

		JButton b = new JButton("打开文件");
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fileChooser = new JFileChooser("E:/FileFormat");
				fileChooser.addChoosableFileFilter(new DatFileFilter("dat"));
				int result = fileChooser.showOpenDialog(frmFilefilterdemo);
				if(result == JFileChooser.APPROVE_OPTION){
					File file = fileChooser.getSelectedFile();
					label.setText("您选择了："+file.getName()+"文件");
				}else if(result == JFileChooser.CANCEL_OPTION){
					label.setText("您没有选择任何文件");
				}
			}
		});
		frmFilefilterdemo.getContentPane().add(b, BorderLayout.SOUTH);
	}

}

class DatFileFilter extends FileFilter {
	String ext;

	public DatFileFilter(String ext) {
		this.ext = ext;
	}

	/*
	 * (non-Javadoc)
	 * @see javax.swing.filechooser.FileFilter#accept(java.io.File)
	 */
	@Override
	public boolean accept(File f) {
		if (f.isDirectory()) {
			return true;
		}
		String fileName = f.getName();
		int index = fileName.lastIndexOf('.');
		if (index > 0 && index < fileName.length() - 1) {
			String extension = fileName.substring(index + 1).toLowerCase();
			if (extension.equals(ext)) {
				return true;
			}
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * @see javax.swing.filechooser.FileFilter#getDescription()
	 */
	@Override
	public String getDescription() {
		return "Mascot DAT File (*.dat)";
	}

}
