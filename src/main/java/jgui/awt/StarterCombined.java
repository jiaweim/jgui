// Created at 2016/8/5 
// Author:	JiaweiMao
// Copyright (c) Dalian Institute of Chemical Physics
//      Chinese Academy of Sciences
// Contact: jiawei@dicp.ac.cn

package jgui.awt;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @date Aug 05 2016, 14:11
 */
public class StarterCombined extends Applet{

    private Label label;

    public void init(){
        System.out.println("Applet:: init()");
    }

    public void start(){
        System.out.println("Applet::start()");
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

    public static void main(String[] args) {

        StarterCombinedFrame frame = new StarterCombinedFrame("Starter application");
        frame.setSize(300, 100);
        frame.setVisible(true);
        System.out.println("StarterCombined frame::main()");

        StarterCombined app = new StarterCombined();
    }
}

class StarterCombinedFrame extends Frame{

    public StarterCombinedFrame(String title) throws HeadlessException {
        super(title);
        StarterCombined applet = new StarterCombined();
        applet.start();
        add(applet, "Center");
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
            }
        });
    }
}
