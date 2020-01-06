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
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import trail.javafx.tableview.Person;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 23 Jan 2018, 3:58 PM
 */
public class ComboBox_Converter extends Application
{

    Label userSelectionMsgLbl = new Label("Your selection:");
    Label userSelectionDataLbl = new Label("");

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        Label personLbl = new Label("Select/Enter Person:");

        ComboBox<Person> persons = new ComboBox<>();
        persons.setEditable(true);
        persons.setConverter(new PersonStringConverter());
        persons.getItems().addAll(new Person("John", "Jacobs"),
                new Person("Donna", "Duncan"),
                new Person("Layne", "Estes"),
                new Person("Mason", "Boyd"));

        // Add ChangeListeners to the selectedItem and selectedIndex
        // properties of the selection model
        persons.getSelectionModel().selectedItemProperty()
                .addListener(this::personChanged);
        persons.getSelectionModel().selectedIndexProperty()
                .addListener(this::indexChanged);
        // Update the message Label when the value changes
        persons.setOnAction(e -> valueChanged(persons));

        GridPane root = new GridPane();
        root.addRow(0, personLbl, persons);
        root.addRow(1, userSelectionMsgLbl, userSelectionDataLbl);
        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Using StringConverter in ComboBox");
        primaryStage.show();
    }


    public void valueChanged(ComboBox<Person> list)
    {
        Person p = list.getValue();
        String name = p.getLastName() + ", " + p.getFirstName();
        userSelectionDataLbl.setText(name);
    }

    // A change listener to track the change in item selection
    public void personChanged(ObservableValue<? extends Person> observable,
                              Person oldValue,
                              Person newValue)
    {
        System.out.println("Itemchanged: old = " + oldValue +
                ", new = " + newValue);
    }

    // A change listener to track the change in index selection
    public void indexChanged(ObservableValue<? extends Number> observable,
                             Number oldValue,
                             Number newValue)
    {
        System.out.println("Indexchanged: old = " + oldValue + ", new = " + newValue);
    }
}
