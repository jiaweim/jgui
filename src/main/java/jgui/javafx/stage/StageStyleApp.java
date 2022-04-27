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

package jgui.javafx.stage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import static javafx.stage.StageStyle.TRANSPARENT;
import static javafx.stage.StageStyle.UNIFIED;

public class StageStyleApp extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        // A label to display the style type
        Label styleLabel = new Label("Stage Style");

        // A button to close the stage
        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> stage.close());
        VBox root = new VBox();
        root.getChildren().addAll(styleLabel, closeButton);
        Scene scene = new Scene(root, 100, 70);
        stage.setScene(scene);

        // The title of the stage is not visible for all styles.
        stage.setTitle("The Style of a Stage");

        /* Uncomment one of the following statements at a time */
//        this.show(stage, styleLabel, DECORATED);
//        this.show(stage, styleLabel, UNDECORATED);
//        this.show(stage, styleLabel, TRANSPARENT);
        this.show(stage, styleLabel, UNIFIED);
        //this.show(stage, styleLabel, UTILITY);
    }

    private void show(Stage stage, Label styleLabel, StageStyle style) {
        // Set the text for the label to match the style
        styleLabel.setText(style.toString());

        // Set the style
        stage.initStyle(style);

        // For a transparent style, set the scene fill to null. Otherwise, the
        // content area will have the default white background of the scene.
        if (style == TRANSPARENT) {
            stage.getScene().setFill(null);
            stage.getScene().getRoot().setStyle("-fx-background-color: transparent");
        } else if (style == UNIFIED) {
            stage.getScene().setFill(Color.TRANSPARENT);
        }

        // Show the stage
        stage.show();
    }
}