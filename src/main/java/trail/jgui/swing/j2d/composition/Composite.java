/**********************************************************
  * File:Composite.java
  *
  * Author:	Jiawei Mao                     
  *
  * Created on Nov 30, 2015
  *                       
  * Copyright (c) Dalian Institute of Chemical Physics
  *	Chinese Academy of Sciences
  * 
  * Contact: jiawei@dicp.ac.cn                   
  *                                              
  *******************************************************/

/**
 * 
 * @version 1.00
 */

package trail.jgui.swing.j2d.composition;

import java.awt.AlphaComposite;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JApplet;
import javax.swing.JPanel;

/**
 * 
 * @author	JiaweiM
 * @date	Nov 30, 2015 4:33:27 PM
 */
public class Composite extends JApplet implements ItemListener{

	/* (non-Javadoc)
	 * @see java.awt.event.ItemListener#itemStateChanged(java.awt.event.ItemEvent)
	 */
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}

}

class CompPanel extends JPanel{
	AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC);
}
