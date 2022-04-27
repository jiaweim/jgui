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
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 25 Dec 2017, 2:36 PM
 */
public class CenterTextEx1 extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage stage)
    {
        Text msg = new Text("A Centered Text Node");

        // Must set the textOrigian to VPos.TOP to center
        // the text node vertcially within the scene
        msg.setTextOrigin(VPos.TOP);
        Group root = new Group();
        root.getChildren().addAll(msg);
        Scene scene = new Scene(root, 200, 50);
        msg.layoutXProperty().bind(scene.widthProperty().subtract(
                msg.layoutBoundsProperty().get().getWidth()).divide(2));
        msg.layoutYProperty().bind(scene.heightProperty().subtract(
                msg.layoutBoundsProperty().get().getHeight()).divide(2));
        stage.setTitle("Centering a Text Node in a Scene");
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }
}
