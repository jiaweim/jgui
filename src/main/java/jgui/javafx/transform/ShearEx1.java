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

package jgui.javafx.transform;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Shear;
import javafx.stage.Stage;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 25 Dec 2017, 10:40 AM
 */
public class ShearEx1 extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        Rectangle rect1 = new Rectangle(100, 50, Color.LIGHTGRAY);
        rect1.setStroke(Color.BLACK);

        Rectangle rect2 = new Rectangle(100, 50, Color.BLACK);
        rect2.setStroke(Color.BLACK);
        rect2.setOpacity(0.5);

        // Apply a shear on rect2. The x and y multipliers are 0.5 and (0,0) is the pivot point.
        Shear shear = new Shear(0.5, 0.5);
        rect2.getTransforms().add(shear);

        Group root = new Group(rect1, rect2);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Applying the Shear Transformation");
        primaryStage.show();
    }
}
