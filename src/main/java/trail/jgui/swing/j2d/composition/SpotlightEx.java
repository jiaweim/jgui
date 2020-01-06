package trail.jgui.swing.j2d.composition;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

/**
 * A Spot light is a strong beam of light that illuminates only a small area, used espically to center attention on a
 * stage performer.
 * <p>
 * The spotlight effect is created with the composition rules and the alpha transparency value. It is also important to
 * note that our image has a transparent background.
 */
class SpotlightSurface extends JPanel {

    private final int RADIUS = 50;
    private Image image;
    private int iw;
    private int ih;
    private int x;
    private int y;
    private boolean mouseIn;

    public SpotlightSurface() {

        initUI();
    }

    private void initUI() {

        loadImage();

        iw = image.getWidth(null);
        ih = image.getHeight(null);

        addMouseMotionListener(new MyMouseAdapter());
        addMouseListener(new MyMouseAdapter());
    }

    private void loadImage() {

        image = new ImageIcon("j2d/penguin.png").getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g.create();

        int midX = (getWidth() - iw) / 2;
        int midY = (getHeight() - ih) / 2;

        // A BufferedImage is created, its dimension is equal to the dimension of the
        // panel. our PNG file has a transparent background; therefore, we use the
        // BufferedImage.TYPE_INT_ARGB image type
        BufferedImage bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D bigr = bi.createGraphics();

        if (mouseIn) {
            bigr.setPaint(Color.white);
            bigr.fillOval(x - RADIUS, y - RADIUS, RADIUS * 2, RADIUS * 2);
            // the AlphaComposite.SrcAtop rule is used to paint a fully opaque circle around the
            // mouse pointer if a mouse is in the panel's area
            bigr.setComposite(AlphaComposite.SrcAtop);
            bigr.drawImage(image, midX, midY, iw, ih, this);
        }

        // paint the rest of the image. The alphaComposite.SrcOver rule is used
        // to create a highly transparent image, which is blended with its background
        bigr.setComposite(AlphaComposite.SrcOver.derive(0.1f));
        // the buffered image is painted over the whole area of the panel
        bigr.drawImage(image, midX, midY, iw, ih, this);
        bigr.dispose();

        g2d.drawImage(bi, 0, 0, getWidth(), getHeight(), this);

        g2d.dispose();
    }

    private class MyMouseAdapter extends MouseAdapter {

        @Override
        public void mouseExited(MouseEvent e) {
            mouseIn = false;
            repaint();
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            mouseIn = true;
        }

        @Override
        public void mouseMoved(MouseEvent e) {

            x = e.getX();
            y = e.getY();

            repaint();
        }
    }
}

public class SpotlightEx extends JFrame {

    public SpotlightEx() {

        initUI();
    }

    private void initUI() {

        add(new SpotlightSurface());

        setSize(350, 300);
        setTitle("Spotlight");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            SpotlightEx ex = new SpotlightEx();
            ex.setVisible(true);
        });
    }
}