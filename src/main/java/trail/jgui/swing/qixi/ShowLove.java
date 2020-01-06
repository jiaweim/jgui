/**********************************************************
  * File:ShowLove.java
  *
  * Author:	Jiawei Mao                     
  *
  * Created on Aug 19, 2015
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

package trail.jgui.swing.qixi;

import java.awt.Robot;
import java.awt.event.KeyEvent;

/**
 * 
 * @Class	ShowLove
 * @author	JiaweiM
 * @date	Aug 19, 2015 9:11:59 PM
 */
public class ShowLove {
	
	public static void main(String[] args) {
		try {
			Robot a = new Robot();
			
			// it let you love open a word processing software in 10 second
			a.delay(10000);
			
			a.keyPress(KeyEvent.VK_I);
			a.keyRelease(KeyEvent.VK_I);
			a.delay(3000);
			
			a.keyPress(KeyEvent.VK_SPACE);
			a.keyRelease(KeyEvent.VK_SPACE);
			a.keyPress(KeyEvent.VK_L);
			a.keyPress(KeyEvent.VK_O);
			a.keyPress(KeyEvent.VK_V);
			a.keyPress(KeyEvent.VK_E);
			
			a.keyRelease(KeyEvent.VK_L);
			a.keyRelease(KeyEvent.VK_O);
			a.keyRelease(KeyEvent.VK_V);
			a.keyRelease(KeyEvent.VK_E);
			
			a.delay(3000);
			
			a.keyPress(KeyEvent.VK_SPACE);
			a.keyRelease(KeyEvent.VK_SPACE);
			
			a.keyPress(KeyEvent.VK_Y);
			a.keyPress(KeyEvent.VK_O);
			a.keyPress(KeyEvent.VK_U);
			
			a.keyRelease(KeyEvent.VK_Y);
			a.keyRelease(KeyEvent.VK_O);
			a.keyRelease(KeyEvent.VK_U);
			
			a.delay(5000);
			
			for(int j=0; j < 10; j++){
				a.delay(2000);
				a.keyPress(KeyEvent.VK_SPACE);
				a.keyRelease(KeyEvent.VK_BACK_SPACE);
			}
			
			a.delay(1000);
			
			for(int i=0; i< 5; i++){
				a.keyPress(KeyEvent.VK_I);
				a.keyRelease(KeyEvent.VK_I);
				
				a.keyPress(KeyEvent.VK_SPACE);
				a.keyRelease(KeyEvent.VK_SPACE);
				
				a.keyPress(KeyEvent.VK_L);
				a.keyPress(KeyEvent.VK_O);
				a.keyPress(KeyEvent.VK_V);
				a.keyPress(KeyEvent.VK_E);
				
				a.keyRelease(KeyEvent.VK_L);
				a.keyRelease(KeyEvent.VK_O);
				a.keyRelease(KeyEvent.VK_V);
				a.keyRelease(KeyEvent.VK_E);
				
				a.keyPress(KeyEvent.VK_SPACE);
				a.keyRelease(KeyEvent.VK_SPACE);
				
				
				a.keyPress(KeyEvent.VK_Y);
				a.keyPress(KeyEvent.VK_O);
				a.keyPress(KeyEvent.VK_U);
				
				a.keyRelease(KeyEvent.VK_Y);
				a.keyRelease(KeyEvent.VK_O);
				a.keyRelease(KeyEvent.VK_U);
				
				a.delay(2000);
				
				for(int j=0; j<10; j++){
					a.keyPress(KeyEvent.VK_BACK_SPACE);
					a.keyRelease(KeyEvent.VK_BACK_SPACE);
				}
				
				a.delay(2000);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
