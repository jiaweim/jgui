/**********
 * File:Color_Index_1.java
 * Author: Jiawei Mao
 *	Created on 2014��5��8��
 * Copyright (c) Dalian Institute of Chemical Physics
 *	Chinese Academy of Sciences
 * Contact: jiawei@dicp.ac.cn
 */
package trail.jgui.awt.color;

import java.applet.Applet;
import java.awt.*;
import java.awt.image.IndexColorModel;
import java.awt.image.MemoryImageSource;

/**
 * @author JiaweiMao
 */
public class Color_Index_1 extends Applet
{
    Color[] colors = {Color.RED, Color.YELLOW, Color.BLUE, Color.CYAN,
            Color.WHITE, Color.GREEN, Color.MAGENTA, Color.ORANGE};
    byte[] reds = {(byte) colors[0].getRed(), (byte) colors[1].getRed(),
            (byte) colors[2].getRed(), (byte) colors[3].getRed(),
            (byte) colors[4].getRed(), (byte) colors[5].getRed(),
            (byte) colors[6].getRed(), (byte) colors[7].getRed()};
    byte[] greens = {(byte) colors[0].getGreen(), (byte) colors[1].getGreen(),
            (byte) colors[2].getGreen(), (byte) colors[3].getGreen(),
            (byte) colors[4].getGreen(), (byte) colors[5].getGreen(),
            (byte) colors[6].getGreen(), (byte) colors[7].getGreen(),};
    byte[] blues = {(byte) colors[0].getBlue(), (byte) colors[1].getBlue(),
            (byte) colors[2].getBlue(), (byte) colors[3].getBlue(),
            (byte) colors[4].getBlue(), (byte) colors[5].getBlue(),
            (byte) colors[6].getBlue(), (byte) colors[7].getBlue(),};
    IndexColorModel icm = new IndexColorModel(8, 8, reds, greens, blues);
    Image image;

    public void init()
    {
        int[] imageBits = new int[]{
                0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7,
                0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7,
                0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7,
                0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7,
                0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7,
                0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7,
                0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7,
                0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7,
                0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7,
                0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7,};
        MemoryImageSource mis = new MemoryImageSource(24, 10, icm, imageBits, 0, 24);
        image = createImage(mis);
    }

    public void paint(Graphics g)
    {
        g.drawImage(image, 0, 0, 240, 200, this);
    }
}
