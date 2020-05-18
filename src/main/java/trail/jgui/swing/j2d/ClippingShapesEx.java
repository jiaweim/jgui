package trail.jgui.swing.j2d;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;


/**
 * clipping to the intersection of two shapes: a rectangle and a circle.
 * we have a bouncing circle and a rotating rectangle. when these shapes
 * overlap, the resulting area is filled with color.
 */
class ClippingShapeSurface extends JPanel implements ActionListener
{

    private Timer timer;
    private double rotate = 1;
    private int pos_x = 8;
    private int pos_y = 8;
    private final double delta[] = {1, 1};

    private final int RADIUS = 60;

    public ClippingShapeSurface()
    {

        initTimer();
    }

    private void initTimer()
    {

        timer = new Timer(10, this);
        timer.start();
    }

    private void doDrawing(Graphics g)
    {

        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        // since we did not create a copy of the Graphics2D object, we store the old clip for
        // later use. In the end, we must reset the clip to the original one.
        Shape oldClip = g2d.getClip();

        int w = getWidth();
        int h = getHeight();

        // the rectangle is being rotated. It is always positioned in the middle of the panel
        Rectangle rect = new Rectangle(0, 0, 200, 80);

        AffineTransform tx = new AffineTransform();
        tx.rotate(Math.toRadians(rotate), w / 2, h / 2);
        tx.translate(w / 2 - 100, h / 2 - 40);

        Ellipse2D circle = new Ellipse2D.Double(pos_x, pos_y, RADIUS, RADIUS);

        // here we get the shape of the rotated rectangle
//        GeneralPath path = new GeneralPath();
//        path.append(tx.createTransformedShape(rect), false);

        Shape transformedShape = tx.createTransformedShape(rect);

        g2d.clip(circle);
//        g2d.clip(path);
        g2d.clip(transformedShape);

        g2d.setPaint(new Color(110, 110, 110));
        g2d.fill(circle);

        g2d.setClip(oldClip);

        g2d.draw(circle);
        g2d.draw(transformedShape);
//        g2d.draw(path);
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        doDrawing(g);
    }

    public void step()
    {

        int w = getWidth();
        int h = getHeight();

        rotate += 1;

        if (pos_x < 0) {

            delta[0] = 1;
        } else if (pos_x > w - RADIUS) {

            delta[0] = -1;
        }

        if (pos_y < 0) {

            delta[1] = 1;
        } else if (pos_y > h - RADIUS) {

            delta[1] = -1;
        }

        pos_x += delta[0];
        pos_y += delta[1];
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {

        step();
        repaint();
    }
}

public class ClippingShapesEx extends JFrame
{

    public ClippingShapesEx()
    {

        initUI();
    }

    private void initUI()
    {

        setTitle("Clipping shapes");

        add(new ClippingShapeSurface());

        setSize(350, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args)
    {

        EventQueue.invokeLater(() -> {
            ClippingShapesEx ex = new ClippingShapesEx();
            ex.setVisible(true);
        });
    }
}