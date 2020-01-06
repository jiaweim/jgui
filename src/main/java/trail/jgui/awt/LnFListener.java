package trail.jgui.awt;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class LnFListener implements ActionListener{
	Frame frame;
	
	public LnFListener(Frame f){
		frame = f;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String lnfName = null;
		
		if(e.getActionCommand().equals("Mac")){
			lnfName = "com.apple.mrj.swing.MacLookAndFeel";
		}else if(e.getActionCommand().equals("Metal")){
			lnfName = "javax.swing.plaf.metal.MetalLookAndFeel";
		}else if(e.getActionCommand().equals("Motif")){
			lnfName = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
		}else if(e.getActionCommand().equals("Windows")){
			lnfName = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
		}else{
			System.err.println("Unrecognied L&F request action:"+e.getActionCommand());
			return;
		}
		
		try{
			try {
				UIManager.setLookAndFeel(lnfName);
			} catch (InstantiationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			SwingUtilities.updateComponentTreeUI(frame);
		}catch(UnsupportedLookAndFeelException e2){
			e2.printStackTrace();
		}catch(ClassNotFoundException e3){
			e3.printStackTrace();
		}
		
	}

}
