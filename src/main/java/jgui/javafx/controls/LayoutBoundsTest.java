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

package jgui.javafx.controls;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 22 Dec 2017, 9:41 PM
 */
public class LayoutBoundsTest extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        Button b1 = new Button("Close");
        b1.setEffect(new DropShadow());

        Button b2 = new Button("Close");

        Button b3 = new Button("Close");
        b3.setEffect(new DropShadow());
        b3.setRotate(30);

        Button b4 = new Button("Close");

        VBox root = new VBox();
        root.getChildren().addAll(b1, b2, b3, b4);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Testing LayoutBounds");
        primaryStage.show();

        System.out.println("b1 " + b1.getLayoutBounds());
        System.out.println("b2 " + b2.getLayoutBounds());
        System.out.println("b3 " + b3.getLayoutBounds());
    }
}
