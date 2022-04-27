package jgui.swing.j2d.hit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 * In the next example, we show how to resize a shape. Our shape is a rectangle. On the rectangle, we draw two small
 * black rectangles. By clicking on these tiny rectangles and dragging them, we can resize the main rectangle.
 * <p>
 * There are two ways to create a rectangle. One way is to provide x and y coordinates of the top-left point and the
 * width and height of the rectangle. Another way is to provide the top-left and bottom-right points. In our code
 * example, we will use both methods.
 */
class ResizingRectangleSurface extends JPanel {

    // in this array, we store points that make our rectangle
    private Point2D[] points;
    // the size of the small black rectangles
    private final int SIZE = 8;
    private int pos;

    public ResizingRectangleSurface() {

        initUI();
    }

    private void initUI() {

        addMouseListener(new ShapeTestAdapter());
        addMouseMotionListener(new ShapeTestAdapter());
        pos = -1;

        // initial coordinates for the rectangle
        points = new Point2D[2];
        points[0] = new Point2D.Double(50, 50);
        points[1] = new Point2D.Double(150, 100);
    }

    private void doDrawing(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;

        for (Point2D point : points) {
            double x = point.getX() - SIZE / 2;
            double y = point.getY() - SIZE / 2;
            g2.fill(new Rectangle2D.Double(x, y, SIZE, SIZE));
        }

        // draw a rectangle from the points
        Rectangle2D r = new Rectangle2D.Double();
        r.setFrameFromDiagonal(points[0], points[1]);

        g2.draw(r);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);
    }

    private class ShapeTestAdapter extends MouseAdapter {

        // determine if we have click inside one of the two controlling points.
        // if we hit one of them, the pos variable stores which of them it was.
        @Override
        public void mousePressed(MouseEvent event) {

            Point p = event.getPoint();

            // draws the two small controlling rectangles
            for (int i = 0; i < points.length; i++) {

                double x = points[i].getX() - SIZE / 2;
                double y = points[i].getY() - SIZE / 2;

                Rectangle2D r = new Rectangle2D.Double(x, y, SIZE, SIZE);

                if (r.contains(p)) {

                    pos = i;
                    return;
                }
            }
        }

        @Override
        public void mouseReleased(MouseEvent event) {

            pos = -1;
        }

        // the rectangle is dynamically resized, during the mouseDragged() event,
        // we get the current point, update our array of points, and repaint the panel
        @Override
        public void mouseDragged(MouseEvent event) {

            if (pos == -1) {
                return;
            }

            points[pos] = event.getPoint();
            repaint();
        }
    }
}

public class ResizingRectangleEx extends JFrame {

    public ResizingRectangleEx() {

        initUI();
    }

    private void initUI() {

        add(new ResizingRectangleSurface());

        setTitle("Resize rectangle");
        setSize(300, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            ResizingRectangleEx ex = new ResizingRectangleEx();
            ex.setVisible(true);
        });
    }
}