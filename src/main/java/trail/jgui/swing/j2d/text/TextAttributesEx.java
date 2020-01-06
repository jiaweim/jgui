package trail.jgui.swing.j2d.text;

import javax.swing.*;
import java.awt.*;
import java.awt.font.TextAttribute;
import java.text.AttributedString;

/**
 * When we draw text, we can control its various attributes. We can modify text rendering with the Font, TextAttributes,
 * and AttributeString classes. The Font class represents fonts which are used to render text. The TextAttribute class
 * defines attribute keys and attribute values used for text rendering. Finally, the AttributedString class holds text
 * and related attribute information.
 */
class TextAttributesSurface extends JPanel {

    private final String words = "Valour fate kinship darkness";
    private final String java = "Java TM";

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Font font = new Font("Serif", Font.PLAIN, 40);

        // create an AttributeString out of the words string
        AttributedString as1 = new AttributedString(words);
        as1.addAttribute(TextAttribute.FONT, font);

        // add a new attribute to the AttributeString. This attribute specifies that the first seven characters
        // will be rendered in red color
        as1.addAttribute(TextAttribute.FOREGROUND, Color.red, 0, 6);
        as1.addAttribute(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON, 7, 11);
        as1.addAttribute(TextAttribute.BACKGROUND, Color.LIGHT_GRAY, 12, 19);
        as1.addAttribute(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON, 20, 28);

        /*
         *The first text is drawn on the panel. Because at the moment we work with the AttributeString class and not
         * directly with the string, we use an overloaded drawString() method, which takes a
         * AttributedCharacterIterator instance as its first parameter.
         */
        g2d.drawString(as1.getIterator(), 15, 60);

        AttributedString as2 = new AttributedString(java);

        as2.addAttribute(TextAttribute.SIZE, 40);
        as2.addAttribute(TextAttribute.SUPERSCRIPT,
                TextAttribute.SUPERSCRIPT_SUPER, 5, 7);

        g2d.drawString(as2.getIterator(), 130, 125);
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }
}

public class TextAttributesEx extends JFrame {

    public TextAttributesEx() {

        initUI();
    }

    private void initUI() {

        add(new TextAttributesSurface());

        setSize(620, 190);
        setTitle("Text attributes");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            TextAttributesEx ex = new TextAttributesEx();
            ex.setVisible(true);
        });
    }
}