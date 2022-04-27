// Created at 2016/7/28 
// Author:	JiaweiMao
// Copyright (c) Dalian Institute of Chemical Physics
//      Chinese Academy of Sciences
// Contact: jiawei@dicp.ac.cn

/**
 * An affine transform is composed of zero or more linear transformations (rotation, scaling or shear) and translation
 * (shift). Several linear transformations can be combined into a single matrix.
 * <ol>
 *     <li>A rotation is a transformation that moves a rigid body around a fixed point.</li>
 *     <li>A scaling is a transformation that enlarges or diminishes objects.
 *     The scale factor is the same in all directions.</li>
 *     <li>A translation is a transformation that moves every point a constant distance in
 *     a specified direction. </li>
 *     <li>A shear is a transformation that moves an object perpendicular to a given axis, with greater
 *     value on one side of the axis than the other.</li>
 * </ol>
 *  sources: (wikipedia.org, freedictionary.com)
 * <p>
 * The AffineTransform is the class in Java 2D to perform affine transformations.
 */
package jgui.swing.j2d.transform;