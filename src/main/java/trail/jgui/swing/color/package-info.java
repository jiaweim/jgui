// Created at 2016/7/28 
// Author:	JiaweiMao
// Copyright (c) Dalian Institute of Chemical Physics
//      Chinese Academy of Sciences
// Contact: jiawei@dicp.ac.cn
/**
 * Transparency is the quality of being able to see through a material. The easiest way to understand transparency is to
 * imagine a piece of glass or water. Technically, the rays of light can go through the glass and this way we can see
 * objects behind the glass.
 * <p>
 * In computer graphics, we can achieve transparency effects using alpha compositing. Alpha compositing is the process
 * of combining an image with a background to create the appearance of partial transparency. The composition process
 * uses an alpha channel. Alpha channel is an 8-bit layer in a graphics file format that is used for expressing
 * translucency (transparency). The extra eight bits per pixel serves as a mask and represents 256 levels of
 * translucency. (answers.com, wikipedia.org)
 * <p>
 * The <code>AlphaComposite</code> class is used to work with transparency in Java 2D. It implements the basic alpha
 * compositing rules for combining source and destination pixels to achieve blending and transparency effects with
 * graphics and images. To create an AlphaComposite, we provide two values: the rule designator and the alpha value. The
 * rule specifies how we combine source and destination pixels. Most often it is AlphaComposite.SRC_OVER. The alpha
 * value can range from 0.0f (completely transparent) to 1.0f (completely opaque).
 */
package trail.jgui.swing.color;
