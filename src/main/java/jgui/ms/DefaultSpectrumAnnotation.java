/**********************************************************
 * Created at 2016/6/1
 * <p>
 * Author:	JiaweiMao
 * <p>
 * Copyright (c) Dalian Institute of Chemical Physics
 * Chinese Academy of Sciences
 * <p>
 * Contact: jiawei@dicp.ac.cn
 *******************************************************/
package jgui.ms;

import java.awt.*;

/**
 * This class provides a default implementation of the SpectrumAnnotation
 * interface.
 *
 * @author JiaweiMao
 * @version 1.00
 * @date Jun 01 2016, 13:52
 */
public class DefaultSpectrumAnnotation implements SpectrumAnnotation {

	/**
	 * The color to use for the annotation.
	 */
	private Color iColor = null;
	/**
	 * The x-axis error margin.
	 */
	private double iErrorMargin = 0.0;
	/**
	 * The mz value to annotate.
	 */
	private double iMZ = 0.0;
	/**
	 * The label to use for the annotation.
	 */
	private String iLabel = null;

	/**
	 * Constructor creating a DefaultSpectrumAnnotation object.
	 *
	 * @param aMZ the mz value to annotate
	 * @param aErrorMargin the mz error margin
	 * @param aColor the color to use for the annotation
	 * @param aLabel the label to use for the annotation
	 */
	public DefaultSpectrumAnnotation(double aMZ, double aErrorMargin, Color aColor, String aLabel) {
		this.iMZ = aMZ;
		this.iErrorMargin = aErrorMargin;
		this.iColor = aColor;
		this.iLabel = aLabel;
	}

	/**
	 * This method returns the color for the annotation.
	 *
	 * @return Color with the color for the annotation.
	 */
	public Color getColor() {
		return iColor;
	}

	/**
	 * Returns the allowed error margin (both sides) for the M/Z of the
	 * annotation (eg., 0.1 means an allowed interval of [M/Z-0.1, M/Z+0.1].
	 *
	 * @return double with the error margin.
	 */
	public double getErrorMargin() {
		return iErrorMargin;
	}

	/**
	 * This method returns the label for the annotation.
	 *
	 * @return String with the label to display (above the M/Z) for this
	 *         annotation.
	 */
	public String getLabel() {
		return iLabel;
	}

	/**
	 * This method returns the M/Z of the feature to annotate.
	 *
	 * @return double with the M/Z.
	 */
	public double getMZ() {
		return iMZ;
	}
}
