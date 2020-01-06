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

package trail.jgui.javafx.controls;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 14 Jan 2018, 3:58 PM
 */
public class TabTest extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage stage)
    {
        ImageView privacyIcon = getImage("privacy_icon.png");
        GeneralTab generalTab = new GeneralTab("General", privacyIcon);
        ImageView addressIcon = getImage("address_icon.png");
        AddressTab addressTab = new AddressTab("Address", addressIcon);
        TabPane tabPane = new TabPane();
        tabPane.getTabs().addAll(generalTab, addressTab);
        BorderPane root = new BorderPane();
        root.setCenter(tabPane);
        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Using TabPane and Tab Controls");
        stage.show();
    }

    public ImageView getImage(String fileName)
    {
        ImageView imgView = null;
        try {
            String imagePath = "picture/" + fileName;
            Image img = new Image(imagePath);
            imgView = new ImageView(img);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return imgView;
    }
}
