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

package trail.jgui.javafx.text;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * 创建三个 Text，设置不同的属性，添加到 HBox中。
 *
 * @author JiaweiMao
 * @version 1.0.0
 * @since 25 Dec 2017, 2:00 PM
 */
public class CreatTextEx1 extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        Text t1 = new Text("Hello Text Node!");

        Text t2 = new Text("Bold and Big");
        t2.setFont(Font.font("Tahoma", FontWeight.BOLD, 16));

        Text t3 = new Text("Reflection");
        t3.setEffect(new Reflection());
        t3.setStroke(Color.BLACK);
        t3.setFill(Color.WHITE);
        t3.setFont(Font.font("Arial", FontWeight.BOLD, 20));

        HBox root = new HBox(t1, t2, t3);
        root.setSpacing(20);
        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Using Text Nodes");
        primaryStage.show();
    }
}
