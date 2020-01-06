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
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * 创建了两个Text:
 * 第一个，red stroke and a white fill
 * 第二个，black stroke and white fill.
 *
 * @author JiaweiMao
 * @version 1.0.0
 * @since 25 Dec 2017, 4:01 PM
 */
public class TextFillAndStrokeEx1 extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage stage)
    {
        Text t1 = new Text("Stroke and fill!");
        t1.setStroke(Color.RED);
        t1.setFill(Color.WHITE);
        t1.setFont(new Font(36));

        Text t2 = new Text("Dashed Stroke!");
        t2.setStroke(Color.BLACK);
        t2.setFill(Color.WHITE);
        t2.setFont(new Font(36));
        t2.getStrokeDashArray().addAll(5.0, 5.0);

        HBox root = new HBox(t1, t2);
        root.setSpacing(20);
        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Using Stroke and Fill for Text Nodes");
        stage.show();
    }
}
