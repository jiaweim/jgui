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
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Group 子节点的位置，可以通过绝对和相对位置定义。
 *
 * @author JiaweiMao
 * @version 1.0.0
 * @since 12 Apr 2018, 9:22 PM
 */
public class GroupEx2 extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        Button okBtn = new Button("OK");
        Button cancelBtn = new Button("Cancel");

        okBtn.relocate(10, 10);
        cancelBtn.layoutXProperty().bind(okBtn.layoutXProperty().add(okBtn.widthProperty().add(10)));
        cancelBtn.layoutYProperty().bind(okBtn.layoutYProperty());

        Group root = new Group();
        root.getChildren().addAll(okBtn, cancelBtn);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
