package jgui.swing.j2d.transform;

import javax.swing.*;
import java.awt.*;

/**
 * draw a rectangle, performs a translation and a rotation and draws
 * the same rectangle again.
 */
class RotationSurface extends JPanel {

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g.create();

        g2d.setPaint(new Color(150, 150, 150));
        g2d.fillRect(20, 20, 80, 50);
        g2d.translate(180, -50);
        // perform rotation, the rotation parameter is in radians
        g2d.rotate(Math.PI / 4);
        g2d.fillRect(80, 80, 80, 50);

        g2d.dispose();
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }
}

public class RotationEx extends JFrame {

    public RotationEx() {

        initUI();
    }

    private void initUI() {

        setTitle("Rotation");

        add(new RotationSurface());

        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            RotationEx ex = new RotationEx();
            ex.setVisible(true);
        });
    }
}