/**********************************************************
 * File:JPanel1.java
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

package trail.jgui.swing.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 * @Class JPanel1
 * @author JiaweiM
 * @date Jul 17, 2015 2:14:31 PM
 */
public class JPanel1 {
	static final int WIDTH = 300;
	static final int HEIGHT = 200;

	public static void main(String[] args) {
		JFrame frame = new JFrame("测试程序");
		frame.setLayout(new BorderLayout());
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		JPanel contentPane = new JPanel(new BorderLayout());

		JPanel p1 = new JPanel(new FlowLayout());
		JPanel p2 = new JPanel(new FlowLayout());
		JPanel p3 = new JPanel(new FlowLayout());
		JPanel p4 = new JPanel(new FlowLayout());
		JPanel p5 = new JPanel(new FlowLayout());

		frame.setContentPane(contentPane);
		JButton b1 = new JButton("小赵");// 创建九个普通按钮组件，将p1到p5五个面板设置为流布局。
		JButton b2 = new JButton("小李");
		JButton b3 = new JButton("小王");
		JButton b4 = new JButton("小孙");
		JButton b5 = new JButton("小钱");
		JButton b6 = new JButton("小周");
		JButton b7 = new JButton("小政");
		JButton b8 = new JButton("小武");
		JButton b9 = new JButton("姓");

		p1.add(b1);
		p1.add(b2);
		p2.add(b3);
		p2.add(b4);
		p3.add(b5);
		p3.add(b6);
		p4.add(b7);
		p4.add(b8);
		p5.add(b9);

		contentPane.add(p1, "North");
		contentPane.add(p2, "South");
		contentPane.add(p3, "West");
		contentPane.add(p4, "East");
		contentPane.add(p5, "Center");
		frame.pack();
	}
}
