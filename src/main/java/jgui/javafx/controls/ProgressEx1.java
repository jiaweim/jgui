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

package jgui.javafx.controls;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 15 Apr 2018, 4:26 PM
 */
public class ProgressEx1 extends Application
{
    public static void main(String[] args)
    {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        ProgressIndicator indeterminateInd = new ProgressIndicator();
        ProgressIndicator determinateInd = new ProgressIndicator(0);

        ProgressBar indeterminateBar = new ProgressBar();
        ProgressBar determinateBar = new ProgressBar(0);

        Button completeIndBtn = new Button("Complete Task");
        completeIndBtn.setOnAction(e -> indeterminateInd.setProgress(1.0));

        Button completeBarBtn = new Button("Complete Task");
        completeBarBtn.setOnAction(e -> indeterminateBar.setProgress(1.0));

        Button makeProgresstIndBtn = new Button("Make Progress");
        makeProgresstIndBtn.setOnAction(e -> makeProgress(determinateInd));

        Button makeProgresstBarBtn = new Button("Make Progress");
        makeProgresstBarBtn.setOnAction(e -> makeProgress(determinateBar));

        GridPane root = new GridPane();
        root.setHgap(10);
        root.setVgap(5);
        root.addRow(0, new Label("Indeterminate Progress:"), indeterminateInd, completeIndBtn);
        root.addRow(1, new Label("Determinate Progress:"), determinateInd, makeProgresstIndBtn);
        root.addRow(2, new Label("Indeterminate Progress:"), indeterminateBar, completeBarBtn);
        root.addRow(3, new Label("Determinate Progress:"), determinateBar, makeProgresstBarBtn);

        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Using ProgressIndicator and ProgressBar Controls");
        primaryStage.show();
    }

    public void makeProgress(ProgressIndicator p)
    {
        double progress = p.getProgress();
        if (progress <= 0) {
            progress = 0.1;
        } else {
            progress = progress + 0.1;
            if (progress >= 1.0) {
                progress = 1.0;
            }
        }
        p.setProgress(progress);
    }
}
