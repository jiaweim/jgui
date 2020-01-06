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

package trail.jgui.javafx.text;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 09 Apr 2018, 3:46 PM
 */
public class TextFieldEx2 extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage stage)
    {
        // Create a TextFiled with an empty string as its initial text
        TextField firstNameFld = new TextField();
        TextField lastNameFld = new TextField();

        // Both fields should be wide enough to display 15 chars
        firstNameFld.setPrefColumnCount(15);
        lastNameFld.setPrefColumnCount(15);

        // Add a ChangeListener to the text property
        firstNameFld.textProperty().addListener(this::changed);
        lastNameFld.textProperty().addListener(this::changed);

        // Add a dummy custom context menu for the firstname field
        ContextMenu cm = new ContextMenu();
        MenuItem dummyItem = new MenuItem("Context menu is disabled");
        cm.getItems().add(dummyItem);
        firstNameFld.setContextMenu(cm);

        // Set ActionEvent handlers for both fields
        firstNameFld.setOnAction(e -> nameChanged("First Name"));
        lastNameFld.setOnAction(e -> nameChanged("Last Name"));

        GridPane root = new GridPane();
        root.setHgap(10);
        root.setVgap(5);
        root.addRow(0, new Label("First Name:"), firstNameFld);
        root.addRow(1, new Label("Last Name:"), lastNameFld);
        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Using TextField Controls");
        stage.show();
    }

    public void nameChanged(String fieldName)
    {
        System.out.println("Action event fired on " + fieldName);
    }

    public void changed(ObservableValue<? extends String> prop, String oldValue, String newValue)
    {
        System.out.println("Old = " + oldValue + ", new = " + newValue);
    }
}
