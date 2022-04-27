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
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 23 Dec 2017, 9:06 PM
 */
public class HBoxEx1 extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        Button prevBtn = new Button("Previous");
        Button nextBtn = new Button("Next");
        Button calcBtn = new Button("Cancel");
        Button helpBtn = new Button("Help");

        HBox root = new HBox(5);
        root.setPadding(new Insets(10));
        root.setAlignment(Pos.BASELINE_RIGHT); // 右对齐

        root.getChildren().addAll(prevBtn, nextBtn, calcBtn, helpBtn);

        Scene scene = new Scene(root);
        primaryStage.setTitle("Row of buttons");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
