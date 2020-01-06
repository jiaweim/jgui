// Created at 2016/8/1 
// Author:	JiaweiMao
// Copyright (c) Dalian Institute of Chemical Physics
//      Chinese Academy of Sciences
// Contact: jiawei@dicp.ac.cn

/**
 * Rendering text is another complicated topic. It would easily fill a specialized book. Here we only provide some basic
 * examples.
 * <p>
 * A character is a symbol that represents an item such as a letter, a digit, or a punctuation. A glyph is a shape used
 * to render a character or a sequence of characters. In the Latin alphabet a glyph typically represents one character.
 * In other writing systems, a character may be composed of several glyphs, like ť, ž, ú, ô. These are Latin characters
 * with accents.
 * <p>
 * There are two types of fonts: physical and logical. Physical fonts are the actual font libraries. Logical fonts are
 * the five font families defined by the Java platform: Serif, SansSerif, Monospaced, Dialog, and DialogInput. Logical
 * fonts are not actual font libraries. Logical font names are mapped to physical fonts by the Java runtime
 * environment.
 * <p>
 * Text can be drawn on the window using various fonts. A font is a set of type characters of a particular typeface
 * design and size. Various typefaces include Helvetica, Georgia, Times, or Verdana. A collection of glyphs with a
 * particular style form a font face. A collection of font faces forms a font family.
 */
package trail.jgui.swing.j2d.text;