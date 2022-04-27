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
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.util.ArrayList;

/**
 * This class presents a JPanel that will hold and display a mass spectrum in
 * centroid or profile mode.
 *
 * @author JiaweiMao
 * @version 1.00
 * @date Jun 01 2016, 13:50
 */
public class SpectrumPanel extends GraphicsPanel {

	/**
	 * The color used for the peaks. Default to black.
	 */
	private Color spectrumPeakColor = Color.BLACK;
	/**
	 * The color used for the profile mode spectra. Defaults to pink.
	 */
	private Color spectrumProfileModeLineColor = Color.PINK;

	public SpectrumPanel(double[] aXAxisData, double[] aYAxisData, double aPrecursorMz, int aPrecursorCharge) {
		this(aXAxisData, aYAxisData, aPrecursorMz, String.valueOf(aPrecursorCharge), null);
	}

	/**
	 * This constructor creates a SpectrumPanel based on the passed parameters.
	 * This constructor will be used to annotate matched ions on the spectrum
	 * panels.
	 *
	 * @param aXAxisData double[] with all the x-axis values.
	 * @param aYAxisData double[] with all the y-axis values.
	 * @param aPrecursorMZ double with the precursor mass.
	 * @param aPrecursorCharge String with the precursor intensity.
	 * @param aFileName String with the title of the Query.
	 */
	public SpectrumPanel(double[] aXAxisData, double[] aYAxisData, double aPrecursorMZ, String aPrecursorCharge,
			String aFileName) {
		this(aXAxisData, aYAxisData, aPrecursorMZ, aPrecursorCharge, aFileName, 50, false, true, true);
	}

	/**
	 * This constructor creates a SpectrumPanel based on the passed parameters.
	 * This constructor will be used to annotate matched ions on the spectrum
	 * panels.
	 *
	 * @param aXAxisData double[] with all the x-axis values.
	 * @param aYAxisData double[] with all the y-axis values.
	 * @param aPrecursorMZ double with the precursor mass.
	 * @param aPrecursorCharge String with the precursor intensity.
	 * @param aFileName String with the title of the Query.
	 * @param aShowFileName boolean that specifies if the file name should be
	 *            shown in the panel.
	 */
	public SpectrumPanel(double[] aXAxisData, double[] aYAxisData, double aPrecursorMZ, String aPrecursorCharge,
			String aFileName, boolean aShowFileName) {
		this(aXAxisData, aYAxisData, aPrecursorMZ, aPrecursorCharge, aFileName, 50, aShowFileName, true, true);
	}

	/**
	 * This constructor creates a SpectrumPanel based on the passed parameters.
	 * This constructor will be used to annotate matched ions on the spectrum
	 * panels.
	 *
	 * @param aXAxisData double[] with all the x-axis values.
	 * @param aYAxisData double[] with all the y-axis values.
	 * @param aPrecursorMZ double with the precursor mass.
	 * @param aPrecursorCharge String with the precursor intensity.
	 * @param aFileName String with the title of the Query.
	 * @param aMaxPadding int the sets the maximum padding size.
	 * @param aShowFileName boolean that specifies if the file name should be
	 *            shown in the panel.
	 */
	public SpectrumPanel(double[] aXAxisData, double[] aYAxisData, double aPrecursorMZ, String aPrecursorCharge,
			String aFileName, int aMaxPadding, boolean aShowFileName) {
		this(aXAxisData, aYAxisData, aPrecursorMZ, aPrecursorCharge, aFileName, aMaxPadding, aShowFileName, true, true);
	}

	/**
	 * This constructor creates a SpectrumPanel based on the passed parameters.
	 * This constructor will be used to annotate matched ions on the spectrum
	 * panels.
	 *
	 * @param aXAxisData double[] with all the x-axis values.
	 * @param aYAxisData double[] with all the y-axis values.
	 * @param aPrecursorMZ double with the precursor mass.
	 * @param aPrecursorCharge String with the precursor intensity.
	 * @param aFileName String with the title of the Query.
	 * @param aMaxPadding int the sets the maximum padding size.
	 * @param aShowFileName boolean that specifies if the file name should be
	 *            shown in the panel
	 * @param aShowPrecursorDetails boolean that specifies if the precursor
	 *            details should be shown in the panel
	 * @param aShowResolution boolean that specifies if the resolution should be
	 *            shown in the panel
	 */
	public SpectrumPanel(double[] aXAxisData, double[] aYAxisData, double aPrecursorMZ, String aPrecursorCharge,
			String aFileName, int aMaxPadding, boolean aShowFileName, boolean aShowPrecursorDetails,
			boolean aShowResolution) {
		this(aXAxisData, aYAxisData, aPrecursorMZ, aPrecursorCharge, aFileName, aMaxPadding, aShowFileName,
				aShowPrecursorDetails, aShowResolution, 0);
	}

