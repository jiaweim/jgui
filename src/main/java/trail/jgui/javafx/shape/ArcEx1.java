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
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 21 Dec 2017, 4:21 PM
 */
public class ArcEx1 extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        // An OPEN arc with a fill
        Arc arc1 = new Arc(0, 0, 50, 100, 0, 90);
        arc1.setFill(Color.LIGHTGRAY);

        // An OPEN arc with no fill and a stroke
        Arc arc2 = new Arc(0, 0, 50, 100, 0, 90);
        arc2.setFill(Color.TRANSPARENT);
        arc2.setStroke(Color.BLACK);

        // A CHORD arc with no fill and a stroke
        Arc arc3 = new Arc(0, 0, 50, 100, 0, 90);
        arc3.setFill(Color.TRANSPARENT);
        arc3.setStroke(Color.BLACK);
        arc3.setType(ArcType.CHORD);

        // A ROUND arc with no fill and a stroke
        Arc arc4 = new Arc(0, 0, 50, 100, 0, 90);
        arc4.setFill(Color.TRANSPARENT);
        arc4.setStroke(Color.BLACK);
        arc4.setType(ArcType.ROUND);

        // A ROUND arc with a gray fill and a stroke
        Arc arc5 = new Arc(0, 0, 50, 100, 0, 90);
        arc5.setFill(Color.GRAY);
        arc5.setStroke(Color.BLACK);
        arc5.setType(ArcType.ROUND);
        HBox root = new HBox(arc1, arc2, arc3, arc4, arc5);
        root.setSpacing(10);
        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Using Arcs");
        primaryStage.show();
    }
}
