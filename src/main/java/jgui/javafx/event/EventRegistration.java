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
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 14 Jan 2018, 9:03 PM
 */
public class EventRegistration extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        Circle circle = new Circle(100, 100, 50);
        circle.setFill(Color.CORAL);

        EventHandler<MouseEvent> mouseEventFilter = e -> System.out.println("Mouse event filer has been called.");

        EventHandler<MouseEvent> mouseEventHandler = e -> System.out.println("Mouse event handler has been called.");

        circle.addEventFilter(MouseEvent.MOUSE_CLICKED, mouseEventFilter);
        circle.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEventHandler);

        HBox root = new HBox();
        root.getChildren().add(circle);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Registering Event Filters and Handlers");
        primaryStage.show();
        primaryStage.sizeToScene();
    }
}
