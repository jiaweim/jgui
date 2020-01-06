/**********************************************************
 * File:JTree_4_TreeModelEvent.java
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

package trail.jgui.swing.tree;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

/**
 * 
 * @Class JTree_4_TreeModelEvent
 * @author JiaweiM
 * @date Jul 17, 2015 7:53:24 PM
 */
public class JTree_4_TreeModelEvent implements TreeModelListener {
	JLabel label;
	String nodeName = null;

	public JTree_4_TreeModelEvent() {
		JFrame frame = new JFrame("购买清单");
		Container contentPane = frame.getContentPane();
		contentPane.setLayout(new BorderLayout());
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("今天要买的东西");

		DefaultMutableTreeNode node1 = new DefaultMutableTreeNode("蔬菜");
		DefaultMutableTreeNode node2 = new DefaultMutableTreeNode("水果");
		DefaultMutableTreeNode node3 = new DefaultMutableTreeNode("礼品");
		DefaultMutableTreeNode node4 = new DefaultMutableTreeNode("家用小物件");
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
		tree.setEditable(true);
		tree.addMouseListener(new MouseHandler());
		TreeModel treeModel = tree.getModel();
		treeModel.addTreeModelListener(this);
//		
//		DefaultTreeModel treeModel = (DefaultTreeModel) tree.getModel();
//		treeModel.addTreeModelListener(this);

		JScrollPane pane = new JScrollPane();
		pane.setViewportView(tree);
		label = new JLabel("更改数据为：");

		contentPane.add(pane, BorderLayout.CENTER);
		contentPane.add(label, BorderLayout.SOUTH);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * 实现treeNodesChanged事件处理方法。
	 */
	@Override
	public void treeNodesChanged(TreeModelEvent e) {
		TreePath path = e.getTreePath(); // 获取当前所选取节点的树路径
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) path.getLastPathComponent(); // 获取所选节点
		try {
			int[] index = e.getChildIndices(); // 获取其子节点的节点序号，针对此序号获取其子节点
			node = (DefaultMutableTreeNode) node.getChildAt(index[0]);
			label.setText(nodeName + "更改数据为：" + (String) node.getUserObject());
		} catch (Exception e2) {
		}

	}

	public static void main(String[] args) {
		new JTree_4_TreeModelEvent();
	}

	class MouseHandler extends MouseAdapter {
		public void mousePressed(MouseEvent e) {
			try {
				JTree tree = (JTree) e.getSource();
				int row = tree.getRowForLocation(e.getX(), e.getY());
				TreePath treePath = tree.getPathForRow(row);
				TreeNode node = (TreeNode) treePath.getLastPathComponent();
				nodeName = node.toString();
			} catch (Exception e2) {
			}

		}
	}

	@Override
	public void treeNodesInserted(TreeModelEvent e) {}

	@Override
	public void treeNodesRemoved(TreeModelEvent e) {}

	@Override
	public void treeStructureChanged(TreeModelEvent e) {}
}
