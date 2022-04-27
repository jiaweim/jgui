package jgui.swing.j2d.shape;

import javax.swing.*;
import java.awt.*;

/**
 * <code>color</code> class is used to work with colors in Java 2D. To fill
 * rectangles with the current color, we use fillRect() method.
 */
class ColorSurface extends JPanel {

    public void doDrawing(Graphics g) {

        // there is no need to create a copy of Graphics2D class or to reset the
        // value when we change the color property of the graphics context.
        Graphics2D g2d = (Graphics2D) g;

        // below we draw nine colored rectangles

        // a new color is created with the Color class. The parameters of the constructor
        // are red, green, and blue parts of the new color.
        // the setColor() method sets the graphics context's current color to the specified
        // color value. All subsequence graphics operations use this color value.
        g2d.setColor(new Color(125, 167, 116));
        // to fill the rectangle with a color, we use fillRect() method.
        g2d.fillRect(10, 10, 90, 60);

        g2d.setColor(new Color(42, 179, 231));
        g2d.fillRect(130, 10, 90, 60);

        g2d.setColor(new Color(70, 67, 123));
        g2d.fillRect(250, 10, 90, 60);

        g2d.setColor(new Color(130, 100, 84));
        g2d.fillRect(10, 100, 90, 60);

        g2d.setColor(new Color(252, 211, 61));
        g2d.fillRect(130, 100, 90, 60);

        g2d.setColor(new Color(241, 98, 69));
        g2d.fillRect(250, 100, 90, 60);

        g2d.setColor(new Color(217, 146, 54));
        g2d.fillRect(10, 190, 90, 60);

        g2d.setColor(new Color(63, 121, 186));
        g2d.fillRect(130, 190, 90, 60);

        g2d.setColor(new Color(31, 21, 1));
        g2d.fillRect(250, 190, 90, 60);
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }
}

public class ColoursEx extends JFrame {

    public ColoursEx() {

        initUI();
    }

    private void initUI() {

        add(new ColorSurface());

        setTitle("Colours");
        setSize(360, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            ColoursEx ex = new ColoursEx();
            ex.setVisible(true);
        });
    }
}