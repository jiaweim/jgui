package trail.jgui.awt;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;

public class GetimageDemo extends Frame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String filename;
	public GetimageDemo(String file){
		setSize(1920,1680);
		setVisible(true);
		this.filename = file;
	}
	
	public void paint(Graphics g){
		Image image = getToolkit().getImage(filename);
		g.drawImage(image, 0, 0, this);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new GetimageDemo("C:\\Users\\admin08\\Pictures\\WallPaper\\23.jpg");
		
	}

}
