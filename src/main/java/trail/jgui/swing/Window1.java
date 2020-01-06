/**********************************************************
  * File:Window1.java
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

package trail.jgui.swing;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Swing组件不能直接添加到顶层容器中，必须添加一个与swing顶层组件关联的contentPane。
 * @Class	Window1
 * @author	JiaweiM
 * @date	Jul 16, 2015 4:37:06 PM
 */
public class Window1 {

	public static void main(String[] args) {
		JFrame jf = new JFrame("添加内容面板到测试程序");
		jf.setSize(300, 200);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
		JPanel contentPanel = new JPanel();
		jf.setContentPane(contentPanel);
		
		JButton b1 = new JButton("确定");
		JButton b2 = new JButton("取消");
		contentPanel.add(b1);
		contentPanel.add(b2);
	}
}
