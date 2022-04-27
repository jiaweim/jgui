// Created at 2016/7/28 
// Author:	JiaweiMao
// Copyright (c) Dalian Institute of Chemical Physics
//      Chinese Academy of Sciences
// Contact: jiawei@dicp.ac.cn

package jgui.swing.j2d;

import javax.swing.*;
import java.awt.*;

/**
 * draw a text on a JPanel compoinent.
 */
class Surface extends JPanel {

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        g2d.drawString("Java 2D", 50, 50);
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }
}

/**
 * A simple example of a Java 2D application
 */
public class SimpleEx extends JFrame {

    public SimpleEx() {

        initUI();
    }

    private void initUI() {

        add(new Surface());

        setTitle("Simple Java 2D example");
        setSize(300, 200);
        setLocationRelativeTo(null);    // null means put window in the screen center
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            SimpleEx ex = new SimpleEx();
            ex.setVisible(true);
        });
    }
}
