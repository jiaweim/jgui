// Created at 2016/8/4
// Author:	JiaweiMao
// Copyright (c) Dalian Institute of Chemical Physics
//      Chinese Academy of Sciences
// Contact: jiawei@dicp.ac.cn


package trail.jgui.swing;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author JiaweiM
 * @date Jul 16, 2015 5:10:26 PM
 */
public class ComponentBorder {

    public static void main(String[] args) {
        JFrame jf = new JFrame("添加内容面板测试程序 ");
        jf.setSize(400, 300);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setVisible(true);
        JPanel panel = new JPanel();
        jf.setContentPane(panel);
        JButton b1 = new JButton("确定");
        JButton b2 = new JButton("取消");

        panel.add(b1);
        panel.add(b2);

        b1.setBorder(BorderFactory.createLineBorder(Color.RED));
    }
}
