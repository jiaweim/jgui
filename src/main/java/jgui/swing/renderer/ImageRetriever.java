/**********************************************************
 * File:ImageRetriever.java
 *
 * Author:	Jiawei Mao                     
 *
 * Created on 2014��6��12��
 *                       
 * Copyright (c) Dalian Institute of Chemical Physics
 *	Chinese Academy of Sciences
 * 
 * Contact: jiawei@dicp.ac.cn                   
 *                                              
 *******************************************************/

package jgui.swing.renderer;

import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingWorker;

/**
 * @author JiaweiMao
 * @version 2014��6��12�� ����10:41:40
 */
public class ImageRetriever extends SwingWorker<Icon, Void> {

	private ImageRetriever() {
	}

	public ImageRetriever(JLabel lblImage, String strImageUrl) {
		this.strImageUrl = strImageUrl;
		this.lblImage = lblImage;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.SwingWorker#doInBackground()
	 */
	@Override
	protected Icon doInBackground() throws Exception {
		Icon icon = retrieveImage(strImageUrl);
		return icon;
	}

	private Icon retrieveImage(String strImageUrl)
			throws MalformedURLException, IOException {
		InputStream is = null;
		URL imgUrl = null;
		imgUrl = new URL(strImageUrl);
		is = imgUrl.openStream();
		ImageInputStream iis = ImageIO.createImageInputStream(is);
		Iterator<ImageReader> it = ImageIO.getImageReadersBySuffix("jpg");

		ImageReader reader = it.next();
		reader.setInput(iis);
		Image image = reader.read(0);
		Icon icon = new ImageIcon(image);
		return icon;
	}

	@Override
	protected void done() {
		Icon icon = null;
		String text = null;
		try {
			icon = get();
		} catch (Exception ignore) {
			ignore.printStackTrace();
			text = "Image unavailable";
		}
		lblImage.setIcon(icon);
		lblImage.setText(text);
	}

	private String strImageUrl;
	private JLabel lblImage;
}
