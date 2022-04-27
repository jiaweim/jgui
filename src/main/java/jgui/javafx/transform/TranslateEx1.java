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
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

/**
 * 三个矩形，默认都在 (0,0) 位置，对2,3两个矩形实现平移。
 *
 * @author JiaweiMao
 * @version 1.0.0
 * @since 25 Dec 2017, 9:34 AM
 */
public class TranslateEx1 extends Application
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

        Rectangle rect2 = new Rectangle(100, 50, Color.YELLOW);
        rect2.setStroke(Color.BLACK);

        Rectangle rect3 = new Rectangle(100, 50, Color.STEELBLUE);
        rect3.setStroke(Color.BLACK);

        // Apply a translation on rect2 using the transforms sequence
        Translate translate1 = new Translate(50, 10);
        rect2.getTransforms().addAll(translate1);

        // Apply a translation on rect3 using the translateX and translateY proeprties
        rect3.setTranslateX(180);
        rect3.setTranslateY(20);

        Pane root = new Pane(rect1, rect2, rect3);
        root.setPrefSize(300, 80);

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Applying the Translation Transformation");
        primaryStage.show();
    }
}
