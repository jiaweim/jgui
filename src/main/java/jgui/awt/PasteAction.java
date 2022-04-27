package jgui.awt;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;

public class PasteAction extends AbstractAction {
	  SiteManager manager;

	  public PasteAction(SiteManager sm) {
	    super("", new ImageIcon("paste.gif"));
	    manager = sm;
	  }

	  public void actionPerformed(ActionEvent ae) {
	    JInternalFrame currentFrame = manager.getCurrentFrame();
	    if (currentFrame == null) { return; }
	    // cannot cut or paste sites
	    if (currentFrame instanceof SiteFrame) { return; } 
	    ((PageFrame)currentFrame).pasteText();
	  }
	}
