// Created at 2016/8/5 
// Author:	JiaweiMao
// Copyright (c) Dalian Institute of Chemical Physics
//      Chinese Academy of Sciences
// Contact: jiawei@dicp.ac.cn

package jgui.awt.draw;

import java.applet.Applet;
import java.awt.*;

/**
 * 传递给paint()等方法的Graphics引用仅在方法的执行过程中有效。一旦方法返回，引用将不再有效。
 * 想重用最初传递给 paint()的Graphics引用。直线将在第一次调用paint()时画出，但是对paint()的后续访问将
 * 导致直线在一个无效的Graphics内绘制，因此直线不再显示(通过调整窗口大小可以强行重绘该applet)
 *
 * @author JiaweiMao
 * @version 1.0.0
 * @date Aug 05 2016, 15:54
 */
public class HoldRef extends Applet {

    private Graphics oldg;
    private boolean first = true;

    public void paint(Graphics g) {
        if (first) {
            oldg = g;
            first = false;
        }
        oldg.drawLine(0, 0, getSize().width - 1, getSize().height - 1);
    }

}
