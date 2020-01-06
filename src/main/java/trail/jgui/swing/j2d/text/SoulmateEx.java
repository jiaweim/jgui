package trail.jgui.swing.j2d.text;

import javax.swing.*;
import java.awt.*;

/*
 * In this example, we draw text on the panel. We choose a specific font type.
 */
class SoulmateSurface extends JPanel {

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        RenderingHints rh =
                new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        g2d.setRenderingHints(rh);

        // Here we set a Purisa font type.
        g2d.setFont(new Font("Purisa", Font.PLAIN, 13));

        g2d.drawString("Most relationships seem so transitory", 20, 30);
        g2d.drawString("They're all good but not the permanent one", 20, 60);
        g2d.drawString("Who doesn't long for someone to hold", 20, 90);
        g2d.drawString("Who knows how to love you without being told", 20, 120);
        g2d.drawString("Somebody tell me why I'm on my own", 20, 150);
        g2d.drawString("If there's a soulmate for everyone", 20, 180);
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }
}

public class SoulmateEx extends JFrame {

    public SoulmateEx() {

        initUI();
    }

    private void initUI() {

        setTitle("Soulmate");

        add(new SoulmateSurface());

        setSize(420, 250);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            SoulmateEx ex = new SoulmateEx();
            ex.setVisible(true);
        });
    }
}