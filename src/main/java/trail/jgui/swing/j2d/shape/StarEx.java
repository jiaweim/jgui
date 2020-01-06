package trail.jgui.swing.j2d.shape;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.GeneralPath;

/**
 * More complex shapes can be constructed with GeneralPath.
 * It represents a geometric path constructed from straight lines, and
 * quadratic and cubic Bezier curves.
 */
class StarSurface extends JPanel {

    // the coordinates of the star
    private final double points[][] = {{0, 85}, {75, 75}, {100, 10}, {125, 75},
            {200, 85}, {150, 125}, {160, 190}, {100, 150}, {40, 190}, {50, 125}, {0, 85}
    };

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g.create();

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        g2d.setPaint(Color.gray);
        g2d.translate(25, 5);

        // here we instantiate the GeneralPath class
        GeneralPath star = new GeneralPath();

        // move to the initial coordinate of the GeneralPath
        star.moveTo(points[0][0], points[0][1]);
        // here we connect all the coordinates of the star.
        for (int k = 1; k < points.length; k++)
            star.lineTo(points[k][0], points[k][1]);

        // close the path and fill the interior of the star
        star.closePath();
        g2d.fill(star);

        g2d.dispose();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);
    }
}

public class StarEx extends JFrame {

    public StarEx() {

        initUI();
    }

    private void initUI() {

        add(new StarSurface());

        setTitle("Star");
        setSize(350, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            StarEx ex = new StarEx();
            ex.setVisible(true);
        });
    }
}