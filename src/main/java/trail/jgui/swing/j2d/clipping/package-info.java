// Created at 2016/7/28 
// Author:	JiaweiMao
// Copyright (c) Dalian Institute of Chemical Physics
//      Chinese Academy of Sciences
// Contact: jiawei@dicp.ac.cn

/**
 * Clipping is restricting of drawing to a certain area. This is done for efficiency reasons and to create various
 * effects. When working with the clip, we must either work with a copy of the Graphics object or to restore the
 * original clip attribute. Changing the clip does not affect existing pixels; it affects future rendering only.
 */
package trail.jgui.swing.j2d.clipping;