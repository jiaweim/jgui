package jgui.swing.renderer;
import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;
import javax.imageio.ImageIO;

// Final result is a list of Image
// Intermediate result is a message as a String
public class ImageLoadingWorker extends SwingWorker<List<Image>, String> {
  private JTextArea log;
  private JPanel viewer;
  private String[] filenames;

  public ImageLoadingWorker(JTextArea log, JPanel viewer, String... filenames) {
    this.log = log;
    this.viewer = viewer;
    this.filenames = filenames;
  }

  // In the EDT
  @Override
  protected void done() {
    try {
      for (Image image : get()) {
        viewer.add(new JLabel(new ImageIcon(image)));
        viewer.revalidate();
      }
    } catch (Exception e) { }
  }

  // In the EDT
  @Override
  protected void process(List<String> messages) {
    for (String message : messages) {
      log.append(message);
      log.append("\n");
    }
  }

  // In a thread
  /**
   * ͨ��ִ��SwingWorker��execute������Ȼ�����doInBackground�����������filenames��Ӧ��Image���м��أ����Ӱ�
   * ÿһ��ͼ����ص�ͬʱ��publish����������Ӧ��Ϣ�������Ϣ�ᷢ�͵�process�����н��д�����Ȼǰ������Ҫ��дprocess���������
   * �Ա�֤�������Ҫ����ʾ��
   */
  @Override
  public List<Image> doInBackground() {
    List<Image> images = new ArrayList<Image>();
    for (String filename : filenames) {
      try {
        images.add(ImageIO.read(new File(filename)));
        publish("Loaded " + filename);
      } catch (IOException ioe) {
        publish("Error loading " + filename);
      }
    }
    return images;
  }  
}
