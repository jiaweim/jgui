package trail.jgui.swing.j2d.text;

import javax.swing.*;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;

/**
 * In the last example, we show a rotated text on the panel. To rotate a text, we perform rotation and translation
 * operations. As we already stated, a glyph is a shape used to render a character. So in our code example, we need to
 * get all glyphs of our text, get their measurements, and manipulate them one by one.
 * <p>
 * We will work with several important classes. The FontRenderContext class is a container for the information needed to
 * correctly measure text. The GlyphVector object is a collection of glyphs containing geometric information for the
 * placement of each glyph in the transformed coordinate space.
 */
class RotatedTextSurface extends JPanel {

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g.create();

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // rotate this text, because the text is in Latin1 encoding, glyphs correspond to
        // characters in a one-to-one manner.
        String s = "ZetCode, tutorials for programmers";

        Font font = new Font("Courier", Font.PLAIN, 13);

        g2d.translate(20, 20);

        FontRenderContext frc = g2d.getFontRenderContext();

        // GryphVector is a collection of glyphs and their positions.
        GlyphVector gv = font.createGlyphVector(frc, s);
        // here we get the number of glyphs of our text. If we print the number of the console,
        // we get 34. so in our case, each character is one glyph
        int length = gv.getNumGlyphs();

        for (int i = 0; i < length; i++) {

            // as we iterate through the vector of glyphs, we calculate the glyph's position with
            // the getGlyphPosition() method
            Point2D p = gv.getGlyphPosition(i);
            // calculate the degree by which the glyph is going to be rotated
            double theta = (double) i / (double) (length - 1) * Math.PI / 3;
            // we do an affine rotate transnformation
            AffineTransform at = AffineTransform.getTranslateInstance(p.getX(), p.getY());
            at.rotate(theta);
            // the createTransformedShape() method returns a new Shape object modified by our affine transform operation
            Shape glyph = gv.getGlyphOutline(i);
            Shape transformedGlyph = at.createTransformedShape(glyph);
            g2d.fill(transformedGlyph);
        }

        g2d.dispose();
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }
}

public class RotatedTextEx extends JFrame {

    public RotatedTextEx() {

        initUI();
    }

    private void initUI() {

        add(new RotatedTextSurface());

        setTitle("Rotated text");
        setSize(450, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            RotatedTextEx ex = new RotatedTextEx();
            ex.setVisible(true);
        });
    }
}