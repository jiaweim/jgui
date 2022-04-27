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
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

/**
 * creates three instances of the Ellipse class. The third instance draws a
 * circle as the program sets the same value for the radiusX and radiusY properties.
 *
 * @author JiaweiMao
 * @version 1.0.0
 * @date 2017.01.11, 2:08 PM
 */
public class EllipseTest extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Ellipse e1 = new Ellipse(50, 30);
        e1.setFill(Color.LIGHTGRAY);

        Ellipse e2 = new Ellipse(60, 30);
        e2.setFill(Color.YELLOW);
        e2.setStroke(Color.BLACK);
        e2.setStrokeWidth(2.0);

        // Draw a circle using the Ellipse class (radiusX=radiusY=30)
        Ellipse e3 = new Ellipse(30, 30);
        e3.setFill(Color.YELLOW);
        e3.setStroke(Color.BLACK);
        e3.setStrokeWidth(2.0);

        HBox root = new HBox(e1, e2, e3);
        root.setSpacing(10);
        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Using Ellipses");
        primaryStage.show();
    }
}
