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

package trail.jgui.javafx.shape;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 21 Dec 2017, 3:05 PM
 */
public class EllipseEx1 extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
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
