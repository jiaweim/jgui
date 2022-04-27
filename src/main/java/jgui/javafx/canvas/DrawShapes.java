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

package jgui.javafx.canvas;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Random;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 08 Apr 2018, 7:29 PM
 */
public class DrawShapes extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        primaryStage.setTitle("Grpahics in JavaFX");

        Group root = new Group();
        Canvas canvas = new Canvas(650, 600);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        draw2DShapes(gc);

        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    private void draw2DShapes(GraphicsContext gc)
    {
        double width = gc.getCanvas().getWidth();
        double height = gc.getCanvas().getHeight();

        Random random = new Random(System.currentTimeMillis());

        gc.setFill(Color.rgb(random.nextInt(255), random.nextInt(255), random.nextInt(255), 0.9));
        gc.translate(width / 2, height / 2);

        for (int i = 0; i < 60; i++) {
            gc.rotate(6.0);
            gc.setFill(Color.rgb(random.nextInt(255), random.nextInt(255), random.nextInt(255), 0.9));
            gc.fillOval(10, 60, 30, 30);

            gc.setFill(Color.rgb(random.nextInt(255), random.nextInt(255), random.nextInt(255), 0.9));
            gc.strokeOval(60, 60, 30, 30);

            gc.setFill(Color.rgb(random.nextInt(255), random.nextInt(255), random.nextInt(255), 0.9));
            gc.fillRoundRect(110, 60, 30, 30, 10, 10);

            gc.setFill(Color.rgb(random.nextInt(255), random.nextInt(255), random.nextInt(255), 0.9));
            gc.fillPolygon(new double[]{105, 117, 159, 123, 133, 105, 77, 87, 51, 93},
                    new double[]{150, 186, 186, 204, 246, 222, 246, 204, 186, 186}, 10);
        }
    }
}
