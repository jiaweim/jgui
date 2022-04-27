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
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * 设置快键键的方式。
 *
 * @author JiaweiMao
 * @version 1.0.0
 * @since 22 Dec 2017, 11:03 PM
 */
public class MnemonicEx1 extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        // 按钮，快捷键 Alt+B
        Button btn = new Button("_Button");
        btn.setOnAction((ActionEvent event) -> System.out.println("Button fired"));

        HBox root = new HBox();
        root.setPadding(new Insets(20));
        root.getChildren().add(btn);

        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Mnemonic");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
