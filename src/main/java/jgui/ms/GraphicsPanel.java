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
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;

/**
 * This class presents a JPanel that will hold and display a mass spectrum or a chromatogram.
 *
 * @author JiaweiMao
 * @version 1.00
 * @date Jun 01 2016, 13:46
 */
public abstract class GraphicsPanel extends JPanel {

    /**
     * The width used for the annotated peaks.
     */
    private float peakWidth = 1.0f;
    /**
     * The width used for the background peaks.
     */
    private float backgroundPeakWidth = 1.0f;
    /**
     * If true, all numbers in peak annotations are sub-scripted.
     */
    private boolean subscriptAnnotationNumbers = true;
    /**
     * The color to use for the non-annotated peaks when only the annotated
     * peaks are to be shown.
     */
    private Color peakWaterMarkColor = new Color(100, 100, 100, 50);
    /**
     * If true the x-axis will be drawn using the scientific annotation. The
     * pattern i set in the "scientificPattern" field.
     */
    private boolean scientificXAxis = false;
    /**
     * If true the y-axis will be drawn using the scientific annotation. The
     * pattern i set in the "scientificPattern" field.
     */
    private boolean scientificYAxis = false;
    /**
     * The number format pattern for scientific annotation.
     */
    private String scientificPattern = "##0.#####E0";
    /**
     * A hashmap of the current x-axis reference areas. Key is the name of the
     * reference area.
     */
    private HashMap<String, ReferenceArea> referenceAreasXAxis = new HashMap<>();
    /**
     * A hashmap of the current y-axis reference areas. Key is the name of the
     * reference area.
     */
    private HashMap<String, ReferenceArea> referenceAreasYAxis = new HashMap<>();
    /**
     * If set to true, the y-axis is removed, the y- and x-axis tags are removed, and any annotations are hidden. All
     * to make the graphics panel look better in a smaller version, e.g., when put into a table cell. When turning
     * miniature mode one it is also recommended to reduce the max padding.
     * <p>
     * Note that miniature and reduced max padding is set automatically by the GraphicsPanelTableCellRenderer.
     */
    protected boolean miniature = false;
    /**
     * If set to true, all y data is assumed to be positive. This adds a white polygon under the y-axis hiding any
     * polygon data lines that crosses (slightly) below the y-axis.
     */
    protected boolean yDataIsPositive = true;
    /**
     * The opacity of the spectra. 0 means completely see-through, 1 means opaque.
     */
    protected float alphaLevel = 0.3f;
    /**
     * The number of datasets currently displayed in the panel.
     */
    protected int dataSetCounter = 0;
    /**
     * The number of mirrored datasets currently displayed in the panel.
     */
    protected int dataSetCounterMirroredSpectra = 0;
    /**
     * This status indicates that no annotation will be displayed, but the user will have a fully functional
     * interface (point clicking, selecting, sequencing etc.)
     */
    public final int INTERACTIVE_STATUS = 0;
    /**
     * This status indicates that annotation (if present) will be displayed, while limiting the user to zooming in/out.
     */
    public final int ANNOTATED_STATUS = 1;
    /**
     * This HashMap instance holds all the known mass deltas (if any). The keys are the Doubles with the massdelta,
     * the values are the descriptions.
     */
    protected static HashMap<Double, String> iKnownMassDeltas = null; // @TODO: should not be static!
    /**
     * If true, pairs of delta mass annotations are used when doing de novo
     * sequencing. If false, only single delta masses are annotated.
     */
    private boolean useMassDeltaCombinations = true;

    // Static init block takes care of reading the 'SpectrumPanel.properties'
    // file if it hasn't already been done.
    static {
        try {
            if (iKnownMassDeltas == null) {
                iKnownMassDeltas = new HashMap<>();
                Properties temp = new Properties();
                InputStream is = GraphicsPanel.class.getClassLoader().getResourceAsStream("SpectrumPanel.properties");
                if (is != null) {
                    temp.load(is);
                    is.close();
                    for (Object o : temp.keySet()) {
                        String key = (String) o;
                        iKnownMassDeltas.put(new Double(key), temp.getProperty(key));
                    }
                }
            }
        } catch (Exception e) {
            // Do nothing. So now masses will be known.
        }
    }

    /**
     * The size of the window to use when searching for matches in the known masses list when the user hovers over a
     * second data point after clicking a previous data point.
     */
    protected double deltaMassWindow = 0.2;
    /**
     * The label (and unit between brackets, if available) for the x-axis. Defaults to "m/z".
     */
    protected String iXAxisLabel = "m/z";
    /**
     * The label (and unit between brackets, if available) for the y-axis. Defaults to "Int".
     */
    protected String iYAxisLabel = "Int";
    /**
     * This is the color the filename should be presented in.
     */
    protected Color iFilenameColor = null;
    /**
     * Colors in which the data points and peaks are rendered. Indexed by dataset.
     */
    protected ArrayList<Color> iDataPointAndLineColor = new ArrayList<>();
    /**
     * Colors in which the data points and peaks are rendered for the mirrored spectra. Indexed by dataset.
     */
    protected ArrayList<Color> iDataPointAndLineColorMirroredSpectra = new ArrayList<>();
    /**
     * Colors in which the chromatogram polyline is rendered. Indexed by dataset.
     */
    protected ArrayList<Color> iAreaUnderCurveColor = new ArrayList<>();
    /**
     * Colors in which the chromatogram polyline is rendered for the mirrored spectra. Indexed by dataset.
     */
    protected ArrayList<Color> iAreaUnderCurveColorMirroredSpectra = new ArrayList<>();
    /**
     * Size for the point on a polygon.
     */
    protected Integer iPointSize = 0;
    /**
     * The spectrum or chromatogram filename.
     */
    protected String iFilename = null;
    /**
     * The spectrum or chromatogram filename for the mirrored spectrum or
     * chromatogram.
     */
    protected String iFilenameMirrorredSpectrum = null;
    /**
     * The list of SpectrumPanelListeners.
     */
    protected ArrayList iSpecPanelListeners = new ArrayList();
    /**
     * The deviation (both left and right) allowed for point highlighting detection.
     */
    protected int iPointDetectionTolerance = 5;
    /**
     * When the mouse is dragged, this represents the X-coordinate of the starting location.
     */
    protected int iStartXLoc = 0;
    /**
     * When the mouse is dragged, this represents the Y-coordinate of the starting location.
     */
    protected int iStartYLoc = 0;
    /**
     * When the mouse is dragged, this represents the X-coordinate of the ending location.
     */
    protected int iEndXLoc = 0;
    /**
     * The lower range for the current zoom range.
     */
    protected double xAxisZoomRangeLowerValue = 0;
    /**
     * The upper range for the current zoom range.
     */
    protected double xAxisZoomRangeUpperValue = 0;
    /**
     * The current dragging location.
     */
    protected int iDragXLoc = 0;
    /**
     * Scale unit for the X axis.
     */
    protected double iXScaleUnit = 0.0;
    /**
     * Scale unit for the Y axis.
     */
    protected double iYScaleUnit = 0.0;
    /**
     * Graphical unit for the X axis.
     */
    protected int iXUnit = 0;
    /**
     * Graphical unit for the Y axis.
     */
    protected int iYUnit = 0;
    /**
     * Effective distance from the x-axis to the panel border.
     */
    protected int iXPadding = 0;
    /**
     * Effective distance from the panel top border to 5 pixels above the top of the highest point (or y-tick mark).
     */
    protected int iTopPadding = 0;
    /**
     * This boolean is set to 'true' if the x-axis should start at zero.
     */
    protected boolean iXAxisStartAtZero = true;
    /**
     * This boolean is set to 'true' when dragging is performed.
     */
    protected boolean iDragged = false;
    /**
     * The number of X-axis tags.
     */
    protected int xTagCount = 10;
    /**
     * The number of Y-axis tags.
     */
    protected int yTagCount = 10;
    /**
     * The padding (distance between the axes and the border of the panel).
     */
    protected int padding = 20;
    /**
     * The current padding (distance between the axes and the border of the panel).
     */
    protected int currentPadding = 20;
    /**
     * The maximum padding (distance between the axes and the border of the panel). Increase if font size on the
     * y-axis becomes too small.
     */
    protected int maxPadding = 50;
    /**
     * The boolean is set to 'true' if the file name is to be shown in the panel.
     */
    protected boolean showFileName = true;
    /**
     * The boolean is set to 'true' if the precursor details is to be shown in
     * the panel.
     */
    protected boolean showPrecursorDetails = true;
    /**
     * The boolean is set to 'true' if the resolution is to be shown in the panel.
     */
    protected boolean showResolution = true;
    /**
     * All the x-axis data points. Indexed by dataset (one double[] per dataset). First dataset is the first
     * double[], second dataset is the second double[] etc.Should at all times be sorted from high to low.
     */
    protected ArrayList<double[]> iXAxisData = null;
    /**
     * All the y-axis values. Indexed by dataset (one double[] per dataset). First dataset is the first double[],
     * second dataset is the second double[] etc. Y-axis values are related to the x-axis values by the table index.
     * So the first y-axis value of the first dataset is the value for the first x-axis value in the first dataset etc.
     */
    protected ArrayList<double[]> iYAxisData = null;

    /**
     * All the x-axis data points for the mirrored spectrum. Indexed by dataset (one double[] per dataset). First
     * dataset is the first double[], second dataset is the second double[] etc.Should at all times be sorted from
     * high to low.
     */
    protected ArrayList<double[]> iXAxisDataMirroredSpectrum = null;
    /**
     * All the y-axis values for the mirrored spectra. Indexed by dataset (one double[] per dataset). First dataset
     * is the first double[], second dataset is the second double[] etc. Y-axis values are related to the x-axis
     * values by the table index. So the first y-axis value of the first dataset is the value for the first x-axis
     * value in the first dataset etc.
     */
    protected ArrayList<double[]> iYAxisDataMirroredSpectrum = null;
    /**
     * The minimum x-axis value to display.
     */
    protected double iXAxisMin = 0.0;
    /**
     * The maximum x-axis value to display.
     */
    protected double iXAxisMax = 0.0;
    /**
     * The minimum y-axis value to display.
     */
    protected double iYAxisMin = 0.0;
    /**
     * The maximum y-axis value to display.
     */
    protected double iYAxisMax = 0.0;
    /**
     * The percent non-inclusive, minimal y-axis value (compared to the highest point in the spectrum) a point should
     * have before being eligible for annotation. Default is '0.0'.
     */
    protected double iAnnotationYAxisThreshold = 0.0;

    /**
     * This variable holds the precursor M/Z.
     */
    protected double iPrecursorMZ = 0.0;
    /**
     * This variable holds the precursor M/Z for the mirrored spectrum.
     */
    protected double iPrecursorMZMirroredSpectrum = 0.0;
    /**
     * This String holds the charge for the precursor.
     */
    protected String iPrecursorCharge = null;
    /**
     * This String holds the charge for the precursor for the mirrored spectrum.
     */
    protected String iPrecursorChargeMirorredSpectrum = null;
    /**
     * This array will hold the x-coordinates in pixels for all the x-axis
     * values. Link is through index. Again indexed by dataset (one double[] per
     * dataset).
     */
    protected ArrayList<int[]> iXAxisDataInPixels = null;
    /**
     * This array will hold the y-coordinates in pixels for all the y-axis
     * values. Link is through index. Again indexed by dataset (one double[] per
     * dataset).
     */
    protected ArrayList<int[]> iYAxisDataInPixels = null;
    /**
     * This array will hold the x-coordinates in pixels for all the x-axis
     * values of the mirrored spectrum. Link is through index. Again indexed by
     * dataset (one double[] per dataset).
     */
    protected ArrayList<int[]> iXAxisDataInPixelsMirroredSpectrum = null;
    /**
     * This array will hold the y-coordinates in pixels for all the y-axis
     * values of the mirrored spectrum. Link is through index. Again indexed by
     * dataset (one double[] per dataset).
     */
    protected ArrayList<int[]> iYAxisDataInPixelsMirroredSpectrum = null;
    /**
     * Boolean that will be 'true' when a point needs highlighting.
     */
    protected boolean iHighLight = false;
    /**
     * Boolean that will be 'true' when a point needs highlighting in the mirrored spectra.
     */
    protected boolean iHighLightMirrored = false;
    /**
     * Index of the point that needs to be highlighted.
     */
    protected int iHighLightIndex = 0;
    /**
     * Index of the point that needs to be highlighted in the mirrored spectra.
     */
    protected int iHighLightIndexMirrored = 0;
    /**
     * Index of the dataset containing the point that needs to be highlighted.
     */
    protected int iHighLightDatasetIndex = 0;
    /**
     * Index of the dataset containing the point that needs to be highlighted in the mirrored spectra.
     */
    protected int iHighLightDatasetIndexMirrored = 0;
    /**
     * Boolean that indicates whether a point has been marked by clicking.
     */
    protected boolean iClicked = false;
    /**
     * Boolean that indicates whether a point has been marked by clicking in the mirrored spectra.
     */
    protected boolean iClickedMirrored = false;
    /**
     * Int that indicates which point was clicked.
     */
    protected int iClickedIndex = 0;
    /**
     * Int that indicates which point was clicked in the mirrored spectra.
     */
    protected int iClickedIndexMirrored = 0;
    /**
     * Int that indicates which dataset contains the clicked point.
     */
    protected int iClickedDataSetIndex = 0;
    /**
     * Int that indicates which dataset contains the clicked point in the
     * mirrored spectra.
     */
    protected int iClickedDataSetIndexMirrored = 0;
    /**
     * The Vector that holds all points clicked up to now.
     */
    protected Vector iClickedList = new Vector(15, 5);
    /**
     * The Vector that holds all points clicked up to now in the mirrored spectra.
     */
    protected Vector iClickedListMirrored = new Vector(15, 5);
    /**
     * The Vector that holds the dataset indices of all points clicked up to now.
     */
    protected Vector iClickedListDatasetIndices = new Vector(15, 5);
    /**
     * The Vector that holds the dataset indices of all points clicked up to now in the mirrored spectra.
     */
    protected Vector iClickedListDatasetIndicesMirrored = new Vector(15, 5);
    /**
     * The Vector that holds a set of stored points from a previously established list.
     */
    protected Vector iStoredSequence = new Vector(15, 5);
    /**
     * The Vector that holds a set of stored points from a previously established list in the mirrored spectra.
     */
    protected Vector iStoredSequenceMirrored = new Vector(15, 5);
    /**
     * The Vector that holds the dataset indices of stored points from a previously established list.
     */
    protected Vector iStoredSequenceDatasetIndices = new Vector(15, 5);
    /**
     * The Vector that holds the dataset indices of stored points from a previously established list in the mirrored
     * spectra.
     */
    protected Vector iStoredSequenceDatasetIndicesMirrored = new Vector(15, 5);
    /**
     * The Vector that holds a set of Annotation instances.
     */
    protected Vector<SpectrumAnnotation> iAnnotations = new Vector<>(50, 20);
    /**
     * The Vector that holds a set of Annotation instances for the mirrored spectra.
     */
    protected Vector<SpectrumAnnotation> iAnnotationsMirroredSpectra = new Vector<>(50, 20);
    /**
     * Minimal dragging distance in pixels.
     */
    protected int iMinDrag = 15;
    /**
     * This variable holds the current drawing style.
     */
    protected DrawingStyle iCurrentDrawStyle = DrawingStyle.LINES;
    /**
     * This variable holds the dot radius; only used when drawing style is DOTS style.
     */
    protected int iDotRadius = 2;

    /**
     * An enumerator of the possible GraphicsPanel types.
     */
    public enum DrawingStyle {

        /**
         * Draw lines connecting the X-axis with the measurement
         */
        LINES,
        /**
         * Draw a dot at the measurement height.
         */
        DOTS
    }

    /**
     * The ms level of the current spectrum. O is assumed to mean no ms level given.
     */
    protected int iMSLevel = 0;
    /**
     * If false, only the annotated peaks will be shown. Note that this setting is ignored in profile mode!
     */
    protected boolean showAllPeaks = true;
    /**
     * If true, the automatic y-axis zoom excludes the background peaks. False includes all peaks in the zoom.
     */
    protected boolean yAxisZoomExcludesBackgroundPeaks = false;
    /**
     * If more than one peak is within the accuracy range of an annotation setting this to true will always select
     * the most intense of possible peaks. Setting this variable to false will instead select the most accurate peak.
     */
    protected boolean annotateHighestPeak = true;

