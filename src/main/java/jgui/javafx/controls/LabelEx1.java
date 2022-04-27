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
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 24 Dec 2017, 9:46 AM
 */
public class LabelEx1 extends Application
{
    String lyrics = "It's way too late to think of\n"
            + "Someone I would call now\n"
            + "And neon signs got tired\n"
            + "Red eye flights help the stars out\n"
            + "I'm safe in a corner\n"
            + "Just hours before me\n"
            + "\n"
            + "I'm waking with the roaches\n"
            + "The world has surrendered\n"
            + "I'm dating ancient ghosts\n"
            + "The ones I made friends with\n"
            + "The comfort of fireflies\n"
            + "Long gone before daylight\n"
            + "\n"
            + "And if I had one wishful field tonight\n"
            + "I'd ask for the sun to never rise\n"
            + "If God leant his voice for me to speak\n"
            + "I'd say go to bed, world\n"
            + "\n"
            + "I've always been too late\n"
            + "To see what's before me\n"
            + "And I know nothing sweeter than\n"
            + "Champaign from last New Years\n"
            + "Sweet music in my ears\n"
            + "And a night full of no fears\n"
            + "\n"
            + "But if I had one wishful field tonight\n"
            + "I'd ask for the sun to never rise\n"
            + "If God passed a mic to me to speak\n"
            + "I'd say stay in bed, world\n"
            + "Sleep in peace";

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        Label label = new Label(lyrics);

        HBox root = new HBox();
        root.setPadding(new Insets(10));
        root.getChildren().add(label);

        Scene scene = new Scene(root);
        primaryStage.setTitle("No sleep");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
