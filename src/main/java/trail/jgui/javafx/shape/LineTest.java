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
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 * Creates some Lines and sets their stroke and strokeWidth properties.
 *
 * @author JiaweiMao
 * @version 1.0.0
 * @date 2017.01.10, 3:42 PM
 */
public class LineTest extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // It will be just a point at (0,0)
        Line line1 = new Line();

        Line line2 = new Line(0, 0, 50, 0);
        line2.setStrokeWidth(1.0);

        Line line3 = new Line(0, 50, 50, 0);
        line3.setStrokeWidth(2.0);
        line3.setStroke(Color.RED);

        Line line4 = new Line(0, 0, 50, 50);
        line4.setStrokeWidth(5.0);
        line4.setStroke(Color.BLUE);

        // creates a Line and uses setter method to set the start and end coordinates.
        Line line5 = new Line();
        line5.setStartX(0.0);
        line5.setStartY(0.0);
        line5.setEndX(100.0);
        line5.setEndY(100.0);


        HBox root = new HBox(line1, line2, line3, line4, line5);
        root.setSpacing(10);
        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Using Lines");
        primaryStage.show();
    }
}
