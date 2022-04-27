package jgui.swing.j2d.text;

import java.awt.*;

public class AllFontsEx {

    public static void main(String[] args) {

        /*
         * There are objects that are typical for a particular platform—fonts are among these objects. The collection
         * of fonts on a Unix, OS X, and Windows platform differ. The GraphicsEnvironment class describes the
         * collection of GraphicsDevice objects and Font objects available on a particular platform.
         */
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        // The getAllFonts() returns all fonts available in the GraphicsEnvironment.
        Font[] fonts = ge.getAllFonts();

        for (Font font : fonts) {
            System.out.print(font.getFontName() + " : ");
            System.out.println(font.getFamily());
        }
    }
}