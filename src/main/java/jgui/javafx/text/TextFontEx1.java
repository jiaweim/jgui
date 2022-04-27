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
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * 第一个 Text 使用默认字体。
 *
 * @author JiaweiMao
 * @version 1.0.0
 * @since 25 Dec 2017, 3:15 PM
 */
public class TextFontEx1 extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage stage)
    {
        Text t1 = new Text();
        t1.setText(t1.getFont().toString());

        Text t2 = new Text();
        t2.setFont(Font.font("Arial", 12));
        t2.setText(t2.getFont().toString());

        Text t3 = new Text();
        t3.setFont(Font.font("Arial", FontWeight.BLACK, 12));
        t3.setText(t2.getFont().toString());

        Text t4 = new Text();
        t4.setFont(Font.font("Arial", FontWeight.THIN, FontPosture.ITALIC, 12));
        t4.setText(t2.getFont().toString());

        VBox root = new VBox(t1, t2, t3, t4);
        root.setSpacing(10);
        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Setting Fonts for Text Nodes");
        stage.show();

    }
}
