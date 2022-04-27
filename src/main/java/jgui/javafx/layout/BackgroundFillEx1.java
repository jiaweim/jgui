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
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 13 Apr 2018, 10:14 AM
 */
public class BackgroundFillEx1 extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        Pane p1 = getCSSStyledPane();
        Pane p2 = getObjectStyledPane();

        p1.relocate(10, 10);
        // Place p2 20px right to p1
        p2.layoutYProperty().bind(p1.layoutYProperty());
        p2.layoutXProperty().bind(p1.layoutXProperty().add(p1.widthProperty()).add(20));
        Pane root = new Pane(p1, p2);

        root.setPrefSize(240, 70);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Setting Background Fills for a Region");
        primaryStage.show();
        primaryStage.sizeToScene();
    }

    public Pane getObjectStyledPane()
    {
        Pane p = new Pane();
        p.setPrefSize(100, 50);
        BackgroundFill lightGrayFill = new BackgroundFill(Color.LIGHTGRAY, new CornerRadii(4), new Insets(0));
        BackgroundFill redFill = new BackgroundFill(Color.RED, new CornerRadii(2), new Insets(4));

        Background bg = new Background(lightGrayFill, redFill);
        p.setBackground(bg);
        return p;
    }

    public Pane getCSSStyledPane()
    {
        Pane p = new Pane();
        p.setPrefSize(100, 50);
        p.setStyle("-fx-background-color: lightgray, red;" +
                "-fx-background-insets: 0, 4;" +
                "-fx-background-radius: 4, 2;");
        return p;
    }
}
