// Created at 2016/8/7 
// Author:	JiaweiMao
// Copyright (c) Dalian Institute of Chemical Physics
//      Chinese Academy of Sciences
// Contact: jiawei@dicp.ac.cn

package trail.jgui.swing;

import javax.swing.*;

/**
 * 既可作为应用程序运行又可作为小应用程序运行。
 *
 * @author JiaweiMao
 * @version 1.0.0
 * @date Aug 07 2016, 19:59
 */
public class TestAppletApp extends JApplet {

    public void init() {
        Icon icon = new ImageIcon(getClass().getResource("swing.gif"), "An animated GIF of Duke on a swing");
        JLabel label = new JLabel("Swing!", icon, SwingConstants.CENTER);
        add(label);
    }

    private static void createAndShowGui() {
        JFrame frame = new JFrame("An application");
        JApplet applet = new TestAppletApp();
        applet.init();

        frame.setContentPane(applet.getContentPane());
        frame.setBounds(100, 100, 308, 199);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TestAppletApp::createAndShowGui);
    }

}
