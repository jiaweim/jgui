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

package trail.jgui.javafx.event;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 14 Jan 2018, 9:53 PM
 */
public class HandlersOrder extends Application
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
        HBox root = new HBox();
        root.getChildren().addAll(circle);
        Scene scene = new Scene(root);
        /* Register three handlers for the circle that can handle mouse-clicked events */

        // This will be called last
        circle.addEventHandler(MouseEvent.ANY, e -> handleAnyMouseEvent(e));

        // This will be called first
        circle.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> handleMouseClicked("addEventHandler()", e));

        // This will be called second
        circle.setOnMouseClicked(e -> handleMouseClicked("setOnMouseClicked()", e));

        stage.setScene(scene);
        stage.setTitle("Execution Order of Event Handlers of a Node");
        stage.show();
    }

    public void handleMouseClicked(String registrationMethod, MouseEvent e)
    {
        System.out.println(registrationMethod
                + ": MOUSE_CLICKED handler detected a mouse click.");
    }

    public void handleAnyMouseEvent(MouseEvent e)
    {
// Print a message only for mouse-clicked events, ignoring
// other mouse events such as mouse-pressed, mouse-released, etc.
        if (e.getEventType() == MouseEvent.MOUSE_CLICKED) {
            System.out.println("MouseEvent.ANY handler detected a mouse click.");
        }
    }
}
