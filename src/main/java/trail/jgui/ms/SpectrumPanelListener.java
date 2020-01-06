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

/**
 * This interface describes the behavior for a listener that wants to receive
 * information about events that occurred on a SpectrumPanel.
 *
 * @author JiaweiMao
 * @version 1.00
 * @date Jun 01 2016, 13:49
 */
public interface SpectrumPanelListener {

	/**
	 * This method will be called whenever the SpectrumPanel is rescaled.
	 *
	 * @param aSe ResizingEvent with the details of the rescaling.
	 */
	void rescaled(RescalingEvent aSe);
}
