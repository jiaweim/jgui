package jgui.awt;


import javax.swing.JOptionPane;

public class ScannerTest {
	public static void main(String[] args) {
		String input= "";
		input = JOptionPane.showInputDialog("Input the value of N (exit with input exit)");
		int N=0;
		try{
			 N = Integer.parseInt(input);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		input = (N>90 ? "A":(N>60 ? "B": "C"));
		
		System.out.println(input);
		System.exit(0);
	}

}
