/**********************************************************
 * File:ComponentTooltips.java
 *
 * Author: Jiawei Mao
 *
 * Created on Jul 16, 2015
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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 * @author JiaweiM
 * @date Jul 16, 2015 4:57:03 PM
 */
public class ComponentTooltips {

	public static void main(String[] args) {
		JFrame jf = new JFrame("添加内容面板测试程序");
		jf.setSize(300, 200);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);

		JPanel conJPanel = new JPanel();
		jf.setContentPane(conJPanel);
		JButton b1 = new JButton("确定");
		JButton b2 = new JButton("取消");
		conJPanel.add(b1);
		conJPanel.add(b2);
		b1.setToolTipText("这是一个确定按钮");
		b2.setToolTipText("这是一个取消按钮");
	}
}