	/**
	 * This constructor creates a SpectrumPanel based on the passed parameters.
	 * This constructor will be used to annotate matched ions on the spectrum
	 * panels.
	 *
	 * @param aXAxisData double[] with all the x-axis values.
	 * @param aYAxisData double[] with all the y-axis values.
	 * @param aPrecursorMZ double with the precursor mass.
	 * @param aPrecursorCharge String with the precursor intensity.
	 * @param aFileName String with the title of the Query.
	 * @param aMaxPadding int the sets the maximum padding size.
	 * @param aShowFileName boolean that specifies if the file name should be
	 *            shown in the panel
	 * @param aShowPrecursorDetails boolean that specifies if the precursor
	 *            details should be shown in the panel
	 * @param aShowResolution boolean that specifies if the resolution should be
	 *            shown in the panel
	 * @param aMSLevel int with the ms level for the spectrum, set to 0 if ms
	 *            level is unknown
	 */
	public SpectrumPanel(double[] aXAxisData, double[] aYAxisData, double aPrecursorMZ, String aPrecursorCharge,
			String aFileName, int aMaxPadding, boolean aShowFileName, boolean aShowPrecursorDetails,
			boolean aShowResolution, int aMSLevel) {
		this(aXAxisData, aYAxisData, aPrecursorMZ, aPrecursorCharge, aFileName, aMaxPadding, aShowFileName,
				aShowPrecursorDetails, aShowResolution, aMSLevel, false);
	}

	/**
	 * This constructor creates a SpectrumPanel based on the passed parameters.
	 * This constructor will be used to annotate matched ions on the spectrum
	 * panels.
	 *
	 * @param aXAxisData double[] with all the x-axis values.
	 * @param aYAxisData double[] with all the y-axis values.
	 * @param aPrecursorMZ double with the precursor mass.
	 * @param aPrecursorCharge String with the precursor charge.
	 * @param aFileName String with the title of the Query.
	 * @param aMaxPadding int the sets the maximum padding size.
	 * @param aShowFileName boolean that specifies if the file name should be
	 *            shown in the panel
	 * @param aShowPrecursorDetails boolean that specifies if the precursor
	 *            details should be shown in the panel
	 * @param aShowResolution boolean that specifies if the resolution should be
	 *            shown in the panel
	 * @param aMSLevel int with the ms level for the spectrum, set to 0 if ms
	 *            level is unknown
	 * @param aProfileMode boolean if set to true the spectrum will be drawn in
	 *            profile mode
	 */
	public SpectrumPanel(double[] aXAxisData, double[] aYAxisData, double aPrecursorMZ, String aPrecursorCharge,
			String aFileName, int aMaxPadding, boolean aShowFileName, boolean aShowPrecursorDetails,
			boolean aShowResolution, int aMSLevel, boolean aProfileMode) {
		this.iCurrentDrawStyle = DrawingStyle.LINES;
		this.iSpecPanelListeners = new ArrayList<>();
		this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		this.setBackground(Color.WHITE);
		dataSetCounter = 0;
		processXAndYData(aXAxisData, aYAxisData, spectrumPeakColor, spectrumProfileModeLineColor);
		iPrecursorMZ = aPrecursorMZ;
		iPrecursorCharge = aPrecursorCharge;
		iFilename = aFileName;
		this.maxPadding = aMaxPadding;
		this.showFileName = aShowFileName;
		this.showPrecursorDetails = aShowPrecursorDetails;
		this.showResolution = aShowResolution;
		this.iMSLevel = aMSLevel;

		if (aProfileMode) {
			this.currentGraphicsPanelType = GraphicsPanelType.profileSpectrum;
		} else {
			this.currentGraphicsPanelType = GraphicsPanelType.centroidSpectrum;
		}

		this.addListeners();
	}

