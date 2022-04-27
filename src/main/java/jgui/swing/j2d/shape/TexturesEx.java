package jgui.swing.j2d.shape;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A texture is a bitmap image applied to a shape. To work with textures in Java 2D,
 * we use the TexturePaint class. A texture is applied with the setPaint() method.
 *
 * In the code example, we fill three rectangles with three different textures.
 */
class TextureSurface extends JPanel {

    private BufferedImage slate;
    private BufferedImage java;
    private BufferedImage pane;
    private TexturePaint slatetp;
    private TexturePaint javatp;
    private TexturePaint panetp;

    public TextureSurface() {

        loadImages();
    }

    private void loadImages() {

        // use the ImageIO class, we read an image into a buffered image.
        try {
            slate = ImageIO.read(new File("j2d/slate.png"));
            java = ImageIO.read(new File("j2d/java.png"));
            pane = ImageIO.read(new File("j2d/pane.png"));

        } catch (IOException ex) {

            Logger.getLogger(TextureSurface.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
    }

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g.create();

        // create a TexturePaint class out of the buffered image.
        slatetp = new TexturePaint(slate, new Rectangle(0, 0, 90, 60));
        javatp = new TexturePaint(java, new Rectangle(0, 0, 90, 60));
        panetp = new TexturePaint(pane, new Rectangle(0, 0, 90, 60));

        // fill a rectangle with a texture.
        g2d.setPaint(slatetp);
        g2d.fillRect(10, 15, 90, 60);

        g2d.setPaint(javatp);
        g2d.fillRect(130, 15, 90, 60);

        g2d.setPaint(panetp);
        g2d.fillRect(250, 15, 90, 60);

        g2d.dispose();
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }
}

public class TexturesEx extends JFrame {

    public TexturesEx() {

        initUI();
    }

    private void initUI() {

        add(new TextureSurface());

        setTitle("Textures");
        setSize(360, 120);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        File file = new File(".");
        System.out.println(file.getAbsolutePath());

        EventQueue.invokeLater(() -> {
            TexturesEx ex = new TexturesEx();
            ex.setVisible(true);
        });
    }
}