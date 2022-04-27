package jgui.awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class HelloAwt extends Frame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private void run() {
		configureFrame();
		createButton();
		/*
		 * Adds the specified window listener to receive window events from this window. 
		 */
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		
		setVisible(true);
	}
	
	private void configureFrame() {
		//Sets the title for this frame to the specified string.
		setTitle("Hello AWT");
		/*Sets the layout manager for this container. 
		This method changes layout-related information, and therefore, invalidates the component hierarchy.*/
		setLayout(new FlowLayout());
		/*
		 * Resizes this component so that it has width Dimension.width and height Dimension.height
		 */
		setSize(new Dimension(200,200));
		/*
		 * Moves this component to a new location. The top-left corner of the new location is specified
		 *  by the x and y parameters in the coordinate space of this component's parent. 
		 */
		setLocation(0,0);
	}
	
	private void createButton() {
		Button button = new Button("Open");
		/*
		 * Adds the specified action listener to receive action events from this button. 
		 */
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				createDialog();
				
			}
		});
		
		/*
		 * Adds the specified component to the end of this container. 
		 * Also notifies the layout manager to add the component to this container's layout 
		 * using the specified constraints object.
		 */
		add(button, BorderLayout.NORTH);
	}
	
	private void createDialog() {
		
		final Dialog dialog = new Dialog(HelloAwt.this, "Dialog", true);
		dialog.setSize(new Dimension(267,117));
		
		Toolkit toolkit = dialog.getToolkit();
		// Gets the size of the screen.
		Dimension screenSize = toolkit.getScreenSize();
		System.out.println(screenSize);
		/*
		 * Returns the current x coordinate of the components origin. This
		 * method is preferable to writing component.getBounds().x, or
		 * component.getLocation().x because it doesn't cause any heap
		 * allocations.
		 */
		int x = HelloAwt.this.getX()
				+ (HelloAwt.this.getWidth() - dialog.getWidth()) / 2;
		if (x < 0)
			x=0;
		if(x+dialog.getWidth()>screenSize.width){
			x = screenSize.width-dialog.getWidth();
		}
		
		int y = HelloAwt.this.getY()+(HelloAwt.this.getHeight()-dialog.getHeight())/2;
		if(y<0)
			y=0;
		if(y+dialog.getHeight()>screenSize.height){
			y = screenSize.height-dialog.getHeight();
		}
		
		dialog.setLocation(x, y);

		dialog.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				/*
				 * Releases all of the native screen resources used by this
				 * Window, its subcomponents, and all of its owned children.
				 * That is, the resources for these Components will be
				 * destroyed, any memory they consume will be returned to the
				 * OS, and they will be marked as undisplayable.
				 */
				dialog.dispose();
			}
		});
		
		dialog.setLayout(new GridLayout(2,1));
		Panel topPanel = new Panel();
		Label label = new Label("This is a dialog");
		
		topPanel.add(label, BorderLayout.NORTH);
		dialog.add(topPanel);
		Panel bottomPanel = new Panel();
		Button button = new Button("Confirm");
		
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.dispose();
				
			}
			
		});
		
		bottomPanel.add(button, BorderLayout.SOUTH);
		dialog.add(bottomPanel);
		dialog.setVisible(true);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new HelloAwt().run();

	}

}
