package jgui.swing.j2d;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;

/**
 * Clipping an image to a circle shape.
 * A circle is moving on the screen and showing a part of the
 * underlying image. This is as if we looked through a hole.
 */
class ClippingSurface extends JPanel implements ActionListener
{
    private int pos_x = 8;
    private int pos_y = 8;
    private final int RADIUS = 90;
    private final int DELAY = 35;

    private Timer timer;
    private Image image;

    private final double delta[] = {3, 3};

    public ClippingSurface()
    {

        loadImage();
        determineAndSetImageSize();
        initTimer();
    }

    private void loadImage()
    {

        image = new ImageIcon("j2d/mushrooms.jpg").getImage();
    }

    private void determineAndSetImageSize()
    {

        int h = image.getHeight(this);
        int w = image.getWidth(this);
        setPreferredSize(new Dimension(w, h));
    }

    private void initTimer()
    {

        timer = new Timer(DELAY, this);
        timer.start();
    }

    private void doDrawing(Graphics g)
    {
        // create a copy of the Graphics2D. thus changing the clip will not
        // affect other swing parts where the Graphics2D object is reused.
        Graphics2D g2d = (Graphics2D) g.create();
        // clip() method combines the existing clip with the shape given as an
        // argument. The resulting intersection is set to be the clip.
        g2d.clip(new Ellipse2D.Double(pos_x, pos_y, RADIUS, RADIUS));
        g2d.drawImage(image, 0, 0, null);

        g2d.dispose();
    }

    @Override
    public void paintComponent(Graphics g)
    {

        super.paintComponent(g);
        doDrawing(g);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {

        moveCircle();
        repaint();
    }

    private void moveCircle()
    {

        int w = getWidth();
        int h = getHeight();

        // if the circle hits the left or the right side of the window, the direction of the
        // circle movement changes randomly. Same applies for the top and bottom sides.
        if (pos_x < 0) {

            delta[0] = Math.random() % 4 + 5;
        } else if (pos_x > w - RADIUS) {

            delta[0] = -(Math.random() % 4 + 5);
        }

        if (pos_y < 0) {

            delta[1] = Math.random() % 4 + 5;
        } else if (pos_y > h - RADIUS) {

            delta[1] = -(Math.random() % 4 + 5);
        }

        pos_x += delta[0];
        pos_y += delta[1];
    }
}

public class ClippingEx extends JFrame
{

    public ClippingEx()
    {

        initUI();
    }

    private void initUI()
    {

        setTitle("Clipping");

        add(new ClippingSurface());

        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args)
    {

        EventQueue.invokeLater(() -> {
            ClippingEx cl = new ClippingEx();
            cl.setVisible(true);
        });
    }
}