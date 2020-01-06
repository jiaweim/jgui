package trail.jgui.ms;

import java.awt.event.ActionListener;

/**
 * Implement ActionListenable means the class is actionlistener aware.
 *
 * @author JiaweiMao
 * @version 1.00
 * @date Jun 12 2016, 21:23
 */
public interface ActionListenable {
	
	/**
	 * Add an action listener.
	 *
	 * @param listener action listener
	 */
	void addActionListener(ActionListener listener);

	/**
	 * Remove an action listener.
	 *
	 * @param listener action listener
	 */
	void removeActionListener(ActionListener listener);
}
