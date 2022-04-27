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
 * @since 22 Dec 2017, 9:49 PM
 */
public class BoundsInLocalTest extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        Button button = new Button("Close");
        button.setEffect(new DropShadow());

        VBox root = new VBox();
        root.getChildren().addAll(button);

        Scene scene = new Scene(root);

        primaryStage.setTitle("BoundsInLocal Test");
        primaryStage.setScene(scene);
        primaryStage.show();

        System.out.println("layoutBounds " + button.getLayoutBounds());
        System.out.println("boundInLocal " + button.getBoundsInLocal());
    }
}
