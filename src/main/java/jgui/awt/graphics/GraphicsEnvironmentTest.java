package jgui.awt.graphics;

import org.junit.jupiter.api.Test;

import java.awt.*;


public class GraphicsEnvironmentTest
{
    @Test
    public void testGetAllFonts()
    {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] fonts = ge.getAvailableFontFamilyNames();
        for (String s : fonts) {
            System.out.println(s);
        }
    }

}
