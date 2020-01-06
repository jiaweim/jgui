package trail.jgui.awt.graphics;

import java.awt.GraphicsEnvironment;

import org.junit.Test;

public class GraphicsEnvironmentTest {

	@Test
	public void testGetAllFonts() {
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		String[] fonts = ge.getAvailableFontFamilyNames();
		for (String s : fonts) {
			System.out.println(s);
		}
	}

}
