package trail.jgui.ms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import static javax.swing.SwingConstants.*;

/**
 * SideToolBar class creates an JPanel with side tool bar. It consists of three
 * main display areas:
 * <p/>
 * 1. side tool bar: new action commands can be added, an icon will be created
 * to bind to each action command.
 * <p/>
 * 2. side bar panel: new components can be added to this area, a corresponding
 * icon will be also added to the side tool bar, this icon will control the
 * visibility of the side bar panel.
 * <p/>
 * 3. the central component is the main display area, it can also be an action
 * listener which listens to the actions generated by the side tool bar or by
 * the side bar panel.
 * <p/>
 * To add components to the tool bar, there are two options:
 * <p/>
 * 1. Command component: add an icon to the side tool bar, it sends an action
 * event directly to the central component.
 * <p/>
 * 2. Side bar panel: add an component to the side bar panel, it sends action
 * events directly to the central component, an toggle button will be control
 * its visibility.
 * <p/>
 *
 * @author JiaweiMao
 * @version 1.00
 * @date Jun 12 2016, 21:20
 */
public class SideToolBarPanel extends JPanel implements ActionListener {
	/**
	 * default orientation of the side bar
	 */
	public final static int DEFAULT_ORIENTATION = EAST;

	/**
	 * the central component
	 */
	private JComponent centralComponent;

	/**
	 * side bar, contains side bar component and side bar
	 */
	private JPanel sideBarPanel;

	/**
	 * side tool bar
	 */
	private JToolBar sideToolBar;

	/**
	 * existing side bar panel component
	 */
	private JComponent visibleContainerComponent;

	/**
	 * Split between the central and the side tool bar
	 */
	private JSplitPane centralSplitPane;

	/**
	 * the orientation of the side bar, where it should be drawn
	 */
	private int orientation;

	/**
	 * action to button map The key could be either action command or action
	 * object.
	 */
	private Map<Object, AbstractButton> actionButtonMap;

	/**
	 * action to side bar panel component map The key could be either action
	 * command or action object.
	 */
	private Map<Object, JComponent> actionCommandMap;

	/**
	 * component to JToggleButton map
	 */
	private Map<JComponent, JToggleButton> componentButtonMap;

	/**
	 * Create a side tool bar panel with default settings.
	 */
	public SideToolBarPanel() {
		this(null, DEFAULT_ORIENTATION);
	}

	/**
	 * Create an side tool bar panel with empty central component
	 *
	 * @param orientation oritentation of the tool bar.
	 */
	public SideToolBarPanel(int orientation) {
		this(null, orientation);
	}

	/**
	 * Build a side tool bar pane with default orientation.
	 *
	 * @param centralComponent the main display component.
	 */
	public SideToolBarPanel(JComponent centralComponent) {
		this(centralComponent, DEFAULT_ORIENTATION);
	}

