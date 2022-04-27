/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 JiaweiMao
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software
 * and associated documentation files (the "Software"), to deal in the Software without
 * restriction, including without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package jgui.javafx.effect;

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 * GaussianBlur is a blur effect using a Gaussian convolution kernel with a configurable radius.
 *
 * This program applies a GaussianBlur effect on a Text control. The radius of the blur is controlled by a slider.
 *
 * @author JiaweiMao
 * @version 1.0.0
 * @date 2016.09.14, 2:39 PM
 */
public class GaussianBlurEx extends Application {

    @Override
    public void start(Stage stage) {

        initUI(stage);
    }

    private void initUI(Stage stage) {

        VBox root = new VBox(30);
        root.setPadding(new Insets(10));

        DoubleProperty radius = new SimpleDoubleProperty(0);

        // The blur effect will be applied on this text control
        Text blurredText = new Text("Inception");
        blurredText.setFont(Font.font(38));

        // The slider control managers the radius property of the GaussianBlur effect.
        Slider slider = new Slider(1, 20, 1);
        radius.bind(slider.valueProperty());

        slider.valueProperty().addListener(event -> {
            blurredText.setEffect(new GaussianBlur(radius.get()));
        });

        root.getChildren().addAll(slider, blurredText);

        Scene scene = new Scene(root, 300, 250, Color.WHITESMOKE);

        stage.setTitle("Blur effect");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
