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

package trail.jgui.javafx.shape;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * Creates two circles, the first circle has a light gray fill and no stroke, which is the default.
 * The second circle has a  yellow fill and a 2.0px wide black stroke.
 *
 * @author JiaweiMao
 * @version 1.0.0
 * @date 2017.01.10, 3:10 PM
 */
public class ShapeTest extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create a circle with a light gray fill and no stroke
        Circle c1 = new Circle(40, 40, 40);
        c1.setFill(Color.LIGHTGRAY);

        // Create a circle with an yellow fill and a black stroke of 2.0px
        Circle c2 = new Circle(40, 40, 40);
        c2.setFill(Color.YELLOW);
        c2.setStroke(Color.BLACK);
        c2.setStrokeWidth(2.0);

        HBox root = new HBox(c1, c2);
        root.setSpacing(10);
        root.setStyle("-fx-padding:10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Using Shapes");
        primaryStage.show();
    }
}
