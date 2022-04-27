// Copyright (c) 2016 All rights reserved.
// Dalian Institute of Chemical Physics
//    Chinese Academy of Sciences
// Contact: jiaweiM_philo@hotmail.com

package jgui.javafx.controls;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 * ColorPicker is a built-in dialog for choosing a color value. It allows the user to select a color from either
 * a standard palette of colors or to define a custeom color.
 *
 * This program uses the ColorPicker dialog to choose a color value.
 *
 * We have a ColorPicker and a Text control. The selected color from the color picker
 * is used to set the forground color of the text control.
 *
 * @author JiaweiMao
 * @version 1.0.0
 * @date 2016.09.14, 12:52 PM
 */
public class ColorPickerEx extends Application {

    @Override
    public void start(Stage stage) {

        initUI(stage);
    }

    private void initUI(Stage stage) {

        HBox root = new HBox(25);
        root.setAlignment(Pos.BASELINE_CENTER);
        root.setPadding(new Insets(10));

        // a Text control is created, enlarge its font for better visibility
        Text txt = new Text("ZetCode");

        Font font = Font.font(20);
        txt.setFont(font);

        // A ColorPicker is created and an event handle is set. The currently selected
        // color is retrieved with the ColorPicker's getValue() method. The foreground
        // color of the text control is changed using the setFill() method.
        ColorPicker cp = new ColorPicker();
        cp.setOnAction((ActionEvent event) -> {
            txt.setFill(cp.getValue());
        });

        root.getChildren().addAll(cp, txt);

        Scene scene = new Scene(root, 300, 250);

        stage.setTitle("ColorPicker");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
