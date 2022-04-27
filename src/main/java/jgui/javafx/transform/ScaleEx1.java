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
import javafx.stage.Stage;

/**
 * 创建两个矩形，在相同位置。
 * 第一个矩形透明度设置为 0.5，从而可以透视
 * 通过 scaleX 和 scaleY 属性对第二个矩形进行缩放。
 *
 * @author JiaweiMao
 * @version 1.0.0
 * @since 25 Dec 2017, 10:19 AM
 */
public class ScaleEx1 extends Application
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
        rect1.setOpacity(0.5);

        Rectangle rect2 = new Rectangle(100, 50, Color.LIGHTGRAY);
        rect2.setStroke(Color.BLACK);

        rect2.setScaleX(0.5);
        rect2.setScaleY(0.5);

        Pane root = new Pane(rect1, rect2);
        root.setPrefSize(150, 60);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Applying the Scale Transformation");
        primaryStage.show();
    }
}
