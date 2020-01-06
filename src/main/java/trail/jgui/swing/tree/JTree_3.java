package trail.jgui.swing.tree;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class JTree_3 {
	public JTree_3() {
		JFrame frame = new JFrame("学校名录");
		Container contentPane = frame.getContentPane();
		// 使用DefaultMutableTreeNode构造器创建根节点
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("今天要买的东西");
		// 构造叶节点
		DefaultMutableTreeNode node1 = new DefaultMutableTreeNode("蔬菜");
		DefaultMutableTreeNode node2 = new DefaultMutableTreeNode("水果");
		DefaultMutableTreeNode node3 = new DefaultMutableTreeNode("礼品");
		DefaultMutableTreeNode node4 = new DefaultMutableTreeNode("小物件");
		root.add(node1);
		root.add(node2);
		root.add(node3);
		root.add(node4);
		DefaultMutableTreeNode leafNode = new DefaultMutableTreeNode("白菜");
		node1.add(leafNode);
		leafNode = new DefaultMutableTreeNode("大蒜");
		node1.add(leafNode);
		leafNode = new DefaultMutableTreeNode("土豆");
		node1.add(leafNode);
		leafNode = new DefaultMutableTreeNode("苹果");
		node2.add(leafNode);
		leafNode = new DefaultMutableTreeNode("香蕉");
		node2.add(leafNode);
		leafNode = new DefaultMutableTreeNode("西瓜");
		node2.add(leafNode);
		leafNode = new DefaultMutableTreeNode("茅台");
		node3.add(leafNode);
		leafNode = new DefaultMutableTreeNode("营养麦片");
		node3.add(leafNode);
		leafNode = new DefaultMutableTreeNode("保健食品");
		node3.add(leafNode);
		leafNode = new DefaultMutableTreeNode("味精");
		node4.add(leafNode);
		leafNode = new DefaultMutableTreeNode("酱油");
		node4.add(leafNode);
		leafNode = new DefaultMutableTreeNode("清洁剂");
		node4.add(leafNode);
		leafNode = new DefaultMutableTreeNode("保鲜袋");
		node4.add(leafNode);

		JTree tree = new JTree(root);
		JScrollPane pane = new JScrollPane();
		pane.setViewportView(tree);
		contentPane.add(pane);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new JTree_3();
	}
}
