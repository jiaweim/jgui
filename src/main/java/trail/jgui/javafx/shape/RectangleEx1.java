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

package trail.jgui.javafx.shape;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 21 Dec 2017, 2:48 PM
 */
public class RectangleEx1 extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        // x=0, y=0, width=100, height=50, fill=LIGHTGRAY, stroke=null
        Rectangle rect1 = new Rectangle(100, 50, Color.LIGHTGRAY);

        // x=120, y=20, width=100, height=50, fill=WHITE, stroke=BLACK
        Rectangle rect2 = new Rectangle(120, 20, 100, 50);

        rect2.setFill(Color.WHITE);
        rect2.setStroke(Color.BLACK);
        rect2.setArcWidth(10);
        rect2.setArcHeight(10);

        Rectangle rect3 = new Rectangle();
        rect3.setX(240);
        rect3.setY(10);
        rect3.setWidth(100);
        rect3.setHeight(130);
        rect3.setArcWidth(10);
        rect3.setArcHeight(40);


        Pane root = new Pane();
        root.getChildren().addAll(rect1, rect2, rect3);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Using Rectangles");
        primaryStage.show();
    }
}
