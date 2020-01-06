/**********************************************************
  * File:DesktopTest.java
  *
  * Author:	Jiawei Mao                     
  *
  * Created on Jul 9, 2015
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

package trail.jgui.awt;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

/**
 * 
 * @author	JiaweiM
 * @date	Jul 9, 2015 4:28:20 PM
 */
public class DesktopTest {
	
	public static void main(String[] args) throws IOException {
		Desktop desktop = Desktop.getDesktop();
		desktop.open(new File("E:\\downloads\\国际音标讲义.doc"));
	}

}
