package trail.jgui.swing.j2d.text;

import javax.swing.*;
import java.awt.*;
import java.awt.font.TextLayout;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;

/**
 * In the next example, we create a shadowed text. The effect is created by drawing the same text two times. One text
 * serves as the main text, the other one as a shadow. The shadowed text is moved a bit, colored in light gray, and
 * blurred.
 * This time we do not draw in the paintComponent() method; instead we paint into buffered images.
 */
public class ShadowedTextEx extends JFrame {

    private final int width = 490;
    private final int height = 150;

    private final String text = "Disciplin ist macht";
    private TextLayout textLayout;

    public ShadowedTextEx() {

        initUI();
    }

    private void initUI() {

        setTitle("Shadowed Text");

        BufferedImage image = createImage();
        add(new JLabel(new ImageIcon(image)));

        setSize(490, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void setRenderingHints(Graphics2D g) {

        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
    }

    private BufferedImage createImage() {

        int x = 10;
        int y = 100;

        // choose italic Georgia, of 50 points size
        Font font = new Font("Georgia", Font.ITALIC, 50);

        // create the first buffered image.
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g1d = image.createGraphics();
        setRenderingHints(g1d);

        // TextLayout is an immutable graphical representation of styled character data.
        // It is used for advanced manipulation with the text and font
        textLayout = new TextLayout(text, font, g1d.getFontRenderContext());
        g1d.setPaint(Color.WHITE);
        g1d.fillRect(0, 0, width, height);

        g1d.setPaint(new Color(150, 150, 150));
        // the draw() method renders this TextLayout at the specified location in the specified
        // Graphics2D context. The second and the third parameter specify the coordinates of the
        // origin of the TextLayout.
        textLayout.draw(g1d, x + 3, y + 3);
        g1d.dispose();

        // create the blur effect. The effect is used for the shadow text
        float[] kernel = {
                1f / 9f, 1f / 9f, 1f / 9f,
                1f / 9f, 1f / 9f, 1f / 9f,
                1f / 9f, 1f / 9f, 1f / 9f
        };

        ConvolveOp op = new ConvolveOp(new Kernel(3, 3, kernel), ConvolveOp.EDGE_NO_OP, null);
        // apply the blur effect on the first image and copy the outcome to the second buffered image.
        BufferedImage image2 = op.filter(image, null);

        Graphics2D g2d = image2.createGraphics();
        setRenderingHints(g2d);
        g2d.setPaint(Color.BLACK);
        textLayout.draw(g2d, x, y);

        g2d.dispose();

        return image2;
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            ShadowedTextEx ex = new ShadowedTextEx();
            ex.setVisible(true);
        });
    }
}