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
 * This class provides a JPanel that can display a profile Chromatogram.
 *
 * @author JiaweiMao
 * @version 1.00
 * @date Jun 01 2016, 13:51
 */
public class ChromatogramPanel extends GraphicsPanel {

    /**
     * Color in which the profileChromatogram polyline is rendered. Defaults to
     * gray.
     */
    private Color iChromatogramColor = Color.GRAY;
    /**
     * Color in which the data points and peaks are rendered. Defaults to black.
     */
    private Color iChromatogramPointColor = Color.BLACK;

    /**
     * This constructor creates a ChromatogramPanel based on the passed parameters. This constructor assumes
     * profileChromatogram data rather than spectrum data. (For profile spectrum data use the SpectrumPanel class
     * instead and set ProfileMode to 'true'.)
     *
     * @param aXAxisData double[] with all the X axis data.
     * @param aYAxisData double[] with all the Y axis data.
     */
    public ChromatogramPanel(double[] aXAxisData, double[] aYAxisData) {
        this(aXAxisData, aYAxisData, null, null, null);
    }

    /**
     * This constructor creates a ChromatogramPanel based on the passed parameters. This constructor assumes
     * profileChromatogram data rather than spectrum data. (For profile spectrum data use the SpectrumPanel class
     * instead and set ProfileMode to 'true'.)
     *
     * @param aXAxisData  double[] with all the X axis data.
     * @param aYAxisData  double[] with all the Y axis data.
     * @param aXAxisLabel String with the label for the x-axis (can have a unit
     *                    between brackets, if available) - can be 'null' for no label
     * @param aYAxisLabel String with the label for the y-axis (can have a unit
     *                    between brackets, if available) - can be 'null' for no label
     */
    public ChromatogramPanel(double[] aXAxisData, double[] aYAxisData, String aXAxisLabel, String aYAxisLabel) {
        this(aXAxisData, aYAxisData, aXAxisLabel, aYAxisLabel, null);
    }

    /**
     * This constructor creates a ChromatogramPanel based on the passed parameters. This constructor assumes
     * profileChromatogram data rather than spectrum data. (For profile spectrum data use the SpectrumPanel class
     * instead and set ProfileMode to 'true'.)
     *
     * @param aXAxisData  double[] with all the X axis data.
     * @param aYAxisData  double[] with all the Y axis data.
     * @param aXAxisLabel String with the label for the x-axis (can have a unit
     *                    between brackets, if available) - can be 'null' for no label
     * @param aYAxisLabel String with the label for the y-axis (can have a unit
     *                    between brackets, if available) - can be 'null' for no label
     * @param aPointSize  Integer with the point size to use
     */
    public ChromatogramPanel(double[] aXAxisData, double[] aYAxisData, String aXAxisLabel, String aYAxisLabel,
            Integer aPointSize) {
        this(aXAxisData, aYAxisData, aXAxisLabel, aYAxisLabel, aPointSize, true);
    }

    /**
     * This constructor creates a ChromatogramPanel based on the passed parameters. This constructor assumes
     * profileChromatogram data rather than spectrum data. (For profile spectrum data use the SpectrumPanel class
     * instead and set ProfileMode to 'true'.)
     *
     * @param aXAxisData          double[] with all the X axis data.
     * @param aYAxisData          double[] with all the Y axis data.
     * @param aXAxisLabel         String with the label for the x-axis (can have a unit
     *                            between brackets, if available) - can be 'null' for no label
     * @param aYAxisLabel         String with the label for the y-axis (can have a unit
     *                            between brackets, if available) - can be 'null' for no label
     * @param aPointSize          Integer with the point size to use
     * @param profileChromatogram If true, the profileChromatogram will be drawn with connected peaks, if false, only
     *                            the peaks themselves are drawn. Note that profile mode is not recommended when the
     *                            peak count is high as the drawing will be slow.
     */
    public ChromatogramPanel(double[] aXAxisData, double[] aYAxisData, String aXAxisLabel, String aYAxisLabel,
            Integer aPointSize, boolean profileChromatogram) {

        // if point size is given, update the point size, otherwise keep the default point size
        if (aPointSize != null) {
            this.setPointSize(aPointSize);
        }

        this.currentGraphicsPanelType = GraphicsPanelType.centroidChromatogram;

        dataSetCounter = 0;
        initData(aXAxisData, aYAxisData, aXAxisLabel, aYAxisLabel);
        this.iSpecPanelListeners = new ArrayList<>();
        this.addListeners();
    }

    /**
     * This method wraps all the shared logic of the various constructors.
     *
     * @param aXAxisData  double[] with all the X axis data.
     * @param aYAxisData  double[] with all the Y axis data.
     * @param aXAxisLabel String with the label for the x-axis (can have a unit
     *                    between brackets, if available) - can be 'null' for no label
     * @param aYAxisLabel String with the label for the y-axis (can have a unit
     *                    between brackets, if available) - can be 'null' for no label
     */
    private void initData(double[] aXAxisData, double[] aYAxisData, String aXAxisLabel, String aYAxisLabel) {
        this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        this.setBackground(Color.WHITE);
        processXAndYData(aXAxisData, aYAxisData, iChromatogramColor, iChromatogramPointColor);
        this.iXAxisLabel = (aXAxisLabel == null ? "unknown" : aXAxisLabel);
        this.iYAxisLabel = (aYAxisLabel == null ? "unknown" : aYAxisLabel);
    }

    /**
     * Adds an additional profileChromatogram dataset to be displayed in the same Chromatogram Panel. Remember to use
     * different colors for the different datasets.
     *
     * @param aXAxisData            double[] with all the x-axis values.
     * @param aYAxisData            double[] with all the y-axis values
     * @param dataPointAndLineColor the color to use for the data points and lines
     * @param areaUnderCurveColor   the color to use for the area under the curve
     */
    public void addAdditionalDataset(double[] aXAxisData, double[] aYAxisData, Color dataPointAndLineColor,
            Color areaUnderCurveColor) {

        processXAndYData(aXAxisData, aYAxisData, dataPointAndLineColor, areaUnderCurveColor);

        this.showFileName = false;
        this.showPrecursorDetails = false;
        this.showResolution = false;
    }

    /**
     * This method allows the caller to set the point size for the profileChromatogram. <b>Note</b> that this number
     * needs to be even, so any uneven number will be replaced by the closest, lower, even integer
     * (e.g., 5 becomes 4, 13 becomes 12).
     *
     * @param aPointSize int with the point size, that will be reduced to the closest, lower even integer (e.g., 5
     *                   becomes 4, 13 becomes 12).
     */
    public void setPointSize(Integer aPointSize) {
        if (aPointSize % 2 != 0) {
            aPointSize--;
        }
        iPointSize = aPointSize;
    }

    /**
     * Set the drawing style to profile or centroid mode. Profile mode draws lines between the peaks while centroid
     * mode only draws the peaks. Profile mode is only recommended for datasets with low number of peaks, as it can
     * be slow on bigger datasets.
     *
     * @param profileMode true if use profile mode
     */
    public void setProfileMode(boolean profileMode) {
        if (profileMode) {
            this.currentGraphicsPanelType = GraphicsPanelType.profileChromatogram;
        } else {
            this.currentGraphicsPanelType = GraphicsPanelType.centroidChromatogram;
        }
    }
}
