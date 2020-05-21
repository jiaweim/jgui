/*
 * MIT License
 * Copyright (c) 2018 JiaweiMao
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package trail.jgui.javafx.controls;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since Oct 30, 2018, 11:47:01 PM
 */
public class ChoiceBoxEx1 extends Application
{

    @Override
    public void start(Stage primaryStage)
    {
        Label seasonLbl = new Label("Select a Season:");
        ChoiceBox<String> seasons = new ChoiceBox<>();
        seasons.getItems().addAll("Spring", "Summer", "Fall", "Winter");

        // Select the first season from the list
        seasons.getSelectionModel().selectFirst();

        // Add ChangeListeners to track change in selected index and item. Only
        // one listener is necessary if you want to track change in selection
        seasons.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> System.out.println("Itemchanged: old = " + oldValue + ",new = " + newValue));
        seasons.getSelectionModel().selectedIndexProperty()
                .addListener((observable, oldValue, newValue) -> System.out.println("Indexchanged: old = " + oldValue + ", new = " + newValue));

        Label selectionMsgLbl = new Label("Your selection:");
        Label selectedValueLbl = new Label("None");
        // Bind the value property to the text property of the Label
        selectedValueLbl.textProperty().bind(seasons.valueProperty());
        // Display controls in a GridPane
        GridPane root = new GridPane();
        root.setVgap(10);
        root.setHgap(10);
        root.addRow(0, seasonLbl, seasons);
        root.addRow(1, selectionMsgLbl, selectedValueLbl);
        root.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
                + "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: blue;");
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Using ChoiceBox Controls");
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
