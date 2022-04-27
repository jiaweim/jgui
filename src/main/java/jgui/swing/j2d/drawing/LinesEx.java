package jgui.swing.j2d.drawing;

import javax.swing.*;
import java.awt.*;

class LineSurface extends JPanel {

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        // draw a straight line, the parameters of the method
        // are x,y coordinates of two points
        g2d.drawLine(30, 30, 200, 30);
        g2d.drawLine(200, 30, 30, 200);
        g2d.drawLine(30, 200, 200, 200);
        g2d.drawLine(200, 200, 30, 30);
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }
}

public class LinesEx extends JFrame {

    public LinesEx() {

        initUI();
    }

    private void initUI() {

        add(new LineSurface());

        setTitle("Lines");
        setSize(350, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            LinesEx ex = new LinesEx();
            ex.setVisible(true);
        });
    }
}