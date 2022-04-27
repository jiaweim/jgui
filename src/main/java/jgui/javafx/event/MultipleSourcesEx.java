// Copyright (c) 2016 All rights reserved.
// Dalian Institute of Chemical Physics
//    Chinese Academy of Sciences
// Contact: jiaweiM_philo@hotmail.com

package jgui.javafx.event;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * It is possible to add a single handler to multiple sources. The sources of the event can be
 * determined with the getSource() method.
 *
 * This program plugs an EventHandler to multiple control.
 *
 * The example has four buttons and a label. One event handler is added to all four
 * buttons. The name of the fired button is displayed in the label.
 *
 * @author JiaweiMao
 * @version 1.0.0
 * @date 2016.09.14, 1:59 PM
 */
public class MultipleSourcesEx extends Application {

    private Label lbl;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        initUI(primaryStage);
    }

    private void initUI(Stage stage) {
        AnchorPane root = new AnchorPane();

        VBox vBox = new VBox(5);

        // These four buttons will share a single event handler.
        Button btn1 = new Button("Close");
        Button btn2 = new Button("Open");
        Button btn3 = new Button("Find");
        Button btn4 = new Button("Save");

        // An instance of a MyButtonHandler is created. It is implemented as a inner named class.
        MyButtonHandler handler = new MyButtonHandler();

        btn1.setOnAction(handler);
        btn2.setOnAction(handler);
        btn3.setOnAction(handler);
        btn4.setOnAction(handler);

        vBox.getChildren().addAll(btn1, btn2, btn3, btn4);

        lbl = new Label("Ready");

        AnchorPane.setTopAnchor(vBox, 10d);
        AnchorPane.setLeftAnchor(vBox, 10d);
        AnchorPane.setBottomAnchor(lbl, 10d);
        AnchorPane.setLeftAnchor(lbl, 10d);

        root.getChildren().addAll(vBox, lbl);

        Scene scene = new Scene(root, 350, 200);

        stage.setTitle("Multiple sources event");
        stage.setScene(scene);
        stage.show();

    }

    /**
     * Inside the handler() method of the MyButtonHandler, we determine the source of the event
     * and build a message using the source's text label. THe message is set to the label control with its
     * setText() method.
     */
    private class MyButtonHandler implements EventHandler<ActionEvent> {

        @Override public void handle(ActionEvent event) {
            Button btn = (Button) event.getSource();
            lbl.setText(String.format("Button %s fired", btn.getText()));
        }
    }
}
