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

package trail.jgui.javafx.controls;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 24 Dec 2017, 6:57 PM
 */
public class LabelEx3 extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage stage)
    {
        TextField fNameFld = new TextField();
        Label nameLbl = new Label("_First Name:");
        nameLbl.setLabelFor(fNameFld);
        nameLbl.setMnemonicParsing(true);

        TextField lNameFld = new TextField();
        Label lNameLbl = new Label("_Last Name:");
        lNameLbl.setLabelFor(lNameFld);
        lNameLbl.setMnemonicParsing(true);

        GridPane root = new GridPane();
        root.addRow(0, nameLbl, fNameFld);
        root.addRow(1, lNameLbl, lNameFld);
        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Using Labels");
        stage.show();
    }
}