	/**
	 * Add a mirrored spectrum (or chromatogram).
	 *
	 * @param aXAxisData the x axis data
	 * @param aYAxisData the y axis data
	 * @param aPrecursorMZ the precursor m/z
	 * @param aPrecursorCharge the precursor charge
	 * @param aFileName the file name
	 * @param aProfileMode if the spectrum is to be drawn in profile mode
	 * @param aSpectrumPeakColor the spectrum peak color
	 * @param aSpectrumProfileModeLineColor the spectrum profile mode line color
	 */
	public void addMirroredSpectrum(double[] aXAxisData, double[] aYAxisData, double aPrecursorMZ,
			String aPrecursorCharge, String aFileName, boolean aProfileMode, Color aSpectrumPeakColor,
			Color aSpectrumProfileModeLineColor) {

		iPrecursorMZMirroredSpectrum = aPrecursorMZ;
		iPrecursorChargeMirorredSpectrum = aPrecursorCharge;
		iFilenameMirrorredSpectrum = aFileName;

		processMirroredXAndYData(aXAxisData, aYAxisData, aSpectrumPeakColor, aSpectrumProfileModeLineColor);

		if (aProfileMode) {
			this.currentGraphicsPanelType = GraphicsPanelType.profileSpectrum;
		} else {
			this.currentGraphicsPanelType = GraphicsPanelType.centroidSpectrum;
		}

		this.showFileName = false;
		this.showPrecursorDetails = false;
		this.showResolution = false;
		this.yAxisZoomExcludesBackgroundPeaks = false;
		this.yDataIsPositive = false;
	}

	/**
	 * Adds an additional spectrum dataset to be displayed in the same Spectrum
	 * Panel. Remember to use different colors for the different datasets.
	 *
	 * @param aXAxisData double[] with all the x-axis values.
	 * @param aYAxisData double[] with all the y-axis values
	 * @param dataPointAndLineColor the color to use for the data points and
	 *            lines
	 * @param areaUnderCurveColor the color to use for the area under the curve
	 */
	public void addAdditionalDataset(double[] aXAxisData, double[] aYAxisData, Color dataPointAndLineColor,
			Color areaUnderCurveColor) {

		processXAndYData(aXAxisData, aYAxisData, dataPointAndLineColor, areaUnderCurveColor);

		this.showFileName = false;
		this.showPrecursorDetails = false;
		this.showResolution = false;
	}

	/**
	 * Adds an additional mirrored spectrum dataset to be displayed in the same
	 * Spectrum Panel. Remember to use different colors for the different
	 * datasets.
	 *
	 * @param aXAxisData double[] with all the x-axis values.
	 * @param aYAxisData double[] with all the y-axis values
	 * @param dataPointAndLineColor the color to use for the data points and
	 *            lines
	 * @param areaUnderCurveColor the color to use for the area under the curve
	 */
	public void addAdditionalMirroredDataset(double[] aXAxisData, double[] aYAxisData, Color dataPointAndLineColor,
			Color areaUnderCurveColor) {

		processMirroredXAndYData(aXAxisData, aYAxisData, dataPointAndLineColor, areaUnderCurveColor);

		this.showFileName = false;
		this.showPrecursorDetails = false;
		this.showResolution = false;
	}

	/**
	 * Change the drawing type of the spectrum. Profile or centroid mode.
	 *
	 * @param aProfileMode if true, the spectrum is drawn in profile mode
	 */
	public void setProfileMode(boolean aProfileMode) {
		if (aProfileMode) {
			this.currentGraphicsPanelType = GraphicsPanelType.profileSpectrum;
		} else {
			this.currentGraphicsPanelType = GraphicsPanelType.centroidSpectrum;
		}
	}

	/**
	 * Set the default spectrum peak color. (Note that this only has an impact
	 * on the first spectrum added. For additional spectra or mirrored spectra
	 * set the color in the given constructor.)
	 *
	 * @param aSpectrumPeakColor the color to set
	 */
	public void setSpectrumPeakColor(Color aSpectrumPeakColor) {
		this.spectrumPeakColor = aSpectrumPeakColor;
	}

	/**
	 * Set the default spectrum profile mode color. (Note that this only has an
	 * impact on the first spectrum added. For additional spectra or mirrored
	 * spectra set the color in the given constructor.)
	 *
	 * @param aSpectrumProfileModeLineColor the color to set
	 */
	public void setSpectrumProfileModeLineColor(Color aSpectrumProfileModeLineColor) {
		this.spectrumProfileModeLineColor = aSpectrumProfileModeLineColor;
	}

	/**
	 * If true only the annotated peaks will be drawn. The default value is
	 * false, and result in all peaks being drawn. Note that this setting is
	 * ignored when in profile mode!
	 *
	 * @param aAnnotatedPeaks if true only the annotated peaks will be drawn
	 */
	public void showAnnotatedPeaksOnly(boolean aAnnotatedPeaks) {
		this.showAllPeaks = !aAnnotatedPeaks;
	}

