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
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Creates two ComboBox controls: seasons and breakfasts.
 * <p>
 * The combo box having the list of seasons is not editable.
 * <p>
 * The combo box having the list of breakfast items is editable.
 *
 * @author JiaweiMao
 * @version 1.0.0
 * @since 23 Jan 2018, 3:28 PM
 */
public class ComboBoxEx1 extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        Label seasonsLbl = new Label("Seasons:");
        ComboBox<String> seasons = new ComboBox<>();
        seasons.getItems().addAll("Spring", "Summer", "Fall", "Winter");

        Label breakfastsLbl = new Label("Breakfast:");
        ComboBox<String> breakfasts = new ComboBox<>();
        breakfasts.getItems().addAll("Applet", "Banana", "Strawberry");
        breakfasts.setEditable(true);

        // Show the user's selection in a label
        Label selectionLbl = new Label();
        StringProperty str = new SimpleStringProperty("Your selection:");
        selectionLbl.textProperty().bind(str.concat("Season=")
                .concat(seasons.valueProperty())
                .concat(", Breakfast=")
                .concat(breakfasts.valueProperty()));

        HBox row1 = new HBox(seasonsLbl, seasons, breakfastsLbl, breakfasts);
        row1.setSpacing(10);
        VBox root = new VBox(row1, selectionLbl);
        root.setSpacing(10);
        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Using ComboxBox Controls");
        primaryStage.show();
    }
}
