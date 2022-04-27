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

package jgui.javafx.layout;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 12 Dec 2017, 9:56 AM
 */
public class PaneEx1 extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        Rectangle rect = new Rectangle(25, 25, 50, 50);
        rect.setFill(Color.CADETBLUE);

        Line line = new Line(90, 40, 230, 40);
        line.setStroke(Color.BLACK);

        Circle circle = new Circle(130, 130, 30);
        circle.setFill(Color.CHOCOLATE);

        Pane root = new Pane();
        root.setPrefSize(300, 100);
        root.getChildren().addAll(rect, line, circle);

        Scene scene = new Scene(root, 400, 220, Color.WHITESMOKE);

        primaryStage.setTitle("Absolute layout");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
