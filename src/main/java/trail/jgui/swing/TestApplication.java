// Created at 2016/8/7 
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
 * @date Aug 07 2016, 19:47
 */
public class TestApplication extends JFrame {

    public TestApplication() {
        super("An application");
        Container contentPane = getContentPane();
        Icon icon = new ImageIcon(getClass().getResource("swing.gif"), "An animated GIF of Duke on a swing");
        JLabel label = new JLabel("Swing!", icon, SwingConstants.CENTER);
        contentPane.add(label);
    }

    private static void createAndShowGui() {
        JFrame frame = new TestApplication();
        frame.setBounds(100, 100, 300, 250);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TestApplication::createAndShowGui);
    }
}
