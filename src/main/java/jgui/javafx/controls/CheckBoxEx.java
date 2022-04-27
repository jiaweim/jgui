// Copyright (c) 2016 All rights reserved.
// Dalian Institute of Chemical Physics
//    Chinese Academy of Sciences
// Contact: jiaweiM_philo@hotmail.com

package jgui.javafx.controls;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


/**
 * CheckBox is a tri-state selection control box showing a checkmark or tick mark when checked.
 * The control has two states by default: checked and unchecked.
 * The setAllowIndeterminate() enables the third state: indeterminate.
 * <p>
 * This program presents the CheckBox control.
 * <p>
 * This example shows or hides the title of the window depending whether the check box is selected.
 * <p>
 * Note the blue rectangle around the text of the check box. It indicates that this control has keyboard focus.
 * It is possible to select and deselect the check box with the Space key.
 *
 * @author JiaweiMao
 * @version 1.0.0
 */
public class CheckBoxEx extends Application
{
    @Override
    public void start(Stage stage)
    {
        initUI(stage);
    }

    private void initUI(Stage stage)
    {
        HBox root = new HBox();
        root.setPadding(new Insets(10, 0, 0, 10));

        // A CheckBox control is created. The specified text is its label.
        CheckBox cbox = new CheckBox("Show title");
        // since the title of the window is visible by default, we check the control with the setSelected() method.
        cbox.setSelected(true);

        // With the setOnAction() method, we set the check box's action, which is invoked when the check box is fired.
        // We determine its state with the isSelected() method. Depending on the current state, we show to hide the
        // window title with the setTitle() method.
        cbox.setOnAction((ActionEvent event) -> {
            if (cbox.isSelected()) {
                stage.setTitle("CheckBox");
            } else {
                stage.setTitle("");
            }
        });

        root.getChildren().add(cbox);

        Scene scene = new Scene(root, 300, 200);

        stage.setTitle("CheckBox");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
