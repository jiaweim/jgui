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

package jgui.javafx.shape;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 21 Dec 2017, 3:25 PM
 */
public class PolylineEx1 extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        Polyline triangle1 = new Polyline();
        triangle1.getPoints().addAll(50.0, 0.0,
                0.0, 50.0,
                100.0, 50.0,
                50.0, 0.0);
        triangle1.setFill(Color.WHITE);
        triangle1.setStroke(Color.RED);

        // Create an open parallelogram
        Polyline parallelogram = new Polyline();
        parallelogram.getPoints().addAll(30.0, 0.0,
                130.0, 0.0,
                100.00, 50.0,
                0.0, 50.0);
        parallelogram.setFill(Color.YELLOW);
        parallelogram.setStroke(Color.BLACK);
        Polyline hexagon = new Polyline(100.0, 0.0,
                120.0, 20.0,
                120.0, 40.0,
                100.0, 60.0,
                80.0, 40.0,
                80.0, 20.0,
                100.0, 0.0);
        hexagon.setFill(Color.WHITE);
        hexagon.setStroke(Color.BLACK);
        HBox root = new HBox(triangle1, parallelogram, hexagon);
        root.setSpacing(10);
        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Using Polylines");
        primaryStage.show();
    }
}
