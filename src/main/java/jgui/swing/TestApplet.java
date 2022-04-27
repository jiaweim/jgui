// Created at 2016/8/7 
// Author:	JiaweiMao
// Copyright (c) Dalian Institute of Chemical Physics
//      Chinese Academy of Sciences
// Contact: jiawei@dicp.ac.cn

package jgui.swing;

import javax.swing.*;
import java.awt.*;

/**
 * JApplet的默认布局为 BorderLayout, Applet 的默认布局为FlowLayout。
 *
 * @author JiaweiMao
 * @version 1.0.0
 * @date Aug 07 2016, 19:38
 */
public class TestApplet extends JApplet {

    public void init() {
        Container contentPane = getContentPane();
        Icon icon = new ImageIcon(getClass().getResource("swing.gif"));
        JLabel label = new JLabel("Swing!", icon, SwingConstants.CENTER);
        contentPane.add(label);
    }

}
