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

package trail.jgui.javafx.canvas;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 05 Apr 2018, 10:58 PM
 */
public class ResizableCanvas extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        MyResizableCanvas canvas = new MyResizableCanvas();

        VBox root = new VBox();
        root.getChildren().add(canvas);

//        root.widthProperty().addListener((observable, oldValue, newValue) -> canvas.setWidth(newValue.doubleValue() * 0.5));
//        root.heightProperty().addListener((observable, oldValue, newValue) -> canvas.setHeight(newValue.doubleValue() * 0.5));

        canvas.widthProperty().bind(root.widthProperty());
        canvas.heightProperty().bind(root.heightProperty());

        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Resizable Canvas");
        primaryStage.show();
    }

    class MyResizableCanvas extends Canvas
    {
        public MyResizableCanvas()
        {
            widthProperty().addListener(event -> draw());
            heightProperty().addListener(event -> draw());
        }

        @Override
        public boolean isResizable()
        {
            return true;
        }

        @Override
        public double prefWidth(double height)
        {
            return getWidth();
        }

        @Override
        public double prefHeight(double width)
        {
            return getHeight();
        }

        private void draw()
        {
            double width = getWidth();
            double height = getHeight();

            GraphicsContext gc = getGraphicsContext2D();
            gc.clearRect(0, 0, width, height);

            gc.setStroke(Color.RED);
            gc.strokeLine(0, 0, width, height);
            gc.strokeLine(0, height, width, 0);
        }
    }
}
