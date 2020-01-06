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

package trail.jgui.javafx.layout;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 13 Apr 2018, 5:47 PM
 */
public class TextFlowEx1 extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        Text tx1 = new Text("TextFlow layout pane is cool!");
        tx1.setFill(Color.RED);
        tx1.setFont(Font.font("Arial", FontWeight.BOLD, 12));

        Text tx2 = new Text("It supports rich text display.");
        tx2.setFill(Color.BLUE);

        Text tx3 = new Text("\nThis is a new paragraph, which was created using the \\n newline character.");

        TextFlow root = new TextFlow(tx1, tx2, tx3);
        root.setPrefWidth(300);
        root.setLineSpacing(5);

        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");


        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Using TextFlow");
        primaryStage.show();

    }
}
