/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 JiaweiMao
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software
 * and associated documentation files (the "Software"), to deal in the Software without
 * restriction, including without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package jgui.javafx.shape;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @date 2017.01.10, 4:52 PM
 */
public class RectangleTest extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        // x=0, y=0, width=100, height=50, fill=LIGHTGRAY, stroke=null
        Rectangle rect1 = new Rectangle(100, 50, Color.LIGHTGRAY);

        // x=120, y=20, width=100, height=50, fill=WHITE, stroke=BLACK
        Rectangle rect2 = new Rectangle(120, 20, 100, 50);
        rect2.setFill(Color.WHITE);
        rect2.setStroke(Color.BLACK);
        rect2.setArcWidth(10);
        rect2.setArcHeight(10);

        Pane root = new Pane();
        root.getChildren().addAll(rect1, rect2);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Using Rectangles");
        primaryStage.show();
    }
}
