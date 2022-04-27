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

package jgui.javafx.event;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import static javafx.scene.input.MouseEvent.MOUSE_CLICKED;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 14 Jan 2018, 9:50 PM
 */
public class CaptureBubblingOrder extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage stage)
    {
        Circle circle = new Circle(50, 50, 50);
        circle.setFill(Color.CORAL);

        Rectangle rect = new Rectangle(100, 100);
        rect.setFill(Color.TAN);

        HBox root = new HBox();
        root.setPadding(new Insets(20));
        root.setSpacing(20);
        root.getChildren().addAll(circle, rect);

        Scene scene = new Scene(root);

        // Create two EventHandlders
        EventHandler<MouseEvent> filter = e -> handleEvent("Capture", e);
        EventHandler<MouseEvent> handler = e -> handleEvent("Bubbling", e);

        // Register filters
        stage.addEventFilter(MOUSE_CLICKED, filter);
        scene.addEventFilter(MOUSE_CLICKED, filter);
        root.addEventFilter(MOUSE_CLICKED, filter);
        circle.addEventFilter(MOUSE_CLICKED, filter);

        // Register handlers
        stage.addEventHandler(MOUSE_CLICKED, handler);
        scene.addEventHandler(MOUSE_CLICKED, handler);
        root.addEventHandler(MOUSE_CLICKED, handler);
        circle.addEventHandler(MOUSE_CLICKED, handler);
        stage.setScene(scene);
        stage.setTitle("Event Capture and Bubbling Execution Order");
        stage.show();
    }

    public void handleEvent(String phase, MouseEvent e)
    {
        String type = e.getEventType().getName();
        String source = e.getSource().getClass().getSimpleName();
        String target = e.getTarget().getClass().getSimpleName();
// Get coordinates of the mouse cursor relative to the event source
        double x = e.getX();
        double y = e.getY();
        System.out.println(phase + ": Type=" + type +
                ", Target=" + target + ", Source=" + source +
                ", location(" + x + ", " + y + ")");
    }
}
