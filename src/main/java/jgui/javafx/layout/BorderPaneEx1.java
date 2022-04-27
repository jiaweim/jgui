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
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 23 Dec 2017, 9:09 PM
 */
public class BorderPaneEx1 extends Application
{
    private final int SIZE = 60;
    private BorderPane root;

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        root = new BorderPane();

        // 将五个 label 放在 BorderPane 的五个区域
        root.setTop(getTopLabel());
        root.setBottom(getBottomLabel());
        root.setLeft(getLeftLabel());
        root.setRight(getRightLabel());
        root.setCenter(getCenterLabel());

        Scene scene = new Scene(root, 350, 300);

        primaryStage.setTitle("BorderPane");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Label getTopLabel()
    {
        Label lbl = new MyLabel("Top");
        lbl.setPrefHeight(SIZE);
        lbl.prefWidthProperty().bind(root.widthProperty());
        lbl.setStyle("-fx-border-style: dotted; -fx-border-width: 0 0 1 0;"
                + "-fx-border-color: gray; -fx-font-weight: bold");

        return lbl;
    }

    private Label getBottomLabel()
    {
        Label lbl = new MyLabel("Bottom");
        lbl.setPrefHeight(SIZE); // 提高标签的宽度
        lbl.prefWidthProperty().bind(root.widthProperty());
        lbl.setStyle("-fx-border-style: dotted; -fx-border-width: 1 0 0 0;"
                + "-fx-border-color: gray; -fx-font-weight: bold");

        return lbl;
    }

    private Label getLeftLabel()
    {
        Label lbl = new MyLabel("Left");
        lbl.setPrefWidth(SIZE);
        lbl.prefHeightProperty().bind(root.heightProperty().subtract(2 * SIZE));
        lbl.setStyle("-fx-border-style: dotted; -fx-border-width: 0 1 0 0;"
                + "-fx-border-color: gray; -fx-font-weight: bold");

        return lbl;
    }

    private Label getRightLabel()
    {
        Label lbl = new MyLabel("Right");
        lbl.setPrefWidth(SIZE);
        lbl.prefHeightProperty().bind(root.heightProperty().subtract(2 * SIZE));
        lbl.setStyle("-fx-border-style: dotted; -fx-border-width: 0 0 0 1;"
                + "-fx-border-color: gray; -fx-font-weight: bold");

        return lbl;
    }

    private Label getCenterLabel()
    {
        Label lbl = new MyLabel("Center");
        lbl.setStyle("-fx-font-weight: bold");
        lbl.prefHeightProperty().bind(root.heightProperty().subtract(2 * SIZE));
        lbl.prefWidthProperty().bind(root.widthProperty().subtract(2 * SIZE));

        return lbl;
    }

    class MyLabel extends Label
    {
        public MyLabel(String text)
        {
            super(text);

            setAlignment(Pos.BASELINE_CENTER);
        }
    }
}
