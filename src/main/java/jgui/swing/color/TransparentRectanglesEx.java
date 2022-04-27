package jgui.swing.color;

import javax.swing.*;
import java.awt.*;

/**
 * draw 10 blue rectangle with various levels of transparency applied
 */
class TransparentSurface extends JPanel {

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g.create();

        g2d.setPaint(Color.blue);

        // the alpha value dynamically changes in the for loop
        for (int i = 1; i <= 10; i++) {

            float alpha = i * 0.1f;
            // create AlphaComposite with the specified rule and alpha value
            AlphaComposite alcom = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
            // setComposite() method sets the composite attribute for the Graphics2D
            g2d.setComposite(alcom);
            g2d.fillRect(50 * i, 20, 40, 40);
        }

        g2d.dispose();
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }
}

public class TransparentRectanglesEx extends JFrame {

    public TransparentRectanglesEx() {

        initUI();
    }

    private void initUI() {

        add(new TransparentSurface());

        setTitle("Transparent rectangles");
        setSize(590, 120);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            TransparentRectanglesEx ex = new TransparentRectanglesEx();
            ex.setVisible(true);
        });
    }
}