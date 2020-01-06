package trail.jgui.swing.color;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * in the example below, we will fade out an image. The image will gradually get more
 * transparent until it is completely invisible.
 */
class FadeOutSurface extends JPanel implements ActionListener {

    private Image img;
    private Timer timer;
    private float alpha = 1f;

    private final int DELAY = 40;
    private final int INITIAL_DELAY = 500;

    public FadeOutSurface() {

        loadImage();
        setSurfaceSize();
        initTimer();
    }

    private void loadImage() {

        img = new ImageIcon("j2d/mushrooms.jpg").getImage();
    }

    /**
     * finds out the size of the image and sets a preferred size for the panel.
     * The preferred size with the combination of the pack() method will
     * display the window just large enough to show the whole image.
     */
    private void setSurfaceSize() {

        int h = img.getHeight(this);
        int w = img.getWidth(this);
        setPreferredSize(new Dimension(w, h));
    }

    /**
     * The timer fires action events after the specified initial delay.
     * Successive action events are generated after between-event delay.
     * In reaction of an action event, we will change the alpha value and
     * repaint the panel.
     */
    private void initTimer() {

        timer = new Timer(DELAY, this);
        timer.setInitialDelay(INITIAL_DELAY);
        timer.start();
    }

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g.create();

        AlphaComposite acomp = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
        g2d.setComposite(acomp);
        g2d.drawImage(img, 0, 0, null);

        g2d.dispose();
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }

    private void step() {

        alpha += -0.01f;

        if (alpha <= 0) {

            alpha = 0;
            timer.stop();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        step();
        repaint();
    }
}

public class FadeOutEx extends JFrame {

    public FadeOutEx() {

        initUI();
    }

    private void initUI() {

        add(new FadeOutSurface());

        pack();

        setTitle("Fade out");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            FadeOutEx ex = new FadeOutEx();
            ex.setVisible(true);
        });
    }
}