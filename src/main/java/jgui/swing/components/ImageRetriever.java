// Created at 2016/8/3 
// Author:	JiaweiMao
// Copyright (c) Dalian Institute of Chemical Physics
//      Chinese Academy of Sciences
// Contact: jiawei@dicp.ac.cn

package jgui.swing.components;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Iterator;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @date Aug 03 2016, 10:01
 */
public class ImageRetriever extends SwingWorker<Icon, Void> {

    private String strImageUrl;
    private JLabel lblImage;

    public ImageRetriever(JLabel lblImage, String strImageUrl) {
        this.strImageUrl = strImageUrl;
        this.lblImage = lblImage;
    }

    /**
     * 作为任务线程的一部分执行，它负责完成线程的及基本任务，并以返回值来作为线程的执行结果。
     * 继承类需覆盖该方法并确保包含代理线程的基本任务。不要直接调用该方法，应使用任务对象的
     * execute方法来调度执行。
     */
    @Override
    protected Icon doInBackground() throws Exception {
        Icon icon = retrieveImage(strImageUrl);
        return icon;
    }

    private Icon retrieveImage(String strImageUrl) throws IOException {
        URL imgUrl = new URL(strImageUrl);
        InputStream is = imgUrl.openStream();
        ImageInputStream iis = ImageIO.createImageInputStream(is);
        Iterator<ImageReader> it = ImageIO.getImageReadersBySuffix("jpg");
        ImageReader reader = it.next();
        reader.setInput(iis);
        Image image = reader.read(0);
        return new ImageIcon(image);
    }

    /**
     * 在doInBackground完成后，SwingWorker调用done方法。如果任务需要在完成后使用线程结果更新GUI组件或者做些
     * 清理工作，可覆盖done方法来完成。这儿是调用get方法的最好地方，因为此时已知道线程任务完成了，SwingWorker
     * 在EDT上调用done方法，因此可以在该方法内完全地和任何GUI组件交互。
     */
    @Override
    protected void done() {
        Icon icon = null;
        String text = null;
        try {
            /*
             * 获得 doInBackground的结果，可以在EDT上调用get方法，但该方法将一直处于阻塞状态，直到任务线程完成。
              * 最好在任务完成时调用get方法，这样用户不用等待。
              * 为防止阻塞，可以使用isDone方法来简阳doInBackground是否为完成。获取任务结果的最好地方是在done方法内。
             */
            icon = get();
        } catch (Exception ignore) {
            ignore.printStackTrace();
            text = "Image unavailable";
        }
        lblImage.setIcon(icon);
        lblImage.setText(text);
    }


}
