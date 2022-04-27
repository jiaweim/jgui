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
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 05 Dec 2017, 2:49 PM
 */
public class HelloJavaFX extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        // Create an empty triangle and add vertices later
        Polygon triangle1 = new Polygon();
        triangle1.getPoints().addAll(50.0, 0.0,
                0.0, 100.0,
                100.0, 100.0);
        // Create a triangle with vertices
        Polygon triangle2 = new Polygon(50.0, 0.0,
                0.0, 100.0,
                100.0, 100.0);
    }
}
