// Created at 2016/8/8 
// Author:	JiaweiMao
// Copyright (c) Dalian Institute of Chemical Physics
//      Chinese Academy of Sciences
// Contact: jiawei@dicp.ac.cn

package jgui.swing;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * 提供一个状态区，并能从属性文件中读取资源。
 *
 * @author JiaweiMao
 * @version 1.0.0
 * @date Aug 08 2016, 15:01
 */
public class GJApp
{
    private static JPanel statusArea = new JPanel();
    private static JLabel status = new JLabel("");
    private static ResourceBundle resources;

    static {
        resources = ResourceBundle.getBundle("GJApp", Locale.getDefault());
    }

    private GJApp()
    {
    }

    public static void launch(final JFrame f, String title,
            final int x, final int y, final int w, int h)
    {
        f.setTitle(title);
        f.setBounds(x, y, w, h);
        f.setVisible(true);

        statusArea.setBorder(BorderFactory.createEtchedBorder());
        statusArea.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        statusArea.add(status);
        status.setHorizontalAlignment(JLabel.LEFT);

        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    static public JPanel getStatusArea()
    {
        return statusArea;
    }

    static public void showStatus(String s)
    {
        status.setText(s);
    }

    static String getResource(String key)
    {
        return (resources == null) ? null : resources.getString(key);
    }
}
