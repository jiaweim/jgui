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

package trail.jgui.javafx.css;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 23 Dec 2017, 3:05 PM
 */
public class StylingTextEx1 extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        Text text = new Text("Hello Proteomics");
        text.setFont(Font.font("Serif", FontWeight.BOLD, 76));
        text.setId("text");

        HBox root = new HBox();
        root.setPadding(new Insets(20));
        root.setId("root");
        root.getChildren().add(text);

        Scene scene = new Scene(root);
        scene.getStylesheets().add(this.getClass().getResource("text.css").toExternalForm());

        primaryStage.setTitle("Styling text");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
