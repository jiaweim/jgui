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
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 24 Dec 2017, 11:01 AM
 */
public class LabelEx2_labelFor extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        Label lbl1 = new Label("_Name:");
        Label lbl2 = new Label("_Address:");
        Label lbl3 = new Label("_Occupation:");

        TextField field1 = new TextField();
        TextField field2 = new TextField();
        TextField field3 = new TextField();

        lbl1.setLabelFor(field1);
        lbl1.setMnemonicParsing(true);
        lbl2.setLabelFor(field2);
        lbl2.setMnemonicParsing(true);
        lbl3.setLabelFor(field3);
        lbl3.setMnemonicParsing(true);

        GridPane root = new GridPane();
        root.setVgap(10);
        root.setHgap(5);
        root.setPadding(new Insets(10));

        root.addColumn(0, lbl1, lbl2, lbl3);
        root.addColumn(2, field1, field2, field3);

        GridPane.setHalignment(lbl1, HPos.RIGHT);
        GridPane.setHalignment(lbl2, HPos.RIGHT);
        GridPane.setHalignment(lbl3, HPos.RIGHT);

        Scene scene = new Scene(root);

        primaryStage.setTitle("TextField");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
