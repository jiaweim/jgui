// Created at 2016/8/5 
// Author:	JiaweiMao
// Copyright (c) Dalian Institute of Chemical Physics
//      Chinese Academy of Sciences
// Contact: jiawei@dicp.ac.cn

package jgui.awt;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @date Aug 05 2016, 14:04
 */
public class StarterApplication extends Frame {

    public StarterApplication(String title) throws HeadlessException {
        super(title);
        add(new Label("Starter", Label.CENTER), "Center");
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        StarterApplication app = new StarterApplication("Starter Application");
        app.setSize(300, 100);
        app.setVisible(true);
    }
}
