// Copyright (c) 2016 All rights reserved.
// Dalian Institute of Chemical Physics
//    Chinese Academy of Sciences
// Contact: jiaweiM_philo@hotmail.com

package jgui.javafx.event;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * The following example shows the position of the application window on the screen.
 *
 * This program shows the screen coordinates of the application window in two labels.
 * To get the window position, we listen for changes of the xProperty and yProperty of the stage.
 *
 * @author JiaweiMao
 * @version 1.0.0
 * @date 2016.09.14, 2:25 PM
 */
public class MovingWindowEx extends Application {

    int x = 0;
    int y = 0;
    Label lblx;
    Label lbly;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        initUI(primaryStage);
    }

    private void initUI(Stage stage) {
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));

        // These two labels shows the x and y coordinates of the top-left corner of the application window.
        String txt1 = String.format("x: %d", x);
        lblx = new Label(txt1);

        String txt2 = String.format("y: %d", y);
        lbly = new Label(txt2);

        root.getChildren().addAll(lblx, lbly);

        // The xProperty stores the horizontal location of the stage on the screen. We add a changeListener to listen
        // for changes of the property. Each time the property is modified, we retrieve the new value and update the
        // label.
        stage.xProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

                doChange(newValue);
            }

            private void doChange(Number newValue) {

                x = newValue.intValue();
                updateXLabel();
            }

        });

        stage.yProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

                doChange(newValue);
            }

            private void doChange(Number newValue) {

                y = newValue.intValue();
                updateYLabel();
            }

        });

        Scene scene = new Scene(root, 300, 250);

        stage.setTitle("Moving window");
        stage.setScene(scene);
        stage.show();
    }

    private void updateXLabel() {

        String txt = String.format("x: %d", x);
        lblx.setText(txt);
    }

    private void updateYLabel() {

        String txt = String.format("y: %d", y);
        lbly.setText(txt);
    }
}
