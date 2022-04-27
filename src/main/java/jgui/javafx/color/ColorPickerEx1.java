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

package jgui.javafx.color;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ToolBar;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;
import javafx.stage.Stage;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 04 Apr 2018, 4:53 PM
 */
public class ColorPickerEx1 extends Application
{

    ImageView logo = new ImageView(new Image(getClass().getClassLoader().getResourceAsStream("OracleLogo.png")));

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        primaryStage.setTitle("ColorPickerSample");

        Scene scene = new Scene(new VBox(20), 300, 300);
        //scene.getStylesheets().add("colorpickersample/ControlStyle.css");
        scene.setFill(Color.web("#ccffcc"));
        VBox box = (VBox) scene.getRoot();

        ToolBar tb = new ToolBar();
        box.getChildren().add(tb);

        final ComboBox logoSamples = new ComboBox();
        logoSamples.setPromptText("Logo");
        logoSamples.setValue("Oracle");
        logoSamples.getItems().addAll(
                "Oracle",
                "Java",
                "JavaFX",
                "Cup");

        logoSamples.valueProperty().addListener(new ChangeListener<String>()
        {
            @Override
            public void changed(ObservableValue ov, String t, String t1)
            {
                logo.setImage(new Image(getClass().getClassLoader().getResourceAsStream(t1 + "Logo.png")));
            }
        });


        final ColorPicker colorPicker = new ColorPicker();
        colorPicker.setValue(Color.CORAL);
        tb.getItems().addAll(logoSamples, colorPicker);

        StackPane stack = new StackPane();
        box.getChildren().add(stack);

        final SVGPath svg = new SVGPath();
        svg.setContent("M70,50 L90,50 L120,90 L150,50 L170,50"
                + "L210,90 L180,120 L170,110 L170,200 L70,200 L70,110 L60,120 L30,90"
                + "L70,50");
        svg.setStroke(Color.DARKGREY);
        svg.setStrokeWidth(2);
        svg.setEffect(new DropShadow());
        svg.setFill(colorPicker.getValue());
        stack.getChildren().addAll(svg, logo);

        colorPicker.setOnAction((ActionEvent t) -> {
            svg.setFill(colorPicker.getValue());
        });

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
