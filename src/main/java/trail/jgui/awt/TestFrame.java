package trail.jgui.awt;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Frame;

public class TestFrame extends Frame{
	
	public TestFrame(String title){
		super(title);
	}
	
	public void createFileDialog() {
		FileDialog dialog = new FileDialog(TestFrame.this, "FileDialog");
		dialog.setVisible(true);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestFrame tf = new TestFrame("Test");
		tf.setBackground(Color.BLACK);
		
		tf.setSize(new Dimension(220,220));
		tf.setVisible(true);
		
		tf.createFileDialog();

	}

}