	/**
	 * Build a side tool bar pane with specific orientation.
	 * <p/>
	 * Orientation should be from SwingConstants, they can be: EAST, WEST, NORTH
	 * AND SOUTH.
	 *
	 * @param centralComponent the main display component.
	 * @param orientation the orientation.
	 */
	public SideToolBarPanel(JComponent centralComponent, int orientation) {
		this.setLayout(new BorderLayout());
		this.orientation = orientation;
		this.centralComponent = centralComponent;

		// side bar
		sideBarPanel = new JPanel();
		sideBarPanel.setLayout(new BorderLayout());

		// set side bar panel
		sideToolBar = new JToolBar();
		sideToolBar.setFloatable(false);
		sideToolBar.setRollover(true);
		sideToolBar.setOpaque(false);
		sideToolBar.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 1, Color.lightGray));

		// init action command map
		actionButtonMap = new HashMap<Object, AbstractButton>();
		actionCommandMap = new HashMap<Object, JComponent>();
		componentButtonMap = new HashMap<JComponent, JToggleButton>();

		// add the side bar depending on the orientation
		switch (this.orientation) {
		case EAST:
			sideToolBar.setOrientation(JToolBar.VERTICAL);
			sideBarPanel.add(sideToolBar, BorderLayout.LINE_END);
			centralSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, centralComponent, sideBarPanel);
			break;
		case WEST:
			sideToolBar.setOrientation(JToolBar.VERTICAL);
			sideBarPanel.add(sideToolBar, BorderLayout.LINE_START);
			centralSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, sideBarPanel, centralComponent);
			break;
		case NORTH:
			sideToolBar.setOrientation(JToolBar.HORIZONTAL);
			sideBarPanel.add(sideToolBar, BorderLayout.PAGE_START);
			centralSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, sideBarPanel, centralComponent);
			break;
		case SOUTH:
			sideToolBar.setOrientation(JToolBar.HORIZONTAL);
			sideBarPanel.add(sideToolBar, BorderLayout.PAGE_END);
			centralSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, centralComponent, sideBarPanel);
			break;
		}
		// set the split pane location
		centralSplitPane.setResizeWeight(getSplitPaneResizeWeight(0));
		centralSplitPane.setDividerSize(0);
		centralSplitPane.setBorder(BorderFactory.createEmptyBorder());

		this.add(centralSplitPane);
		centralSplitPane.resetToPreferredSizes();
	}

	/**
	 * get the splitpane's resize weight based on offset.
	 *
	 * @param offset offset for the right bottom component.
	 * @return double resize weight.
	 */
	private double getSplitPaneResizeWeight(double offset) {
		double weight;
		switch (orientation) {
		case EAST:
			weight = 1.0 - offset;
			break;
		case WEST:
			weight = offset;
			break;
		case NORTH:
			weight = 1.0 - offset;
			break;
		case SOUTH:
			weight = offset;
			break;
		default:
			weight = 1.0 - offset;
		}

		return weight;
	}

	/**
	 * Get the central component.
	 *
	 * @return JComponent central component.
	 */
	public JComponent getMainComponent() {
		return centralComponent;
	}

	/**
	 * Set the central component.
	 *
	 * @param component new central component.
	 */
	public void setMainComponent(JComponent component) {
		// dispose the old central component first.
		if (centralComponent != null) {

			centralSplitPane.remove(centralComponent);
			if (centralComponent instanceof ActionListener) {
				// remove it as ActionListener from all the buttons.
				for (AbstractButton button : actionButtonMap.values()) {
					button.removeActionListener((ActionListener) centralComponent);
				}
				// remove it as ActionListener from all the side bar panel
				// component.
				for (JComponent sbPane : actionCommandMap.values()) {
					if (sbPane instanceof ActionListenable) {
						((ActionListenable) sbPane).removeActionListener((ActionListener) centralComponent);
					}
				}
			}
		}

		// set the new central component
		this.centralComponent = component;
		if (centralComponent != null) {
			switch (this.orientation) {
			case EAST:
				centralSplitPane.setTopComponent(component);
				break;
			case WEST:
				centralSplitPane.setBottomComponent(component);
				break;
			case NORTH:
				centralSplitPane.setBottomComponent(component);
				break;
			case SOUTH:
				centralSplitPane.setTopComponent(component);
				break;
			default:
				centralSplitPane.setBottomComponent(component);
			}
		}
	}

	/**
	 * Add an action to the side tool bar
	 *
	 * @param action action
	 * @param isToggle whether to create a toggle button
	 * @return JComponent return the button represents the input component on
	 *         the side tool bar
	 */
	public JComponent addAction(Action action, boolean isToggle) {
		// create an button
		AbstractButton button = createButton(action, isToggle);
		sideToolBar.add(button);
		actionButtonMap.put(action, button);
		// add action listener
		button.addActionListener(this);

		return button;
	}

	/**
	 * Add an command button to the side tool bar.
	 *
	 * @param icon icon for the button.
	 * @param label label for the button.
	 * @param tooltip tool tip for the button.
	 * @param actionCommand the action command for this button.
	 * @param isToggle whether to create a toggle button.
	 * @return JComponent return the button represents the input component on
	 *         the side tool bar
	 */
	public JComponent addCommand(Icon icon, String label, String tooltip, String actionCommand, boolean isToggle) {
		// create an button
		AbstractButton button = createButton(icon, label, tooltip, actionCommand, isToggle);
		sideToolBar.add(button);
		actionButtonMap.put(actionCommand, button);
		// add action listener
		button.addActionListener(this);

		return button;
	}

	/**
	 * Add an component to the side bar panel as well as adding an button to the
	 * side tool bar.
	 *
	 * @param icon icon for the button.
	 * @param label label for the button.
	 * @param tooltip tool tip for the button.
	 * @param actionCommand the action command for this button.
	 * @param component the component to be added to the side bar panel.
	 * @return JComponent return the button represents the input component on
	 *         the side tool bar
	 */
	public JComponent addComponent(Icon icon, String label, String tooltip, String actionCommand,
			JComponent component) {
		// create a button
		JToggleButton button = (JToggleButton) createButton(icon, label, tooltip, actionCommand, true);
		sideToolBar.add(button);
		// register the button
		actionButtonMap.put(actionCommand, button);
		actionCommandMap.put(actionCommand, component);
		componentButtonMap.put(component, button);
		// add action listener
		button.addActionListener(this);
		if (component instanceof ActionListenable) {
			((ActionListenable) component).addActionListener(this);
		}

		return button;
	}

	/**
	 * Remove an action command from this panel
	 *
	 * @param actionCommand action command to be removed
	 */
	public void removeActionCommand(String actionCommand) {
		AbstractButton button = actionButtonMap.get(actionCommand);

		// remove the button
		if (button != null) {
			sideToolBar.remove(button);
			if (centralComponent != null && centralComponent instanceof ActionListener) {
				button.removeActionListener((ActionListener) centralComponent);
			}
		}
	}

	/**
	 * Remove an action from this panel, it also removes all its related
	 * components.
	 *
	 * @param action action command.
	 */
	public void removeAction(Object action) {
		AbstractButton button = actionButtonMap.get(action);
		// remove the button
		if (button != null) {
			sideToolBar.remove(button);
			if (centralComponent != null && centralComponent instanceof ActionListener) {
				button.removeActionListener((ActionListener) centralComponent);
			}
			// remove the side tool bar pane
			actionCommandMap.remove(action);
		}
	}

	/**
	 * Invoke an action command or action from the side bar
	 *
	 * @param action either action or action command
	 */
	public void invokeAction(Object action) {
		AbstractButton button = actionButtonMap.get(action);
		if (button != null) {
			button.doClick();
		}
	}

	/**
	 * Set the visibility of a action command
	 *
	 * @param actionCommand action command
	 * @param isEnabled true to visible, false to invisible
	 */
	public void enableActionCommand(String actionCommand, boolean isEnabled) {
		enableActionControl(actionCommand, isEnabled);
	}

	/**
	 * Set the visibility of a action command
	 *
	 * @param action action command
	 * @param isEnabled true to visible, false to invisible
	 */
	public void enableAction(Object action, boolean isEnabled) {
		enableActionControl(action, isEnabled);
	}

	private void enableActionControl(Object action, boolean isEnabled) {
		AbstractButton button = actionButtonMap.get(action);
		if (button != null) {
			button.setEnabled(isEnabled);
		}
	}

	/**
	 * Check whether the button associated with an action is toggled.
	 *
	 * @param action input action can be either action command or action object.
	 * @return boolean return true if the button is a toggle button and is
	 *         toggled.
	 */
	public boolean isToggled(Object action) {
		AbstractButton button = actionButtonMap.get(action);
		return button != null && button instanceof JToggleButton && button.isSelected();
	}

	/**
	 * Set the visibility of the side bar panel.
	 *
	 * @param e action event.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if (actionCommandMap.containsKey(command)) {
			JComponent component = actionCommandMap.get(command);
			if (component != null) {
				if (visibleContainerComponent != null) {
					sideBarPanel.remove(visibleContainerComponent);
					centralSplitPane.setDividerSize(0);
				}

				JToggleButton button = componentButtonMap.get(visibleContainerComponent);
				if (button != null) {
					button.setSelected(false);
				}

				if (!component.equals(visibleContainerComponent)) {
					sideBarPanel.add(component, BorderLayout.CENTER);
					visibleContainerComponent = component;
					centralSplitPane.setDividerSize(5);
				} else {
					visibleContainerComponent = null;
				}
				centralSplitPane.resetToPreferredSizes();
			}
		}

		if (centralComponent != null && centralComponent instanceof ActionListener) {
			((ActionListener) centralComponent).actionPerformed(e);
		}
	}

	/**
	 * Add a gap to the tool bar.
	 *
	 * @param size the width of the gap.
	 */
	public void addGap(int size) {
		Dimension dim;
		switch (orientation) {
		case EAST:
			dim = new Dimension(0, size);
			break;
		case WEST:
			dim = new Dimension(0, size);
			break;
		case NORTH:
			dim = new Dimension(size, 0);
			break;
		case SOUTH:
			dim = new Dimension(size, 0);
			break;
		default:
			dim = new Dimension(0, size);
		}
		sideToolBar.add(Box.createRigidArea(dim));
	}

	/**
	 * Add a separator to the tool bar.
	 */
	public void addSeparator() {
		sideToolBar.addSeparator();
	}

	/**
	 * Create an button from an action.
	 *
	 * @param action input action
	 * @param isToggle if true then create a toggle button, otherwise a JButton
	 * @return AbstractButton new button
	 */
	private AbstractButton createButton(Action action, boolean isToggle) {
		AbstractButton button = isToggle ? new JToggleButton() : new JButton();
		button.setFocusable(false);
		button.setOpaque(false);
		button.setAction(action);
		if (action.getValue(Action.SMALL_ICON) == null) {
			button.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		}
		return button;
	}

	/**
	 * Create a button using icon, label, tooltip and action command
	 *
	 * @param icon icon for the button
	 * @param label name of the button
	 * @param tooltip tooltip for the button
	 * @param actionCommand action command for the button
	 * @param isToggle if true then create a toggle button, otherwise a JButton
	 * @return AbstractButton new button
	 */
	private AbstractButton createButton(Icon icon, String label, String tooltip, String actionCommand,
			boolean isToggle) {
		AbstractButton button = isToggle ? new JToggleButton() : new JButton();
		button.setFocusable(false);
		button.setOpaque(false);
		if (icon == null) {
			button.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		}
		button.setIcon(icon);
		button.setText(label);
		button.setActionCommand(actionCommand);
		button.setToolTipText(tooltip);
		return button;
	}
}
