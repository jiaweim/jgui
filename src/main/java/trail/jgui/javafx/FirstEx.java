// Copyright (c) 2016 All rights reserved.
// Dalian Institute of Chemical Physics
//    Chinese Academy of Sciences
// Contact: jiaweiM_philo@hotmail.com

package trail.jgui.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


/**
 * @author JiaweiMao
 * @version 1.0.0
 * @date 2016.09.14, 9:08 AM
 */
public class FirstEx extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        StackPane root = new StackPane();

        Scene scene = new Scene(root, 300, 250);
        Label lbl = new Label("Simple JavaFX application.");
        lbl.setFont(Font.font("Serif", FontWeight.BOLD, 20));
        root.getChildren().add(lbl);

        primaryStage.setTitle("Simple application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
