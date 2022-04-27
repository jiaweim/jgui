// Copyright (c) 2016 All rights reserved.
// Dalian Institute of Chemical Physics
//    Chinese Academy of Sciences
// Contact: jiaweiM_philo@hotmail.com

package jgui.javafx.controls;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * ChoiceBox is used for presenting the user with a small set of predefined choices. When the user clicks on the
 * box, a list of choices is shown. Only one option can be seelcted at a time. When this list is not showing, the
 * currently selected choice is shown. ChoiceBox item selection is handled by a SelectionModel.
 * <p>
 * This program uses a ChoiceBox. The chosen item is shown in a label.
 * <p>
 * In our example, we have a choice box and a label. The choice box contains a list of strings denoting
 * names of Linux distribution. The selected item from the choice box is displayed in the label.
 *
 * @author JiaweiMao
 * @version 1.0.0
 * @date 2016.09.14, 10:48 AM
 */
public class ChoiceBoxEx extends Application
{
    @Override
    public void start(Stage stage)
    {

        initUI(stage);
    }

    private void initUI(Stage stage)
    {
        VBox root = new VBox(35);
        root.setPadding(new Insets(10));

        // This label shows the currently selected item from the choice box.
        Label lbl = new Label();

        // A ChoiceBox is created. It takes an observable array list as a parameter.
        ChoiceBox<String> chbox = new ChoiceBox<>(FXCollections.observableArrayList(
                "Ubuntu", "Redhat", "Arch", "Debian", "Mint"));

        // To implement a listener, we need to get the selection model with the getSelectionModel() method.
        // The model contains the observable selectedItem property. Inside the handler method, we get the
        // selected value and set it to the label.
        SingleSelectionModel<String> model = chbox.getSelectionModel();
        model.selectedItemProperty().addListener((observable, oldValue, newValue) -> lbl.setText(newValue));

        root.getChildren().addAll(chbox, lbl);

        Scene scene = new Scene(root, 300, 250);

        stage.setTitle("ChoiceBox");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
