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

package jgui.javafx.text;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;

import java.util.Random;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 08 Apr 2018, 5:52 PM
 */
public class TextEx1 extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        primaryStage.setTitle("Graphics in JavaFX");
        Group root = new Group();

        Scene scene = new Scene(root, 650, 450, Color.WHITE);

        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < 500; i++) {
            Text text = new Text(random.nextInt((int) scene.getWidth()),
                    random.nextInt((int) scene.getHeight()), Character.valueOf((char) random.nextInt(255)).toString());

            text.setFont(Font.font("Serif", random.nextInt(30)));
            text.setFill(Color.rgb(random.nextInt(255),
                    random.nextInt(255),
                    random.nextInt(255),
                    0.5));
            root.getChildren().add(text);
        }

        Text text2 = new Text(60, scene.getHeight() / 2, "Graphics is Fun!");
        text2.setFont(Font.font("Serif", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 60));
        text2.setFill(Color.RED);
        text2.setFontSmoothingType(FontSmoothingType.LCD);

        DropShadow shadow = new DropShadow();
        shadow.setOffsetX(2.0f);
        shadow.setOffsetY(2.0);
        shadow.setColor(Color.BLACK);
        shadow.setRadius(7);

        text2.setEffect(shadow);
        text2.setStroke(Color.DARKRED);

        root.getChildren().add(text2);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
