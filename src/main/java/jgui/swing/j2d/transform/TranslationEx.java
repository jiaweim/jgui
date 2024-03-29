package jgui.swing.j2d.transform;

import javax.swing.*;
import java.awt.*;

/**
 * draw a rectangle, then we do a translation and draw the same rectangle again.
 */
class TranslationSurface extends JPanel {

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g.create();

        g2d.setPaint(new Color(150, 150, 150));
        g2d.fillRect(20, 20, 80, 50);
        // moves the origin of the Graphics2D context to a new point
        g2d.translate(150, 50);
        g2d.fillRect(20, 20, 80, 50);

        g2d.dispose();
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }
}

public class TranslationEx extends JFrame {

    public TranslationEx() {

        initUI();
    }

    private void initUI() {

        add(new TranslationSurface());

        setTitle("Translation");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            TranslationEx ex = new TranslationEx();
            ex.setVisible(true);
        });
    }
}