package trail.jgui.swing.j2d.effects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.GeneralPath;

/**
 * In this demo, we have a star. The star rotates and grows and then shrinks.
 */
class StarDemoSurface extends JPanel implements ActionListener {

    // these points are used to draw the star shape
    private final int points[][] = {
            {0, 85}, {75, 75}, {100, 10}, {125, 75},
            {200, 85}, {150, 125}, {160, 190}, {100, 150},
            {40, 190}, {50, 125}, {0, 85}
    };

    private Timer timer;
    private double angle = 0; // is used when we rotate the star
    private double scale = 1;   // determines the size of the star
    private double delta = 0.01;    // the amount of change of the scale

    private final int DELAY = 10;

    public StarDemoSurface() {

        initTimer();
    }

    private void initTimer() {

        timer = new Timer(DELAY, this);
        timer.start();
    }

    private void doDrawing(Graphics g) {

        int h = getHeight();
        int w = getWidth();

        Graphics2D g2d = (Graphics2D) g.create();

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        g2d.translate(w / 2, h / 2); // the coordinate system is moved into the middle of the window

        // The generalPath is used to create the star shape.
        // the first point is added to the path with the moveTo() method.
        // subsequent points to the star are added with the lineTo() method.
        GeneralPath star = new GeneralPath();
        star.moveTo(points[0][0], points[0][1]);

        for (int k = 1; k < points.length; k++) {

            star.lineTo(points[k][0], points[k][1]);
        }

        g2d.rotate(angle);
        g2d.scale(scale, scale);
        g2d.fill(star);

        g2d.dispose();
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }

    private void step() {

        if (scale < 0.01) {

            delta = -delta;
        } else if (scale > 0.99) {

            delta = -delta;
        }

        scale += delta;
        angle += 0.01;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        step();
        repaint();
    }
}

public class StarDemoEx extends JFrame {

    public StarDemoEx() {

        initUI();
    }

    private void initUI() {

        add(new StarDemoSurface());

        setTitle("Star");
        setSize(420, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            StarDemoEx ex = new StarDemoEx();
            ex.setVisible(true);
        });
    }
}