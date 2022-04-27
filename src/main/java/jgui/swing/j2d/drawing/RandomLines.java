// Created at 2016/8/5 
// Author:	JiaweiMao
// Copyright (c) Dalian Institute of Chemical Physics
//      Chinese Academy of Sciences
// Contact: jiawei@dicp.ac.cn

package jgui.swing.j2d.drawing;

import java.applet.Applet;
import java.awt.*;

/**
 * 随机绘制直线
 * @author JiaweiMao
 * @version 1.0.0
 * @date Aug 05 2016, 16:16
 */
public class RandomLines extends Applet {

    private static Color[] colors = {Color.WHITE, Color.BLACK, Color.BLUE, Color.RED, Color.YELLOW, Color.ORANGE,
            Color.CYAN, Color.PINK, Color.MAGENTA, Color.GREEN};

    public void init() {
        Button button = new Button("scatter");
        add(button);
        button.addActionListener(e -> repaint());
    }

    public void paint(Graphics g) {
        for (int i = 0; i < 500; i++) {
            int x = (int) (Math.random() * 100);
            int y = (int) (Math.random() * 100);
            int deltax = (int) (Math.random() * 100);
            int deltay = (int) (Math.random() * 100);

            g.setColor(colors[(int) (Math.random() * 10)]);
            g.drawLine(x, y, x + deltax, y + deltay);
        }
    }
}
