/**********************************************************
 * File:RobotTest.java
 *
 * Author: Jiawei Mao
 *
 * Created on Aug 19, 2015
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

package trail.jgui.awt;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;

/**
 * 
 * @Class RobotTest
 * @author JiaweiM
 * @date Aug 19, 2015 9:28:22 PM
 */
public class RobotTest {

	public static void main(String[] args) throws AWTException {
		final Robot rt = new Robot();
		
		new Thread() {
			public void run() {
				rt.delay(2000);
				rt.keyPress(KeyEvent.VK_ENTER);
				rt.keyRelease(KeyEvent.VK_ENTER);
			}
		}.start();

		JOptionPane.showMessageDialog(null, "以下程序自动执行，包括本对话框，请不必进行认为干预。\n" + "如果不能正常执行程序，请先关闭输入法");

		// 设置开始菜单的大概位置
		int x = 40;
		int y = Toolkit.getDefaultToolkit().getScreenSize().height - 10;

		// 鼠标移动到开始菜单。
		rt.mouseMove(x, y);
		rt.delay(500);

		// 单击三次开始菜单
		for (int i = 0; i < 3; i++) {
			pressMouse(rt, InputEvent.BUTTON1_DOWN_MASK, 500);
		}
		rt.delay(1000);

		// 运行CMD命令 r cmd enter
		int[] ks = { KeyEvent.VK_R, KeyEvent.VK_C, KeyEvent.VK_M, KeyEvent.VK_D,KeyEvent.VK_ENTER };
		pressKeys(rt, ks, 500);
		rt.mouseMove(400, 400);
		rt.delay(500);

		// 运行DIR命令 dir enter
		ks = new int[] { KeyEvent.VK_D, KeyEvent.VK_I, KeyEvent.VK_R, KeyEvent.VK_ENTER };
		pressKeys(rt, ks, 500);
		rt.delay(1000);

		// 运行CLS命令 cls enter
		ks = new int[] { KeyEvent.VK_C, KeyEvent.VK_L, KeyEvent.VK_S, KeyEvent.VK_ENTER };
		pressKeys(rt, ks, 500);
		rt.delay(1000);

		// 运行EXIT命令 exit enter
		ks = new int[] { KeyEvent.VK_E, KeyEvent.VK_X, KeyEvent.VK_I, KeyEvent.VK_T, KeyEvent.VK_ENTER };
		pressKeys(rt, ks, 500);
		rt.delay(1000);

		// 右键测试
		x = Toolkit.getDefaultToolkit().getScreenSize().width - 10;
		rt.mouseMove(x, y);
		// 如果是双键鼠标,请改用InputEvent.BUTTON2_MASK试试,我没有这种鼠标
		pressMouse(rt, InputEvent.BUTTON3_MASK, 500);
		// 显示日期调整对话框 a
		pressKeys(rt, new int[] { KeyEvent.VK_A }, 1000);
		rt.delay(2000);
		pressKeys(rt, new int[] { KeyEvent.VK_ESCAPE }, 0);
		rt.delay(1000);
		new Thread() {
			public void run() {
				rt.delay(1000);
				// 回车
				rt.keyPress(KeyEvent.VK_ENTER);
				rt.keyRelease(KeyEvent.VK_ENTER);
			}
		}.start();
		JOptionPane.showMessageDialog(null, "演示完毕!");

	}

	// 鼠标单击，要双击就连续调用
	private static void pressMouse(Robot r, int m, int delay) {
		r.mousePress(m);
		r.delay(10);
		r.mouseRelease(m);
		r.delay(delay);
	}

	// 键盘输入
	private static void pressKeys(Robot r, int[] ks, int delay) {
		for (int i = 0; i < ks.length; i++) {
			r.keyPress(ks[i]);
			r.delay(10);
			r.keyRelease(ks[i]);
			r.delay(delay);
		}
	}

}