    /**
     * Returns true if the most intense of possible peaks to annotate is to be selected, false if the most accurate
     * is to be selected.
     *
     * @return true if the most intense of possible peaks to annotate is to be selected, false if the most accurate
     * is to be selected
     */
    public boolean isAnnotateHighestPeak() {
        return annotateHighestPeak;
    }

    /**
     * Set if the most intense of possible peaks to annotate is to be selected, false if the most accurate is to be
     * selected.
     *
     * @param annotateHighestPeak if the most intense of possible peaks to annotate is to be selected, false if the
     *                            most accurate is to be selected
     */
    public void setAnnotateHighestPeak(boolean annotateHighestPeak) {
        this.annotateHighestPeak = annotateHighestPeak;
    }

    /**
     * Returns true if the numbers in the peak annotations are to be subscripted.
     *
     * @return true if the numbers in the peak annotations are to be subscripted
     */
    public boolean isSubscriptAnnotationNumbers() {
        return subscriptAnnotationNumbers;
    }

    /**
     * Set if the numbers in the peak annotations are to be subscripted.
     *
     * @param subscriptAnnotationNumbers set if the numbers in the peak annotations are to be subscripted
     */
    public void setSubscriptAnnotationNumbers(boolean subscriptAnnotationNumbers) {
        this.subscriptAnnotationNumbers = subscriptAnnotationNumbers;
    }

    /**
     * Returns true if the automatic y-axis zoom excludes background peaks.
     * False if includes all peaks.
     *
     * @return true if the automatic y-axis zoom only excludes background peaks
     */
    public boolean yAxisZoomOnlyExcludesBackgroundPeaks() {
        return yAxisZoomExcludesBackgroundPeaks;
    }

    /**
     * Set if the automatic y-axis zoom only considers the annotated peaks.
     *
     * @param yAxisZoomExcludesBackgroundPeaks if the automatic y-axis zoom only considers the annotated peaks
     */
    public void setYAxisZoomExcludesBackgroundPeaks(boolean yAxisZoomExcludesBackgroundPeaks) {
        this.yAxisZoomExcludesBackgroundPeaks = yAxisZoomExcludesBackgroundPeaks;
    }

    /**
     * If true, pairs of delta mass annotations are used when doing de novo sequencing. If false, only single delta
     * masses are annotated.
     *
     * @return the useMassDeltaCombinations if pairs of delta mass annotations are used when doing de novo sequencing
     */
    public boolean useMassDeltaCombinations() {
        return useMassDeltaCombinations;
    }

    /**
     * If true, pairs of delta mass annotations are used when doing de novo
     * sequencing. If false, only single delta masses are annotated.
     *
     * @param useMassDeltaCombinations the useMassDeltaCombinations to set
     */
    public void setUseMassDeltaCombinations(boolean useMassDeltaCombinations) {
        this.useMassDeltaCombinations = useMassDeltaCombinations;
    }

    /**
     * Returns true of the precursor details are to be shown.
     *
     * @return true of the precursor details are to be show
     */
    public boolean showPrecursorDetails() {
        return showPrecursorDetails;
    }

    /**
     * Set whether the precursor details are to be shown.
     *
     * @param showPrecursorDetails the showPrecursorDetails to set
     */
    public void setShowPrecursorDetails(boolean showPrecursorDetails) {
        this.showPrecursorDetails = showPrecursorDetails;
    }

    /**
     * Returns true if the resolution is to be shown.
     *
     * @return true of the resolution is to be shown
     */
    public boolean showResolution() {
        return showResolution;
    }

    /**
     * Set whether the resolution is to be shown.
     *
     * @param showResolution the showResolution to set
     */
    public void setShowResolution(boolean showResolution) {
        this.showResolution = showResolution;
    }

    /**
     * An enumerator of the possible GraphicsPanel types.
     */
    protected enum GraphicsPanelType {

        profileSpectrum,
        centroidSpectrum,
        profileChromatogram,
        centroidChromatogram,
        isotopicDistributionCentroid,
        isotopicDistributionProfile
    }

    /**
     * Sets the current GraphicsPanel type, default to centroid spectrum.
     */
    protected GraphicsPanelType currentGraphicsPanelType = GraphicsPanelType.centroidSpectrum;

    /**
     * Returns true of all the y-data is to be assumed as positive.
     *
     * @return true of all the y-data is to be assumed as positive
     */
    public boolean yDataIsPositive() {
        return yDataIsPositive;
    }

    /**
     * Set to true of all y data values can be assumed to be positive.
     *
     * @param yDataIsPositive true of all y data values can be assumed to be positive
     */
    public void setYDataIsPositive(boolean yDataIsPositive) {
        this.yDataIsPositive = yDataIsPositive;
    }

    /**
     * Returns true if the graphics panel is to be drawn in a miniature form.
     *
     * @return true if the graphics panel is to be drawn in a miniature form
     */
    public boolean isMiniature() {
        return miniature;
    }

    /**
     * Set if the graphics panel is to be drawn in a miniature form.
     *
     * @param miniature if the spectrum is to be drawn in a miniature form
     */
    public void setMiniature(boolean miniature) {
        this.miniature = miniature;
    }

    /**
     * Returns the lower range for the current zoom range.
     *
     * @return the lower range for the current zoom range
     */
    public double getXAxisZoomRangeLowerValue() {
        return xAxisZoomRangeLowerValue;
    }

    /**
     * Returns the upper range for the current zoom range.
     *
     * @return the upper range for the current zoom range
     */
    public double getXAxisZoomRangeUpperValue() {
        return xAxisZoomRangeUpperValue;
    }

    /**
     * Get the size of the window to use when searching for matches in the known
     * masses list when the user hovers over a second data point after clicking
     * a previous data point.
     *
     * @return the size of the delta mass window
     */
    public double getDeltaMassWindow() {
        return deltaMassWindow;
    }

    /**
     * Set the size of the window to use when searching for matches in the known
     * masses list when the user hovers over a second data point after clicking
     * a previous data point.
     *
     * @param deltaMassWindow the new size of the delta mass window
     */
    public void setDeltaMassWindow(double deltaMassWindow) {
        this.deltaMassWindow = deltaMassWindow;
    }

    /**
     * Get all the known mass deltas (if any). The keys are the Doubles with the massdelta, the values are the
     * descriptions.
     *
     * @return HashMap of the known mass deltas
     */
    public static HashMap<Double, String> getKnownMassDeltas() {
        return iKnownMassDeltas;
    }

    /**
     * Set all the known mass deltas (if any). The keys are the Doubles with the
     * massdelta, the values are the descriptions.
     *
     * @param aiKnownMassDeltas the HasMap of the known mass deltas
     */
    public static void setKnownMassDeltas(HashMap<Double, String> aiKnownMassDeltas) {
        iKnownMassDeltas = aiKnownMassDeltas;
    }

    /**
     * Returns the x-axis data.
     *
     * @return the x-axis data
     */
    public ArrayList<double[]> getXAxisData() {
        return iXAxisData;
    }

    /**
     * Returns the y-axis data.
     *
     * @return the y-axis data
     */
    public ArrayList<double[]> getYAxisData() {
        return iYAxisData;
    }

    /**
     * Returns the alpha level.
     *
     * @return the alphaLevel
     */
    public float getAlphaLevel() {
        return alphaLevel;
    }

    /**
     * Sets the alpha level
     *
     * @param alphaLevel the alphaLevel to set
     */
    public void setAlphaLevel(float alphaLevel) {
        this.alphaLevel = alphaLevel;
    }

    /**
     * This method sets the start value of the x-axis to zero.
     *
     * @param aXAxisStartAtZero if true the x axis starts at zero
     */
    public void setXAxisStartAtZero(boolean aXAxisStartAtZero) {
        iXAxisStartAtZero = aXAxisStartAtZero;
    }

    /**
     * Set the max padding (distance between the axes and the border of the
     * panel).
     *
     * @param aMaxPadding the new max padding
     */
    public void setMaxPadding(int aMaxPadding) {
        maxPadding = aMaxPadding;
    }

    /**
     * Returns the max padding (distance between the axes and the border of the
     * panel).
     *
     * @return the max padding
     */
    public int getMaxPadding() {
        return maxPadding;
    }

    /**
     * Returns the current width of the peaks.
     *
     * @return the peak width
     */
    public float getPeakWidth() {
        return peakWidth;
    }

    /**
     * Set the peak width.
     *
     * @param peakWidth the new peak width
     */
    public void setPeakWidth(float peakWidth) {
        this.peakWidth = peakWidth;
    }

    /**
     * Returns the current width of the background peaks.
     *
     * @return the peak width
     */
    public float getBackgroundPeakWidth() {
        return backgroundPeakWidth;
    }

    /**
     * Set the backgroundPeakWidth peak width.
     *
     * @param backgroundPeakWidth the new backgroundPeakWidth peak width
     */
    public void setBackgroundPeakWidth(float backgroundPeakWidth) {
        this.backgroundPeakWidth = backgroundPeakWidth;
    }

    /**
     * This method sets all the annotations on this instance. Passing a 'null' value for the Vector will result in
     * simply removing all annotations. Do note that this method will attempt to remove duplicate annotations on a
     * point by deleting any annotation for which the combination of annotation label and annotation x-axis value has
     * been seen before!
     *
     * @param aAnnotations        Vector with SpectrumAnnotation instances.
     * @param annotateHighestPeak boolean indicating if the most intense peak within the accuracy range (true) or the
     *                            most accurate peak (false) is to be annotated
     */
    public void setAnnotations(java.util.List<SpectrumAnnotation> aAnnotations, boolean annotateHighestPeak) {
        this.annotateHighestPeak = annotateHighestPeak;
        setAnnotations(aAnnotations);
    }

    /**
     * This method sets all the annotations on this instance. Passing a 'null' value for the Vector will result in
     * simply removing all annotations. Do note that this method will attempt to remove duplicate annotations on a
     * point by deleting any annotation for which the combination of annotation label and annotation x-axis value has
     * been seen before!
     *
     * @param aAnnotations Vector with SpectrumAnnotation instances.
     */
    public void setAnnotations(java.util.List<SpectrumAnnotation> aAnnotations) {
        this.iAnnotations = new Vector<>(50, 25);
        if (aAnnotations != null) {
            // Attempt to remove duplicates.
            HashSet<String> removeDupes = new HashSet<>(aAnnotations.size());
            for (SpectrumAnnotation annotation : aAnnotations) {
                String key = annotation.getLabel() + annotation.getMZ();
                if (!removeDupes.contains(key)) {
                    removeDupes.add(key);
                    this.iAnnotations.add(annotation);
                }
            }
        }
    }

    /**
     * This method sets all the annotations for the mirrored spectra. Passing a 'null' value for the Vector will
     * result in simply removing all annotations. Do note that this method will attempt to remove duplicate
     * annotations on a point by deleting any annotation for which the combination of annotation label and annotation
     * x-axis value has been seen before!
     *
     * @param aAnnotations        Vector with SpectrumAnnotation instances
     * @param annotateHighestPeak boolean indicating if the most intense peak within the accuracy range (true) or the
     *                            most accurate peak (false) is to be annotated
     */
    public void setAnnotationsMirrored(java.util.List<SpectrumAnnotation> aAnnotations, boolean annotateHighestPeak) {
        this.annotateHighestPeak = annotateHighestPeak;
        setAnnotationsMirrored(aAnnotations);
    }

    /**
     * This method sets all the annotations for the mirrored spectra. Passing a 'null' value for the Vector will
     * result in simply removing all annotations. Do note that this method will attempt to remove duplicate
     * annotations on a point by deleting any annotation for which the combination of annotation label and annotation
     * x-axis value has been seen before!
     *
     * @param aAnnotations Vector with SpectrumAnnotation instances
     */
    public void setAnnotationsMirrored(java.util.List<SpectrumAnnotation> aAnnotations) {
        this.iAnnotationsMirroredSpectra = new Vector(50, 25);
        if (aAnnotations != null) {
            // Attempt to remove duplicates.
            HashSet<String> removeDupes = new HashSet<>(aAnnotations.size());
            for (SpectrumAnnotation annotation : aAnnotations) {
                String key = annotation.getLabel() + annotation.getMZ();
                if (!removeDupes.contains(key)) {
                    removeDupes.add(key);
                    this.iAnnotationsMirroredSpectra.add(annotation);
                }
            }
        }
    }

    /**
     * This method allows the caller to set the minimal non-inclusive y-axis value threshold in percent (compared to
     * the highest point in the spectrum or chromatogram) a point must pass before being eligible for annotation.
     *
     * @param aThreshold double with the minimal y-axis value in percent (as compared to the highest point in the
     *                   spectrum or chromatogram) cutoff threshold for annotation.
     */
    public void setAnnotationYAxisThreshold(double aThreshold) {
        this.iAnnotationYAxisThreshold = (aThreshold / 100) * iYAxisMax;
    }

    /**
     * This method sets the display color for the filename on the panel. Can be 'null' for default coloring.
     *
     * @param aFilenameColor Color to render the filename in on the panel. Can be 'null' for default coloring.
     */
    public void setFilenameColor(Color aFilenameColor) {
        iFilenameColor = aFilenameColor;
    }

    /**
     * Returns the minimum value of the x-axis.
     *
     * @return the minimum the axis value
     */
    public double getXAxisMin() {
        return iXAxisMin;
    }

    /**
     * Sets the minimum value for the x-axis.
     *
     * @param aXAxisMin double with the minimum x-axis value
     */
    public void setXAxisMin(double aXAxisMin) {
        this.iXAxisMin = aXAxisMin;
    }

    /**
     * Returns the maximum value of the x-axis.
     *
     * @return the maximum x axis value
     */
    public double getXAxisMax() {
        return iXAxisMax;
    }

    /**
     * Sets the maximum value for the x-axis.
     *
     * @param aXAxisMax double with the maximum x-axis value
     */
    public void setXAxisMax(double aXAxisMax) {
        this.iXAxisMax = aXAxisMax;
    }

    /**
     * Returns the minimum value of the y-axis.
     *
     * @return the minimum y axis value
     */
    public double getYAxisMin() {
        return iYAxisMin;
    }

    /**
     * Sets the minimum value for the y-axis.
     *
     * @param aYAxisMin double with the minimum y-axis value
     */
    public void setYAxisMin(double aYAxisMin) {
        this.iYAxisMin = aYAxisMin;
    }

    /**
     * Returns the maximum value of the y-axis.
     *
     * @return the maximum y axis value
     */
    public double getYAxisMax() {
        return iYAxisMax;
    }

    /**
     * Sets the maximum value for the y-axis.
     *
     * @param aYAxisMax double with the maximum y-axis value
     */
    public void setYAxisMax(double aYAxisMax) {
        this.iYAxisMax = aYAxisMax;
    }

