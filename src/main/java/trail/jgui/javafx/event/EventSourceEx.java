// Copyright (c) 2016 All rights reserved.
// Dalian Institute of Chemical Physics
//    Chinese Academy of Sciences
// Contact: jiaweiM_philo@hotmail.com

package trail.jgui.javafx.event;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


/**
 * The following program explorers the properties of a MouseEvent. It is an event that occurs
 * due to the user interacting with a mouse.
 *
 * In the example, we have a rectangle shape. we add an event handler to the mouse clicked event type.
 *
 * @author JiaweiMao
 * @version 1.0.0
 * @date 2016.09.14, 1:45 PM
 */
public class EventSourceEx extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        initUI(primaryStage);
    }

    private void initUI(Stage stage){

        Pane root = new Pane();
        Rectangle react = new Rectangle(30, 30, 80, 80);

        /**
         * The setOnMouseClicked() adds an event handler to the mouse clicked event types.
         * The handler is an anonymous inner class.
         */
        react.setOnMouseClicked(event -> {
            // These three are the generic properties, available for all events. The
            // getSource() method returns an object on which the event initially occured.
            // The getTarget() method returns the event target of this event.
            // In our case, the event source and the event target is the same - the rectangle.
            // the getEventType() method returns the event type of the MouseEvent. IN our case
            // it returns the MOUSE_CLICKED value.
            System.out.println(event.getSource());
            System.out.println(event.getTarget());
            System.out.println(event.getEventType());
            // These four properties are specific to this event. We print the x and y coordinates
            // of a mouse click, relative to the scene and to the screen.
            System.out.format("x:%f, y:%f%n", event.getSceneX(), event.getSceneY());
            System.out.format("x:%f, y:%f%n", event.getScreenX(), event.getScreenY());
        });

        root.getChildren().addAll(react);

        Scene scene = new Scene(root, 300, 250);

        stage.setTitle("Event properties");
        stage.setScene(scene);
        stage.show();
    }

}
