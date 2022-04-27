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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 11 Jan 2018, 10:54 AM
 */
public class StylesPriorities extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage stage)
    {
        Button yesBtn = new Button("Yes");
        Button noBtn = new Button("No");
        Button cancelBtn = new Button("Cancel");

        // Change the font size for the Yes button
        // using two methods: inline style and JavaFX API
        yesBtn.setStyle("-fx-font-size: 16px");
        yesBtn.setFont(new Font(10));

        // Change the font size for the No button using the JavaFX API
        noBtn.setFont(new Font(8));
        HBox root = new HBox();
        root.setSpacing(10);
        root.getChildren().addAll(yesBtn, noBtn, cancelBtn);

        Scene scene = new Scene(root);
// Add a style sheet to the scene
        scene.getStylesheets().addAll("css/stylespriorities.css");
        stage.setScene(scene);
        stage.setTitle("Styles Priorities");
        stage.show();
    }
}
