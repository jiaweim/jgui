/**********************************************************
  * File:FontDemo.java
  *
  * Author:	Jiawei Mao                     
  *
  * Created on May 20, 2015
  *                       
  * Copyright (c) Dalian Institute of Chemical Physics
  *	Chinese Academy of Sciences
  * 
  * Contact: jiawei@dicp.ac.cn                   
  *                                              
  *******************************************************/

package trail.jgui.awt;

import java.awt.Font;
import java.awt.GraphicsEnvironment;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author JiaweiMao
 * @version May 20, 2015 10:32:03 AM
 */
public class FontDemo {
	
	GraphicsEnvironment local;
	
	@Before
	public void setup(){
		local = GraphicsEnvironment.getLocalGraphicsEnvironment();
	}
	
	/**
	 * Physical fonts 为系统上的实际字体
	 * 获得系统上所有字体的logical name，即物理名称
	 */
	@Test
	@Ignore
	public void getAllLogicalNames(){
		String[] fonts = local.getAvailableFontFamilyNames();
		for(String font : fonts){
			System.out.println(font);
		}

	}
	
	/**
	 * 获得系统上所有字体，
	 * getName返回logical name，
	 * getFamily返回 family name,
	 * getFontName返回font face name
	 */
	@Test
	public void getAllFonts(){
		Font[] fonts = local.getAllFonts();
		System.out.println("Face Name\tLogical Name\tFamily Name");
		for(Font f : fonts){
			System.out.println(f.getFontName()+"\t"+f.getName()+"\t"+f.getFamily());
		}
		
	}
	

}
