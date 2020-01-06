/**********************************************************
  * File:LoadImage.java
  *
  * Author:	Jiawei Mao                     
  *
  * Created on Jan 10, 2016
  *                       
  * Copyright (c) Dalian Institute of Chemical Physics
  *	Chinese Academy of Sciences
  * 
  * Contact: jiawei@dicp.ac.cn                   
  *                                              
  *******************************************************/
package trail.jgui.swing.j2d.images;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 * This class demonstrates how to load an Image from an external file
 * 
 * @author  JiaweiMao
 * @date	Jan 10, 2016 10:37:18 PM
 */
public class LoadImage extends Component{

	BufferedImage image;
	
	/**
	 * 
	 */
	public LoadImage() {
		try {
			image = ImageIO.read(new File(LoadImage.class.getResource("strawberry.jpg").toURI()));
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
	}
	
	public void paint(Graphics g){
		g.drawImage(image, 0, 0, null);
	}
	
	public Dimension getPreferredSize(){
		if(image == null){
			return new Dimension(100, 100);
		}else{
			return new Dimension(image.getWidth(), image.getHeight());
		}
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Load Image Sample");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(new LoadImage());
		frame.pack();
		frame.setVisible(true);
	}
}