    @Override
    public void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	 if (iXAxisData != null) {
             if (iDragged && iDragXLoc > 0) {
                 g.drawLine(iStartXLoc, iStartYLoc, iDragXLoc, iStartYLoc);
                 g.drawLine(iStartXLoc, iStartYLoc - 2, iStartXLoc, iStartYLoc + 2);
                 g.drawLine(iDragXLoc, iStartYLoc - 2, iDragXLoc, iStartYLoc + 2);
             }

             // round the range of the x- and y-axis to integer values
             iXAxisMin = (int) Math.floor(iXAxisMin); // @TODO: increase the zooming resolution!!!
             iXAxisMax = (int) Math.ceil(iXAxisMax);
             iYAxisMin = (int) Math.floor(iYAxisMin);
             iYAxisMax = (int) Math.ceil(iYAxisMax);

             // draw the x and y axis
             drawAxes(g, iXAxisMin, iXAxisMax, 2, iYAxisMin, iYAxisMax);// @TODO: scale?

             // add reference areas that are to be drawn in the back, if any
             drawYAxisReferenceAreas(g, false);
             drawXAxisReferenceAreas(g, false);

             // draw the peaks
             if (currentGraphicsPanelType.equals(GraphicsPanelType.profileChromatogram)
                     || currentGraphicsPanelType.equals(GraphicsPanelType.profileSpectrum)
                     || currentGraphicsPanelType.equals(GraphicsPanelType.isotopicDistributionProfile)) {
                 drawFilledPolygon(g);
             } else {
                 drawPeaks(g);
                 if (dataSetCounterMirroredSpectra > 0) {
                     drawMirroredPeaks(g);
                 }
             }

             // draw any measurement lines in the normal spectra
             if (iClicked && iHighLight && iClickedIndex != iHighLightIndex) {
                 // Now we should calculate the distance based on the real values and draw a line to show this.
                 this.drawMeasurementLine(iClickedIndex, iClickedDataSetIndex, iHighLightIndex, iHighLightDatasetIndex,
                         g, Color.blue, 0, false);
             }

             // draw any measurement lines in the mirrored spectra
             if (iClickedMirrored && iHighLightMirrored && iClickedIndexMirrored != iHighLightIndexMirrored) {
                 // Now we should calculate the distance based on the real values and draw a line to show this.
                 this.drawMeasurementLine(iClickedIndexMirrored, iClickedDataSetIndexMirrored, iHighLightIndexMirrored,
                         iHighLightDatasetIndexMirrored, g, Color.blue, 0, true);
             }

             // hihlight peaks
             if (iHighLight) {
                 this.highLightPeak(iHighLightIndex, iHighLightDatasetIndex, g, false);
                 iHighLight = false;
             }

             // highlight mirrored peaks
             if (iHighLightMirrored) {
                 this.highLightPeak(iHighLightIndexMirrored, iHighLightDatasetIndexMirrored, g, true);
                 iHighLightMirrored = false;
             }

             // highlight clicked peaks
             if (iClicked) {
                 this.highlightClicked(iClickedIndex, iHighLightDatasetIndex, g, false);
             }

             // highlight clicked mirrored peaks
             if (iClickedMirrored) {
                 this.highlightClicked(iClickedIndexMirrored, iHighLightDatasetIndexMirrored, g, true);
             }

             // see if there are daisychain to display
             drawDaisyChain(g, iClickedList, iClickedListDatasetIndices, iClickedIndex, iClickedDataSetIndex,
                     iStoredSequence, iStoredSequenceDatasetIndices, false);

             // see if there are daisychains to display for the mirrored spectra
             drawDaisyChain(g, iClickedListMirrored, iClickedListDatasetIndicesMirrored, iClickedIndexMirrored,
                     iClickedDataSetIndexMirrored, iStoredSequenceMirrored, iStoredSequenceDatasetIndicesMirrored, true);

             // annotate peaks
             annotatePeaks(g, iAnnotations, false);

             // annotate mirrored peaks
             annotatePeaks(g, iAnnotationsMirroredSpectra, true);

             // add reference areas that are to be drawn on top of the data, if any{
             drawYAxisReferenceAreas(g, true);
             drawXAxisReferenceAreas(g, true);

             // (re-)draw the axes to have them appear in front of the data points
             drawAxes(g, iXAxisMin, iXAxisMax, 2, iYAxisMin, iYAxisMax); // @TODO scale.
         }
    }
