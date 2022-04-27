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
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 * 定义了三个多行的 Text 组件，文本内容相同。
 * 第一个， LEFT 对齐，行距 5px
 * 第二个，RIGHT对齐，默认行距 0px
 * 第三个，wrappingWidth 为 100px。
 *
 * @author JiaweiMao
 * @version 1.0.0
 * @since 25 Dec 2017, 2:51 PM
 */
public class AlignmentTextEx1 extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage stage)
    {
        String text = "Strange fits of passion have I known: \n" +
                "And I will dare to tell, \n" +
                "But in the lover's ear alone, \n" +
                "What once to me befell.";
        Text t1 = new Text(text);
        t1.setLineSpacing(5);

        Text t2 = new Text(text);
        t2.setTextAlignment(TextAlignment.RIGHT);

        Text t3 = new Text(text);
        t3.setWrappingWidth(100);

        HBox root = new HBox(t1, t2, t3);
        root.setSpacing(20);
        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Using Multiline Text Nodes");
        stage.show();
    }
}
