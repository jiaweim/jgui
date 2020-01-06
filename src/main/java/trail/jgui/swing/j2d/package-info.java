// Created at 2016/8/1 
// Author:	JiaweiMao
// Copyright (c) Dalian Institute of Chemical Physics
//      Chinese Academy of Sciences
// Contact: jiawei@dicp.ac.cn

/**
 * The Tetris game is one of the most popular computer games ever created. The original game was designed and programmed
 * by a Russian programmer Alexey Pajitnov in 1985. Since then, Tetris is available on almost every computer platform in
 * lots of variations. Even my mobile phone has a modified version of the Tetris game.
 * <p>
 * Tetris is called a falling block puzzle game. In this game, we have seven different shapes called tetrominoes.
 * S-shape, Z-shape, T-shape, L-shape, Line-shape, MirroredL-shape and a Square-shape. Each of these shapes is formed
 * with four squares. The shapes are falling down the board. The object of the Tetris game is to move and rotate the
 * shapes, so that they fit as much as possible. If we manage to form a row, the row is destroyed and we score. We play
 * the Tetris game until we top out.
 * <p>
 * We do not have images for our Tetris game, we draw the tetrominoes using Swing drawing API. Behind every computer
 * game, there is a mathematical model. So it is in Tetris.
 * <p>
 * Some ideas behind the game.
 * <p>
 * We use a Timer class to create a game cycle The tetrominoes are drawn The shapes move on a square by square basis
 * (not pixel by pixel) Mathematically a board is a simple list of numbers I have simplified the game a bit, so that it
 * is easier to understand. The game starts immediately, after it is launched. We can pause the game by pressing the p
 * key. The space key will drop the Tetris piece immediately to the bottom. The d key will drop the piece one line down.
 * (It can be used to speed up the falling a bit.) The game goes at constant speed, no acceleration is implemented. The
 * score is the number of lines, that we have removed.
 */
package trail.jgui.swing.j2d;