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

package jgui.javafx.shape;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 21 Dec 2017, 2:15 PM
 */
public class ShapeEx1 extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {

        // Sine wave
        CubicCurve cubicCurve = new CubicCurve(
                50, // start x
                75, // start y
                80, // control x1
                -25, // control y1
                110, // control x2
                175, // control y2
                140, // end x
                75 // end y
        );

        cubicCurve.setStrokeType(StrokeType.CENTERED);
        cubicCurve.setStroke(Color.BLACK);
        cubicCurve.setStrokeWidth(3);
        cubicCurve.setFill(Color.WHITE);


        // Ice cream cone
        Path path = new Path();
        path.setStrokeWidth(3);

        // Create top part beginning on the left
        MoveTo moveTo = new MoveTo();
        moveTo.setX(50);
        moveTo.setY(50);

        // curve ice cream
        QuadCurveTo quadCurveTo = new QuadCurveTo();
        quadCurveTo.setX(150);
        quadCurveTo.setY(150);
        quadCurveTo.setControlX(100);
        quadCurveTo.setControlX(50);

        // cone rim
        LineTo lineTo1 = new LineTo();
        lineTo1.setX(50);
        lineTo1.setY(150);

        // left side of cone
        LineTo lineTo2 = new LineTo();
        lineTo2.setX(100);
        lineTo2.setY(275);

        // right side of cone
        LineTo lineTo3 = new LineTo();
        lineTo3.setX(150);
        lineTo3.setY(150);

        path.getElements().addAll(moveTo, quadCurveTo, lineTo1, lineTo2, lineTo3);
        path.setTranslateY(30);

        // A smile
        QuadCurve quad = new QuadCurve(
                50, // start x point
                50, // start y point
                125,// control x point
                150,// control y point
                150,// end x point
                50);// end y point
        quad.setTranslateY(path.getBoundsInParent().getMaxY());
        quad.setStrokeWidth(3);
        quad.setStroke(Color.BLACK);
        quad.setFill(Color.WHITE);

        // outer donut
        Ellipse bigCircle = new Ellipse(
                100, // center x
                100, // center y
                50, // radius x
                75/2); // radius y
        bigCircle.setStrokeWidth(3);
        bigCircle.setStroke(Color.BLACK);
        bigCircle.setFill(Color.WHITE);

        // donut hole
        Ellipse smallCircle = new Ellipse(
                100, // center x
                100, // center y
                35/2, // radius x
                25/2); // radius y
// make a donut
        Shape donut = Path.subtract(bigCircle, smallCircle);
        donut.setStrokeWidth(1.8);
        donut.setStroke(Color.BLACK);
// orange glaze
        donut.setFill(Color.rgb(255, 200, 0));

        // add drop shadow
        DropShadow dropShadow = new DropShadow(
                5, // radius
                2.0f, // offset X
                2.0f, // offset Y
                Color.rgb(50, 50, 50, .588));
        donut.setEffect(dropShadow);
// move slightly down
        donut.setTranslateY(quad.getBoundsInParent().getMinY() + 30);

        HBox root = new HBox(cubicCurve, path, quad, donut);
        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Using Shapes");
        primaryStage.show();
    }
}
