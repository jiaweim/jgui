package trail.jgui.swing.j2d.transform;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

/**
 * In this example, we draw three rectangles in three different colors.
 * They form a structure. Two of them are sheared.
 */
class ShearingSurface extends JPanel {

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g.create();

        AffineTransform tx1 = new AffineTransform();
        tx1.translate(50, 90);

        g2d.setTransform(tx1);
        g2d.setPaint(Color.green);
        g2d.drawRect(0, 0, 160, 50);

        AffineTransform tx2 = new AffineTransform();
        tx2.translate(50, 90);
        // the two parameters are multipliers by which coordinates are shifted in the
        // direction of the x and y axis
        tx2.shear(0, 1);

        g2d.setTransform(tx2);
        g2d.setPaint(Color.blue);

        g2d.draw(new Rectangle(0, 0, 80, 50));

        AffineTransform tx3 = new AffineTransform();
        tx3.translate(130, 10);
        tx3.shear(0, 1);

        g2d.setTransform(tx3);
        g2d.setPaint(Color.red);
        g2d.drawRect(0, 0, 80, 50);

        g2d.dispose();
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }
}

public class ShearingEx extends JFrame {

    public ShearingEx() {

        initUI();
    }

    private void initUI() {

        add(new ShearingSurface());

        setTitle("Shearing");
        setSize(330, 270);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            ShearingEx ex = new ShearingEx();
            ex.setVisible(true);
        });
    }
}