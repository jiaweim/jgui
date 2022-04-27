package jgui.swing.j2d.images;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The next code example blurs an image. A blur means an unfocused image. To blur an image, we use a convolution
 * operation. It is a mathematical operation which is also used in edge detection or noise elimination. Blur operations
 * can be used in various graphical effects. For example creating speed illusion or showing an unfocused vision of a
 * human.
 * <p>
 * The blur filter operation replaces each pixel in image with an average of the pixel and its neighbours. Convolutions
 * are per-pixel operations. The same arithmetic is repeated for every pixel in the image. A kernel can be thought of as
 * a two-dimensional grid of numbers that passes over each pixel of an image in sequence, performing calculations along
 * the way. Since images can also be thought of as two-dimensional grids of numbers, applying a kernel to an image can
 * be visualized as a small grid (the kernel) moving across a substantially larger grid (the image).
 */
class BlurredImageSurface extends JPanel {

    private BufferedImage mshi;
    private BufferedImage bluri;

    public BlurredImageSurface() {

        loadImage();
        createBlurredImage();
        setSurfaceSize();
    }

    private void loadImage() {

        try {
            // read an image from the disk and returns a BufferedImage
            mshi = ImageIO.read(new File("j2d/mushrooms.jpg"));
        } catch (IOException ex) {

            Logger.getLogger(BlurredImageSurface.class.getName()).log(
                    Level.WARNING, null, ex);
        }
    }

    private void createBlurredImage() {
        // this matrix is called a kernel. The values are weights that are applied to the
        // neighbouring values of the pixel being changed.
        float[] blurKernel = {
                1 / 9f, 1 / 9f, 1 / 9f,
                1 / 9f, 1 / 9f, 1 / 9f,
                1 / 9f, 1 / 9f, 1 / 9f
        };

        // apply the blur filter on the image
        BufferedImageOp blur = new ConvolveOp(new Kernel(3, 3, blurKernel));
        bluri = blur.filter(mshi, new BufferedImage(mshi.getWidth(), mshi.getHeight(), mshi.getType()));
    }

    private void setSurfaceSize() {

        Dimension d = new Dimension();
        d.width = mshi.getWidth(null);
        d.height = mshi.getHeight(null);
        setPreferredSize(d);
    }

    /**
     * the blurred image is drawn on the window.
     */
    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(bluri, null, 0, 0);
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }
}

public class BlurredImageEx extends JFrame {

    public BlurredImageEx() {

        setTitle("Blurred image");
        add(new BlurredImageSurface());

        pack();

        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            BlurredImageEx ex = new BlurredImageEx();
            ex.setVisible(true);
        });
    }
}