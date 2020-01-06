package trail.jgui.ms;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class SpectrumPanelDemo extends JFrame{

	public SpectrumPanelDemo(String title) throws HeadlessException {
		super(title);
		
		double tol = 0.1;
		
		double[] mzs = new double[100];
		for(int i=0; i< 100; i++){
			mzs[i] = i;
		}
		
		double[] ins = new double[100];
		for(int i=0; i< ins.length; i++){
			ins[i] = Math.random();
		}
		
		SpectrumPanel panel = new SpectrumPanel(mzs, ins, 0, 2);
		panel.setAnnotateHighestPeak(true);
		List<SpectrumAnnotation> list = new ArrayList<>();
		SpectrumAnnotation an1 = new DefaultSpectrumAnnotation(10, tol, Color.GREEN, "y2*++");
		list.add(an1);
		panel.setAnnotations(list);
		panel.setSize(500, 400);
		panel.setYAxisMax(1.5);
		
//		panel.setSubscriptAnnotationNumbers(false);
		
		add(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				SpectrumPanelDemo demo = new SpectrumPanelDemo("panel");
				demo.setVisible(true);
			}
		});

	}
	
}
