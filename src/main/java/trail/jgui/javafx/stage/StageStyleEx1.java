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

package trail.jgui.javafx.stage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import static javafx.stage.StageStyle.*;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 01 Jan 2018, 1:11 PM
 */
public class StageStyleEx1 extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        // A label to display the style type
        Label styleLabel = new Label("Stage Style");

        // A button to close the stage
        Button closeBtn = new Button("Close");
        closeBtn.setOnAction(e -> primaryStage.close());

        VBox root = new VBox();
        root.getChildren().addAll(styleLabel, closeBtn);

        Scene scene = new Scene(root, 100, 70);
        primaryStage.setScene(scene);

        // The title of the stage is not visible for all styles.
        primaryStage.setTitle("The Style of a Stage");

        // Uncomment of the following statements at a time
        show(primaryStage, styleLabel, DECORATED);
    }

    private void show(Stage stage, Label styleLabel, StageStyle style)
    {
        // Set the text for the label to match the style
        styleLabel.setText(style.toString());

        // Set the style
        stage.initStyle(style);
        // For a transparent style, set the scene fill to null. Otherwise, the
        // content area will have the default white background of the scene.
        if (style == TRANSPARENT) {
            stage.getScene().setFill(null);
            stage.getScene().getRoot().setStyle(
                    "-fx-background-color: transparent");
        } else if (style == UNIFIED) {
            stage.getScene().setFill(Color.TRANSPARENT);
        }

        // Show the stage
        stage.show();
    }
}
