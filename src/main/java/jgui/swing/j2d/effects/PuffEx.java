package jgui.swing.j2d.effects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Next we show a puff effect. This effect is common in flash animations or film introductions.
 * Text grows gradually on the screen and after some time it slowly disappears.
 *
 * The example draws a growing text on the window and from some point,
 * the text becomes more and more transparent, until it is invisible.
 */
class PuffSurface extends JPanel implements ActionListener {

    private Timer timer;
    private int x = 1;
    private float alpha = 1;
    private final int DELAY = 15;
    private final int INITIAL_DELAY = 200;

    public PuffSurface() {

        initTimer();
    }

    private void initTimer() {

        timer = new Timer(DELAY, this);
        timer.setInitialDelay(INITIAL_DELAY);
        timer.start();
    }

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g.create();

        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
        rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        g2d.setRenderingHints(rh);

        // the font used for text
        Font font = new Font("Dialog", Font.PLAIN, x);
        g2d.setFont(font);

        // this class stores information about the rendering of a particular
        // font on a particular screen.
        FontMetrics fm = g2d.getFontMetrics();
        String s = "ZetCode";
        Dimension size = getSize();

        int w = (int) size.getWidth();
        int h = (int) size.getHeight();

        // get width of the string
        int stringWidth = fm.stringWidth(s);
        // set the transparency of the text being drawn
        AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
        g2d.setComposite(ac);

        // draw string in the (horizontal) middle of the window
        g2d.drawString(s, (w - stringWidth) / 2, h / 2);

        g2d.dispose();
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }

    private void step() {

        x += 1;

        // after the string is higher than 40 points, it begins fading
        if (x > 40)
            alpha -= 0.01;

        if (alpha <= 0.01)
            timer.stop();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        step();
        repaint();
    }
}

public class PuffEx extends JFrame {

    public PuffEx() {

        initUI();
    }

    private void initUI() {

        setTitle("Puff");

        add(new PuffSurface());

        setSize(400, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            PuffEx ex = new PuffEx();
            ex.setVisible(true);
        });
    }
}