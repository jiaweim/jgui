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

package jgui.javafx.css;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 11 Jan 2018, 10:07 AM
 */
public class InlineStyles extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        Button yesBtn = new Button("Yes");
        Button noBtn = new Button("No");
        Button calcelBtn = new Button("Cancel");

        yesBtn.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");

        Button openBtn = new Button("Open");
        Button saveBtn = new Button("Save");
        Button closeBtn = new Button("Close");

        VBox vb1 = new VBox();
        vb1.setPadding(new Insets(10, 10, 10, 10));
        vb1.getChildren().addAll(yesBtn, noBtn, calcelBtn);

        VBox vb2 = new VBox();
        vb2.setPadding(new Insets(10, 10, 10, 10));
        vb2.getChildren().addAll(openBtn, saveBtn, closeBtn);

        vb1.setStyle("-fx-border-width: 4.0; -fx-border-color: blue;");
        vb2.setStyle("-fx-border-width: 4.0; -fx-border-color: blue;");

        HBox root = new HBox();
        root.setSpacing(20);
        root.setPadding(new Insets(10, 10, 10, 10));
        root.getChildren().addAll(vb1, vb2);

        root.setStyle("-fx-border-width: 10.0; -fx-border-color: navy;");

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Using Inline Styles");
        primaryStage.show();
    }
}
