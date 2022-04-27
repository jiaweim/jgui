package jgui.swing.layout;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * 
 * @Class BoxLayout_1
 * @author JiaweiM
 * @date Jul 17, 2015 4:35:28 PM
 */
public class BoxLayout_1 {
	public static void main(String[] args) {
		BoxLayoutFrame frame = new BoxLayoutFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}

class BoxLayoutFrame extends JFrame {
	private static final int WIDTH = 300;
	private static final int HEIGHT = 200;

	public BoxLayoutFrame() {
		setTitle("测试箱式布局管理器");
		setSize(WIDTH, HEIGHT);
		Container cn = getContentPane();
		JLabel label1 = new JLabel(" 姓名：");
		JTextField text1 = new JTextField(10);
		text1.setMaximumSize(text1.getPreferredSize());
		Box hbox1 = Box.createHorizontalBox();
		hbox1.add(label1);
		hbox1.add(Box.createHorizontalStrut(20));
		hbox1.add(text1);
		JLabel label2 = new JLabel(" 密码：");
		JTextField text2 = new JTextField(10);
		text2.setMaximumSize(text2.getPreferredSize());
		Box hbox2 = Box.createHorizontalBox();
		hbox2.add(label2);
		hbox2.add(Box.createHorizontalStrut(20));
		hbox2.add(text2);
		JButton button1 = new JButton("确定");
		JButton button2 = new JButton("取消");
		Box hbox3 = Box.createHorizontalBox();
		hbox3.add(button1);
		hbox3.add(button2);
		Box vBox = Box.createVerticalBox();
		vBox.add(hbox1);
		vBox.add(hbox2);
		vBox.add(Box.createVerticalGlue());
		vBox.add(hbox3);
		cn.add(vBox, BorderLayout.CENTER);
	}
}
