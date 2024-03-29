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

package jgui.javafx.thread;

import javafx.application.Application;
import javafx.concurrent.Worker;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 15 Jan 2018, 6:42 PM
 */
public class OneShotTask extends Application
{
    Button startBtn = new Button("Start");
    Button cancelBtn = new Button("Cancel");
    Button exitBtn = new Button("Exit");
    // Create the task
    PrimeFinderTask task = new PrimeFinderTask();

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage stage)
    {
        startBtn.setOnAction(e -> startTask());
        cancelBtn.setOnAction(e -> task.cancel());
        exitBtn.setOnAction(e -> stage.close());

        startBtn.disableProperty().bind(task.stateProperty().isNotEqualTo(Worker.State.READY));
        cancelBtn.disableProperty().bind(task.stateProperty().isNotEqualTo(Worker.State.RUNNING));

        GridPane pane = new WorkerStateUI(task);
        HBox buttonBox = new HBox(5, startBtn, cancelBtn, exitBtn);
        BorderPane root = new BorderPane();
        root.setCenter(pane);
        root.setBottom(buttonBox);
        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("A Prime Number Finder Task");
        stage.show();
    }

    public void startTask()
    {
        Thread backgroundThread = new Thread(task);
        backgroundThread.setDaemon(true);
        backgroundThread.start();
    }
}
