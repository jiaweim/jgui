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
package trail.jgui.ms;

import java.awt.*;

/**
 * This interface describes the behavior for a spectrum annotation.
 *
 * @author JiaweiMao
 * @version 1.00
 * @date Jun 01 2016, 13:48
 */
public interface SpectrumAnnotation {

	/**
	 * This method returns the M/Z of the feature to annotate.
	 *
	 * @return double with the M/Z.
	 */
	double getMZ();

	/**
	 * Returns the allowed error margin (both sides) for the M/Z of the
	 * annotation (eg., 0.1 means an allowed interval of [M/Z-0.1, M/Z+0.1].
	 *
	 * @return double with the error margin.
	 */
	double getErrorMargin();

	/**
	 * Returns the color for the annotation.
	 *
	 * @return Color with the color for the annotation.
	 */
	Color getColor();

	/**
	 * Returns the label for the annotation.
	 *
	 * @return String with the label to display (above the M/Z) for this
	 *         annotation.
	 */
	String getLabel();
}
