package jgui.swing.j2d.transform;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

/**
 * create an complex shape by rotating an ellipse
 */
class DonutSurface extends JPanel {

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g.create();

        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        g2d.setRenderingHints(rh);

        Dimension size = getSize();
        double w = size.getWidth();
        double h = size.getHeight();

        // first create an ellipse
        Ellipse2D e = new Ellipse2D.Double(0, 0, 80, 130);
        g2d.setStroke(new BasicStroke(1));
        g2d.setPaint(Color.gray);

        // several rotation
        for (double deg = 0; deg < 360; deg += 5) {
            AffineTransform at = AffineTransform.getTranslateInstance(w / 2, h / 2);
            at.rotate(Math.toRadians(deg));
            g2d.draw(at.createTransformedShape(e));
        }
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }
}

public class DonutEx extends JFrame {

    public DonutEx() {

        initUI();
    }

    private void initUI() {

        add(new DonutSurface());

        setTitle("Donut");
        setSize(370, 320);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            DonutEx ex = new DonutEx();
            ex.setVisible(true);
        });
    }
}