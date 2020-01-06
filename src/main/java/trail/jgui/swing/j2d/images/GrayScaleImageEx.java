package trail.jgui.swing.j2d.images;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * In computing, a grayscale digital image is an image in which the value of each pixel is a single sample, that is, it
 * carries the full (and only) information about its intensity. Images of this sort are composed exclusively of shades
 * of neutral gray, varying from black at the weakest intensity to white at the strongest.
 */
class GrayScaleImageSurface extends JPanel {

    private Image mshi;
    private BufferedImage bufimg;
    private Dimension d;

    public GrayScaleImageSurface() {

        loadImage();
        determineAndSetSize();
        createGrayImage();
    }

    private void determineAndSetSize() {

        d = new Dimension();
        d.width = mshi.getWidth(null);
        d.height = mshi.getHeight(null);
        setPreferredSize(d);
    }

    private void createGrayImage() {
        // there are several ways to create a grayscale image. We do it by writing image
        // data into buffered image of BufferedImage.TYPE_BYTE_GRAY
        bufimg = new BufferedImage(d.width, d.height, BufferedImage.TYPE_BYTE_GRAY);

        // draw the mushrooms image into the buffered image.
        Graphics2D g2d = bufimg.createGraphics();
        g2d.drawImage(mshi, 0, 0, null);

        // Graphics objects created with createGraphics() method should be manully released.
        // Graphics objects which are provided as arguments to the paint() and update()
        // method of components are automatically released by the system when those methods return.
        g2d.dispose();
    }

    private void loadImage() {

        mshi = new ImageIcon("j2d/mushrooms.jpg").getImage();
    }

    // buffered image is drawn on the panel
    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(bufimg, null, 0, 0);
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }
}

public class GrayScaleImageEx extends JFrame {

    public GrayScaleImageEx() {

        initUI();
    }

    private void initUI() {

        GrayScaleImageSurface dpnl = new GrayScaleImageSurface();
        add(dpnl);

        pack();

        setTitle("GrayScale image");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            GrayScaleImageEx ex = new GrayScaleImageEx();
            ex.setVisible(true);
        });
    }
}