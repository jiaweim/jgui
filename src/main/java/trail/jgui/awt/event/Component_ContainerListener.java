/**********
  * File:Component_ContainerListener.java
  * Author: Jiawei Mao
  *	Created on 2014��5��7��
  * Copyright (c) Dalian Institute of Chemical Physics
  *	Chinese Academy of Sciences
  * Contact: jiawei@dicp.ac.cn
  */
package trail.jgui.awt.event;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Component;
import java.awt.Panel;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * @author JiaweiMao
 * @version 2014��5��7�� ����9:47:49
 */
public class Component_ContainerListener extends Applet{
	
	public void init(){
		final Button button = new Button("button ");
		Choice visible = new Choice(), addRemove = new Choice();
		Panel controls = new Panel();
		visible.add("show");
		visible.add("hide");
		
		addRemove.add("remove");
		addRemove.add("add");
		
		controls.add(visible);
		controls.add(addRemove);
		
		setLayout(new BorderLayout());
		add(button, BorderLayout.CENTER);
		add(controls, "North");
		
		button.addComponentListener(new ButtonListener());
		addContainerListener(new AppletListener());
		
		visible.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				String aString = ((Choice)e.getSource()).getSelectedItem();
				if(aString.equals("hide"))
					button.setVisible(false);
				else{
					button.setVisible(true);
				}
			}
		});
		
		addRemove.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				String aString = ((Choice)e.getSource()).getSelectedItem();
				if(aString.equals("add"))
					add(button, "Center");
				else{
					remove(button);
				}
				
			}
		});
	}

	class ButtonListener implements ComponentListener{

		/* (non-Javadoc)
		 * @see java.awt.event.ComponentListener#componentResized(java.awt.event.ComponentEvent)
		 */
		@Override
		public void componentResized(ComponentEvent e) {
			Component c = e.getComponent();
			System.out.println("button resized:"+c.getSize());
		}

		/* (non-Javadoc)
		 * @see java.awt.event.ComponentListener#componentMoved(java.awt.event.ComponentEvent)
		 */
		@Override
		public void componentMoved(ComponentEvent e) {
			Component c = e.getComponent();
			System.out.println("button moved:"+c.getLocation());
		}

		/* (non-Javadoc)
		 * @see java.awt.event.ComponentListener#componentShown(java.awt.event.ComponentEvent)
		 */
		@Override
		public void componentShown(ComponentEvent e) {
			System.out.println("button shown");
		}

		/* (non-Javadoc)
		 * @see java.awt.event.ComponentListener#componentHidden(java.awt.event.ComponentEvent)
		 */
		@Override
		public void componentHidden(ComponentEvent e) {
			System.out.println("button hidden");
		}
		
	}
	
	class AppletListener implements ContainerListener{

		/* (non-Javadoc)
		 * @see java.awt.event.ContainerListener#componentAdded(java.awt.event.ContainerEvent)
		 */
		@Override
		public void componentAdded(ContainerEvent e) {
			Component c = e.getChild();
			System.out.println("Container: button added");
		}

		/* (non-Javadoc)
		 * @see java.awt.event.ContainerListener#componentRemoved(java.awt.event.ContainerEvent)
		 */
		@Override
		public void componentRemoved(ContainerEvent e) {
			System.out.println("Container: button removed");
		}
		
	}
}
