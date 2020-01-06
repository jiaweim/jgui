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

package trail.jgui.javafx.canvas;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

/**
 * This program draws six circles in six different colors.
 *
 * @author JiaweiMao
 * @version 1.0.0
 * @date 2017.01.12, 3:53 PM
 */
public class ColorEx extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        Color blue = new Color(0.0, 0.0, 1.0, 1.0);

        Pane root = new Pane();

        Canvas canvas = new Canvas(600, 300);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        drawShapes(gc);

        root.getChildren().add(canvas);

        Scene scene = new Scene(root, 600, 200, Color.WHITESMOKE);

        stage.setTitle("Colors");
        stage.setScene(scene);
        stage.show();
    }

    private void drawShapes(GraphicsContext gc) {

        gc.setFill(Color.CADETBLUE);
        gc.fillOval(30, 30, 50, 50);

        gc.setFill(Color.DARKRED);
        gc.fillOval(110, 30, 50, 50);

        gc.setFill(Color.STEELBLUE);
        gc.fillOval(190, 30, 50, 50);

        Paint redColor = Paint.valueOf("red");
        gc.setFill(redColor);
        gc.fillOval(270, 30, 50, 50);

        Paint linearGradientColor = Paint.valueOf("linear-gradient(to bottom right, red, black)");
        gc.setFill(linearGradientColor);
        gc.fillRoundRect(350, 30, 50, 50, 10, 10);

        Paint radialGradientColor = Paint.valueOf("radial-gradient(radius 100%, red, blue, black)");
        gc.setFill(radialGradientColor);
        gc.fillOval(430, 30, 50, 50);

        gc.setFill(Color.BURLYWOOD);
        gc.fillOval(30, 110, 50, 50);

        gc.setFill(Color.LIGHTSEAGREEN);
        gc.fillOval(110, 110, 50, 50);

        gc.setFill(Color.CHOCOLATE);
        gc.fillOval(190, 110, 50, 50);
    }
}
