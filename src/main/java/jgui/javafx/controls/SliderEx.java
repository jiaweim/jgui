// Copyright (c) 2016 All rights reserved.
// Dalian Institute of Chemical Physics
//    Chinese Academy of Sciences
// Contact: jiaweiM_philo@hotmail.com

package jgui.javafx.controls;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


/**
 * Slider is a control that lets the user graphically select a value by sliding a knob within a bounded interval.
 * The slider can optionally show tick marks and labels indicating different slider position values.
 *
 * This program uses a Slider control to manipulate the images of an ImageView
 *
 * In the code example, we show a Slider and an ImageView control. By draggign the knob of the slider, we change
 * the image on the label control.
 *
 * @author JiaweiMao
 * @version 1.0.0
 * @date 2016.09.14, 10:41 AM
 */
public class SliderEx extends Application {


    private ImageView iview;
    private Image muteImg;
    private Image minImg;
    private Image maxImg;
    private Image medImg;

    @Override
    public void start(Stage stage) {

        initUI(stage);
    }

    private void initUI(Stage stage) {

        HBox root = new HBox(10);
        // the slider and the image view are centered in the row
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(15));

        loadImages();

        // ImageView displays images loaded with the Image class
        iview = new ImageView(muteImg);

        // A Slider control is created with the specified minimum, maximum, and current values
        Slider slider = new Slider(0, 100, 0);
        // A listener is added to the value changes of the slider.
        slider.valueProperty().addListener(new MyChangeListener());

        Scene scene = new Scene(root);

        root.getChildren().addAll(slider, iview);

        stage.setTitle("Slider");
        stage.setScene(scene);
        stage.show();
    }

    private void loadImages() {

        muteImg = new Image("file:mute.png");
        minImg = new Image("file:min.png");
        maxImg = new Image("file:max.png");
        medImg = new Image("file:med.png");
    }

    private class MyChangeListener implements ChangeListener<Number> {

        @Override
        public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

            Double value = newValue.doubleValue();

            if (value == 0) {
                iview.setImage(muteImg);
            } else if (value > 0 && value <= 30) {
                iview.setImage(minImg);
            } else if (value > 30 && value < 80) {
                iview.setImage(medImg);
            } else {
                iview.setImage(maxImg);
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