	/**
	 * Returns the color to use for the given fragment ion label.
	 *
	 * @param seriesLabel the series label
	 * @return the fragment ion color
	 */
	public static Color determineFragmentIonColor(String seriesLabel) {

		Color currentColor = Color.GRAY;

		if (seriesLabel.startsWith("a")) {

			// turquoise
			currentColor = new Color(153, 0, 0);

			if (seriesLabel.lastIndexOf("H2O") != -1 || seriesLabel.lastIndexOf("H20") != -1) {
				// light purple-blue
				currentColor = new Color(171, 161, 255);
			} else if (seriesLabel.lastIndexOf("NH3") != -1) {
				// ugly purple pink
				currentColor = new Color(248, 151, 202);
			}

			// change color slightly if a double charge is detected
			if (seriesLabel.lastIndexOf("++") != -1) {
				currentColor = new Color(currentColor.getRed() - 100, currentColor.getGreen(), currentColor.getBlue());
			}

		} else if (seriesLabel.startsWith("b")) {

			// dark blue
			currentColor = new Color(0, 0, 255);

			// change color slightly if a neutral loss is detected
			if (seriesLabel.lastIndexOf("H2O") != -1 || seriesLabel.lastIndexOf("H20") != -1) {
				currentColor = new Color(0, 150, 255);
			} else if (seriesLabel.lastIndexOf("NH3") != -1 || seriesLabel.equalsIgnoreCase("b ions - mod.")) {
				currentColor = new Color(150, 0, 255);
			}

			// change color slightly if a double charge is detected
			if (seriesLabel.lastIndexOf("++") != -1) {
				currentColor = new Color(currentColor.getRed(), currentColor.getGreen(), currentColor.getBlue() - 100);
			}

		} else if (seriesLabel.startsWith("c")) {

			// purple blue
			currentColor = new Color(188, 0, 255);

			// change color slightly if a neutral loss is detected
			if (seriesLabel.lastIndexOf("H2O") != -1 || seriesLabel.lastIndexOf("H20") != -1) {
				currentColor = new Color(188, 150, 255);
			} else if (seriesLabel.lastIndexOf("NH3") != -1) {
				currentColor = new Color(255, 0, 255);
			}

			// change color slightly if a double charge is detected
			if (seriesLabel.lastIndexOf("++") != -1) {
				currentColor = new Color(currentColor.getRed(), currentColor.getGreen(), currentColor.getBlue() - 100);
			}

		} else if (seriesLabel.startsWith("x")) {

			// green
			currentColor = new Color(78, 200, 0);

			// change color slightly if a neutral loss is detected
			if (seriesLabel.lastIndexOf("H2O") != -1 || seriesLabel.lastIndexOf("H20") != -1) {
				currentColor = new Color(78, 200, 150);
			} else if (seriesLabel.lastIndexOf("NH3") != -1) {
				currentColor = new Color(255, 200, 255);
			}

			// change color slightly if a double charge is detected
			if (seriesLabel.lastIndexOf("++") != -1) {
				currentColor = new Color(currentColor.getRed(), currentColor.getGreen() - 100, currentColor.getBlue());
			}

		} else if (seriesLabel.startsWith("y")) {

			// red
			currentColor = new Color(255, 0, 0);

			// change color slightly if a neutral loss is detected
			if (seriesLabel.lastIndexOf("H2O") != -1 || seriesLabel.lastIndexOf("H20") != -1) {
				currentColor = new Color(255, 150, 0);
			} else if (seriesLabel.lastIndexOf("NH3") != -1 || seriesLabel.equalsIgnoreCase("y ions - mod.")) {
				currentColor = new Color(255, 0, 150);
			}

			// change color slightly if a double charge is detected
			if (seriesLabel.lastIndexOf("++") != -1) {
				currentColor = new Color(currentColor.getRed() - 100, currentColor.getGreen(), currentColor.getBlue());
			}

		} else if (seriesLabel.startsWith("z")) {

			// dark green
			currentColor = new Color(64, 179, 0);

			// change color slightly if a neutral loss is detected
			if (seriesLabel.lastIndexOf("H2O") != -1 || seriesLabel.lastIndexOf("H20") != -1) {
				currentColor = new Color(64, 179, 150);
			} else if (seriesLabel.lastIndexOf("NH3") != -1) {
				currentColor = new Color(255, 179, 150);
			}

			// change color slightly if a double charge is detected
			if (seriesLabel.lastIndexOf("++") != -1) {
				currentColor = new Color(currentColor.getRed(), currentColor.getGreen() - 100, currentColor.getBlue());
			}

		} else if (seriesLabel.startsWith("iTRAQ") || seriesLabel.startsWith("TMT")) {
			return Color.ORANGE;
		}

		return currentColor;
	}
}
