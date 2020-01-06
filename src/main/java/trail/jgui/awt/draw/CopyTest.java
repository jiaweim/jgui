// Created at 2016/8/5 
// Author:	JiaweiMao
// Copyright (c) Dalian Institute of Chemical Physics
//      Chinese Academy of Sciences
// Contact: jiawei@dicp.ac.cn

package trail.jgui.awt.draw;

import java.applet.Applet;
import java.awt.*;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @date Aug 05 2016, 15:36
 */
public class CopyTest extends Applet {

    public void paint(Graphics g) {
        setForeground(Color.YELLOW);
        Graphics graphics = getGraphics();
        System.out.println("g="+g.getColor()+"copy="+graphics.getColor());
        g.drawLine(0, 0, getSize().width - 1, getSize().height - 1);
        graphics.dispose();
        setPreferredSize(new Dimension(500, 400));
        setVisible(true);
    }
}
