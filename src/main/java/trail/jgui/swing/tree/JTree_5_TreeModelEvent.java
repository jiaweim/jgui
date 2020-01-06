/**********************************************************
 * File:JTree_5_TreeModelEvent.java
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
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

/**
 * 
 * @Class JTree_5_TreeModelEvent
 * @author JiaweiM
 * @date Jul 17, 2015 8:06:39 PM
 */
public class JTree_5_TreeModelEvent implements TreeModelListener {
	
	JLabel label;
	String nodeName = null;
	DefaultMutableTreeNode root;
	DefaultMutableTreeNode node1;
	DefaultMutableTreeNode node2;
	DefaultMutableTreeNode node3;
	DefaultMutableTreeNode node4;
	JTree tree;

	public JTree_5_TreeModelEvent() {
		
		JFrame frame = new JFrame("学科");
		Container contentPane = frame.getContentPane();
		JPanel panel = new JPanel();
		root = new DefaultMutableTreeNode("学科");
		node1 = new DefaultMutableTreeNode("化学");
		node2 = new DefaultMutableTreeNode("生物");
		node3 = new DefaultMutableTreeNode("计算机");
		node4 = new DefaultMutableTreeNode("数学");
		root.add(node1);
		root.add(node2);
		root.add(node3);
		root.add(node4);
		root.add(node1);
		
		DefaultMutableTreeNode leaf = new DefaultMutableTreeNode("分析化学");
		node1.add(leaf);
		leaf = new DefaultMutableTreeNode("量子化学");
		node1.add(leaf);
		leaf = new DefaultMutableTreeNode("无机化学");
		node1.add(leaf);
		leaf = new DefaultMutableTreeNode("物理化学");
		node1.add(leaf);
		leaf = new DefaultMutableTreeNode("有机化学");
		node1.add(leaf);
		leaf = new DefaultMutableTreeNode("材料化学");
		node1.add(leaf);
		
		leaf = new DefaultMutableTreeNode("Anthropology");
		node2.add(leaf);
		leaf = new DefaultMutableTreeNode("BioChemistry");
		node2.add(leaf);
		leaf = new DefaultMutableTreeNode("Bioethics");
		node2.add(leaf);
		leaf = new DefaultMutableTreeNode("BiologicalPsychiatry");
		node2.add(leaf);
		leaf = new DefaultMutableTreeNode("Biophysics");
		node2.add(leaf);
		leaf = new DefaultMutableTreeNode("BioTechnology");
		node2.add(leaf);
		leaf = new DefaultMutableTreeNode("Botany");
		node2.add(leaf);
		
		leaf = new DefaultMutableTreeNode("C");
		node3.add(leaf);
		leaf = new DefaultMutableTreeNode("C#");
		node3.add(leaf);
		leaf = new DefaultMutableTreeNode("C++");
		node3.add(leaf);
		leaf = new DefaultMutableTreeNode("Java");
		node3.add(leaf);
		leaf = new DefaultMutableTreeNode("Matlab");
		node3.add(leaf);
		leaf = new DefaultMutableTreeNode("Perl");
		node3.add(leaf);
		
		leaf = new DefaultMutableTreeNode("代数");
		node4.add(leaf);
		leaf = new DefaultMutableTreeNode("拓扑");
		node4.add(leaf);
		leaf = new DefaultMutableTreeNode("数论");
		node4.add(leaf);
		leaf = new DefaultMutableTreeNode("微积分");
		node4.add(leaf);

		tree = new JTree(root);
		tree.setEditable(true);
		tree.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				try {
					JTree tree = (JTree) e.getSource();
					int loc = tree.getRowForLocation(e.getX(), e.getY());
					TreePath path = tree.getPathForRow(loc);
					TreeNode node = (TreeNode) path.getLastPathComponent();
					nodeName = node.toString();
				} catch (Exception e2) {
				}
			}
		});

		final DefaultTreeModel treeModel = (DefaultTreeModel) tree.getModel();
		treeModel.addTreeModelListener(this);
		JScrollPane pane = new JScrollPane();
		pane.setViewportView(tree);
		label = new JLabel("更改数据为：");
		JButton b1 = new JButton("增加节点");
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DefaultMutableTreeNode parentNode = null;
				DefaultMutableTreeNode newNode = new DefaultMutableTreeNode("新节点");
				newNode.setAllowsChildren(true);
				
				TreePath path = tree.getSelectionPath();
				parentNode = (DefaultMutableTreeNode) path.getLastPathComponent();
				treeModel.insertNodeInto(newNode, parentNode, parentNode.getChildCount());
				// scrollPathToVisible使Tree自动展开文件夹，以便展示所加入的新节点
				tree.scrollPathToVisible(new TreePath(newNode.getPath()));
				label.setText("新增节点成功");
			}
		});
		JButton b2 = new JButton("删除节点");
		b2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TreePath path = tree.getSelectionPath();
				if (path != null) {
					DefaultMutableTreeNode selectionNode = (DefaultMutableTreeNode) path.getLastPathComponent();
					TreeNode parentNode = selectionNode.getParent();
					if (parentNode != null) {
						treeModel.removeNodeFromParent(selectionNode);
						label.setText("删除节点成功");
					}
				}
			}
		});
		
		panel.setLayout(new FlowLayout());
		panel.add(b1);
		panel.add(b2);
		panel.add(label);
		contentPane.add(pane, BorderLayout.CENTER);
		contentPane.add(panel, BorderLayout.SOUTH);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		new JTree_5_TreeModelEvent();
	}

	@Override
	public void treeNodesChanged(TreeModelEvent e) {
		TreePath path = e.getTreePath();
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) path.getLastPathComponent();
		try {
			int[] index = e.getChildIndices();
			node = (DefaultMutableTreeNode) node.getChildAt(index[0]);
		} catch (Exception e2) {
		}
		
		label.setText(nodeName + "更改数据为：" + node.getUserObject());
	}

	@Override
	public void treeNodesInserted(TreeModelEvent e) {}

	@Override
	public void treeNodesRemoved(TreeModelEvent e) {}

	@Override
	public void treeStructureChanged(TreeModelEvent e) {}
}
