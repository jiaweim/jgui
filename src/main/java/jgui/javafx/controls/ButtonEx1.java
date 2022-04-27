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
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Button 放在窗口左上角，添加了一个事件处理。
 *
 * @author JiaweiMao
 * @version 1.0.0
 * @since 22 Dec 2017, 10:53 PM
 */
public class ButtonEx1 extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        Button button = new Button();
        button.setText("Quit");// 设置按钮标签

        button.setOnAction((ActionEvent event) -> Platform.exit()); // 设置按钮响应事件

        HBox root = new HBox(); // HBox 单行显示
        root.setPadding(new Insets(25)); // 节点周围填充，默认填充为 Insets.EMPTY。设置后，组件和边界之间有一定距离
        root.getChildren().add(button); // 将按钮添加到 HBox

        Scene scene = new Scene(root, 280, 200);

        primaryStage.setTitle("Quit button");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
