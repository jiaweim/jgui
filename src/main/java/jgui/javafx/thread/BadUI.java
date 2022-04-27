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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 15 Jan 2018, 2:06 PM
 */
public class BadUI extends Application
{
    Label statusLbl = new Label("Not Started...");
    Button startBtn = new Button("Start");
    Button exitBtn = new Button("Exit");

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        startBtn.setOnAction(e -> startTask());
        exitBtn.setOnAction(e -> primaryStage.close());

        HBox buttonBox = new HBox(5, startBtn, exitBtn);
        VBox root = new VBox(10, statusLbl, buttonBox);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("A Bad UI");
        primaryStage.show();
    }

    public void startTask()
    {
        // Create a Runnable
        Runnable task = () -> runTask();
        // Run the task in a background thread
        Thread backgroundThread = new Thread(task);
        // Terminate the running thread if the application exits
        backgroundThread.setDaemon(true);
        // Start the thread
        backgroundThread.start();
    }

    public void runTask()
    {
        for (int i = 1; i <= 10; i++) {
            try {
                String status = "Processing " + i + " of " + 10;
                statusLbl.setText(status);
                System.out.println(status);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
