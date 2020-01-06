package trail.jgui.swing.tree;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;

/**
 * 下面创建了一个系统默认的树组件，即当使用不带参数的构造器创建树。
 * 
 * @Class	JTree_1
 * @author	JiaweiM
 * @date	Jul 17, 2015 7:05:41 PM
 */
public class JTree_1 {
	public JTree_1() {
		JFrame frame = new JFrame("树组件测试");
		Container contentPane = frame.getContentPane();
		JTree tree = new JTree();
		tree.setShowsRootHandles(true);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(tree);
		contentPane.add(scrollPane);
		
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new JTree_1();
	}
}
