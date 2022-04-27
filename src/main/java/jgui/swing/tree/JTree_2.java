/**********************************************************
  * File:JTree_2.java
  *
  * Author:	Jiawei Mao                     
  *
  * Created on Jul 17, 2015
  *                       
  * Copyright (c) Dalian Institute of Chemical Physics
  *	Chinese Academy of Sciences
  * 
  * Contact: jiawei@dicp.ac.cn                   
  *                                              
  *******************************************************/

/**
 * 
 * @version 1.00
 */

package jgui.swing.tree;

import java.awt.Container;
import java.awt.Font;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.UIManager;

/**
 * 使用Hashtable构造JTree，使用这种方法创建的树不会显示其根结点。
 * 
 * @Class	JTree_2
 * @author	JiaweiM
 * @date	Jul 17, 2015 7:06:37 PM
 */
public class JTree_2 {

	/**
	 * 
	 */
	public JTree_2() {
		JFrame frame = new JFrame("树组件测试");
		Container contentPane = frame.getContentPane();
		String[] s1 = {"青菜","大蒜","大葱"};
		String[] s2 = {"苹果","离子","香蕉"};
		String[] s3 = {"馒头","包子","饺子","面条","混沌"};
		Hashtable table1 = new Hashtable();
		Hashtable table2 = new Hashtable();
		table1.put("蔬菜", s1);
		table1.put("水果", s2);
		table1.put("点心", table2);
		table2.put("中点", s3);
		Font font = new Font("Dialog",Font.PLAIN,12);
		Enumeration keys=UIManager.getLookAndFeelDefaults().keys();
		// 定义Windows界面
		while(keys.hasMoreElements()){
			Object key=keys.nextElement();
			if(UIManager.get(key) instanceof Font){
				UIManager.put(key, font);
			}
		}
		
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JTree tree= new JTree(table1);
		JScrollPane pane = new JScrollPane();
		pane.setViewportView(tree);
		contentPane.add(pane);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new JTree_2();
	}
}
