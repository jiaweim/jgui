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
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 04 Apr 2018, 6:48 PM
 */
public class PasswordFieldEx1 extends Application
{

    final Label message = new Label("");

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage stage)
    {
        Group root = new Group();
        Scene scene = new Scene(root, 260, 80);
        stage.setScene(scene);
        stage.setTitle("Password Field Sample");

        VBox vb = new VBox();
        vb.setPadding(new Insets(10, 0, 0, 10));
        vb.setSpacing(10);
        HBox hb = new HBox();
        hb.setSpacing(10);
        hb.setAlignment(Pos.CENTER_LEFT);

        Label label = new Label("Password");
        final PasswordField pb = new PasswordField();
        pb.setText("Your password");

        pb.setOnAction((ActionEvent e) -> {
            if (!pb.getText().equals("T2f$Ay!")) {
                message.setText("Your password is incorrect!");
                message.setTextFill(Color.rgb(210, 39, 30));
            } else {
                message.setText("Your password has been confirmed");
                message.setTextFill(Color.rgb(21, 117, 84));
            }
            pb.clear();
        });

        hb.getChildren().addAll(label, pb);
        vb.getChildren().addAll(hb, message);

        scene.setRoot(vb);
        stage.show();
    }
}
