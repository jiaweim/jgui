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
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * GridPane 默认添加的控件都放在 (0,0)，所以，下面三个按钮就重叠了。
 *
 * @author JiaweiMao
 * @version 1.0.0
 * @since 23 Dec 2017, 11:01 PM
 */
public class GridPaneEx2 extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        Button b1 = new Button("One One One One One");
        Button b2 = new Button("Two Two Two");
        Button b3 = new Button("Three");

        GridPane root = new GridPane();

        // 直接添加按钮到 GridPane
        root.getChildren().addAll(b1, b2, b3);

        root.setStyle("-fx-padding:10;" +
                "-fx-border-style:solid inside;" +
                "-fx-border-width:2;" +
                "-fx-border-insets:5;" +
                "-fx-border-radius:5;" +
                "-fx-border-color:blue;");
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Adding Children to a GridPane");
        primaryStage.show();
    }
}
