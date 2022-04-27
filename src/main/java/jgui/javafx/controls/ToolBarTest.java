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
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * It creates a toolbar and adds four items. when you click one of the items with a shape, it draws the shape on a canvas.
 * The exit item closes the application.
 *
 * @author JiaweiMao
 * @version 1.0.0
 * @since 18 Jan 2018, 10:41 AM
 */
public class ToolBarTest extends Application
{

    Canvas canvas = new Canvas(200, 200);

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        Button rectBtn = new Button("", new Rectangle(0, 0, 16, 16));
        Button circleBtn = new Button("", new Circle(0, 0, 8));
        Button ellipseBtn = new Button("", new Ellipse(8, 8, 8, 6));
        Button exitBtn = new Button("Exit");

        // Set tooltips
        rectBtn.setTooltip(new Tooltip("Draws a rectangle"));
        circleBtn.setTooltip(new Tooltip("Draws a circle"));
        ellipseBtn.setTooltip(new Tooltip("Draws an ellipse"));
        exitBtn.setTooltip(new Tooltip("Exits application"));

        // Add ActionEvent handlers for items
        rectBtn.setOnAction(e -> draw("Rectangle"));
        circleBtn.setOnAction(e -> draw("Circle"));
        ellipseBtn.setOnAction(e -> draw("Ellipse"));
        exitBtn.setOnAction(e -> Platform.exit());

        ToolBar toolBar = new ToolBar(rectBtn, circleBtn, ellipseBtn,
                new Separator(),
                exitBtn);
        BorderPane root = new BorderPane();
        root.setTop(new VBox(new Label("Click a shape to draw."), toolBar));
        root.setCenter(canvas);
        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Using ToolBar Controls");
        primaryStage.show();
    }

    public void draw(String shapeType)
    {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, 200, 200); // First clear the canvas
        gc.setFill(Color.TAN);
        switch (shapeType) {
            case "Rectangle":
                gc.fillRect(0, 0, 200, 200);
                break;
            case "Circle":
                gc.fillOval(0, 0, 200, 200);
                break;
            case "Ellipse":
                gc.fillOval(10, 40, 180, 120);
                break;
        }
    }
}
