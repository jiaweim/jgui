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
import javafx.scene.shape.*;
import javafx.stage.Stage;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 21 Dec 2017, 9:11 PM
 */
public class PathEx3 extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        // Both triangles use a couterclockwise stroke
        PathElement[] pathEleemnts1 = {new MoveTo(50, 0),
                new LineTo(0, 50),
                new LineTo(100, 50),
                new LineTo(50, 0),
                new MoveTo(90, 15),
                new LineTo(40, 65),
                new LineTo(140, 65),
                new LineTo(90, 15)};

        // One traingle uses a clockwise stroke and
        // another uses a couterclockwise stroke
        PathElement[] pathEleemnts2 = {new MoveTo(50, 0),
                new LineTo(0, 50),
                new LineTo(100, 50),
                new LineTo(50, 0),
                new MoveTo(90, 15),
                new LineTo(140, 65),
                new LineTo(40, 65),
                new LineTo(90, 15)};
        /* Using the NON-ZERO fill rule by default */
        Path p1 = new Path(pathEleemnts1);
        p1.setFill(Color.LIGHTGRAY);
        Path p2 = new Path(pathEleemnts2);
        p2.setFill(Color.LIGHTGRAY);

        /* Using the EVEN_ODD fill rule */
        Path p3 = new Path(pathEleemnts1);
        p3.setFill(Color.LIGHTGRAY);
        p3.setFillRule(FillRule.EVEN_ODD);
        Path p4 = new Path(pathEleemnts2);
        p4.setFill(Color.LIGHTGRAY);
        p4.setFillRule(FillRule.EVEN_ODD);
        HBox root = new HBox(p1, p2, p3, p4);
        root.setSpacing(10);
        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Using Fill Rules for Paths");
        primaryStage.show();
    }
}
