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
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 04 Apr 2018, 6:32 PM
 */
public class HyperlinkEx1 extends Application
{

    final static String[] imageFiles = new String[]{
            "product.png",
            "education.png",
            "partners.png",
            "support.png"
    };
    final static String[] captions = new String[]{
            "Products",
            "Education",
            "Partners",
            "Support"
    };
    final ImageView selectedImage = new ImageView();
    final ScrollPane list = new ScrollPane();
    final Hyperlink[] hpls = new Hyperlink[captions.length];
    final Image[] images = new Image[imageFiles.length];

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage stage)
    {
        Scene scene = new Scene(new Group());
        stage.setTitle("Hyperlink Sample");
        stage.setWidth(300);
        stage.setHeight(200);

        selectedImage.setLayoutX(100);
        selectedImage.setLayoutY(10);

        for (int i = 0; i < captions.length; i++) {
            final Hyperlink hpl = hpls[i] = new Hyperlink(captions[i]);
            final Image image = images[i] =
                    new Image(getClass().getClassLoader().getResourceAsStream(imageFiles[i]));
            hpl.setOnAction((ActionEvent e) -> {
                selectedImage.setImage(image);
            });
        }

        final Button button = new Button("Refresh links");
        button.setOnAction((ActionEvent e) -> {
            for (int i = 0; i < captions.length; i++) {
                hpls[i].setVisited(false);
                selectedImage.setImage(null);
            }
        });

        VBox vbox = new VBox();
        vbox.getChildren().addAll(hpls);
        vbox.getChildren().add(button);
        vbox.setSpacing(5);

        ((Group) scene.getRoot()).getChildren().addAll(vbox, selectedImage);
        stage.setScene(scene);
        stage.show();
    }
}
