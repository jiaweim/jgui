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

package jgui.javafx;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * http://stackoverflow.com/questions/11886230/how-to-draw-a-crisp-opaque-hairline-in-javafx-2-2
 */
public class LineWidths extends Application
{
    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage stage)
    {
        Line fuzzyline = new Line(5, 50, 90, 50);
        fuzzyline.setStroke(Color.BLACK);
        fuzzyline.setStrokeWidth(1);

        Line hairline = new Line(4.5, 99.5, 89.5, 99.5);
        hairline.setStroke(Color.BLACK);
        hairline.setStrokeWidth(1);

        Line fatline = new Line(5, 150, 90, 150);
        fatline.setStroke(Color.BLACK);
        fatline.setStrokeWidth(1);
        fatline.setStrokeType(StrokeType.OUTSIDE);

        Line insideline = new Line(5, 25, 90, 25);
        insideline.setStroke(Color.BLACK);
        insideline.setStrokeWidth(1);

        Pane snappedPane = new Pane();
        snappedPane.setSnapToPixel(true);
        snappedPane.getChildren().add(insideline);
        snappedPane.setPrefSize(100, 50);
        snappedPane.relocate(-0.5, 174.5);

        stage.setScene(
                new Scene(
                        new Group(
                                fuzzyline, hairline, fatline, snappedPane,
                                new Text(10, 40, "fuzzyline"),
                                new Text(10, 90, "hairline"),
                                new Text(10, 140, "fatline"),
                                new Text(10, 190, "snappedPane")
                        ), 100, 250
                )
        );
        stage.show();
    }
}