package jgui.swing.j2d.shape;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

/**
 * Another way to create complex shapes is to compose areas.
 * Area stores and manipulates a resolution-independent description of an enclosed
 * area of 2-dimensional space. It can be manipulated by addition, subtraction, intersection,
 * and exclusiveOr operations.
 * This example creates three different shapes by manipulating areas.
 */
class AreaSurface extends JPanel {

    public void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHints(rh);

        g2d.setPaint(Color.gray);

        // rectangle - ellipse
        Area a1 = new Area(new Rectangle2D.Double(20, 20, 100, 100));
        Area a2 = new Area(new Ellipse2D.Double(50, 50, 100, 100));

        a1.subtract(a2);
        g2d.fill(a1);

        Area a3 = new Area(new Rectangle2D.Double(150, 20, 100, 100));
        Area a4 = new Area(new Ellipse2D.Double(150, 20, 100, 100));

        a3.subtract(a4);
        g2d.fill(a3);

        // rectangle + ellipse
        Area a5 = new Area(new Rectangle2D.Double(280, 20, 100, 100));
        Area a6 = new Area(new Ellipse2D.Double(320, 40, 100, 100));

        a5.add(a6);
        g2d.fill(a5);
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }
}

public class AreasEx extends JFrame {

    public AreasEx() {

        initUI();
    }

    private void initUI() {

        add(new AreaSurface());

        setTitle("Areas");
        setSize(450, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            AreasEx ex = new AreasEx();
            ex.setVisible(true);
        });
    }
}