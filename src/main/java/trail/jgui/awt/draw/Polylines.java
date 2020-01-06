// Created at 2016/8/5 
// Author:	JiaweiMao
// Copyright (c) Dalian Institute of Chemical Physics
//      Chinese Academy of Sciences
// Contact: jiawei@dicp.ac.cn

package trail.jgui.awt.draw;

import java.applet.Applet;
import java.awt.*;

/**
 * 使用 drawPolyline绘制折线
 *
 * @author JiaweiMao
 * @version 1.0.0
 * @date Aug 05 2016, 16:24
 */
public class Polylines extends Applet {

    private static Color[] colors = {Color.WHITE, Color.BLACK, Color.BLUE, Color.RED, Color.YELLOW, Color.ORANGE,
            Color.CYAN, Color.PINK, Color.MAGENTA, Color.GREEN};

    public void init() {
        Button button = new Button("repaint");
        add(button);
        button.addActionListener(e -> repaint());
    }

    public void paint(Graphics g) {
        int arraySize = (int) (Math.random() * 100);
        int[] xPoints = new int[arraySize];
        int[] yPoints = new int[arraySize];
        for (int i = 0; i < xPoints.length; ++i) {
            xPoints[i] = (int) (Math.random() * 200);
            yPoints[i] = (int) (Math.random() * 200);
        }
        g.setColor(colors[(int) (Math.random() * 10)]);
        g.drawPolygon(xPoints, yPoints, xPoints.length);
        showStatus(arraySize + " points");
    }
}
