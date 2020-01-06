package trail.jgui.awt;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;

public class ZoomImage
{
    public void zoom(String file1, String file2)
    {
        try {
            File _file = new File(file1);
            Image src = javax.imageio.ImageIO.read(_file);
            int width = src.getWidth(null);
            int height = src.getHeight(null);

            BufferedImage tag = new BufferedImage(width / 2, height / 2, BufferedImage.TYPE_INT_RGB);
            tag.getGraphics().drawImage(src, 0, 0, width / 2, height / 2, null);

            FileOutputStream out = new FileOutputStream(file2);
//			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
//			encoder.encode(tag);
            out.close();

        } catch (Exception e) {

        }
    }

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        String file1 = "C:\\Users\\admin08\\Pictures\\WallPaper\\23.jpg";
        String file2 = "C:\\Users\\admin08\\Pictures\\WallPaper\\23test.jpg";
        new ZoomImage().zoom(file1, file2);
    }

}
