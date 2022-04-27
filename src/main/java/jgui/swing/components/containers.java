package jgui.swing.components;

import javax.swing.*;

;


/**
 * 这段代码主要是为读者介绍如何在一个顶层容器内获取一个面板，也可以说是在顶层容器内产生一个默认的内容面板
 *
 * @author JiaweiMao
 * @version 1.0.0
 * @date 14 Aug 2016, 15:36
 */
public class containers {
    static final int WIDTH = 800;
    static final int HEIGHT = 600;

    public static void main(String[] args) {
        // simple sample, not thread safe

        JFrame jf = new JFrame("添加内容面板测试程序");///创建一个顶层容器类对象
        jf.setSize(WIDTH, HEIGHT); ///设置顶层容器类对象的大小
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); ///设置顶层容器类对象的关闭功能
        jf.setVisible(true); ///设置顶层容器类的可见性
        JPanel contentPane = new JPanel(); ///创建一个中间容器类对象
        jf.setContentPane(contentPane);//将中间容器组件对象contentPane设置为内容面板
    }
}
