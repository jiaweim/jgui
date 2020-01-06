/*
 * Copyright 2017 JiaweiMao jiaweiM_philo@hotmail.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package trail.jgui.javafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 09 Apr 2018, 6:12 PM
 */
public class DrawingShrpLinesInCanvas extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage stage)
    {
        MyCanvas canvasBlurry = new MyCanvas(false);
        MyCanvas canvasSharp = new MyCanvas(true);

        Label labelBlurry = new Label("Blurry");
        Label labelSharp = new Label("Sharp");

        VBox.setMargin(canvasBlurry, new Insets(10));
        VBox.setMargin(canvasSharp, new Insets(10));

        VBox.setMargin(labelBlurry, new Insets(10, 10, 0, 10));
        VBox.setMargin(labelSharp, new Insets(10, 10, 0, 10));

        VBox box = new VBox();
        box.getChildren().add(labelBlurry);
        box.getChildren().add(canvasBlurry);
        box.getChildren().add(labelSharp);
        box.getChildren().add(canvasSharp);

        stage.setScene(new Scene(box));
        stage.setTitle("Tip 2: Sharp Lines in Canvas");
        stage.show();
    }

    class MyCanvas extends Canvas
    {
        public MyCanvas(boolean drawSharpLines)
        {
            setWidth(150);
            setHeight(150);

            double w = getWidth();
            double h = getHeight();

            GraphicsContext gc = getGraphicsContext2D();
            gc.clearRect(0, 0, w, h);

            gc.setStroke(Color.BLACK);
            gc.strokeRect(0, 0, w, h);
//            gc.setLineWidth(2);

            for (double y = 20; y <= h - 20; y += 10) {
                if (drawSharpLines) {
                    // Snap the y coordinate
                    gc.strokeLine(10, snap(y), w - 10, snap(y));
                } else {
                    gc.strokeLine(10, y, w - 10, y);
                }
            }
        }

        private double snap(double y)
        {
            return ((int) y) + .5;
        }
    }
}
