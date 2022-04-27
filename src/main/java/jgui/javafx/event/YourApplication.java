// Copyright (c) 2017 All rights reserved.
// Dalian Institute of Chemical Physics
//    Chinese Academy of Sciences
// Contact: jiaweiM_philo@hotmail.com

package jgui.javafx.event;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @date 2017.01.17, 2:16 PM
 */
public class YourApplication extends Application {


    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hello World");
        Group root = new Group();
        Scene scene = new Scene(root, 300, 250);
        Button btn = new Button();
        btn.setLayoutX(100);
        btn.setLayoutY(80);
        btn.setText("Hello World");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                System.out.println("Hello World");
            }
        });
        root.getChildren().add(btn);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
