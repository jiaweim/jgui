/**********************************************************
  * File:Menu1.java
  *
  * Author:	Jiawei Mao                     
  *
  * Created on Jul 16, 2015
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

package jgui.swing;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * 
 * @Class	Menu1
 * @author	JiaweiM
 * @date	Jul 16, 2015 4:40:35 PM
 */
public class Menu1 {
	
	public static void main(String[] args) {
		JFrame jf = new JFrame();
		jf.setSize(300, 200);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setTitle("学生管理系统");
		JMenuBar menuBar1 = new JMenuBar();
		jf.setJMenuBar(menuBar1);
		JMenu menu1 = new JMenu("文件");
		JMenu menu2 = new JMenu("编辑");
		JMenu menu3 = new JMenu("视图");
		menuBar1.add(menu1);
		menuBar1.add(menu2);
		menuBar1.add(menu3);
		
		JMenuItem item1 = new JMenuItem("打开");
		JMenuItem item2 = new JMenuItem("保存");
		JMenuItem item3 = new JMenuItem("打印");
		JMenuItem item4 = new JMenuItem("退出");
		
		menu1.add(item1);
		menu1.add(item2);
		menu1.addSeparator();
		menu1.add(item3);
		menu1.addSeparator();
		menu1.add(item4);
		jf.setVisible(true);
	}

}
