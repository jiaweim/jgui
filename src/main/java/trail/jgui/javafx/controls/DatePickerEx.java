// Copyright (c) 2016 All rights reserved.
// Dalian Institute of Chemical Physics
//    Chinese Academy of Sciences
// Contact: jiaweiM_philo@hotmail.com

package trail.jgui.javafx.controls;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.LocalDate;


/**
 * DatePicker is a control for choosing a date.
 *
 * This program shows a date chosen from a DatePicker in a label.
 *
 * The example uses a DatePicker control to select and display a date. The date is
 * shown in a label control.
 *
 * @author JiaweiMao
 * @version 1.0.0
 * @date 2016.09.14, 10:54 AM
 */
public class DatePickerEx extends Application {

    @Override
    public void start(Stage stage) {

        initUI(stage);
    }

    private void initUI(Stage stage) {

        VBox root = new VBox(15);
        root.setPadding(new Insets(10));

        Label lbl = new Label("...");

        // The instance of a DatePicker control is created.
        DatePicker datePicker = new DatePicker();

        // the getValue method returns the selected date as a LocalDate. The chosen date
        // is set to the label control with its setText() method
        datePicker.setOnAction(e -> {
            LocalDate date = datePicker.getValue();
            lbl.setText(date.toString());
        });

        root.getChildren().addAll(datePicker, lbl);

        Scene scene = new Scene(root, 350, 200);

        stage.setTitle("Date picker");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
