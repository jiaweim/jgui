/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 JiaweiMao
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software
 * and associated documentation files (the "Software"), to deal in the Software without
 * restriction, including without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package trail.jgui.javafx.concurrent;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @date 2017.01.11, 4:50 PM
 */
public class ResponsiveUI extends Application {

    Label statusLbl = new Label("Not Started...");
    Button startBtn = new Button("Start");
    Button exitBtn = new Button("Exit");

    @Override
    public void start(Stage stage) throws Exception {

        // Add event handlers to the buttons
        startBtn.setOnAction(e -> startTask());
        exitBtn.setOnAction(e -> stage.close());
        HBox buttonBox = new HBox(5, startBtn, exitBtn);
        VBox root = new VBox(10, statusLbl, buttonBox);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("A Responsive UI");
        stage.show();
    }

    public void startTask() {
        // Create a Runnable
        Runnable task = () -> runTask();

        // Run the task in a background thread
        Thread backgroundThread = new Thread(task);

        // Terminate the running thread if the application exits
        backgroundThread.setDaemon(true);

        // Start the thread
        backgroundThread.start();
    }

    public void runTask() {
        for (int i = 1; i <= 10; i++) {
            try {
                String status = "Processing " + i + " of " + 10;

                // Update the Label on the JavaFx Application Thread
                Platform.runLater(() -> statusLbl.setText(status));
                System.out.println(status);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
