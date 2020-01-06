/**********************************************************
  * File:RGBCal.java
  *
  * Author:	Jiawei Mao                     
  *
  * Created on 2014��6��17��
  *                       
  * Copyright (c) Dalian Institute of Chemical Physics
  *	Chinese Academy of Sciences
  * 
  * Contact: jiawei@dicp.ac.cn                   
  *                                              
  *******************************************************/

package trail.jgui.awt.composite;

/**
 * @author JiaweiMao
 * @version 2014��6��17�� ����3:04:08
 */
public class RGBCal {
	public static void main(String[] args){
		int srcA = 127;
		int srcR = 255;
		int srcG = 0;
		int srcB = 0;
		
		int dstA = 255;
		int dstR = 0;
		int dstG = 0;
		int dstB = 255;
		
		srcR  = (srcR * srcA)/255;
		srcG  = (srcG * srcA)/255;
		srcB  = (srcB * srcA)/255;
		
		dstR = (dstR * dstA) / 255;
		dstG = (dstG * dstA) / 255;
		dstB = (dstB * dstA) / 255;
		
		int resultA = srcA + (dstA * (255-srcA))/255;
		int resultR = srcR = (dstR * (255-srcR))/255;
		
		
		
		System.out.println();
	}

}
