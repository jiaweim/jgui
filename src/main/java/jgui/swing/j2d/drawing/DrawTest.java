// Created at 2016/8/5 
// Author:	JiaweiMao
// Copyright (c) Dalian Institute of Chemical Physics
//      Chinese Academy of Sciences
// Contact: jiawei@dicp.ac.cn

package jgui.swing.j2d.drawing;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @date Aug 05 2016, 9:09
 */
public class DrawTest extends JComponent {
    private static final int DEFAULT_WIDTH = 400;
    private static final int DEFAULT_HEIGHT = 400;

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        // draw a rectangle
        double leftX = 100;
        double topY = 100;
        double width = 200;
        double height = 150;

        Rectangle2D rect = new Rectangle2D.Double(leftX, topY, width, height);
        g2.draw(rect);

        // draw the enclosed ellipse
        Ellipse2D ellipse2d = new Ellipse2D.Double();
        ellipse2d.setFrame(rect);
        g2.draw(ellipse2d);

        // draw a diagonal line
        g2.draw(new Line2D.Double(leftX, topY, leftX + width, topY + height));

        // draw a circle with the same center
        double centerX = rect.getCenterX();
        double centerY = rect.getCenterY();

        double radius = 150;

        Ellipse2D circle = new Ellipse2D.Double();
        circle.setFrameFromCenter(centerX, centerY, centerX + radius, centerY + radius);
        g2.draw(circle);
    }

    private static void createAndShowGui() {
        JFrame frame = new JFrame("DrawTest");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(new DrawTest());
        frame.pack();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(DrawTest::createAndShowGui);
    }

    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}
