package jgui.awt;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TextEditor extends WindowAdapter implements ActionListener{
	private Frame frame;
	private TextArea textarea;
	private String filename;
	
	
	public void createEditor() {
		MenuBar menubar = new MenuBar();
		Menu menufile = new Menu("�ļ�");
		MenuItem menunew = new MenuItem("�½�",new MenuShortcut(KeyEvent.VK_N));
		MenuItem menuopen = new MenuItem("��", new MenuShortcut(KeyEvent.VK_O));
		MenuItem menusave = new MenuItem("����", new MenuShortcut(KeyEvent.VK_S));
		
		menufile.add(menunew);
		menufile.add(menuopen);
		menufile.add(menusave);
		menufile.add("���Ϊ...");
		menufile.addSeparator();
		menufile.add("�˳�");
		menufile.addActionListener(this);
		
		Menu menuhelp = new Menu("����");
		menuhelp.add("����");
		menuhelp.addActionListener(this);
		
		menubar.add(menufile);
		menubar.setHelpMenu(menuhelp);
		
		frame = new Frame("Java �ı��༭��");
		frame.setMenuBar(menubar);
		textarea = new TextArea();
		frame.add("Center", textarea);
		
		frame.setSize(400,600);
		frame.setVisible(true);
		
	}
	
	
	public void windowClosing(WindowEvent e){
		System.exit(0);
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TextEditor te = new TextEditor();
		te.createEditor();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			if(e.getActionCommand() == "�½�"){
			
				textarea.setText("");
			}else if(e.getActionCommand() == "��"){
				FileDialog fdopen = new FileDialog(frame, "Open",0);
				fdopen.setVisible(true);
				filename = fdopen.getDirectory()+fdopen.getFile();
				
				FileReader fr = new FileReader(filename);
				BufferedReader br = new BufferedReader(fr);
				
				String str = "";
				while(br.ready()){
					int c = br.read();
					str += (char)c;
				}
				textarea.setText(str);
				fr.close();
				br.close();
				frame.setTitle("Java �ı��༭�� - "+filename);
			}else if(e.getActionCommand() == "����"){
				File file = new File(filename);
				FileWriter fos = new FileWriter(file,true);
				BufferedWriter bos = new BufferedWriter(fos);
				PrintWriter pw = new PrintWriter(bos);
				pw.print(textarea.getText());
				
				bos.close();
				pw.close();
				fos.close();
			}else if(e.getActionCommand() == "���Ϊ..."){
				FileDialog fd = new FileDialog(frame, "Open",0);
				fd.setVisible(true);
				
				filename = fd.getDirectory()+fd.getFile();
				File file = new File(filename);
				FileWriter fw = new FileWriter(file,true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter pw = new PrintWriter(bw);
				pw.print(textarea.getText());
				
				pw.close();
				fw.close();
				bw.close();
				
			}else if(e.getActionCommand() == "����"){
				final Dialog dialog = new Dialog(frame,"����",true);
				dialog.setSize(267, 117);
				dialog.setLayout(new GridLayout(2,1));
				
				dialog.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e){
						dialog.dispose();
					}
				});
				
				Panel topPanel = new Panel();
				Label label = new Label("Java �ı��༭��-���ߣ�ë��ά");
				topPanel.add(label, BorderLayout.NORTH);
				dialog.add(topPanel);
				dialog.setVisible(true);
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}catch (IOException r){
			r.printStackTrace();
		}
		
	
		
	}

}
