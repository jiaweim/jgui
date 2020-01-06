// Created at 2016/8/13 
// Author:	JiaweiMao
// Copyright (c) Dalian Institute of Chemical Physics
//      Chinese Academy of Sciences
// Contact: jiawei@dicp.ac.cn

package trail.jgui.swing;

import javax.swing.*;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @date Aug 13 2016, 18:43
 */
public class MyApp
{

    public MyApp(String[] args)
    {
        // invoked on the EDT. do any initialization here.
    }

    public void show()
    {
        // show the ui
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> new MyApp(args).show());
    }
}
