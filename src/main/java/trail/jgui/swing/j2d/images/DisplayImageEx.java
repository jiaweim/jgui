package trail.jgui.swing.j2d.images;

import javax.swing.*;
import java.awt.*;

/**
 * display a image on the panel.
 */
class DesplayImageSurface extends JPanel {

    private Image mshi;

    public DesplayImageSurface() {

        loadImage();
        setSurfaceSize();
    }

    private void loadImage() {

        mshi = new ImageIcon("j2d/mushrooms.jpg").getImage();
    }

    /**
     * determined the size of the loaded image. with setPrederredSize() method,
     * we set the preferred size of the Surface panel. The pack() method of the JFrame
     * container will cause the frame to fit the size of its children. In our case the
     * Surface panel. As a consequence, the window will be sized to exactly display the
     * loaded image.
     */
    private void setSurfaceSize() {

        Dimension d = new Dimension();
        d.width = mshi.getWidth(null);
        d.height = mshi.getHeight(null);
        setPreferredSize(d);
    }

    /**
     * the image is drawn on the panel using the drawImage() method. The last
     * parameter is the ImageObserver class. It is sometimes used for asynchronous
     * loading. When we do not need asynchronous loading of our image, we can just
     * put null there.
     */
    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(mshi, 0, 0, null);
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }
}

public class DisplayImageEx extends JFrame {

    public DisplayImageEx() {

        initUI();
    }

    private void initUI() {

        add(new DesplayImageSurface());

        // size the containers to fit the size of the child panel.
        pack();

        setTitle("Mushrooms");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            DisplayImageEx ex = new DisplayImageEx();
            ex.setVisible(true);
        });
    }
}