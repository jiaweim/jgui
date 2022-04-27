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

import javax.swing.*;

/**
 * This class implements a resizing event that occurred on a SpectrumPanel.
 *
 * @author JiaweiMao
 * @version 1.00
 * @date Jun 01 2016, 13:49
 */
public class RescalingEvent {

	/**
	 * The minimal mass to display after rescaling.
	 */
	private double iMinMass = 0;

	/**
	 * The maximal mass to display after rescaling.
	 */
	private double iMaxMass = 0;

	/**
	 * This JPanel represents the source.
	 */
	private JPanel iSource = null;

	/**
	 * The constructor takes the resizing event X coordinates in mass units.
	 *
	 * @param aSource The JPanel that threw the event.
	 * @param aMinMass The minimal mass to display after rescaling.
	 * @param aMaxMass The maximal mass to display after rescaling.
	 */
	public RescalingEvent(JPanel aSource, double aMinMass, double aMaxMass) {
		this.iSource = aSource;
		this.iMinMass = aMinMass;
		this.iMaxMass = aMaxMass;
	}

	/**
	 * Returns the maximum mass.
	 *
	 * @return the maximum mass
	 */
	public double getMaxMass() {
		return iMaxMass;
	}

	/**
	 * Returns the minimum mass.
	 *
	 * @return the minimum mass
	 */
	public double getMinMass() {
		return iMinMass;
	}

	/**
	 * Returns the JPanel source.
	 *
	 * @return the JPanel source
	 */
	public JPanel getSource() {
		return iSource;
	}
}
