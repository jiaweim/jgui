package trail.jgui.swing.renderer;
import java.awt.*;
import javax.swing.*;

/**
 * @author Romain Guy
 */
public class SafeRepaint extends JFrame {
    private SafeComponent safeComponent;

    public SafeRepaint() {
        super("Safe Repaint");

        safeComponent = new SafeComponent();
        add(safeComponent);

        pack();
        setLocationRelativeTo(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    safeComponent.repaint();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                }
            }
        }).start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                SafeRepaint repaint = new SafeRepaint();
                repaint.setVisible(true);
            }
        });
    }
}