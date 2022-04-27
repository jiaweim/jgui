package jgui.swing.j2d.transform;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

/**
 * Scaling is done with the scale() method. In this method, we provide two parameters. They are the x scale and y scale
 * factor, by which coordinates are scaled along the x or y axis respectively.
 *
 * we have a rectangle, first we scale it down and then we scale it up a bit.
 */
class ScalingSurface extends JPanel {

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g.create();

        g2d.setColor(new Color(150, 150, 150));
        g2d.fillRect(20, 20, 80, 50);

        AffineTransform tx1 = new AffineTransform();
        tx1.translate(110, 22);
        // scale down
        tx1.scale(0.5, 0.5);

        g2d.setTransform(tx1);
        g2d.fillRect(0, 0, 80, 50);

        AffineTransform tx2 = new AffineTransform();
        tx2.translate(170, 20);
        // scale up
        tx2.scale(1.5, 1.5);

        g2d.setTransform(tx2);
        g2d.fillRect(0, 0, 80, 50);

        g2d.dispose();
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }
}

public class ScalingEx extends JFrame {

    public ScalingEx() {

        initUI();
    }

    private void initUI() {

        add(new ScalingSurface());

        setTitle("Scaling");
        setSize(330, 160);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            ScalingEx ex = new ScalingEx();
            ex.setVisible(true);
        });
    }
}