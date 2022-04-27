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
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 14 Apr 2018, 1:49 PM
 */
public class PopWindow extends Application
{
    private Stage primaryStage;

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        this.primaryStage = primaryStage;

        Pane layout = new Pane();
        layout.setPrefSize(100, 100);
        layout.setOnMouseClicked(event -> {
            Stage stage = new Stage(StageStyle.UNDECORATED);
            stage.initOwner(primaryStage);

            stage.setX(event.getSceneX());
            stage.setY(event.getSceneY());

            Pane layout1 = new Pane();
            layout1.setStyle("-fx-background-color: paleturquoise;");
            layout1.setPrefSize(40, 40);
            layout1.setOnMouseClicked(event1 -> stage.close());

            stage.setScene(new Scene(layout1));
            stage.show();
        });

        primaryStage.setScene(new Scene(layout));
        primaryStage.show();
    }
}
