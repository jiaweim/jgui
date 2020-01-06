package trail.jgui.swing.color;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * In this example, we use transparency effect to create a waiting demo. We draw
 * 8 lines that gradually fade out creating an illusion that a line is moving. Such
 * effects are used to inform uses that a lengthy task is going on behind the scenes.
 */
class WaitingSurface extends JPanel implements ActionListener {

    private Timer timer;
    private int count;
    private final int INITIAL_DELAY = 200;
    private final int DELAY = 80;
    private final int NUMBER_OF_LINES = 8;
    private final int STROKE_WIDTH = 3;

    // two dimensional array of transparency values used in this demo.
    // there are 8 rows, each for one state. Each of the 8 lines will continuously use
    // these values.
    private final double[][] trs = {
            {0.0, 0.15, 0.30, 0.5, 0.65, 0.80, 0.9, 1.0},
            {1.0, 0.0, 0.15, 0.30, 0.5, 0.65, 0.8, 0.9},
            {0.9, 1.0, 0.0, 0.15, 0.3, 0.5, 0.65, 0.8},
            {0.8, 0.9, 1.0, 0.0, 0.15, 0.3, 0.5, 0.65},
            {0.65, 0.8, 0.9, 1.0, 0.0, 0.15, 0.3, 0.5},
            {0.5, 0.65, 0.8, 0.9, 1.0, 0.0, 0.15, 0.3},
            {0.3, 0.5, 0.65, 0.8, 0.9, 1.0, 0.0, 0.15},
            {0.15, 0.3, 0.5, 0.65, 0.8, 0.9, 1.0, 0.0}
    };

    public WaitingSurface() {

        initTimer();
    }

    private void initTimer() {

        timer = new Timer(DELAY, this);
        timer.setInitialDelay(INITIAL_DELAY);
        timer.start();
    }

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g.create();

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        int width = getWidth();
        int height = getHeight();

        // make the lines a bit thicker so that they are better visible. we draw the lines with
        // rounded caps.
        g2d.setStroke(new BasicStroke(STROKE_WIDTH, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g2d.translate(width / 2, height / 2);

        // we draw eight lines with different alpha values.
        for (int i = 0; i < NUMBER_OF_LINES; i++) {

            float alpha = (float) trs[count % NUMBER_OF_LINES][i];
            AlphaComposite acomp = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
            g2d.setComposite(acomp);

            // rotate() method is used to rotate the lines alongside a circle.
            g2d.rotate(Math.PI / 4f);
            g2d.drawLine(0, -10, 0, -40);
        }

        g2d.dispose();
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        repaint();
        count++;
    }
}

public class WaitingEx extends JFrame {

    public WaitingEx() {

        initUI();
    }

    private void initUI() {

        add(new WaitingSurface());

        setTitle("Waiting");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            WaitingEx ex = new WaitingEx();
            ex.setVisible(true);
        });
    }
}