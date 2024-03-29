package jgui.swing.chooser;

import java.io.File;
import javax.swing.filechooser.*;

/**
 * 
 * @author JiaweiM
 * @date Sep 17, 2015 1:19:44 PM
 */
public class ImageFilter extends FileFilter {

	/**
	 * Accept all directories and all gif, jpg, tiff, or png files.
	 */
	public boolean accept(File f) {
		if (f.isDirectory()) {
			return true;
		}

		String extension = Utils.getExtension(f);
		if (extension != null) {
			if (extension.equals(Utils.tiff) || extension.equals(Utils.tif) || extension.equals(Utils.gif)
					|| extension.equals(Utils.jpeg) || extension.equals(Utils.jpg) || extension.equals(Utils.png)) {
				return true;
			} else {
				return false;
			}
		}

		return false;
	}

	public String getDescription() {
		return "Just Images";
	}
}
