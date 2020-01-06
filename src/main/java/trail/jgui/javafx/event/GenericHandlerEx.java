// Copyright (c) 2016 All rights reserved.
// Dalian Institute of Chemical Physics
//    Chinese Academy of Sciences
// Contact: jiaweiM_philo@hotmail.com

package trail.jgui.javafx.event;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 * a generic event handler that listens for all kinds of events.
 *
 * This program adds a generic event handler to a button control.
 *
 * This example has one button control. A generic handler is plugged to the button.
 *
 * @author JiaweiMao
 * @version 1.0.0
 * @date 2016.09.14, 1:54 PM
 */
public class GenericHandlerEx extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        initUI(primaryStage);
    }

    private void initUI(Stage stage) {
        StackPane root = new StackPane();

        // The addEventHanlder() method registers an event handler to the button node for the specified event type.
        // the EventType.ROOT stands for all event types
        Button btn = new Button("Button");
        btn.addEventHandler(EventType.ROOT, new GenericHandler());

        root.getChildren().add(btn);

        Scene scene = new Scene(root, 300, 250);

        stage.setTitle("Generic handler");
        stage.setScene(scene);
        stage.show();
    }

    // The handler prints the event type to the control in its handler() method.
    private class GenericHandler implements EventHandler<Event> {
        @Override public void handle(Event event) {
            System.out.println(event.getEventType());
        }
    }
}