//    
//    @Override
//    public void paint(Graphics g) {
//        super.paint(g);
//        if (iXAxisData != null) {
//            if (iDragged && iDragXLoc > 0) {
//                g.drawLine(iStartXLoc, iStartYLoc, iDragXLoc, iStartYLoc);
//                g.drawLine(iStartXLoc, iStartYLoc - 2, iStartXLoc, iStartYLoc + 2);
//                g.drawLine(iDragXLoc, iStartYLoc - 2, iDragXLoc, iStartYLoc + 2);
//            }
//
//            // round the range of the x- and y-axis to integer values
//            iXAxisMin = (int) Math.floor(iXAxisMin); // @TODO: increase the zooming resolution!!!
//            iXAxisMax = (int) Math.ceil(iXAxisMax);
//            iYAxisMin = (int) Math.floor(iYAxisMin);
//            iYAxisMax = (int) Math.ceil(iYAxisMax);
//
//            // draw the x and y axis
//            drawAxes(g, iXAxisMin, iXAxisMax, 2, iYAxisMin, iYAxisMax);// @TODO: scale?
//
//            // add reference areas that are to be drawn in the back, if any
//            drawYAxisReferenceAreas(g, false);
//            drawXAxisReferenceAreas(g, false);
//
//            // draw the peaks
//            if (currentGraphicsPanelType.equals(GraphicsPanelType.profileChromatogram)
//                    || currentGraphicsPanelType.equals(GraphicsPanelType.profileSpectrum)
//                    || currentGraphicsPanelType.equals(GraphicsPanelType.isotopicDistributionProfile)) {
//                drawFilledPolygon(g);
//            } else {
//                drawPeaks(g);
//                if (dataSetCounterMirroredSpectra > 0) {
//                    drawMirroredPeaks(g);
//                }
//            }
//
//            // draw any measurement lines in the normal spectra
//            if (iClicked && iHighLight && iClickedIndex != iHighLightIndex) {
//                // Now we should calculate the distance based on the real values and draw a line to show this.
//                this.drawMeasurementLine(iClickedIndex, iClickedDataSetIndex, iHighLightIndex, iHighLightDatasetIndex,
//                        g, Color.blue, 0, false);
//            }
//
//            // draw any measurement lines in the mirrored spectra
//            if (iClickedMirrored && iHighLightMirrored && iClickedIndexMirrored != iHighLightIndexMirrored) {
//                // Now we should calculate the distance based on the real values and draw a line to show this.
//                this.drawMeasurementLine(iClickedIndexMirrored, iClickedDataSetIndexMirrored, iHighLightIndexMirrored,
//                        iHighLightDatasetIndexMirrored, g, Color.blue, 0, true);
//            }
//
//            // hihlight peaks
//            if (iHighLight) {
//                this.highLightPeak(iHighLightIndex, iHighLightDatasetIndex, g, false);
//                iHighLight = false;
//            }
//
//            // highlight mirrored peaks
//            if (iHighLightMirrored) {
//                this.highLightPeak(iHighLightIndexMirrored, iHighLightDatasetIndexMirrored, g, true);
//                iHighLightMirrored = false;
//            }
//
//            // highlight clicked peaks
//            if (iClicked) {
//                this.highlightClicked(iClickedIndex, iHighLightDatasetIndex, g, false);
//            }
//
//            // highlight clicked mirrored peaks
//            if (iClickedMirrored) {
//                this.highlightClicked(iClickedIndexMirrored, iHighLightDatasetIndexMirrored, g, true);
//            }
//
//            // see if there are daisychain to display
//            drawDaisyChain(g, iClickedList, iClickedListDatasetIndices, iClickedIndex, iClickedDataSetIndex,
//                    iStoredSequence, iStoredSequenceDatasetIndices, false);
//
//            // see if there are daisychains to display for the mirrored spectra
//            drawDaisyChain(g, iClickedListMirrored, iClickedListDatasetIndicesMirrored, iClickedIndexMirrored,
//                    iClickedDataSetIndexMirrored, iStoredSequenceMirrored, iStoredSequenceDatasetIndicesMirrored, true);
//
//            // annotate peaks
//            annotatePeaks(g, iAnnotations, false);
//
//            // annotate mirrored peaks
//            annotatePeaks(g, iAnnotationsMirroredSpectra, true);
//
//            // add reference areas that are to be drawn on top of the data, if any{
//            drawYAxisReferenceAreas(g, true);
//            drawXAxisReferenceAreas(g, true);
//
//            // (re-)draw the axes to have them appear in front of the data points
//            drawAxes(g, iXAxisMin, iXAxisMax, 2, iYAxisMin, iYAxisMax); // @TODO scale.
//        }
//    }

    /**
     * Annotate the annotated peaks.
     *
     * @param g           the <code>Graphics</code> context in which to paint
     * @param annotations the annotations
     * @param mirrored    if the annotations are for the mirrored spectra
     */
    protected void annotatePeaks(Graphics g, Vector annotations, boolean mirrored) {
        if (annotations != null && annotations.size() > 0 && !miniature) {
            // This HashMap will contain the indices of the points that already carry an annotation
            // as keys (datasetIndex_peakIndex), and the number of annotations as values.
            HashMap<String, Integer> annotatedPeaks = new HashMap<>();
            annotations.stream().filter(o -> o instanceof SpectrumAnnotation).forEach(o -> {
                SpectrumAnnotation sa = (SpectrumAnnotation) o;
                this.annotate(sa, g, annotatedPeaks, mirrored);
            });
        }
    }

    /**
     * Draw daisy chains.
     *
     * @param g                            the <code>Graphics</code> context in which to paint
     * @param clickedList                  vector that holds all points clicked up to now
     * @param clickedListDatasetIndices    vector that holds the dataset indices of all points clicked up to now
     * @param clickedIndex                 int that indicates which point was clicked
     * @param clickedDataSetIndex          int that indicates which dataset contains the clicked point
     * @param storedSequence               vector that holds a set of stored points from a previously established list
     * @param storedSequenceDatasetIndices vector that holds the dataset indices of stored points from a previously
     *                                     established list.
     * @param mirrored                     if the daisy chains are for the mirrored spectra
     */
    protected void drawDaisyChain(Graphics g, Vector clickedList, Vector clickedListDatasetIndices, int clickedIndex,
            int clickedDataSetIndex, Vector storedSequence, Vector
            storedSequenceDatasetIndices, boolean mirrored) {

        int clickedSize = clickedList.size();

        if (clickedSize > 0) {
            for (int i = 0; i < clickedSize; i++) {
                // The last one should be connected to iClicked.
                int first = (Integer) clickedList.get(i);
                int firstDataSetIndex = (Integer) clickedListDatasetIndices.get(i);

                int second, secondDataSetIndex;

                if ((i + 1) == clickedSize) {
                    second = clickedIndex;
                    secondDataSetIndex = clickedDataSetIndex;
                } else {
                    second = (Integer) clickedList.get(i + 1);
                    secondDataSetIndex = ((Integer) clickedListDatasetIndices.get(i + 1));
                }

                this.drawMeasurementLine(first, firstDataSetIndex, second, secondDataSetIndex, g, Color.LIGHT_GRAY, 0,
                        mirrored);
            }
        }

        // See if there are secondary daisychains to display.
        if (storedSequence.size() > 0) {
            for (int i = 1; i < storedSequence.size(); i++) {
                int first = (Integer) storedSequence.get(i - 1);
                int second = (Integer) storedSequence.get(i);
                int firstDataSetIndex = (Integer) storedSequenceDatasetIndices.get(i - 1);
                int secondDataSetIndex = (Integer) storedSequenceDatasetIndices.get(i);
                this.drawMeasurementLine(first, firstDataSetIndex, second, secondDataSetIndex, g, Color.red,
                        g.getFontMetrics().getAscent() + 15, mirrored);
            }
        }
    }

    /**
     * Draws the x-axis reference areas if any.
     *
     * @param g         Graphics object to draw on.
     * @param drawOnTop if true the areas to be drawn on top of the data are drawn, if false the areas that are to be
     *                  drawn behind the data are drawn
     */
    protected void drawXAxisReferenceAreas(Graphics g, boolean drawOnTop) {

        // used to find the location of the label
        FontMetrics fm = g.getFontMetrics();
        Font oldFont = this.getFont();

        // switch to 2D graphics
        Graphics2D g2d = (Graphics2D) g;

        // store the original color
        Color originalColor = g2d.getColor();
        Composite originalComposite = g2d.getComposite();
        Stroke originalStroke = g2d.getStroke();

        for (String s : referenceAreasXAxis.keySet()) {

            ReferenceArea currentReferenceArea = referenceAreasXAxis.get(s);

            if (drawOnTop == currentReferenceArea.drawOnTop()) {

                // set the color and opacity level
                g.setColor(currentReferenceArea.getAreaColor());
                g2d.setComposite(makeComposite(currentReferenceArea.getAlpha()));

                // set up the data tables for the polygon
                int[] xTemp = new int[4];
                int[] yTemp = new int[4];

                // x range start
                double tempDouble = (currentReferenceArea.getStart() - iXAxisMin) / iXScaleUnit;
                int start = (int) tempDouble;
                if ((tempDouble - start) >= 0.5) {
                    start++;
                }

                // x range end
                tempDouble = (currentReferenceArea.getEnd() - iXAxisMin) / iXScaleUnit;
                int end = (int) tempDouble;
                if ((tempDouble - end) >= 0.5) {
                    end++;
                }

                // x-axis locations
                xTemp[0] = start + iXPadding;
                xTemp[1] = end + iXPadding;
                xTemp[2] = end + iXPadding;
                xTemp[3] = start + iXPadding;

                // y-axis locations
                int xAxisYLocation;
                if (dataSetCounterMirroredSpectra > 0) {
                    xAxisYLocation = (this.getHeight() - currentPadding) / 2;
                } else {
                    xAxisYLocation = this.getHeight() - currentPadding;
                }

                double areaHeight = xAxisYLocation - currentPadding;
                int y = (int) (areaHeight - (areaHeight * currentReferenceArea.getPercentLength())) + currentPadding;

                if (currentReferenceArea.isAboveXAxis()) {
                    yTemp[0] = y;
                    yTemp[1] = y;

                    if (dataSetCounterMirroredSpectra > 0) {
                        yTemp[2] = this.getHeight() - xAxisYLocation - currentPadding;
                        yTemp[3] = this.getHeight() - xAxisYLocation - currentPadding;
                    } else {
                        yTemp[2] = this.getHeight() - currentPadding;
                        yTemp[3] = this.getHeight() - currentPadding;
                    }
                } else {
                    y = this.getHeight() - y - currentPadding;
                    yTemp[0] = this.getHeight() - xAxisYLocation - currentPadding;
                    yTemp[1] = this.getHeight() - xAxisYLocation - currentPadding;
                    yTemp[2] = y;
                    yTemp[3] = y;
                }

                // draw the polygon
                g2d.fillPolygon(xTemp, yTemp, xTemp.length);

                // draw the thin line around the polygon
                g2d.setComposite(originalComposite);
                g2d.setColor(currentReferenceArea.getBorderColor());
                g2d.setStroke(new BasicStroke(currentReferenceArea.getBorderWidth()));
                g2d.drawRect(xTemp[0], yTemp[0], xTemp[1] - xTemp[0], yTemp[2] - yTemp[0]);
                g2d.setStroke(originalStroke);
                g2d.setColor(originalColor);

                // draw the label
                if (currentReferenceArea.drawLabel() && !miniature) {

                    // set the color and opacity level for the label
                    g2d.setColor(currentReferenceArea.getLabelColor());

                    // set the font to use for the labels
                    if (currentReferenceArea.useBoldFont()) {
                        g.setFont(new Font(oldFont.getName(), oldFont.getStyle() | Font.BOLD, oldFont.getSize()));
                    } else {
                        g.setFont(new Font(oldFont.getName(), oldFont.getStyle(), oldFont.getSize()));
                    }

                    // insert the label
                    String label = currentReferenceArea.getLabel();
                    int width = g.getFontMetrics().stringWidth(label);
                    int xPosText = xTemp[0] + (Math.abs(xTemp[1] - xTemp[0]) / 2) - (width / 2);
                    if (currentReferenceArea.isAboveXAxis()) {
                        g2d.drawString(label, xPosText, y + (int) fm.getStringBounds(label, g).getHeight() + 8);
                    } else {
                        g2d.drawString(label, xPosText, y - (int) fm.getStringBounds(label, g).getHeight());
                    }
                }
            }
        }

        // Change the color and alpha level back to its original setting.
        g2d.setColor(originalColor);
        g2d.setComposite(originalComposite);
        g.setFont(oldFont);
    }

    /**
     * Draws the y-axis reference areas if any.
     *
     * @param g         Graphics object to draw on.
     * @param drawOnTop if true the areas to be drawn on top of the data are drawn, if false the areas that are to be
     *                  drawn behind the data are drawn
     */
    protected void drawYAxisReferenceAreas(Graphics g, boolean drawOnTop) {

        // used to find the location of the label
        FontMetrics fm = g.getFontMetrics();
        Font oldFont = this.getFont();

        // switch to 2D graphics
        Graphics2D g2d = (Graphics2D) g;
        Stroke originalStroke = g2d.getStroke();

        // store the original color
        Color originalColor = g2d.getColor();
        Composite originalComposite = g2d.getComposite();

        for (String s : referenceAreasYAxis.keySet()) {

            ReferenceArea currentReferenceArea = referenceAreasYAxis.get(s);

            if (drawOnTop == currentReferenceArea.drawOnTop()) {

                // set the color and opacity level
                g.setColor(currentReferenceArea.getAreaColor());
                g2d.setComposite(makeComposite(currentReferenceArea.getAlpha()));

                // set up the data tables for the polygon
                int[] xTemp = new int[4];
                int[] yTemp = new int[4];

                // y range start
                double tempDouble = (currentReferenceArea.getStart() - iYAxisMin) / iYScaleUnit;
                int start = (int) tempDouble;
                if ((tempDouble - start) >= 0.5) {
                    start++;
                }

                // y range end
                tempDouble = (currentReferenceArea.getEnd() - iYAxisMin) / iYScaleUnit;
                int end = (int) tempDouble;
                if ((tempDouble - end) >= 0.5) {
                    end++;
                }

                int areaLength = this.getWidth() - currentPadding;
                int xMax = (int) (areaLength * currentReferenceArea.getPercentLength());

                xTemp[0] = currentPadding;
                yTemp[0] = this.getHeight() - start - currentPadding;

                xTemp[1] = currentPadding;
                yTemp[1] = this.getHeight() - end - currentPadding;

                xTemp[2] = xMax;
                yTemp[2] = this.getHeight() - end - currentPadding;

                xTemp[3] = xMax;
                yTemp[3] = this.getHeight() - start - currentPadding;

                g2d.fillPolygon(xTemp, yTemp, xTemp.length);

                // draw the thin line around the polygon
                g2d.setComposite(originalComposite);
                g2d.setColor(currentReferenceArea.getBorderColor());
                g2d.setStroke(new BasicStroke(currentReferenceArea.getBorderWidth()));
                g2d.drawRect(xTemp[0], yTemp[2], xTemp[2] - xTemp[0], yTemp[0] - yTemp[2]);
                g2d.setStroke(originalStroke);
                g2d.setColor(originalColor);

                // draw the label
                if (currentReferenceArea.drawLabel() && !miniature) {

                    // set the color and opacity level for the label
                    g2d.setColor(currentReferenceArea.getLabelColor());

                    // set the font to use for the labels
                    if (currentReferenceArea.useBoldFont()) {
                        g.setFont(new Font(oldFont.getName(), oldFont.getStyle() | Font.BOLD, oldFont.getSize()));
                    } else {
                        g.setFont(new Font(oldFont.getName(), oldFont.getStyle(), oldFont.getSize()));
                    }

                    // insert the label
                    String label = currentReferenceArea.getLabel();
                    g2d.drawString(label, currentPadding + 5,
                            this.getHeight() - end - currentPadding + (int) fm.getStringBounds(label, g).getHeight());
                }
            }
        }

        // Change the color and alpha level back to its original setting.
        g2d.setColor(originalColor);
        g2d.setComposite(originalComposite);
    }

    /**
     * This method reports on the largest x-axis value in the point collection
     * across all datasets.
     *
     * @return double with the largest x-axis value in the point collection.
     */
    public double getMaxXAxisValue() {

        double maxValue = Double.MIN_VALUE;

        for (double[] iXAxisData1 : iXAxisData) {
            if (iXAxisData1.length > 0 && iXAxisData1[iXAxisData1.length - 1] > maxValue) {
                maxValue = iXAxisData1[iXAxisData1.length - 1];
            }
        }

        if (dataSetCounterMirroredSpectra > 0) {
            for (double[] iXAxisDataCurrentMirroredSpectrum : iXAxisDataMirroredSpectrum) {
                for (double lMass : iXAxisDataCurrentMirroredSpectrum) {
                    if (lMass > maxValue) {
                        maxValue = lMass;
                    }
                }
            }
        }

        return maxValue;
    }

    /**
     * This method reports on the smallest x-axis value in the point collection
     * across all datasets.
     *
     * @return double with the smallest x-axis value in the point collection.
     */
    public double getMinXAxisValue() {

        double minValue = Double.MAX_VALUE;

        for (double[] iXAxisData1 : iXAxisData) {
            if (iXAxisData1[0] < minValue) {
                minValue = iXAxisData1[0];
            }
        }

        if (dataSetCounterMirroredSpectra > 0) {
            for (double[] iXAxisDataCurrentMirroredSpectrum : iXAxisDataMirroredSpectrum) {
                for (double lMass : iXAxisDataCurrentMirroredSpectrum) {
                    if (lMass < minValue) {
                        minValue = lMass;
                    }
                }
            }
        }

        return minValue;
    }

    /**
     * This method registers the specified SpectrumPanelListener with this instance and notifies it of all future
     * events. The Listeners will be notified in order of addition (first addition is notified first).
     *
     * @param aListener SpectrumPanelListener to register on this instance.
     */
    public void addSpectrumPanelListener(SpectrumPanelListener aListener) {
        this.iSpecPanelListeners.add(aListener);
    }

    /**
     * This method adds the event listeners to the panel.
     */
    protected void addListeners() {
        this.addMouseListener(new MouseAdapter() {
            /**
             * Invoked when a mouse button has been released on a component.
             */
            public void mouseReleased(MouseEvent e) {
                if (iXAxisData != null) {
                    if (e.getButton() == MouseEvent.BUTTON3 || e.getButton() == MouseEvent.BUTTON2) {
                        if (iXAxisStartAtZero) {
                            rescale(0.0, getMaxXAxisValue());
                        } else {

                            double tempMinXValue = getMinXAxisValue();

                            // if isotopic distribution add a little padding on the left side
                            // to make sure that the first peak is not too close to the y-axis
                            if (currentGraphicsPanelType.equals(GraphicsPanelType.isotopicDistributionProfile)
                                    || currentGraphicsPanelType.equals(GraphicsPanelType
                                    .isotopicDistributionCentroid)) {
                                tempMinXValue -= 1;

                                if (tempMinXValue < 0) {
                                    tempMinXValue = 0;
                                }
                            }

                            rescale(tempMinXValue, getMaxXAxisValue());
                        }
                        iDragged = false;
                        repaint();
                    } else if (e.getButton() == MouseEvent.BUTTON1) {
                        iEndXLoc = e.getX();
                        int min = Math.min(iEndXLoc, iStartXLoc);
                        int max = Math.max(iEndXLoc, iStartXLoc);
                        double start = iXAxisMin + ((min - iXPadding) * iXScaleUnit);
                        double end = iXAxisMin + ((max - iXPadding) * iXScaleUnit);
                        if (iDragged) {
                            iDragged = false;
                            // Rescale.
                            if ((max - min) > iMinDrag) {
                                rescale(start, end);
                            }
                            iDragXLoc = 0;
                            repaint();
                        }
                    }
                }
            }

            /**
             * Invoked when the mouse has been clicked on a component.
             */
            public void mouseClicked(MouseEvent e) {

                // see if we're above or below the x-axis
                int xAxisYLocation = (getHeight() - currentPadding) / 2;
                boolean aboveXAxis = e.getY() < xAxisYLocation;

                if (dataSetCounterMirroredSpectra == 0) {
                    aboveXAxis = true;
                }

                if (aboveXAxis) { // @TODO: merge the above/below code
                    if (iXAxisData != null) {
                        if (e.getButton() == MouseEvent.BUTTON1
                                && e.getModifiersEx() == (MouseEvent.CTRL_DOWN_MASK | MouseEvent.ALT_DOWN_MASK)) {
                            iStoredSequence = new Vector(15, 5);
                            iStoredSequenceDatasetIndices = new Vector(15, 5);
                            repaint();
                        } else if (e.getButton() == MouseEvent.BUTTON1
                                && e.getModifiersEx() == MouseEvent.CTRL_DOWN_MASK) {
                            iClicked = false;
                            iClickedList = new Vector(15, 5);
                            iClickedListDatasetIndices = new Vector(15, 5);
                            repaint();
                        } else if (e.getButton() == MouseEvent.BUTTON1
                                && e.getModifiersEx() == MouseEvent.SHIFT_DOWN_MASK) {
                            // If the clicked point is the last one in the list
                            // of previously clicked points, remove it from the list!
                            if (iClickedList != null && iClickedList.size() > 0 && iHighLightIndex == iClickedIndex) {
                                // Retrieve the previously clicked index from the list and set the currently clicked
                                // one to that value.
                                iClickedIndex = (Integer) iClickedList.get(iClickedList.size() - 1);
                                iClickedDataSetIndex = (Integer) iClickedListDatasetIndices
                                        .get(iClickedListDatasetIndices.size() - 1);
                                // Remove the previously clicked index from the list.
                                iClickedList.remove(iClickedList.size() - 1);
                                iClickedListDatasetIndices.remove(iClickedListDatasetIndices.size() - 1);
                                // Repaint.
                                repaint();
                            }
                        } else if (e.getButton() == MouseEvent.BUTTON1
                                && e.getModifiersEx() == MouseEvent.ALT_DOWN_MASK) {
                            // See if there is a clicked list and if it contains any values.
                            if (iClickedList != null && iClickedList.size() > 0) {
                                // Copy the current clickedlist into the stored sequence.
                                iStoredSequence = (Vector) iClickedList.clone();
                                iStoredSequence.add(Integer.valueOf(iClickedIndex));
                                iStoredSequenceDatasetIndices = (Vector) iClickedListDatasetIndices.clone();
                                iStoredSequenceDatasetIndices.add(iClickedDataSetIndex);
                                iClicked = false;
                                // Reset the clicked list.
                                iClickedList = new Vector(15, 5);
                                iClickedListDatasetIndices = new Vector(15, 5);
                                repaint();
                            }
                        } else if (e.getButton() == MouseEvent.BUTTON1) {
                            if (iClicked && iClickedIndex != iHighLightIndex) {
                                // We need the current point to be stored in the
                                // previously clicked Vector and set the current one as clicked.
                                iClickedList.add(iClickedIndex);
                                iClickedListDatasetIndices.add(iClickedDataSetIndex);
                            }
                            iClicked = true;
                            iClickedIndex = iHighLightIndex;
                            iClickedDataSetIndex = iHighLightDatasetIndex;
                            repaint();
                        }
                    }
                } else {
                    if (iXAxisDataMirroredSpectrum != null) {
                        if (e.getButton() == MouseEvent.BUTTON1
                                && e.getModifiersEx() == (MouseEvent.CTRL_DOWN_MASK | MouseEvent.ALT_DOWN_MASK)) {
                            iStoredSequenceMirrored = new Vector(15, 5);
                            iStoredSequenceDatasetIndicesMirrored = new Vector(15, 5);
                            repaint();
                        } else if (e.getButton() == MouseEvent.BUTTON1
                                && e.getModifiersEx() == MouseEvent.CTRL_DOWN_MASK) {
                            iClickedMirrored = false;
                            iClickedListMirrored = new Vector(15, 5);
                            iClickedListDatasetIndicesMirrored = new Vector(15, 5);
                            repaint();
                        } else if (e.getButton() == MouseEvent.BUTTON1
                                && e.getModifiersEx() == MouseEvent.SHIFT_DOWN_MASK) {
                            // If the clicked point is the last one in the list of previously clicked points,
                            // remove it from the list!
                            if (iClickedListMirrored != null && iClickedListMirrored.size() > 0
                                    && iHighLightIndexMirrored == iClickedIndexMirrored) {
                                // Retrieve the previously clicked index from the list and set the currently clicked
                                // one to that value.
                                iClickedIndexMirrored = (Integer) iClickedListMirrored
                                        .get(iClickedListMirrored.size() - 1);
                                iClickedDataSetIndexMirrored = (Integer) iClickedListDatasetIndicesMirrored
                                        .get(iClickedListDatasetIndicesMirrored.size() - 1);
                                // Remove the previously clicked index from the list.
                                iClickedListMirrored.remove(iClickedListMirrored.size() - 1);
                                iClickedListDatasetIndicesMirrored
                                        .remove(iClickedListDatasetIndicesMirrored.size() - 1);
                                // Repaint.
                                repaint();
                            }
                        } else if (e.getButton() == MouseEvent.BUTTON1
                                && e.getModifiersEx() == MouseEvent.ALT_DOWN_MASK) {
                            // See if there is a clicked list and if it contains any values.
                            if (iClickedListMirrored != null && iClickedListMirrored.size() > 0) {
                                // Copy the current clickedlist into the stored sequence.
                                iStoredSequenceMirrored = (Vector) iClickedListMirrored.clone();
                                iStoredSequenceMirrored.add(iClickedIndexMirrored);
                                iStoredSequenceDatasetIndicesMirrored = (Vector) iClickedListDatasetIndicesMirrored
                                        .clone();
                                iStoredSequenceDatasetIndicesMirrored.add(iClickedDataSetIndexMirrored);
                                iClicked = false;
                                // Reset the clicked list.
                                iClickedListMirrored = new Vector(15, 5);
                                iClickedListDatasetIndicesMirrored = new Vector(15, 5);
                                repaint();
                            }
                        } else if (e.getButton() == MouseEvent.BUTTON1) {
                            if (iClickedMirrored && iClickedIndexMirrored != iHighLightIndexMirrored) {
                                // We need the current point to be stored in the previously clicked
                                // Vector and set the current one as clicked.
                                iClickedListMirrored.add(iClickedIndexMirrored);
                                iClickedListDatasetIndicesMirrored.add(iClickedDataSetIndexMirrored);
                            }
                            iClickedMirrored = true;
                            iClickedIndexMirrored = iHighLightIndexMirrored;
                            iClickedDataSetIndexMirrored = iHighLightDatasetIndexMirrored;
                            repaint();
                        }
                    }
                }
            }

            /**
             * Invoked when a mouse button has been pressed on a component.
             */
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    iStartXLoc = e.getX();
                    iStartYLoc = e.getY();
                }
            }
        });

        this.addMouseMotionListener(new MouseMotionAdapter() {
            /**
             * Invoked when a mouse button is pressed on a component and then
             * dragged. Mouse drag events will continue to be delivered to the
             * component where they first originated until the mouse button is
             * released (regardless of whether the mouse position is within the
             * bounds of the component).
             */
            public void mouseDragged(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    iDragged = true;
                    iDragXLoc = e.getX();
                    repaint();
                }
            }

            /**
             * Invoked when the mouse button has been moved on a component (with
             * no buttons no down).
             */
            public void mouseMoved(MouseEvent e) {

                // see if we're above or below the x-axis
                int y = e.getY();

                int xAxisYLocation = (getHeight() - currentPadding) / 2;
                boolean aboveXAxis = y < xAxisYLocation;

                if (dataSetCounterMirroredSpectra == 0) {
                    aboveXAxis = true;
                }

                ArrayList<double[]> xAxisData;
                ArrayList<int[]> xAxisDataInPixels;
                ArrayList<int[]> yAxisDataInPixels;

                if (aboveXAxis) {
                    xAxisData = iXAxisData;
                    xAxisDataInPixels = iXAxisDataInPixels;
                    yAxisDataInPixels = iYAxisDataInPixels;
                } else {
                    xAxisData = iXAxisDataMirroredSpectrum;
                    xAxisDataInPixels = iXAxisDataInPixelsMirroredSpectrum;
                    yAxisDataInPixels = iYAxisDataInPixelsMirroredSpectrum;
                }

                if (xAxisData != null && xAxisDataInPixels != null) {
                    int x = e.getX();

                    // this variable is used to make sure that the most intense
                    // peak within range is highlighted
                    int highestPeakInRange = 0;

                    for (int j = 0; j < xAxisDataInPixels.size(); j++) {
                        for (int i = 0; i < xAxisDataInPixels.get(j).length; i++) {
                            int delta = xAxisDataInPixels.get(j)[i] - x;
                            if (Math.abs(delta) < iPointDetectionTolerance) {
                                if (aboveXAxis) {
                                    int deltaYPixels = y - yAxisDataInPixels.get(j)[i];
                                    if (deltaYPixels < 0
                                            && Math.abs(deltaYPixels) < (getHeight() - yAxisDataInPixels.get(j)[i])
                                            && highestPeakInRange < (getHeight() - yAxisDataInPixels.get(j)[i])) {
                                        iHighLight = true;
                                        iHighLightIndex = i;
                                        iHighLightDatasetIndex = j;
                                        highestPeakInRange = (getHeight() - yAxisDataInPixels.get(j)[i]);
                                        repaint();
                                    }
                                } else {
                                    int deltaYPixels = yAxisDataInPixels.get(j)[i] - y;
                                    if (deltaYPixels < 0 && Math.abs(deltaYPixels) < yAxisDataInPixels.get(j)[i]
                                            && highestPeakInRange < yAxisDataInPixels.get(j)[i]) {
                                        iHighLightMirrored = true;
                                        iHighLightIndexMirrored = i;
                                        iHighLightDatasetIndexMirrored = j;
                                        highestPeakInRange = yAxisDataInPixels.get(j)[i];
                                        repaint();
                                    }
                                }
                            } else if (delta >= iPointDetectionTolerance) {
                                break;
                            }
                        }
                    }
                    repaint();
                }
            }
        });
    }

    /**
     * This method rescales the x-axis while notifying the observers.
     *
     * @param aMinXAxisValue double with the new minimum x-axis value to display.
     * @param aMaxXAxisValue double with the new maximum x-axis value to display.
     */
    public void rescale(double aMinXAxisValue, double aMaxXAxisValue) {
        this.rescale(aMinXAxisValue, aMaxXAxisValue, true);
    }

    /**
     * Add a x-axis reference area.
     *
     * @param referenceArea the reference area to add
     */
    public void addReferenceAreaXAxis(ReferenceArea referenceArea) {
        referenceAreasXAxis.put(referenceArea.getIdentifier(), referenceArea);
    }

    /**
     * Removes the x-axis reference area with the given identifier. Does nothing
     * if no reference with the given identifier is found.
     *
     * @param identifier the identifier of the reference to remove
     */
    public void removeReferenceAreaXAxis(String identifier) {
        referenceAreasXAxis.remove(identifier);
    }

    /**
     * Removes all the x-axis reference areas.
     */
    public void removeAllReferenceAreasXAxis() {
        referenceAreasXAxis = new HashMap<String, ReferenceArea>();
    }

    /**
     * Returns all the x-axis references areas as a hashmap, with the labels as
     * the keys.
     *
     * @return hashmap of all reference areas
     */
    public HashMap<String, ReferenceArea> getAllReferenceAreasXAxis() {
        return referenceAreasXAxis;
    }

    /**
     * Add a y-axis reference area.
     *
     * @param referenceArea the reference area to add
     */
    public void addReferenceAreaYAxis(ReferenceArea referenceArea) {
        referenceAreasYAxis.put(referenceArea.getIdentifier(), referenceArea);
    }

    /**
     * Removes the y-axis reference area with the given identifier. Does nothing
     * if no reference with the given identifier is found.
     *
     * @param identifier the identifier of the reference to remove
     */
    public void removeReferenceAreaYAxis(String identifier) {
        referenceAreasYAxis.remove(identifier);
    }

    /**
     * Removes all the y-axis reference areas.
     */
    public void removeAllReferenceAreasYAxis() {
        referenceAreasYAxis = new HashMap<String, ReferenceArea>();
    }

    /**
     * Returns all the y-axis references areas as a hashmap, with the labels as
     * the keys.
     *
     * @return hashmap of all reference areas
     */
    public HashMap<String, ReferenceArea> getAllReferenceAreasYAxis() {
        return referenceAreasYAxis;
    }

    /**
     * Sets the color of data points and line for the dataset with the given
     * dataset index. Index starts at 0.
     *
     * @param aColor the color to use
     * @param index  the index of the dataset
     */
    public void setDataPointAndLineColor(Color aColor, int index) {
        if (index < iDataPointAndLineColor.size() && index >= 0) {
            iDataPointAndLineColor.set(index, aColor);
        }
    }

    /**
     * Sets the color of the area under the curve for profile chromatograms and
     * spectra for the dataset with the given dataset index. Index starts at 0.
     *
     * @param aColor the color to use
     * @param index  the index of the dataset
     */
    public void setAreaUnderCurveColor(Color aColor, int index) {
        if (index < iAreaUnderCurveColor.size() && index >= 0) {
            iAreaUnderCurveColor.set(index, aColor);
        }
    }

    /**
     * Returns the list of colors used for the datasets. Index on dataset. Index
     * starts at 0.
     *
     * @return the the list of colors used for the datasets
     */
    public ArrayList<Color> getAreaUnderCurveColors() {
        return iAreaUnderCurveColor;
    }

    /**
     * This method rescales the x-axis, allowing the caller to specify whether
     * the observers need be notified.
     *
     * @param aMinXAxisValue   double with the new minimum x-axis value to display.
     * @param aMaxXAxisValue   double with the new maximum x-axis value to display.
     * @param aNotifyListeners boolean to indicate whether the observers should
     *                         be notified.
     */
    public void rescale(double aMinXAxisValue, double aMaxXAxisValue, boolean aNotifyListeners) {

        xAxisZoomRangeLowerValue = aMinXAxisValue;
        xAxisZoomRangeUpperValue = aMaxXAxisValue;

        // Calculate the new max x-axis value.
        double maxInt = 1.0;

        for (int j = 0; j < iXAxisData.size(); j++) {
            for (int i = 0; i < iXAxisData.get(j).length; i++) {
                double lMass = iXAxisData.get(j)[i];
                if (lMass < aMinXAxisValue) {
                    continue;
                } else if (lMass > aMaxXAxisValue) {
                    break;
                } else {
                    if (iYAxisData.get(j)[i] > maxInt) {

                        boolean annotatedPeak = false;

                        // exclude background peaks?
                        if (yAxisZoomExcludesBackgroundPeaks) {
                            annotatedPeak = isPeakAnnotated(iXAxisData.get(j)[i], false);
                        }

                        if (!yAxisZoomExcludesBackgroundPeaks || (yAxisZoomExcludesBackgroundPeaks && annotatedPeak)
                                || showAllPeaks) {
                            maxInt = iYAxisData.get(j)[i];
                        }
                    }
                }
            }
        }

        if (dataSetCounterMirroredSpectra > 0) {
            for (int j = 0; j < iXAxisDataMirroredSpectrum.size(); j++) {
                for (int i = 0; i < iXAxisDataMirroredSpectrum.get(j).length; i++) {
                    double lMass = iXAxisDataMirroredSpectrum.get(j)[i];
                    if (lMass < aMinXAxisValue) {
                        continue;
                    } else if (lMass > aMaxXAxisValue) {
                        break;
                    } else {
                        if (iYAxisDataMirroredSpectrum.get(j)[i] > maxInt) {

                            boolean annotatedPeak = false;

                            // exclude background peaks?
                            if (yAxisZoomExcludesBackgroundPeaks) {
                                annotatedPeak = isPeakAnnotated(iXAxisDataMirroredSpectrum.get(j)[i], true);
                            }
                            if (!yAxisZoomExcludesBackgroundPeaks || (yAxisZoomExcludesBackgroundPeaks && annotatedPeak)
                                    || showAllPeaks) {
                                maxInt = iYAxisDataMirroredSpectrum.get(j)[i];
                            }
                        }
                    }
                }
            }
        }

        // Init the new params.
        double delta = aMaxXAxisValue - aMinXAxisValue;

        // Round to nearest order of 10, based on displayed delta.
        double tempOoM = (Math.log(delta) / Math.log(10)) - 1;
        if (tempOoM < 0) {
            tempOoM--;
        }

        int orderOfMagnitude = (int) tempOoM;
        double power = Math.pow(10, orderOfMagnitude);
        iXAxisMin = aMinXAxisValue - (aMinXAxisValue % power);
        iXAxisMax = aMaxXAxisValue + (power - (aMaxXAxisValue % power));

        // @TODO: just some helpful printouts for when this is refined further.
        // logger.info(" - Delta: " + delta + "\tAdj. delta: " +
        // (iMassMax-iMassMin) + "\tMinMass: " + iMassMin + "\tMaxMass: " +
        // iMassMax + "\tScale: " + power);
        iYAxisMax = maxInt + (maxInt / 10);

        int liSize = iSpecPanelListeners.size();
        RescalingEvent re = new RescalingEvent(this, aMinXAxisValue, aMaxXAxisValue);
        if (aNotifyListeners) {
            for (Object iSpecPanelListener : iSpecPanelListeners) {
                ((SpectrumPanelListener) iSpecPanelListener).rescaled(re);
            }
        }
    }

    /**
     * This method reads the x and y values from the specified arrays and stores
     * these internally for drawing. The x-axis values are sorted in this step.
     *
     * @param aXAxisData            double[] with the x-axis values.
     * @param aYAxisData            double[] with the corresponding y-axis values.
     * @param dataPointAndLineColor the color to use for the data points and line
     * @param areaUnderCurveColor   the color to use for the area under the curve
     */
    protected void processXAndYData(double[] aXAxisData, double[] aYAxisData, Color dataPointAndLineColor,
            Color areaUnderCurveColor) {

        // if first dataset, create the dataset array lists
        if (dataSetCounter == 0) {
            iXAxisData = new ArrayList<double[]>();
            iYAxisData = new ArrayList<double[]>();
        }

        // set the data colors
        iDataPointAndLineColor.add(dataPointAndLineColor);
        iAreaUnderCurveColor.add(areaUnderCurveColor);

        HashMap<Double, Double> peaks = new HashMap<>(aXAxisData.length);

        // add the peaks to the dataset
        for (int i = 0; i < aXAxisData.length; i++) {
            peaks.put(aXAxisData[i], aYAxisData[i]);
        }

        // add the new dataset
        iXAxisData.add(new double[peaks.size()]);
        iYAxisData.add(new double[peaks.size()]);

        // Maximum y-axis value.
        double maxYAxisValue = 0.0;

        // TreeSets are sorted.
        TreeSet<Double> masses = new TreeSet<>(peaks.keySet());
        Iterator<Double> iter = masses.iterator();
        int count = 0;
        while (iter.hasNext()) {
            Double key = iter.next();
            double xValue = key;
            double yValue = peaks.get(key);
            if (yValue > maxYAxisValue) {
                maxYAxisValue = yValue;
            }
            iXAxisData.get(dataSetCounter)[count] = xValue;
            iYAxisData.get(dataSetCounter)[count] = yValue;
            count++;
        }

        // rescale the added dataset
        if (iXAxisStartAtZero) {
            this.rescale(0.0, getMaxXAxisValue());
        } else {
            this.rescale(getMinXAxisValue(), getMaxXAxisValue());
        }

        dataSetCounter++;
    }

    /**
     * This method reads the x and y values from the specified arrays and stores
     * these internally for drawing. The x-axis values are sorted in this step.
     *
     * @param aXAxisData            double[] with the x-axis values.
     * @param aYAxisData            double[] with the corresponding y-axis values.
     * @param dataPointAndLineColor the color to use for the data points and line
     * @param areaUnderCurveColor   the color to use for the area under the curve
     */
    protected void processMirroredXAndYData(double[] aXAxisData, double[] aYAxisData, Color dataPointAndLineColor,
            Color areaUnderCurveColor) {

        // create the dataset array lists if first mirrored dataset, create the dataset array lists
        if (dataSetCounterMirroredSpectra == 0) {
            iXAxisDataMirroredSpectrum = new ArrayList<>();
            iYAxisDataMirroredSpectrum = new ArrayList<>();
        }

        // set the data colors
        iDataPointAndLineColorMirroredSpectra.add(dataPointAndLineColor);
        iAreaUnderCurveColorMirroredSpectra.add(areaUnderCurveColor);

        HashMap<Double, Double> peaks = new HashMap<>(aXAxisData.length);

        // add the peaks to the dataset
        for (int i = 0; i < aXAxisData.length; i++) {
            peaks.put(aXAxisData[i], aYAxisData[i]);
        }

        // add the new dataset
        iXAxisDataMirroredSpectrum.add(new double[peaks.size()]);
        iYAxisDataMirroredSpectrum.add(new double[peaks.size()]);

        // Maximum y-axis value.
        double maxYAxisValue = 0.0;

        // TreeSets are sorted.
        TreeSet<Double> masses = new TreeSet<>(peaks.keySet());
        Iterator iter = masses.iterator();
        int count = 0;
        while (iter.hasNext()) {
            Double key = (Double) iter.next();
            double xValue = key;
            double yValue = peaks.get(key);
            if (yValue > maxYAxisValue) {
                maxYAxisValue = yValue;
            }
            iXAxisDataMirroredSpectrum.get(dataSetCounterMirroredSpectra)[count] = xValue;
            iYAxisDataMirroredSpectrum.get(dataSetCounterMirroredSpectra)[count] = yValue;
            count++;
        }

        dataSetCounterMirroredSpectra++;

        // rescale the added dataset
        if (iXAxisStartAtZero) {
            this.rescale(0.0, getMaxXAxisValue());
        } else {
            this.rescale(getMinXAxisValue(), getMaxXAxisValue());
        }
    }

    /**
     * This method draws the axes and their labels on the specified Graphics
     * object, taking into account the padding.
     *
     * @param g       Graphics object to draw on.
     * @param aXMin   double with the minimal x value.
     * @param aXMax   double with the maximum x value.
     * @param aXScale int with the scale to display for the X-axis labels (as used in BigDecimal's setScale).
     * @param aYMin   double with the minimal y value.
     * @param aYMax   double with the maximum y value.
     * @return int[] with the length of the X axis and Y axis respectively.
     */
    protected int[] drawAxes(Graphics g, double aXMin, double aXMax, int aXScale, double aYMin, double aYMax) {

        // Recalibrate padding so that it holds the axis labels.
        FontMetrics fm = g.getFontMetrics();
        int xAxisLabelWidth = fm.stringWidth(iXAxisLabel);
        int yAxisLabelWidth = fm.stringWidth(iYAxisLabel);
        int minWidth = fm.stringWidth(Double.toString(aYMin));
        int maxWidth = fm.stringWidth(Double.toString(aYMax));
        int max = Math.max(Math.max(xAxisLabelWidth, yAxisLabelWidth), Math.max(minWidth, maxWidth));
        currentPadding = padding;

        if ((padding - max) < 0) {
            currentPadding += max;
            if (currentPadding > maxPadding) {
                currentPadding = maxPadding;
            }
        } else {
            currentPadding *= 2;
        }

        // X-axis.
        int xAxis = (this.getWidth() - (2 * currentPadding));

        int xAxisYLocation = this.getHeight() - currentPadding;

        if (dataSetCounterMirroredSpectra > 0) {
            xAxisYLocation = (this.getHeight() - currentPadding) / 2;
        }

        // hide any data going slightly below the y-axis
        if (yDataIsPositive) {
            Color currentColor = g.getColor();
            g.setColor(this.getBackground());

            if (miniature) {
                g.fillRect(currentPadding, xAxisYLocation, this.getWidth() - currentPadding - 2, 2);
            } else {
                g.fillRect(currentPadding, xAxisYLocation, this.getWidth() - currentPadding - 2, 20);
            }

            g.setColor(currentColor);
        }

        g.drawLine(currentPadding, xAxisYLocation, this.getWidth() - currentPadding, xAxisYLocation);

        if (!miniature) {

            // Arrowhead on X-axis.
            g.fillPolygon(
                    new int[]{this.getWidth() - currentPadding - 3, this.getWidth() - currentPadding - 3,
                            this.getWidth() - currentPadding + 2},
                    new int[]{xAxisYLocation + 5, xAxisYLocation - 5, xAxisYLocation}, 3);

            // X-axis label
            if (iXAxisLabel.equalsIgnoreCase("m/z")) {
                g.drawString(iXAxisLabel, this.getWidth() - (currentPadding - (padding / 2)), xAxisYLocation + 4);
            } else {
                g.drawString(iXAxisLabel, this.getWidth() - (xAxisLabelWidth + 5),
                        xAxisYLocation - (currentPadding / 2));
            }

            // Y-axis.
            g.drawLine(currentPadding, this.getHeight() - currentPadding, currentPadding, currentPadding / 2);
        }

        iXPadding = currentPadding;
        int yAxis = xAxisYLocation - (currentPadding / 2);

        if (!miniature) {

            // Arrowhead on Y axis.
            g.fillPolygon(new int[]{currentPadding - 5, currentPadding + 5, currentPadding},
                    new int[]{(currentPadding / 2) + 3, (currentPadding / 2) + 3, currentPadding / 2 - 2}, 3);

            // Y-axis label
            if (iYAxisLabel.equalsIgnoreCase("Int")) {
                g.drawString(iYAxisLabel, currentPadding - yAxisLabelWidth, (currentPadding / 2) - 4);
            } else {
                g.drawString(iYAxisLabel, currentPadding - (yAxisLabelWidth / 5), (currentPadding / 2) - 4);
            }
        }

        // Now the tags along the axes.
        this.drawXTags(g, (int) Math.floor(aXMin), (int) Math.ceil(aXMax), aXScale, xAxis, currentPadding); // @TODO:
        // increase the zooming resolution!!!
        int yTemp = yAxis;

        if (iAnnotations != null && iAnnotations.size() > 0 && !miniature) {
            yTemp -= 20;
        }

        iTopPadding = this.getHeight() - yTemp - 5;
        this.drawYTags(g, (int) Math.floor(aYMin), (int) Math.ceil(aYMax), yTemp, currentPadding);

        return new int[]{xAxis, yAxis};
    }

    /**
     * Draws tags on the X axis.
     *
     * @param aMin        double with the minimum value for the axis.
     * @param aMax        double with the maximum value for the axis.
     * @param aXScale     int with the scale to display for the X-axis labels (as used in BigDecimal's setScale).
     * @param g           Graphics object to draw on.
     * @param aXAxisWidth int with the axis width in pixels.
     * @param aPadding    int with the amount of padding to take into account.
     */
    protected void drawXTags(Graphics g, int aMin, int aMax, int aXScale, int aXAxisWidth, int aPadding) {

        // @TODO: increase the zooming resolution!!!
        // Font Metrics. We'll be needing these.
        FontMetrics fm = g.getFontMetrics();

        // this.setFont(new Font(this.getFont().getName(),
        // this.getFont().getStyle(), 18));

        // find the scale unit
        double delta = aMax - aMin;
        iXScaleUnit = delta / aXAxisWidth; // note: do not alter! also used when
        // drawing the peaks

        // The next section will only be drawn for spectra.
        if (currentGraphicsPanelType.equals(GraphicsPanelType.centroidSpectrum)
                || currentGraphicsPanelType.equals(GraphicsPanelType.profileSpectrum)) {

            if (!miniature) {

                // Since we know the scale unit, we also know the resolution.
                // This will be displayed on the bottom line.
                String resolution = "";
                if (showResolution) {
                    resolution = "Resolution: "
                            + new BigDecimal(iXScaleUnit).setScale(2, BigDecimal.ROUND_HALF_UP).toString();
                }

                // Also print the MS level and precursor MZ and charge (if known, '?' otherwise).
                String msLevel_and_optional_precursor = "";
                if (showPrecursorDetails) {
                    msLevel_and_optional_precursor = "MS level: " + iMSLevel;

                    if (iMSLevel > 0) {
                        // Also print the precursor MZ and charge (if known, '?' otherwise).
                        msLevel_and_optional_precursor += "   Precursor M/Z: " + this.iPrecursorMZ + " ("
                                + this.iPrecursorCharge + ")";
                    } else {
                        msLevel_and_optional_precursor = "Precursor M/Z: " + this.iPrecursorMZ + " ("
                                + this.iPrecursorCharge + ")";
                    }
                }

                // Finally, we also want the filename.
                String filename = "";
                if (showFileName) {
                    filename = "Filename: " + iFilename;
                }

                int precLength = fm.stringWidth(msLevel_and_optional_precursor);
                int resLength = fm.stringWidth(resolution);
                int xDistance = ((this.getWidth() - (iXPadding * 2)) / 4) - (precLength / 2);
                int fromBottom = fm.getAscent() / 2;
                Font oldFont = this.getFont();

                int smallFontCorrection = 0;
                int yHeight = this.getHeight() - fromBottom;
                int xAdditionForResolution = precLength + 15;
                int xAdditionForFilename = xAdditionForResolution + resLength + 15;

                if (precLength + resLength + 45 + fm.stringWidth(filename) > aXAxisWidth) {
                    g.setFont(new Font(oldFont.getName(), oldFont.getStyle(), oldFont.getSize() - 2));
                    smallFontCorrection = g.getFontMetrics().getAscent();
                    xAdditionForFilename = g.getFontMetrics().stringWidth(msLevel_and_optional_precursor) + 5;
                    xAdditionForResolution = g.getFontMetrics().stringWidth(msLevel_and_optional_precursor) / 2;
                    xDistance = aPadding;
                }

                g.drawString(msLevel_and_optional_precursor, xDistance, yHeight - smallFontCorrection);
                g.drawString(resolution, xDistance + xAdditionForResolution, yHeight);

                Color foreground = null;

                if (iFilenameColor != null) {
                    foreground = g.getColor();
                    g.setColor(iFilenameColor);
                }

                g.drawString(filename, xDistance + xAdditionForFilename, yHeight - smallFontCorrection);

                if (foreground != null) {
                    g.setColor(foreground);
                }

                // Restore original font.
                g.setFont(oldFont);
            }
        }

        if (!miniature) {

            int labelHeight = fm.getAscent() + 5;

            // Find out how many tags we have room for
            int tagWidthEstimate = fm.stringWidth("1545") + 15;
            int numberTimes = (aXAxisWidth / tagWidthEstimate);

            // find the scale unit for the x tags
            double scaleUnitXTags = aXAxisWidth / delta;

            // try to find the optimal distance to use between the tags
            int distanceBetweenTags = findOptimalTagDistance(numberTimes, delta);

            // set up the number formatting
            DecimalFormat numberFormat = new DecimalFormat();
            numberFormat.setGroupingSize(3);
            numberFormat.setGroupingUsed(true);

            if (scientificXAxis) {
                numberFormat = new DecimalFormat(scientificPattern);
            }

            int xAxisYLocation = this.getHeight();

            if (dataSetCounterMirroredSpectra > 0) {
                xAxisYLocation = (this.getHeight() + currentPadding) / 2;
            }

            // add the tags and values
            if (delta > 1) {

                long lTagValue = 0;

                // now we can mark the first unit
                for (int i = 0; i < aMax; i++) {

                    if ((aMin + i) % distanceBetweenTags == 0) {

                        int xLoc = (int) (aPadding + (i * scaleUnitXTags));

                        if (xLoc < (aPadding + aXAxisWidth)) {
                            g.drawLine(xLoc, xAxisYLocation - aPadding, xLoc, xAxisYLocation - aPadding + 3);
                            int labelAsInt = aMin + i;
                            String label = numberFormat.format(labelAsInt);
                            int labelWidth = fm.stringWidth(label);

                            boolean drawValue = true;
                            if (labelAsInt == 0 && dataSetCounterMirroredSpectra > 0) {
                                drawValue = false;
                            }
                            if (drawValue) {
                                g.drawString(label, xLoc - (labelWidth / 2), xAxisYLocation - aPadding + labelHeight);
                            }

                            lTagValue = i;
                            break;
                        }
                    }
                }

                // now we can mark the rest of the units
                while (lTagValue < aMax && distanceBetweenTags > 0) {
                    int xLoc = (int) (aPadding + (lTagValue * scaleUnitXTags));
                    if (xLoc < (aPadding + aXAxisWidth)) {
                        g.drawLine(xLoc, xAxisYLocation - aPadding, xLoc, xAxisYLocation - aPadding + 3);
                        long labelAsInt = aMin + lTagValue;
                        String label = numberFormat.format(labelAsInt);
                        int labelWidth = fm.stringWidth(label);
                        boolean drawValue = true;
                        if (labelAsInt == 0 && dataSetCounterMirroredSpectra > 0) {
                            drawValue = false;
                        }
                        if (drawValue) {
                            g.drawString(label, xLoc - (labelWidth / 2), xAxisYLocation - aPadding + labelHeight);
                        }
                    }
                    lTagValue += distanceBetweenTags;
                }

            } else {

                // special case for when zoom size is 1Da. we then need to use
                // float values, e.g., 155.1, 155.2 etc.
                // first find how many tags we have room for: 10, 5, 2 or 1
                int numberOfTags = 10;

                // find the scale unit for the x tags
                if (numberTimes >= numberOfTags) {
                    scaleUnitXTags = aXAxisWidth / numberOfTags;
                } else {
                    numberOfTags = 5;

                    if (numberTimes >= numberOfTags) {
                        scaleUnitXTags = aXAxisWidth / numberOfTags;
                    } else {
                        numberOfTags = 2;

                        if (numberTimes >= numberOfTags) {
                            numberOfTags = 1;
                        }
                    }
                }

                // add the tags
                for (int i = 0; i < numberOfTags; i++) {

                    int xLoc = (int) (aPadding + (i * scaleUnitXTags));

                    if (xLoc < (aPadding + aXAxisWidth)) {
                        g.drawLine(xLoc, this.getHeight() - aPadding, xLoc, this.getHeight() - aPadding + 3);
                        double labelAsdouble = aMin + ((1 / (double) numberOfTags) * i);
                        String label = numberFormat.format(labelAsdouble);
                        int labelWidth = fm.stringWidth(label);
                        g.drawString(label, xLoc - (labelWidth / 2), this.getHeight() - aPadding + labelHeight);
                    }
                }
            }
        }
    }

    /**
     * This method draws tags on the Y axis.
     *
     * @param aMin         double with the minimum value for the axis.
     * @param aMax         double with the maximum value for the axis.
     * @param g            Graphics object to draw on.
     * @param aYAxisHeight int with the axis height in pixels.
     * @param aPadding     int with the amount of padding to take into account.
     */
    protected void drawYTags(Graphics g, int aMin, int aMax, int aYAxisHeight, int aPadding) {

        // Font Metrics. We'll be needing these.
        FontMetrics fm = g.getFontMetrics();
        int labelHeight = fm.getAscent();

        // Find out how many tags we have room for
        int tagHeightEstimate = labelHeight + 10;
        int numberTimes = (aYAxisHeight / tagHeightEstimate);

        // find the scale unit
        double delta = aMax - aMin;
        iYScaleUnit = delta / aYAxisHeight; // note: do not alter! also used
        // when drawing the peaks

        if (!miniature) {

            // find the scale unit for the x tags
            double scaleUnitYTags = aYAxisHeight / delta;

            // find the optimal distance to use between the tags
            int distanceBetweenTags = findOptimalTagDistance(numberTimes, delta);

            // set up the number formatting
            DecimalFormat numberFormat = new DecimalFormat();
            numberFormat.setGroupingSize(3);
            numberFormat.setGroupingUsed(true);

            if (scientificYAxis) {
                numberFormat = new DecimalFormat(scientificPattern);
            }

            // max y-value to display
            String largestLabel = numberFormat.format((int) aMax);

            // old font storage
            Font oldFont = g.getFont();

            // find the required scaling level for the y-axis tags
            int sizeCounter = 0;
            int margin = aPadding - 10;

            while (g.getFontMetrics().stringWidth(largestLabel) >= margin) {
                sizeCounter++;
                g.setFont(new Font(oldFont.getName(), oldFont.getStyle(), oldFont.getSize() - sizeCounter));
            }

            // set the font to use for the y-axis tags
            if (oldFont.getSize() - sizeCounter > 0) {
                g.setFont(new Font(oldFont.getName(), oldFont.getStyle(), oldFont.getSize() - sizeCounter));
            } else {
                // have to make sure that the font at least has a size of 1
                g.setFont(new Font(oldFont.getName(), oldFont.getStyle(), 1));
            }

            int height = this.getHeight();

            if (dataSetCounterMirroredSpectra > 0) {
                height = this.getHeight() - (((this.getHeight() - currentPadding)) / 2);
            }

            long lTagValue = 0;
            while (lTagValue < aMax) {
                int yLoc = (int) (aPadding + (lTagValue * scaleUnitYTags));
                g.drawLine(aPadding, height - yLoc, aPadding - 3, height - yLoc);
                long labelAsInt = aMin + lTagValue;
                String label = numberFormat.format(labelAsInt);
                int labelWidth = g.getFontMetrics().stringWidth(label) + 5;
                g.drawString(label, aPadding - labelWidth, height - yLoc + (g.getFontMetrics().getAscent() / 2) - 1);
                lTagValue = lTagValue + distanceBetweenTags;
            }

            if (dataSetCounterMirroredSpectra > 0) {

                height = (this.getHeight() - currentPadding * 3) / 2;

                lTagValue = 0;
                while (lTagValue < aMax) {
                    int yLoc = (int) (aPadding + (lTagValue * scaleUnitYTags));
                    long labelAsInt = aMin + lTagValue;

                    if (labelAsInt != 0) {
                        g.drawLine(aPadding, height + yLoc, aPadding - 3, height + yLoc);
                        String label = numberFormat.format(labelAsInt);
                        int labelWidth = g.getFontMetrics().stringWidth(label) + 5;
                        g.drawString(label, aPadding - labelWidth,
                                height + yLoc + (g.getFontMetrics().getAscent() / 2) - 1);
                    }

                    lTagValue = lTagValue + distanceBetweenTags;
                }
            }

            // restore original font
            g.setFont(oldFont);
        }
    }

    /**
     * Try to find the optimal distance between the tags. The most detailed
     * option is always used, i.e., the option containing the most tags within
     * the current boundaries. Note always returns a round number, e.g., 1, 5,
     * 10, 25, 50, etc.
     *
     * @param maxNumberOfTags the maximum number of tags there is room for
     * @param delta           the difference between the max and the min value
     * @return the optimal distance between the tags
     */
    private int findOptimalTagDistance(int maxNumberOfTags, double delta) {

        // the two smallest tag options
        int[] distanceAlternatives = {1, 5};

        int optimalDistance = 1;
        boolean optimalDistanceFound = false;

        // check if the two minimum tag options can be used
        for (int i = 0; i < distanceAlternatives.length && !optimalDistanceFound; i++) {
            if (delta / distanceAlternatives[i] <= maxNumberOfTags) {
                optimalDistance = distanceAlternatives[i];
                optimalDistanceFound = true;
            }
        }

        int tempOptimalDistance = 10;

        // find the optimal tag distance
        while (!optimalDistanceFound) {

            if (delta / (tempOptimalDistance * 2.5) <= maxNumberOfTags) {
                optimalDistance = Double.valueOf(tempOptimalDistance * 2.5).intValue();
                optimalDistanceFound = true;
            }

            if (delta / (tempOptimalDistance * 5) <= maxNumberOfTags && !optimalDistanceFound) {
                optimalDistance = Double.valueOf(tempOptimalDistance * 5).intValue();
                optimalDistanceFound = true;
            }

            if (delta / (tempOptimalDistance * 10) <= maxNumberOfTags && !optimalDistanceFound) {
                optimalDistance = Double.valueOf(tempOptimalDistance * 10).intValue();
                optimalDistanceFound = true;
            }

            tempOptimalDistance *= 10;
        }

        return optimalDistance;
    }

    /**
     * This method will draw a highlighting triangle + x-value on top of the
     * marked point.
     *
     * @param aIndex       int with the index of the point to highlight
     * @param dataSetIndex the index of the dataset
     * @param g            Graphics object to draw the highlighting on
     * @param mirrored     if true the highlighted peak is from a mirrored spectrum
     */
    protected void highLightPeak(int aIndex, int dataSetIndex, Graphics g, boolean mirrored) {
        if (!mirrored) {
            this.highLight(aIndex, dataSetIndex, g, Color.blue, null, 0, true, 1, mirrored);
        } else {
            this.highLight(aIndex, dataSetIndex, g, Color.blue, null, 20, true, 1, mirrored);
        }
    }

    /**
     * This method will draw a highlighting triangle + x-value on top of the
     * clicked marked point.
     *
     * @param aIndex       int with the index of the clicked point to highlight
     * @param dataSetIndex the index of the dataset
     * @param g            Graphics object to draw the highlighting on
     * @param mirrored     if true the highlighted peak is from a mirrored spectrum
     */
    protected void highlightClicked(int aIndex, int dataSetIndex, Graphics g, boolean mirrored) {
        this.highLight(aIndex, dataSetIndex, g, Color.BLACK, null, 0, true, 1, mirrored);
    }

    /**
     * Highlight the specified point in the specified color by
     * drawing a floating triangle + x-value above it.
     *
     * @param aIndex             int with the index.
     * @param dataSetIndex       the index of the dataset
     * @param g                  Graphics object to draw on
     * @param aColor             Color to draw the highlighting in.
     * @param aComment           String with an optional comment. Can be 'null' in which
     *                           case it will be omitted.
     * @param aPixelsSpacer      int that gives the vertical spacer in pixels for the
     *                           highlighting.
     * @param aShowArrow         boolean that indicates whether a downward-pointing
     *                           arrow and dotted line should be drawn over the point.
     * @param aAnnotationCounter the number of annotation of the given peak
     * @param mirrored           if true the highlighting is done on the mirrored spectra
     */
    protected void highLight(int aIndex, int dataSetIndex, Graphics g, Color aColor, String aComment, int aPixelsSpacer,
            boolean aShowArrow, int aAnnotationCounter, boolean mirrored) {

        int x;

        if (!mirrored) {
            x = iXAxisDataInPixels.get(dataSetIndex)[aIndex];
        } else {
            x = iXAxisDataInPixelsMirroredSpectrum.get(dataSetIndex)[aIndex];
        }

        int y;

        if (aPixelsSpacer < 0) {
            if (!mirrored) {
                y = iTopPadding;
            } else {
                y = this.getHeight() - iTopPadding;
            }
        } else {
            if (!mirrored) {
                y = iYAxisDataInPixels.get(dataSetIndex)[aIndex] - aPixelsSpacer;
            } else {
                y = iYAxisDataInPixelsMirroredSpectrum.get(dataSetIndex)[aIndex] + (aPixelsSpacer / 2); // @TODO:
                // what is the correct aPixelsSpacer value?
            }

            // special case for when top peak is annotated with multiple annotations
            if (y < 0) {
                y = (iTopPadding / 3) - (aAnnotationCounter - 3) * (g.getFontMetrics().getAscent() + 4); // @TODO:
                // what about mirrored spectra?
            }
        }

        // Correct for absurd heights.
        if (!mirrored) {
            if (dataSetCounterMirroredSpectra == 0) {
                if (y < iTopPadding / 3) {
                    y = (iTopPadding / 3) - (aAnnotationCounter - 3) * (g.getFontMetrics().getAscent() + 4);
                }
            } else {
                y = iYAxisDataInPixels.get(dataSetIndex)[aIndex] - aPixelsSpacer;
                if (y < iTopPadding / 3) {
                    y = maxPadding - aAnnotationCounter * (g.getFontMetrics().getAscent() + 4); // @TODO:
                    // check if this makes sense...
                }
            }
        } else {
            if (y > this.getHeight() - iXPadding) {
                y = this.getHeight() - iXPadding; // @TODO: check... and what
                // about multiple annotations?
            }
        }

        // Temporarily change the color
        Color originalColor = g.getColor();
        g.setColor(aColor);

        // Draw the triangle first, if appropriate.
        int arrowSpacer = 10;
        if (aShowArrow) {
            if (!mirrored) {
                g.fillPolygon(new int[]{x - 3, x + 3, x}, new int[]{y - 6, y - 6, y - 3}, 3);
                arrowSpacer = 13;
            } else {
                g.fillPolygon(new int[]{x - 4, x + 4, x}, new int[]{y - 3, y - 3, y - 8}, 3);
                arrowSpacer = -10;
            }
        }

        Graphics2D g2d = (Graphics2D) g;
        AffineTransform defaultAt = g2d.getTransform();
        AffineTransform affineTransform = AffineTransform.getQuadrantRotateInstance(3);
        g2d.setTransform(affineTransform);
//        
        // Now the x-value.
        // If there is any, print the comment instead of the x-value.
        if (aComment != null && !aComment.trim().equals("")) {
            aComment = aComment.trim();

            if (subscriptAnnotationNumbers) {
                int commentXStart = -(y-arrowSpacer);
//                		x - g2d.getFontMetrics().stringWidth(aComment) / 2;
                Font oldFont = g2d.getFont();

                for (int i = 0; i < aComment.length(); i++) {

                    int tempX = commentXStart + g2d.getFontMetrics().stringWidth(aComment.substring(0, i));

                    if (Character.isDigit(aComment.charAt(i))) {
                    	g2d.setFont(new Font(oldFont.getName(), oldFont.getStyle(), oldFont.getSize() - 2));
                    	g2d.drawString("" + aComment.charAt(i), tempX, x + g2d.getFontMetrics().getAscent()/4 + 3);
                    } else {
                    	g2d.drawString("" + aComment.charAt(i), tempX, x + g2d.getFontMetrics().getAscent()/4);
                    }

                    g2d.setFont(oldFont);
                }
            } else {
            	// to let string visible, the x should be negative
            	g2d.drawString(aComment, -(y-arrowSpacer), x + g2d.getFontMetrics().getAscent()/4);
            }
        } else {
            // No comment, so print the x- and y-value. Note: both are rounded to four decimals
            String xValue;
            String yValue;

            if (!mirrored) {
                xValue = Double.toString(MathUtil.round(iXAxisData.get(dataSetIndex)[aIndex], 4));
                yValue = Double.toString(MathUtil.round(iYAxisData.get(dataSetIndex)[aIndex], 4));
            } else {
                xValue = Double.toString(MathUtil.round(iXAxisDataMirroredSpectrum.get(dataSetIndex)[aIndex], 4));
                yValue = Double.toString(MathUtil.round(iYAxisDataMirroredSpectrum.get(dataSetIndex)[aIndex], 4));
            }

            String label = "(" + xValue + ", " + yValue + ")";

            int halfWayMass = g2d.getFontMetrics().stringWidth(label) / 2;
            g2d.drawString(label, x - halfWayMass, y - arrowSpacer);
        }

        g2d.setTransform(defaultAt);
        // If we drew above/below the point, drop a dotted line.
        if (aPixelsSpacer != 0 && aShowArrow) {
            if (!mirrored) {
                dropDottedLine(aIndex, dataSetIndex, y + 2, g, mirrored);
            } else {
                dropDottedLine(aIndex, dataSetIndex, y - 4, g, mirrored);
            }
        }

        // Restore original color.
        g.setColor(originalColor);
    }

    /**
     * This method draws a line, measuring the distance between two points in
     * real mass units.
     *
     * @param aFirstIndex         int with the first point index to draw from.
     * @param aFirstDatasetIndex  the dataset index of the first data point
     * @param aSecondIndex        int with the second point index to draw to.
     * @param aSecondDatasetIndex the dataset index of the second data point
     * @param g                   Graphics object on which to draw.
     * @param aColor              Color object with the color for all the drawing.
     * @param aExtraPadding       int with an optional amount of extra padding (lower
     *                            on the graph if positive, higher on the graph if negative)
     * @param mirrored            if true the line is drawn for the mirrored spectra
     */
    protected void drawMeasurementLine(int aFirstIndex, int aFirstDatasetIndex, int aSecondIndex,
            int aSecondDatasetIndex, Graphics g, Color aColor, int aExtraPadding, boolean
            mirrored) {

        // First get the x coordinates of the two points.
        int x1;
        int x2;
        ArrayList<double[]> xAxisData;

        if (!mirrored) {
            x1 = iXAxisDataInPixels.get(aFirstDatasetIndex)[aFirstIndex];
            x2 = iXAxisDataInPixels.get(aSecondDatasetIndex)[aSecondIndex];
            xAxisData = iXAxisData;
        } else {
            x1 = iXAxisDataInPixelsMirroredSpectrum.get(aFirstDatasetIndex)[aFirstIndex];
            x2 = iXAxisDataInPixelsMirroredSpectrum.get(aSecondDatasetIndex)[aSecondIndex];
            xAxisData = iXAxisDataMirroredSpectrum;
        }

        if (x1 == 0 && x2 == 0) {
            return;
        } else if (x1 == 0) {
            if (xAxisData.get(aFirstDatasetIndex)[aFirstIndex] < iXAxisMin) {
                x1 = iXPadding + 1;
            } else {
                x1 = this.getWidth() - iXPadding - 1;
            }
        } else if (x2 == 0) {
            if (xAxisData.get(aSecondDatasetIndex)[aSecondIndex] < iXAxisMin) {
                x2 = iXPadding + 1;
            } else {
                x2 = this.getWidth() - iXPadding - 1;
            }
        }

        // Now the real x-value difference as a String.
        double delta = Math
                .abs(xAxisData.get(aFirstDatasetIndex)[aFirstIndex] - xAxisData.get(aSecondDatasetIndex)[aSecondIndex]);
        String deltaMass = new BigDecimal(delta).setScale(2, BigDecimal.ROUND_HALF_UP).toString();
        String deNovoTag = this.findDeltaMassMatches(delta, deltaMassWindow);

        int deNovoTagWidth = g.getFontMetrics().stringWidth(deNovoTag);
        int deltaMassWidth = g.getFontMetrics().stringWidth(deltaMass);

        // Vertical position of the bar with the position of the highest point + a margin.
        int y;

        if (!mirrored) {
            y = (int) (iYScaleUnit / iYAxisMax + (iXPadding / 2)) + aExtraPadding;
        } else {
            y = this.getHeight() - iXPadding - aExtraPadding;
        }

        // Draw the line.
        Color originalColor = g.getColor();
        g.setColor(aColor);
        g.drawLine(x1, y, x2, y);
        g.drawLine(x1, y - 3, x1, y + 3);
        g.drawLine(x2, y - 3, x2, y + 3);

        // Drop a dotted line down to the peaks.
        dropDottedLine(aFirstIndex, aFirstDatasetIndex, y - 3, g, mirrored);
        dropDottedLine(aSecondIndex, aSecondDatasetIndex, y - 3, g, mirrored);

        // Draw the de novo tag.
        int xPosText = Math.min(x1, x2) + (Math.abs(x1 - x2) / 2) - (deNovoTagWidth / 2);
        g.drawString(deNovoTag, xPosText, y - 5);

        // Draw the mass.
        xPosText = Math.min(x1, x2) + (Math.abs(x1 - x2) / 2) - (deltaMassWidth / 2);
        g.drawString(deltaMass, xPosText, y + 15);

        // Return original color.
        g.setColor(originalColor);
    }

    /**
     * This method drops a dotted line from the specified total height to the
     * top of the indicated point.
     *
     * @param aPeakIndex    int with the index of the point to draw the dotted line for.
     * @param aDatasetIndex the index of the dataset
     * @param aTotalHeight  int with the height (in pixels) to drop the dotted line from.
     * @param g             Graphics object to draw the dotted line on.
     * @param mirrored      if true the line is drawn on the mirrored spectra
     */
    protected void dropDottedLine(int aPeakIndex, int aDatasetIndex, int aTotalHeight, Graphics g, boolean mirrored) {

        int x;
        int y;

        if (!mirrored) {
            x = iXAxisDataInPixels.get(aDatasetIndex)[aPeakIndex];
            y = iYAxisDataInPixels.get(aDatasetIndex)[aPeakIndex];
        } else {
            x = iXAxisDataInPixelsMirroredSpectrum.get(aDatasetIndex)[aPeakIndex];
            y = iYAxisDataInPixelsMirroredSpectrum.get(aDatasetIndex)[aPeakIndex];
        }

        if (!mirrored) {
            // Draw the dotted line.
            if ((y - aTotalHeight) > 10) {
                int start = aTotalHeight;
                while (start < y) {
                    g.drawLine(x, start, x, start + 2);
                    start += 7;
                }
            }
        } else {
            // Draw the dotted line.
            if ((aTotalHeight - y) > 10) {
                int start = aTotalHeight;
                while (start > y) {
                    g.drawLine(x, start, x, start - 2);
                    start -= 7;
                }
            }
        }
    }

    /**
     * This method attempts to find a list of known mass deltas, corresponding
     * with the specified x value in the given window.
     *
     * @param aDelta  the delta mass to search for
     * @param aWindow the window used for the search
     * @return String with the description of the matching mass delta or empty
     * String if none was found.
     */
    protected String findDeltaMassMatches(double aDelta, double aWindow) {

        StringBuilder result = new StringBuilder("");
        boolean appended = false;

        if (iKnownMassDeltas != null) {
            for (Double mass : iKnownMassDeltas.keySet()) {
                if (Math.abs(mass - aDelta) < aWindow) {
                    if (appended) {
                        result.append(" ");
                    } else {
                        appended = true;
                    }
                    result.append(iKnownMassDeltas.get(mass));
                }
            }

            // add combinations of two mass deltas
            if (useMassDeltaCombinations) {

                // look for combinations of two mass deltas
                Iterator<Double> iter1 = iKnownMassDeltas.keySet().iterator();
                ArrayList<String> addedMassDeltas = new ArrayList<>();

                while (iter1.hasNext()) {
                    Double mass1 = iter1.next();

                    for (Double mass2 : iKnownMassDeltas.keySet()) {
                        Double mass = mass1 + mass2;

                        if (Math.abs(mass - aDelta) < aWindow) {

                            if (!addedMassDeltas
                                    .contains(iKnownMassDeltas.get(mass2) + "" + iKnownMassDeltas.get(mass1))) {

                                if (appended) {
                                    result.append(" ");
                                } else {
                                    appended = true;
                                }

                                result.append(iKnownMassDeltas.get(mass1)).append("")
                                        .append(iKnownMassDeltas.get(mass2));
                                addedMassDeltas.add(iKnownMassDeltas.get(mass1) + "" + iKnownMassDeltas.get(mass2));
                            }
                        }
                    }
                }
            }
        }

        return result.toString();
    }

    /**
     * This method attempts to find the specified SpectrumAnnotation in the
     * current peak list and if so, annotates it correspondingly on the screen.
     *
     * @param aSA               SpectrumAnnotation with the annotation to find.
     * @param g                 Graphics instance to annotate on.
     * @param aAlreadyAnnotated HashMap with the index of a point as key, and the number of times it has been
     *                          annotated as value (or 'null' if not yet annotated).
     * @param mirrored          if true the annotation is for the mirrored spectra
     */
    protected void annotate(SpectrumAnnotation aSA, Graphics g, HashMap<String, Integer> aAlreadyAnnotated,
            boolean mirrored) {

        double xValue = aSA.getMZ();
        double error = Math.abs(aSA.getErrorMargin());

        // Only do those that fall within the current visual range.
        if (!(xValue < iXAxisMin || xValue > iXAxisMax)) {

            ArrayList<double[]> xAxisData;
            ArrayList<double[]> yAxisData;

            if (!mirrored) {
                xAxisData = iXAxisData;
                yAxisData = iYAxisData;
            } else {
                xAxisData = iXAxisDataMirroredSpectrum;
                yAxisData = iYAxisDataMirroredSpectrum;
            }

            // See if any match is to be found.
            boolean foundMatch = false;
            int peakIndex = -1;
            int dataSetIndex = -1;
            double smallestAbsError = Double.MAX_VALUE;

            for (int j = 0; j < xAxisData.size(); j++) {
                for (int i = 0; i < xAxisData.get(j).length; i++) {
                    double delta = xAxisData.get(j)[i] - xValue;
                    if (Math.abs(delta) <= error) {
                        if (!foundMatch) {
                            foundMatch = true;
                            peakIndex = i;
                            dataSetIndex = j;
                            smallestAbsError = Math.abs(delta);
                        } else {
                            // we already had one. take the one with the largest intensity or the most accurate
                            if (annotateHighestPeak) {
                                if (yAxisData.get(j)[i] > yAxisData.get(dataSetIndex)[peakIndex]) {
                                    peakIndex = i;
                                    dataSetIndex = j;
                                }
                            } else {
                                if (Math.abs(delta) < smallestAbsError) {
                                    peakIndex = i;
                                    dataSetIndex = j;
                                }
                            }
                        }
                    } else if (delta > error) {
                        break;
                    }
                }
            }

            // If a match was found and it qualifies against the minimal intensity,
            // we now have a peak index so we can annotate.
            if (foundMatch && yAxisData.get(dataSetIndex)[peakIndex] > iAnnotationYAxisThreshold) {
                // String label = aSA.getLabel() + " (" + new BigDecimal(mz-iMasses[peakIndex]).setScale(2,
                // BigDecimal.ROUND_HALF_UP).toString() + ")";
                String label = aSA.getLabel();
                int spacer = (int) ((yAxisData.get(dataSetIndex)[peakIndex] - iYAxisMin) / iYScaleUnit) / 2; // @TODO:
                // should this be different if mirrored?
                boolean showArrow = true;
                String key = dataSetIndex + "_" + peakIndex;
                if (aAlreadyAnnotated.containsKey(key)) {
                    int count = aAlreadyAnnotated.get(key);
                    spacer += count * (g.getFontMetrics().getAscent() + 4);
                    aAlreadyAnnotated.put(key, count + 1);
                    showArrow = false;
                } else {
                    aAlreadyAnnotated.put(key, 1);
                }
                this.highLight(peakIndex, dataSetIndex, g, aSA.getColor(), label, spacer, showArrow,
                        aAlreadyAnnotated.get(key), mirrored);
            }
        }
    }

    /**
     * This method draws all of the peaks for all datasets in the current x-axis
     * range on the panel.
     *
     * @param g Graphics object to draw on.
     */
    protected void drawMirroredPeaks(Graphics g) {

        // @TODO: should be merged with the drawPeaks method
        Color originalColor = g.getColor();

        // Init an array that holds pixel coordinates for each peak.
        iXAxisDataInPixelsMirroredSpectrum = new ArrayList<int[]>();
        iYAxisDataInPixelsMirroredSpectrum = new ArrayList<int[]>();

        // cycle the datasets
        for (int j = 0; j < iXAxisDataMirroredSpectrum.size(); j++) {

            // set the color
            g.setColor(iDataPointAndLineColorMirroredSpectra.get(j));

            iXAxisDataInPixelsMirroredSpectrum.add(new int[iXAxisDataMirroredSpectrum.get(j).length]);
            iYAxisDataInPixelsMirroredSpectrum.add(new int[iYAxisDataMirroredSpectrum.get(j).length]);

            // cycle the peaks for the dataset
            for (int i = 0; i < iXAxisDataMirroredSpectrum.get(j).length; i++) {

                double lXAxisValue = iXAxisDataMirroredSpectrum.get(j)[i];

                // Only draw those x values within the ('low x value', 'high x
                // value') window.
                if (lXAxisValue < iXAxisMin) {
                    continue;
                } else if (lXAxisValue > iXAxisMax) {
                    break;
                } else {

                    // is the peak annotated?
                    boolean annotatedPeak = true;

                    if (!showAllPeaks) {
                        annotatedPeak = isPeakAnnotated(lXAxisValue, true);
                    }

                    double lYAxisValue = iYAxisDataMirroredSpectrum.get(j)[i];

                    // Calculate pixel coordinates for x and y values.
                    // X value first.
                    double tempDouble = (lXAxisValue - iXAxisMin) / iXScaleUnit;
                    int temp = (int) tempDouble;

                    if ((tempDouble - temp) >= 0.5) {
                        temp++;
                    }

                    int xAxisPxl = temp + iXPadding;

                    if (annotatedPeak || showAllPeaks) {
                        iXAxisDataInPixelsMirroredSpectrum.get(j)[i] = xAxisPxl;
                    }

                    // Now intensity.
                    tempDouble = (lYAxisValue - iYAxisMin) / iYScaleUnit;
                    temp = (int) tempDouble;

                    if ((tempDouble - temp) >= 0.5) {
                        temp++;
                    }

                    int xAxisYLocation = (this.getHeight() + currentPadding) / 2;
                    int yValuePxl = xAxisYLocation + (temp - iXPadding);

                    if (annotatedPeak || showAllPeaks) {
                        iYAxisDataInPixelsMirroredSpectrum.get(j)[i] = yValuePxl;
                    }

                    // store the current peak color
                    Color currentColor = g.getColor();

                    // set the width of the peaks
                    Graphics2D g2 = (Graphics2D) g;
                    Stroke tempStroke = g2.getStroke();

                    // change the peak color if the peak is to be drawn in the background
                    if (!annotatedPeak && !showAllPeaks) {
                        g.setColor(peakWaterMarkColor);
                        BasicStroke stroke = new BasicStroke(backgroundPeakWidth);
                        g2.setStroke(stroke);
                    } else {
                        BasicStroke stroke = new BasicStroke(peakWidth);
                        g2.setStroke(stroke);
                    }

                    // draw the peak
                    if (iCurrentDrawStyle == DrawingStyle.LINES) {
                        // Draw the line.
                        g2.draw(new Line2D.Double(xAxisPxl, xAxisYLocation - iXPadding, xAxisPxl, yValuePxl));
                    } else if (iCurrentDrawStyle == DrawingStyle.DOTS) {
                        // Draw the dot.
                        g.fillOval(xAxisPxl - iDotRadius, yValuePxl - iDotRadius, iDotRadius * 2, iDotRadius * 2);
                    }

                    // reset the width of lines to the previous width
                    g2.setStroke(tempStroke);

                    g.setColor(currentColor);
                }
            }
        }

        // Change the color back to its original setting.
        g.setColor(originalColor);

    }

    /**
     * This method draws all of the peaks for all datasets in the current x-axis
     * range on the panel.
     *
     * @param g Graphics object to draw on.
     */
    protected void drawPeaks(Graphics g) {

        Color originalColor = g.getColor();

        // Init an array that holds pixel coordinates for each peak.
        iXAxisDataInPixels = new ArrayList<>();
        iYAxisDataInPixels = new ArrayList<>();

        // cycle the datasets
        for (int j = 0; j < iXAxisData.size(); j++) {

            // set the color
            g.setColor(iDataPointAndLineColor.get(j));

            iXAxisDataInPixels.add(new int[iXAxisData.get(j).length]);
            iYAxisDataInPixels.add(new int[iYAxisData.get(j).length]);

            // cycle the peaks for the dataset
            for (int i = 0; i < iXAxisData.get(j).length; i++) {

                double lXAxisValue = iXAxisData.get(j)[i];

                // Only draw those x values within the ('low x value', 'high x value') window.
                if (lXAxisValue < iXAxisMin) {
                    continue;
                } else if (lXAxisValue > iXAxisMax) {
                    break;
                } else {

                    // is the peak annotated?
                    boolean annotatedPeak = true;

                    if (!showAllPeaks) {
                        annotatedPeak = isPeakAnnotated(lXAxisValue, false);
                    }

                    double lYAxisValue = iYAxisData.get(j)[i];

                    // Calculate pixel coordinates for x and y values. X value first.
                    double tempDouble = (lXAxisValue - iXAxisMin) / iXScaleUnit;
                    int temp = (int) tempDouble;

                    if ((tempDouble - temp) >= 0.5) {
                        temp++;
                    }

                    int xAxisPxl = temp + iXPadding;

                    if (annotatedPeak || showAllPeaks) {
                        iXAxisDataInPixels.get(j)[i] = xAxisPxl;
                    }

                    // Now intensity.
                    tempDouble = (lYAxisValue - iYAxisMin) / iYScaleUnit;
                    temp = (int) tempDouble;

                    if ((tempDouble - temp) >= 0.5) {
                        temp++;
                    }

                    int xAxisYLocation = this.getHeight();

                    if (dataSetCounterMirroredSpectra > 0) {
                        xAxisYLocation = (this.getHeight() + currentPadding) / 2;
                    }

                    int yValuePxl = xAxisYLocation - (temp + iXPadding);

                    if (annotatedPeak || showAllPeaks) {
                        iYAxisDataInPixels.get(j)[i] = yValuePxl;
                    }

                    // store the current peak color
                    Color currentColor = g.getColor();

                    // set the width of the peaks
                    Graphics2D g2 = (Graphics2D) g;
                    Stroke tempStroke = g2.getStroke();

                    // change the peak color if the peak is to be drawn in the background
                    if (!annotatedPeak && !showAllPeaks) {
                        g.setColor(peakWaterMarkColor);
                        BasicStroke stroke = new BasicStroke(backgroundPeakWidth);
                        g2.setStroke(stroke);
                    } else {
                        BasicStroke stroke = new BasicStroke(peakWidth);
                        g2.setStroke(stroke);
                    }

                    // draw the peak
                    if (iCurrentDrawStyle == DrawingStyle.LINES) {
                        // Draw the line.
                        g2.draw(new Line2D.Double(xAxisPxl, xAxisYLocation - iXPadding, xAxisPxl, yValuePxl));
                    } else if (iCurrentDrawStyle == DrawingStyle.DOTS) {
                        // Draw the dot.
                        g.fillOval(xAxisPxl - iDotRadius, yValuePxl - iDotRadius, iDotRadius * 2, iDotRadius * 2);
                    }

                    // reset the width of lines to the previous width
                    g2.setStroke(tempStroke);

                    g.setColor(currentColor);
                }
            }
        }

        // Change the color back to its original setting.
        g.setColor(originalColor);
    }

    /**
     * This method draws filled polygons for all of the peaks for all datasets
     * in the current x-axis range on the panel.
     *
     * @param g Graphics object to draw on.
     */
    protected void drawFilledPolygon(Graphics g) {

        // switch to 2D graphics
        Graphics2D g2d = (Graphics2D) g;

        // store the original color
        Color originalColor = g2d.getColor();
        Composite originalComposite = g2d.getComposite();

        // init an array that holds pixel coordinates for each point.
        iXAxisDataInPixels = new ArrayList<>();
        iYAxisDataInPixels = new ArrayList<>();

        // cycle the datasets
        for (int j = 0; j < iXAxisData.size(); j++) {

            iXAxisDataInPixels.add(new int[iXAxisData.get(j).length]);
            iYAxisDataInPixels.add(new int[iYAxisData.get(j).length]);

            // These arrays only contain the visible points.
            ArrayList<Integer> xAxisPointsShown = new ArrayList<>();
            ArrayList<Integer> yAxisPointsShown = new ArrayList<>();

            // cycle the datapoints
            for (int i = 0; i < iXAxisData.get(j).length; i++) {

                double xMeasurement = iXAxisData.get(j)[i];

                // Only draw those x-axis measurements within the ('low x',
                // 'high x') window.
                if (xMeasurement < iXAxisMin) {
                    continue;
                } else if (xMeasurement > iXAxisMax) {
                    break;
                } else {
                    // See if we need to initialize the start index.
                    double yMeasurement = iYAxisData.get(j)[i];

                    // Calculate pixel coordinates for X and Y. X first.
                    double tempDouble = (xMeasurement - iXAxisMin) / iXScaleUnit;
                    int temp = (int) tempDouble;
                    if ((tempDouble - temp) >= 0.5) {
                        temp++;
                    }
                    int xAxisPxl = temp + iXPadding;
                    iXAxisDataInPixels.get(j)[i] = xAxisPxl;

                    // Now intensity.
                    tempDouble = (yMeasurement - iYAxisMin) / iYScaleUnit;
                    temp = (int) tempDouble;
                    if ((tempDouble - temp) >= 0.5) {
                        temp++;
                    }
                    int yAxisPxl = this.getHeight() - (temp + iXPadding);
                    iYAxisDataInPixels.get(j)[i] = yAxisPxl;

                    // Add to the list of points shwon.
                    xAxisPointsShown.add(xAxisPxl);
                    yAxisPointsShown.add(yAxisPxl);
                }
            }

            // check if there are any data points to draw
            if (!xAxisPointsShown.isEmpty()) {

                // set the color and opacity level
                g.setColor(iAreaUnderCurveColor.get(j));

                if (j != 0) {
                    g2d.setComposite(makeComposite(alphaLevel));
                }

                // First draw the filled polygon.
                int[] xTemp = new int[xAxisPointsShown.size() + 2];
                int[] yTemp = new int[yAxisPointsShown.size() + 2];
                xTemp[0] = xAxisPointsShown.get(0);
                yTemp[0] = this.getHeight() - iXPadding;
                for (int i = 0; i < xAxisPointsShown.size(); i++) {
                    xTemp[i + 1] = xAxisPointsShown.get(i);
                    yTemp[i + 1] = yAxisPointsShown.get(i);
                }
                xTemp[xTemp.length - 1] = xAxisPointsShown.get(xAxisPointsShown.size() - 1);
                yTemp[xTemp.length - 1] = this.getHeight() - iXPadding;

                // Fill out the chromatogram.
                g2d.fillPolygon(xTemp, yTemp, xTemp.length);

                // set the color
                g.setColor(iDataPointAndLineColor.get(j));

                // Now draw the points, and a line connecting them.
                g2d.drawPolyline(xTemp, yTemp, xTemp.length);

                // Skip the point for the first and last element;
                // these are just there to nicely fill the polygon.
                for (int i = 1; i < xTemp.length - 1; i++) {
                    int x = xTemp[i] - (iPointSize / 2);
                    int y = yTemp[i] - (iPointSize / 2);
                    g2d.fillOval(x, y, iPointSize, iPointSize);
                }

                g2d.setComposite(originalComposite);
            }
        }

        // Change the color back to its original setting.
        g2d.setColor(originalColor);
    }

    /**
     * Helper method for setting the opacity.
     *
     * @param alpha the opacity value, 0 means completely see-through, 1 means opaque.
     * @return an AlphaComposite object
     */
    private AlphaComposite makeComposite(float alpha) {
        int type = AlphaComposite.SRC_OVER;
        return (AlphaComposite.getInstance(type, alpha));
    }

    /**
     * Set if the x-axis tags are to be drawn using scientific annotation. The
     * default is false. The default pattern is "##0.#####E0".
     *
     * @param scientificXAxis if the x-axis tags is to be drawn using scientific annotation
     */
    public void setScientificXAxis(boolean scientificXAxis) {
        this.scientificXAxis = scientificXAxis;
    }

    /**
     * Set if the x-axis tags are to be drawn using scientific annotation. The
     * default is false. For pattern details see java.text.DecimalFormat. The
     * default pattern is "##0.#####E0".
     *
     * @param pattern the number format pattern to use
     */
    public void setScientificXAxis(String pattern) {
        this.scientificXAxis = true;
        this.scientificPattern = pattern;
    }

    /**
     * Set if the y-axis tags are to be drawn using scientific annotation. The
     * default is false. The default pattern is "##0.#####E0".
     *
     * @param scientificYAxis if the y-axis tags is to be drawn using scientific annotation
     */
    public void setScientificYAxis(boolean scientificYAxis) {
        this.scientificYAxis = scientificYAxis;
    }

    /**
     * Set if the y-axis tags are to be drawn using scientific annotation. The
     * default is false. For pattern details see java.text.DecimalFormat. The
     * default pattern is "##0.#####E0".
     *
     * @param pattern the number format pattern to use
     */
    public void setScientificYAxis(String pattern) {
        this.scientificYAxis = true;
        this.scientificPattern = pattern;
    }

    /**
     * Get the peak water mark color.
     *
     * @return the peak water mark color
     */
    public Color getPeakWaterMarkColor() {
        return peakWaterMarkColor;
    }

    /**
     * Set the peak water mark color.
     *
     * @param peakWaterMarkColor the color to set
     */
    public void setPeakWaterMarkColor(Color peakWaterMarkColor) {
        this.peakWaterMarkColor = peakWaterMarkColor;
    }

    /**
     * Returns true of the given x-axis value is annotated with at least one
     * annotation.
     *
     * @param xAxisValue the x-axis value
     * @param mirrored   if true checks for the mirrored peaks, false checks the
     *                   normal peaks
     * @return true of the given x-axis value is annotated with at least one
     * annotation
     */
    private boolean isPeakAnnotated(double xAxisValue, boolean mirrored) {

        Vector annotations;

        if (!mirrored) {
            annotations = iAnnotations;
        } else {
            annotations = iAnnotationsMirroredSpectra;
        }

        boolean annotatedPeak = false;

        for (int m = 0; m < annotations.size() && !annotatedPeak; m++) {
            Object o = annotations.get(m);
            if (o instanceof SpectrumAnnotation) {
                SpectrumAnnotation sa = (SpectrumAnnotation) o;

                double xValue = sa.getMZ();
                // @TODO :make sure that there is only one annotated peak per annotation!
                double error = Math.abs(sa.getErrorMargin());
                double delta = xAxisValue - xValue;

                if (Math.abs(delta) <= error) {
                    annotatedPeak = true;
                }
            }
        }

        return annotatedPeak;
    }
}
