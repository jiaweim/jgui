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

package jgui.javafx.controls;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.SepiaTone;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 04 Apr 2018, 6:56 PM
 */
public class SliderEx1 extends Application
{

    final static Color textColor = Color.BLACK;
    final static SepiaTone sepiaEffect = new SepiaTone();
    final Slider opacityLevel = new Slider(0, 1, 1);
    final Slider sepiaTone = new Slider(0, 1, 1);
    final Slider scaling = new Slider(0.5, 1, 1);
    final Image image = new Image(getClass().getClassLoader().getResourceAsStream(
            "cappuccino.jpg")
    );
    final Label opacityCaption = new Label("Opacity Level:");
    final Label sepiaCaption = new Label("Sepia Tone:");
    final Label scalingCaption = new Label("Scaling Factor:");
    final Label opacityValue = new Label(
            Double.toString(opacityLevel.getValue()));
    final Label sepiaValue = new Label(
            Double.toString(sepiaTone.getValue()));
    final Label scalingValue = new Label(
            Double.toString(scaling.getValue()));

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage stage)
    {
        Group root = new Group();
        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.setTitle("Slider Sample");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(10);
        grid.setHgap(70);

        final ImageView cappuccino = new ImageView(image);
        cappuccino.setEffect(sepiaEffect);
        GridPane.setConstraints(cappuccino, 0, 0);
        GridPane.setColumnSpan(cappuccino, 3);
        grid.getChildren().add(cappuccino);
        scene.setRoot(grid);

        opacityCaption.setTextFill(textColor);
        GridPane.setConstraints(opacityCaption, 0, 1);
        grid.getChildren().add(opacityCaption);


        opacityLevel.valueProperty().addListener((
                ObservableValue<? extends Number> ov,
                Number old_val, Number new_val) -> {
            cappuccino.setOpacity(new_val.doubleValue());
            opacityValue.setText(String.format("%.2f", new_val));
        });

        GridPane.setConstraints(opacityLevel, 1, 1);
        grid.getChildren().add(opacityLevel);

        opacityValue.setTextFill(textColor);
        GridPane.setConstraints(opacityValue, 2, 1);
        grid.getChildren().add(opacityValue);

        sepiaCaption.setTextFill(textColor);
        GridPane.setConstraints(sepiaCaption, 0, 2);
        grid.getChildren().add(sepiaCaption);

        sepiaTone.valueProperty().addListener((
                ObservableValue<? extends Number> ov, Number old_val,
                Number new_val) -> {
            sepiaEffect.setLevel(new_val.doubleValue());
            sepiaValue.setText(String.format("%.2f", new_val));
        });
        GridPane.setConstraints(sepiaTone, 1, 2);
        grid.getChildren().add(sepiaTone);

        sepiaValue.setTextFill(textColor);
        GridPane.setConstraints(sepiaValue, 2, 2);
        grid.getChildren().add(sepiaValue);

        scalingCaption.setTextFill(textColor);
        GridPane.setConstraints(scalingCaption, 0, 3);
        grid.getChildren().add(scalingCaption);

        scaling.valueProperty().addListener((
                ObservableValue<? extends Number> ov, Number old_val,
                Number new_val) -> {
            cappuccino.setScaleX(new_val.doubleValue());
            cappuccino.setScaleY(new_val.doubleValue());
            scalingValue.setText(String.format("%.2f", new_val));
        });
        GridPane.setConstraints(scaling, 1, 3);
        grid.getChildren().add(scaling);

        scalingValue.setTextFill(textColor);
        GridPane.setConstraints(scalingValue, 2, 3);
        grid.getChildren().add(scalingValue);

        stage.show();
    }
}
