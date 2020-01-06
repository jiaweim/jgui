// Created at 2016/8/4 
// Author:	JiaweiMao
// Copyright (c) Dalian Institute of Chemical Physics
//      Chinese Academy of Sciences
// Contact: jiawei@dicp.ac.cn

package trail.jgui.swing.j2d.drawing;

import javax.swing.*;
import java.awt.*;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @date Aug 04 2016, 13:56
 */
public class DiagonalLineDemo extends JComponent {

    public void paintComponent(Graphics g) {
        g.drawLine(0, 0, getWidth() - 1, getHeight() - 1);
    }

    private static void createAndShowGUI() {
        JFrame f = new JFrame("Diagonal Line Demo");
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setSize(300, 100);
        f.add(new DiagonalLineDemo());
        f.setVisible(true);
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(DiagonalLineDemo::createAndShowGUI);
    }
}
