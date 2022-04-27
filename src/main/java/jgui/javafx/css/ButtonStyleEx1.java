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
import javafx.stage.Stage;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 23 Dec 2017, 4:19 PM
 */
public class ButtonStyleEx1 extends Application
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

        HBox root = new HBox();
        root.getChildren().addAll(yesBtn, noBtn, calcelBtn);

        Scene scene = new Scene(root);
        scene.getStylesheets().addAll("css/button_style_1.css");

        primaryStage.setScene(scene);
        primaryStage.setTitle("Styling Buttons");
        primaryStage.show();
    }
}
