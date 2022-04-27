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

package jgui.javafx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 05 Dec 2017, 3:48 PM
 */
public class HelloJavaFXImproved extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        Label nameLbl = new Label("Enter your name:");
        TextField nameFld = new TextField();

        Label msgLbl = new Label("");
        msgLbl.setStyle("-fx-text-fill:blue;");

        Button sayHelloBtn = new Button("Say Hello");
        Button exitBtn = new Button("Exit");

        sayHelloBtn.setOnAction(event -> {
            String name = nameFld.getText();
            if (name.trim().length() > 0)
                msgLbl.setText("Hello " + name);
            else
                msgLbl.setText("Hello there");
        });

        exitBtn.setOnAction(event -> Platform.exit());

        VBox root = new VBox();
        root.setSpacing(5);

        root.getChildren().addAll(nameLbl, nameFld, msgLbl, sayHelloBtn, exitBtn);

        Scene scene = new Scene(root, 350, 150);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Improved Hello JavaFX Application");
        primaryStage.show();
    }
}
