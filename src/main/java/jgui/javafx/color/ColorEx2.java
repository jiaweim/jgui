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
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.*;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 05 Apr 2018, 6:20 PM
 */
public class ColorEx2 extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        primaryStage.setTitle("Painting Colors");
        Group root = new Group();

        Scene scene = new Scene(root, 350, 300, Color.WHITE);
        // Red ellipse with radial gradient color
        Ellipse ellipse = new Ellipse(100, // center X
                50 + 70 / 2, // center Y
                50, // radius X
                70 / 2); // radius Y
        RadialGradient gradient1 = new RadialGradient(
                0, // focusAngle
                .1, // focusDistance
                80, // centerX
                45, // centerY
                120, // radius
                false, // proportional
                CycleMethod.NO_CYCLE, // cycleMethod
                new Stop(0, Color.RED), // stops
                new Stop(1, Color.BLACK)
        );
        ellipse.setFill(gradient1);
        root.getChildren().add(ellipse);
        double ellipseHeight = ellipse.getBoundsInParent().getHeight();

        // thick black line behind second shape
        Line blackLine = new Line();
        blackLine.setStartX(170);
        blackLine.setStartY(30);
        blackLine.setEndX(20);
        blackLine.setEndY(140);
        blackLine.setFill(Color.BLACK);
        blackLine.setStrokeWidth(10.0f);
        blackLine.setTranslateY(ellipseHeight + 10);
        root.getChildren().add(blackLine);

        // A rectangle filled with a linear gradient with a translucent color.
        Rectangle rectangle = new Rectangle();
        rectangle.setX(50);
        rectangle.setY(50);
        rectangle.setWidth(100);
        rectangle.setHeight(70);
        rectangle.setTranslateY(ellipseHeight + 10);

        LinearGradient linearGrad = new LinearGradient(
                0, // start X
                0, // start Y
                0, // end X
                1, // end Y
                true, // proportional
                CycleMethod.NO_CYCLE, // cycle colors stops
                new Stop(0.1f, Color.rgb(255, 200, 0, .784)),
                new Stop(1.0f, Color.rgb(0, 0, 0, .784)));
        rectangle.setFill(linearGrad);
        root.getChildren().add(rectangle);

        // A rectangle filled with a linear gradient with a reflective cycle.
        Rectangle roundRect = new Rectangle();
        roundRect.setX(50);
        roundRect.setY(50);
        roundRect.setWidth(100);
        roundRect.setHeight(70);
        roundRect.setArcWidth(20);
        roundRect.setArcHeight(20);
        roundRect.setTranslateY(ellipseHeight + 10 +
                rectangle.getHeight() + 10);
        LinearGradient cycleGrad = new LinearGradient(
                50, // start X
                50, // start Y
                70, // end X
                70, // end Y
                false, // proportional
                CycleMethod.REFLECT, // cycleMethod
                new Stop(0f, Color.rgb(0, 255, 0, .784)),
                new Stop(1.0f, Color.rgb(0, 0, 0, .784))
        );
        roundRect.setFill(cycleGrad);
        root.getChildren().add(roundRect);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
