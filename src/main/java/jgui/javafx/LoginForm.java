// Copyright (c) 2016 All rights reserved.
// Dalian Institute of Chemical Physics
//    Chinese Academy of Sciences
// Contact: jiaweiM_philo@hotmail.com

package jgui.javafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 * @author JiaweiMao
 * @version 1.0.0
 * @date 2016.09.14, 4:44 PM
 */
public class LoginForm extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        primaryStage.setTitle("JavaFX Welcome");

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Welcome");
        scenetitle.setId("welcome-text");

//        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        gridPane.add(scenetitle, 0, 0, 2, 1);

        Label userName = new Label("User Name:");
        gridPane.add(userName, 0, 1);

        TextField userTextField = new TextField();
        gridPane.add(userTextField, 1, 1);

        Label pw = new Label("Password:");
        gridPane.add(pw, 0, 2);

        PasswordField pwBox = new PasswordField();
        gridPane.add(pwBox, 1, 2);

        Button btn = new Button("Sign in");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        gridPane.add(hbBtn, 1, 4);

        final Text actiontarget = new Text();
        actiontarget.setId("actiontarget");
        gridPane.add(actiontarget, 1, 6);

        btn.setOnAction(event -> {
//            actiontarget.setFill(Color.FIREBRICK);
            actiontarget.setText("Sign in button pressed");
        });

        Scene scene = new Scene(gridPane, 300, 275);
        primaryStage.setScene(scene);
        scene.getStylesheets().add("fxml/Login.css");

        primaryStage.show();
    }
}
