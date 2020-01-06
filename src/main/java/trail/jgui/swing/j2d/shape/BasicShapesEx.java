package trail.jgui.swing.j2d.shape;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * In this example, we draw six basic shapes on the panel: a square, a rectangle,
 * a rounded rectangle, an ellipse, an arc, and a circle.
 */
class BasicShapeSurface extends JPanel {

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        // the shapes will be drawn in a gray background
        g2d.setPaint(new Color(150, 150, 150));

        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        g2d.setRenderingHints(rh);

        // draw a square
        g2d.fillRect(30, 20, 50, 50);
        // draw a rectangle
        g2d.fillRect(120, 20, 90, 60);
        // create a rounded rectangle, the last two parameters are the horizontal and vertical
        // diameters of the arc at the four cornets.
        g2d.fillRoundRect(250, 20, 70, 60, 25, 25);
        // draws the interior of the given shape, an ellipse
        g2d.fill(new Ellipse2D.Double(10, 100, 80, 100));
        // fills a circular or elliptical arc covering the specified rectangle.
        // An arc is a portion of the circumference of a circle
        g2d.fillArc(120, 130, 110, 100, 5, 150);
        g2d.fillOval(270, 130, 50, 50);
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }
}

public class BasicShapesEx extends JFrame {

    public BasicShapesEx() {

        initUI();
    }

    private void initUI() {

        add(new BasicShapeSurface());

        setTitle("Basic shapes");
        setSize(350, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            BasicShapesEx ex = new BasicShapesEx();
            ex.setVisible(true);
        });
    }
}