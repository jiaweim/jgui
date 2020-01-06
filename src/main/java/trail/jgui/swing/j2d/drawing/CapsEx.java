package trail.jgui.swing.j2d.drawing;

import javax.swing.*;
import java.awt.*;

/**
 * Caps are decorations applied to the ends of unclosed subpaths and dash
 * segments. There are three different end caps in Java2D:
 * <ul>
 * <li>CAP_BUTT - ends unclosed subpaths and dash segments with no added decoration.</li>
 * <li>CAP_ROUND - ends unclosed subpaths and dash segments with a round decoration that has
 * a radius equals to half of the width of the pen.</li>
 * <li>CAP_SQUARE - ends unclused subpaths and dash segments with a square projection that
 * extends beyond the end of the segment of a distance equal to half of the line width</li>
 * </ul>
 */
class CapsSurface extends JPanel {

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g.create();

        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        g2d.setRenderingHints(rh);

        // below we show all three types of end caps
        BasicStroke bs1 = new BasicStroke(8, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);
        g2d.setStroke(bs1);
        g2d.drawLine(20, 30, 250, 30);

        BasicStroke bs2 = new BasicStroke(8, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);
        g2d.setStroke(bs2);
        g2d.drawLine(20, 80, 250, 80);

        BasicStroke bs3 = new BasicStroke(8, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL);
        g2d.setStroke(bs3);
        g2d.drawLine(20, 130, 250, 130);

        BasicStroke bs4 = new BasicStroke();
        g2d.setStroke(bs4);

        g2d.drawLine(20, 20, 20, 140);
        g2d.drawLine(250, 20, 250, 140);
        g2d.drawLine(254, 20, 254, 140);

        g2d.dispose();
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }
}

public class CapsEx extends JFrame {

    public CapsEx() {

        initUI();
    }

    private void initUI() {

        add(new CapsSurface());

        setTitle("Caps");
        setSize(280, 270);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            CapsEx ex = new CapsEx();
            ex.setVisible(true);
        });
    }
}