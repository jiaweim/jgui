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

package jgui.javafx.stage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ShowAndWaitApp extends Application {
    protected static int counter = 0;
    protected Stage lastOpenStage;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        VBox root = new VBox();
        Button openButton = new Button("Open");
        openButton.setOnAction(e -> open(++counter));
        root.getChildren().add(openButton);
        Scene scene = new Scene(root, 400, 400);
        stage.setScene(scene);
        stage.setTitle("The Primary Stage");
        stage.show();
        this.lastOpenStage = stage;
    }

    private void open(int stageNumber) {
        Stage stage = new Stage();
        stage.setTitle("#" + stageNumber);
        Button sayHelloButton = new Button("Say Hello");
        sayHelloButton.setOnAction(e -> System.out.println("Hello from #" + stageNumber));
        Button openButton = new Button("Open");
        openButton.setOnAction(e -> open(++counter));
        VBox root = new VBox();
        root.getChildren().addAll(sayHelloButton, openButton);
        Scene scene = new Scene(root, 200, 200);
        stage.setScene(scene);
        stage.setX(this.lastOpenStage.getX() + 50);
        stage.setY(this.lastOpenStage.getY() + 50);
        this.lastOpenStage = stage;
        System.out.println("Before stage.showAndWait(): " + stageNumber);

        // Show the stage and wait for it to close
        stage.showAndWait();
        System.out.println("After stage.showAndWait(): " + stageNumber);
    }
}