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
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

/**
 * 除了文本，TextFlow 还可以添加其他的元素。
 *
 * @author JiaweiMao
 * @version 1.0.0
 * @since 14 Apr 2018, 2:28 PM
 */
public class TextFlowEx2 extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        Text tx1 = new Text("I,  ");

        RadioButton rb1 = new RadioButton("Mr.");
        RadioButton rb2 = new RadioButton("Ms.");
        rb1.setSelected(true);

        ToggleGroup group = new ToggleGroup();
        rb1.setToggleGroup(group);
        rb2.setToggleGroup(group);

        TextField nameFld = new TextField();
        nameFld.setPromptText("Your Name");

        Text tx2 = new Text(", acknowledge the receipt of this letter...\n\nSincerelym\n\n");

        Button submitFormBtn = new Button("Submit Form");

        // Create a TextFlow object with all nodes
        TextFlow root = new TextFlow(tx1, rb1, rb2, nameFld, tx2, submitFormBtn);

        root.setPrefWidth(350);
        root.setLineSpacing(5);
        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
