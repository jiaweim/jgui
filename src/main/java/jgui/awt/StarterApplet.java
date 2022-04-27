// Created at 2016/8/5 
// Author:	JiaweiMao
// Copyright (c) Dalian Institute of Chemical Physics
//      Chinese Academy of Sciences
// Contact: jiawei@dicp.ac.cn

package jgui.awt;

import java.applet.Applet;
import java.awt.*;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @date Aug 05 2016, 14:35
 */
public class StarterApplet extends Applet{
    private Label label;

    public void init(){
        System.out.println("Applet::init()");
    }

    public void start(){
        System.out.println("Applet:start()");
        label = new Label("Starter");
        add(label);
    }

    public void stop(){
        System.out.println("Applet::stop()");
        remove(label);
    }

    public void destroy(){
        System.out.println("Applet::destroy()");
    }

}
