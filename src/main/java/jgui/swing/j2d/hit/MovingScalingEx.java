package jgui.swing.j2d.hit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

/**
 * we will learn how to move and scale graphical objects with a mouse on the panel. It can be used to move and scale
 * charts, diagrams or other various objects in our application.
 * <p>
 * In our code example, we have two graphical objects: a rectangle and a circle. We can move both by clicking on them
 * and dragging them. We can also scale them up or down by positioning the mouse cursor over the objects and moving the
 * mouse wheel.
 */
class MovingScalingSurface extends JPanel {

    private ZRectangle zrect;
    private ZEllipse zell;

    public MovingScalingSurface() {

        initUI();
    }

    private void initUI() {

        MovingAdapter ma = new MovingAdapter();

        // register three listeners. These listeners capture mouse press, mouse drag, and mouse wheel events.
        addMouseMotionListener(ma);
        addMouseListener(ma);
        addMouseWheelListener(new ScaleHandler());

        zrect = new ZRectangle(50, 50, 50, 50);
        zell = new ZEllipse(150, 70, 80, 80);
    }

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        Font font = new Font("Serif", Font.BOLD, 40);
        g2d.setFont(font);

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        g2d.setPaint(new Color(0, 0, 200));
        g2d.fill(zrect);
        g2d.setPaint(new Color(0, 200, 0));
        g2d.fill(zell);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);
    }

    // add functionality for scaling and moving an ellipse. For example, the
    // isHit() method determines if the mouse pointer is inside the area of an ellipse.
    class ZEllipse extends Ellipse2D.Float {

        public ZEllipse(float x, float y, float width, float height) {

            setFrame(x, y, width, height);
        }

        public boolean isHit(float x, float y) {

            return getBounds2D().contains(x, y);
        }

        public void addX(float x) {

            this.x += x;
        }

        public void addY(float y) {

            this.y += y;
        }

        public void addWidth(float w) {

            this.width += w;
        }

        public void addHeight(float h) {

            this.height += h;
        }
    }

    class ZRectangle extends Rectangle2D.Float {

        public ZRectangle(float x, float y, float width, float height) {

            setRect(x, y, width, height);
        }

        public boolean isHit(float x, float y) {

            return getBounds2D().contains(x, y);
        }

        public void addX(float x) {

            this.x += x;
        }

        public void addY(float y) {

            this.y += y;
        }

        public void addWidth(float w) {

            this.width += w;
        }

        public void addHeight(float h) {

            this.height += h;
        }
    }

    /**
     * handlers the mouse press and mouse drag events
     */
    class MovingAdapter extends MouseAdapter {

        private int x;
        private int y;

        @Override
        public void mousePressed(MouseEvent e) {

            x = e.getX();
            y = e.getY();
        }

        @Override
        public void mouseDragged(MouseEvent e) {

            doMove(e);
        }

        /**
         * calculate the distance by which we have dragged the object.
         */
        private void doMove(MouseEvent e) {

            int dx = e.getX() - x;
            int dy = e.getY() - y;

            // if we are inside the area of the rectangle, we update the x and y coordinates of
            // the rectangle and repaint the panel.
            if (zrect.isHit(x, y)) {

                zrect.addX(dx);
                zrect.addY(dy);
                repaint();
            }

            if (zell.isHit(x, y)) {

                zell.addX(dx);
                zell.addY(dy);
                repaint();
            }

            // the initial coordinates are updated.
            x += dx;
            y += dy;
        }
    }

    /**
     * handles the scaling of the objects.
     */
    class ScaleHandler implements MouseWheelListener {

        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {

            doScale(e);
        }

        private void doScale(MouseWheelEvent e) {

            int x = e.getX();
            int y = e.getY();

            /*
            If we move a mouse wheel and our cursor is inside the area of a rectangle, the rectangle is resized and
            the panel repainted. The amount of the scaling is computed from the getWheelRotation() method, which
            returns the amount of the wheel rotation.
             */
            if (e.getScrollType() == MouseWheelEvent.WHEEL_UNIT_SCROLL) {

                if (zrect.isHit(x, y)) {

                    float amount = e.getWheelRotation() * 5f;
                    zrect.addWidth(amount);
                    zrect.addHeight(amount);
                    repaint();
                }

                if (zell.isHit(x, y)) {

                    float amount = e.getWheelRotation() * 5f;
                    zell.addWidth(amount);
                    zell.addHeight(amount);
                    repaint();
                }
            }
        }
    }
}

public class MovingScalingEx extends JFrame {

    public MovingScalingEx() {

        initUI();
    }

    private void initUI() {

        add(new MovingScalingSurface());

        setTitle("Moving and scaling");
        setSize(300, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            MovingScalingEx ex = new MovingScalingEx();
            ex.setVisible(true);
        });
    }
}