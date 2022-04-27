package jgui.swing.j2d.hit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Hit testing is determining if we have clicked inside a Shape with a mouse pointer. Each Shape has a contains()
 * method. The method tests if a specified Point2D is inside the boundary of a Shape.
 * <p>
 * In our example, we have two Shapes: a rectangle and a circle. By clicking on them they gradually begin to fade away.
 * In this example, we use threads.
 */
class HitTestingSurface extends JPanel
{

    // we work with a rectangle and an ellipse
    private Rectangle2D rect;
    private Ellipse2D ellipse;
    // control the transparency of the two geometrical objects.
    private float alpha_rectangle;
    private float alpha_ellipse;

    public HitTestingSurface()
    {

        initSurface();
    }

    private void initSurface()
    {

        addMouseListener(new HitTestAdapter());

        rect = new Rectangle2D.Float(20f, 20f, 80f, 50f);
        ellipse = new Ellipse2D.Float(120f, 30f, 60f, 60f);

        alpha_rectangle = 1f;
        alpha_ellipse = 1f;
    }

    /**
     * set the transparency of the rectangle. The alpha_rectangle is computed inside a dedicated Thread.
     */
    private void doDrawing(Graphics g)
    {

        Graphics2D g2d = (Graphics2D) g.create();

        g2d.setPaint(new Color(50, 50, 50));

        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        g2d.setRenderingHints(rh);

        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha_rectangle));
        g2d.fill(rect);

        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
                alpha_ellipse));
        g2d.fill(ellipse);

        g2d.dispose();
    }

    @Override
    public void paintComponent(Graphics g)
    {

        super.paintComponent(g);
        doDrawing(g);
    }

    class RectRunnable implements Runnable
    {

        private Thread runner;

        public RectRunnable()
        {

            initThread();
        }

        private void initThread()
        {

            runner = new Thread(this);
            runner.start();
        }

        @Override
        public void run()
        {

            while (alpha_rectangle >= 0) {

                repaint();
                alpha_rectangle += -0.01f;

                if (alpha_rectangle < 0) {
                    alpha_rectangle = 0;
                }

                try {

                    Thread.sleep(50);
                } catch (InterruptedException ex) {

                    Logger.getLogger(HitTestingSurface.class.getName()).log(Level.SEVERE,
                            null, ex);
                }
            }
        }
    }

    /**
     * reponsible for handling of mouse events. It does implement the Runnable interface, which
     * means that it also creates the first thread.
     */
    class HitTestAdapter extends MouseAdapter implements Runnable
    {

        private RectRunnable rectAnimator;
        private Thread ellipseAnimator;

        @Override
        public void mousePressed(MouseEvent e)
        {

            int x = e.getX();
            int y = e.getY();
            /*
             *For the rectangle, we have a separate inner class—the RectRunnable class. This class creates its own
             * thread in the constructor.
             */
            if (rect.contains(x, y)) {

                rectAnimator = new RectRunnable();
            }
            /*
             * If we press inside the ellipse a new Thread is created. The thread calls the run() method. In our
             * case, it is the run() method of the class itself (HitTestAdapter).
             */
            if (ellipse.contains(x, y)) {

                ellipseAnimator = new Thread(this);
                ellipseAnimator.start();
            }
        }

        @Override
        public void run()
        {

            while (alpha_ellipse >= 0) {

                repaint();
                alpha_ellipse += -0.01f;

                if (alpha_ellipse < 0) {

                    alpha_ellipse = 0;
                }

                try {

                    Thread.sleep(50);
                } catch (InterruptedException ex) {

                    Logger.getLogger(HitTestingSurface.class.getName()).log(Level.SEVERE,
                            null, ex);
                }
            }
        }
    }
}

public class HitTestingEx extends JFrame
{

    public HitTestingEx()
    {
        add(new HitTestingSurface());

        setTitle("Hit testing");
        setSize(250, 150);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args)
    {

        EventQueue.invokeLater(() -> {
            HitTestingEx ex = new HitTestingEx();
            ex.setVisible(true);
        });
    }
}