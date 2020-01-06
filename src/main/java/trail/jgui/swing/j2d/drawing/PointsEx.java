// Created at 2016/7/28
// Author:	JiaweiMao
// Copyright (c) Dalian Institute of Chemical Physics
//      Chinese Academy of Sciences
// Contact: jiawei@dicp.ac.cn

package trail.jgui.swing.j2d.drawing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

class PointSurface extends JPanel implements ActionListener {

    private final int DELAY = 150;
    private Timer timer;

    public PointSurface() {

        initTimer();
    }

    private void initTimer() {
        // Timer is used to create animation, 每隔150 ms 调用 actionPerformted()一次，从而重绘组件
        timer = new Timer(DELAY, this);
        timer.start();
    }

    public Timer getTimer() {

        return timer;
    }

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        g2d.setPaint(Color.BLUE); // points are painted in blue color

        // get the width and height of the component
        int w = getWidth();
        int h = getHeight();


        // get a random number in range of the size of area
        Random r = new Random();

        for (int i = 0; i < 2000; i++) {

            int x = Math.abs(r.nextInt()) % w;
            int y = Math.abs(r.nextInt()) % h;
            g2d.drawLine(x, y, x, y);// draw the point, specify the same point twice
        }
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // each action event, we call the repaint()
        repaint();
    }
}

/**
 * This example draws randomly 2000 points on the window. A
 * timer is used to draw points in a cycle.
 */
public class PointsEx extends JFrame {

    public PointsEx() {

        initUI();
    }

    private void initUI() {

        final PointSurface surface = new PointSurface();
        add(surface);

        // when the window is about to be closed, we retrieve the timer and close it with
        // its stop() method. Timers not explicitly cancelled may hold resources
        // indefinitely. The EXIT_ON_CLOSE default closing operation closes the JVM and all
        // its threads so this is not necessary for our example.
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Timer timer = surface.getTimer();
                timer.stop();
            }
        });

        setTitle("Points");
        setSize(350, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            PointsEx ex = new PointsEx();
            ex.setVisible(true);
        });
    }
}