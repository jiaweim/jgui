// Copyright (c) 2016 All rights reserved.
// Dalian Institute of Chemical Physics
//    Chinese Academy of Sciences
// Contact: jiaweiM_philo@hotmail.com

package trail.jgui.javafx.controls;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * RadioButton is usually used to create mutually exclusive series of items. Only one
 * RadioButton can be selected when placed in a ToggleGroup. When a RadioButton is selected an
 * ActionEvent is sent.
 *
 * This example has three radio buttons. By placing them in a toggle group, only one of them
 * can be selected at a time.
 *
 * @author JiaweiMao
 * @version 1.0.0
 * @date 2016.09.14, 1:00 PM
 */
public class RadioButtonEx extends Application {


    private final double BORDER = 10d;
    private Label lbl2;

    @Override
    public void start(Stage stage) {

        initUI(stage);
    }

    private void initUI(Stage stage) {

        AnchorPane root = new AnchorPane();

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));

        // this label givens description to the radio buttons.
        Label lbl1 = new Label("Difficulty");

        // This label shows the text label of the currently selected radio button.
        // Its style is customized with the setStyle() method. The label is enlarged to take
        // to width of the stage minus the specified border.
        lbl2 = new Label("");
        lbl2.setStyle("-fx-background-color:wheat; -fx-padding: 0 0 0 5");
        lbl2.prefWidthProperty().bind(stage.widthProperty().subtract(2 * BORDER));

        // A ToggleGroup is created and a listener is added to its selectedToggleProperty.
        ToggleGroup tg = new ToggleGroup();
        tg.selectedToggleProperty().addListener(new MyToggleListener());

        // A RadioButton control is created.
        RadioButton rb1 = new RadioButton("Easy");
        // setToggleGroup() method sets the radio button to the toggle group
        rb1.setToggleGroup(tg);
        // selects the radio button
        rb1.setSelected(true);

        RadioButton rb2 = new RadioButton("Medium");
        rb2.setToggleGroup(tg);

        RadioButton rb3 = new RadioButton("Hard");
        rb3.setToggleGroup(tg);

        vbox.getChildren().addAll(lbl1, rb1, rb2, rb3);

        root.getChildren().addAll(vbox, lbl2);

        AnchorPane.setTopAnchor(vbox, BORDER);
        AnchorPane.setBottomAnchor(lbl2, BORDER);
        AnchorPane.setLeftAnchor(lbl2, BORDER);

        Scene scene = new Scene(root, 300, 250);

        stage.setTitle("RadioButton");
        stage.setScene(scene);
        stage.show();
    }

    private class MyToggleListener implements ChangeListener<Toggle> {

        /**
         * Inside the listener object, we get the radio button's text label with the getText() method and
         * set it to the label using the setText() method
         */
        @Override
        public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {

            RadioButton rb = (RadioButton) newValue;
            String txt = rb.getText();
            lbl2.setText(txt);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
