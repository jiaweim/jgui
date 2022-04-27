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
import javafx.scene.effect.DropShadow;
import javafx.stage.Stage;

/**
 * 添加 rotation transformation of 10 degrees, a drop shadow effect, and opacity of
 * 80% to two buttons.
 *
 * @author JiaweiMao
 * @version 1.0.0
 * @since 13 Apr 2018, 8:27 AM
 */
public class GroupEx3 extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        Button okBtn = new Button("OK");
        Button calcelBtn = new Button("Calcel");

        okBtn.relocate(10, 10);
        calcelBtn.relocate(80, 10);

        Group group = new Group();
        group.setEffect(new DropShadow());
        group.setRotate(10);
        group.setOpacity(0.8);

        group.getChildren().addAll(okBtn, calcelBtn);

        Scene scene = new Scene(group);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Applying Transformations and Effects to a Group");
        primaryStage.show();
    }
}
