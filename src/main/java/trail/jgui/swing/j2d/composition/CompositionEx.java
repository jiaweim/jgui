package trail.jgui.swing.j2d.composition;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * There are several compositing operations. We show some of them in the next code example.
 * The AlphaComposite class implements basic alpha compositing rules for combining source
 * and destination colours to achieve blending and transparency effects with graphics and images.
 * <p>
 * Say we want to draw two objects on a panel. The first object drawn is called a destination,
 * the second one a source.
 * The AlphaComposite class determines how these two objects are going to be blended together.
 * If we have a AlphaComposite.SRC_OVER rule, the pixels of the source object will be drawn
 * where the two objects overlap.
 */
class CompositionSurface extends JPanel {
    /**
     * we draw two rectangles and combine them with six different compositing operations.
     * here we have six different compositing rules.
     */
    private final int rules[] = {
            AlphaComposite.DST,
            AlphaComposite.DST_ATOP,
            AlphaComposite.DST_OUT,
            AlphaComposite.SRC,
            AlphaComposite.SRC_ATOP,
            AlphaComposite.SRC_OUT
    };

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g.create();

        for (int x = 20, y = 20, i = 0; i < rules.length; x += 60, i++) {
            // we get the AlphaComposite class with given rule
            AlphaComposite ac = AlphaComposite.getInstance(rules[i], 0.8f);

            // we use buffer image to perform the compositing operations.
            BufferedImage buffImg = new BufferedImage(60, 60, BufferedImage.TYPE_INT_ARGB);
            Graphics2D gbi = buffImg.createGraphics();

            gbi.setPaint(Color.blue);
            gbi.fillRect(0, 0, 40, 40);
            // set the composite for the Graphics2D context
            gbi.setComposite(ac);

            gbi.setPaint(Color.green);
            gbi.fillRect(5, 5, 40, 40);

            // the buffered image is drawn on the panel using the drawImage() method
            g2d.drawImage(buffImg, x, y, null);
            // the created graphics object must be disposed.
            gbi.dispose();
        }

        g2d.dispose();
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }
}

public class CompositionEx extends JFrame {

    public CompositionEx() {

        add(new CompositionSurface());

        setTitle("Composition");
        setSize(400, 120);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            CompositionEx ex = new CompositionEx();
            ex.setVisible(true);
        });
    }
}