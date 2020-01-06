// Created at 2016/8/8 
// Author:	JiaweiMao
// Copyright (c) Dalian Institute of Chemical Physics
//      Chinese Academy of Sciences
// Contact: jiawei@dicp.ac.cn

package trail.jgui.swing;

import javax.swing.*;
import java.awt.*;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @date Aug 08 2016, 16:34
 */
public class ResourceBundleTest extends JFrame {

    public ResourceBundleTest() {
        Container contentPane = getContentPane();
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEtchedBorder());
        contentPane.add(panel, BorderLayout.CENTER);
        contentPane.add(GJApp.getStatusArea(), BorderLayout.SOUTH);
        GJApp.showStatus(GJApp.getResource("statusAreaText"));
    }

    public static void main(String[] args) {
        GJApp.launch(new ResourceBundleTest(), "Status Area", 300, 300, 450, 300);
    }
}
