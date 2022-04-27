// Created at 2016/7/28
// Author:	JiaweiMao
// Copyright (c) Dalian Institute of Chemical Physics
//      Chinese Academy of Sciences
// Contact: jiawei@dicp.ac.cn

package jgui.swing.j2d.drawing;

import javax.swing.*;
import java.awt.*;

/**
 * BasicStroke class defines a basic set of rendering attributes for the outlines
 * of graphics primitives.
 * These rendering attributes include width, end caps, line joins, miter limit, and dash.
 */
class BasicStrokeSurface extends JPanel {

    private void doDrawing(Graphics g) {

        // as we need to change the stroke attribute, therefore we work with
        // copy of the Graphics object.
        Graphics2D g2d = (Graphics2D) g.create();

        // four different dash patterns
        float[] dash1 = {2f, 0f, 2f};
        float[] dash2 = {1f, 1f, 1f};
        float[] dash3 = {4f, 0f, 2f};
        float[] dash4 = {4f, 4f, 1f};

        g2d.drawLine(20, 40, 250, 40);

        BasicStroke bs1 = new BasicStroke(1, BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_ROUND, 1.0f, dash1, 2f);

        BasicStroke bs2 = new BasicStroke(1, BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_ROUND, 1.0f, dash2, 2f);

        BasicStroke bs3 = new BasicStroke(1, BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_ROUND, 1.0f, dash3, 2f);

        BasicStroke bs4 = new BasicStroke(1, BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_ROUND, 1.0f, dash4, 2f);

        // use setStroke() method to apply the BasicStroke
        // to the current graphics context
        g2d.setStroke(bs1);
        g2d.drawLine(20, 80, 250, 80);

        g2d.setStroke(bs2);
        g2d.drawLine(20, 120, 250, 120);

        g2d.setStroke(bs3);
        g2d.drawLine(20, 160, 250, 160);

        g2d.setStroke(bs4);
        g2d.drawLine(20, 200, 250, 200);

        // in the end, we dispose the copy of the Graphics object
        g2d.dispose();
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }
}

public class BasicStrokesEx extends JFrame {

    public BasicStrokesEx() {

        initUI();
    }

    private void initUI() {

        add(new BasicStrokeSurface());

        setTitle("Basic strokes");
        setSize(280, 270);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            BasicStrokesEx ex = new BasicStrokesEx();
            ex.setVisible(true);
        });
    }
}