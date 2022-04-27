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
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 04 Apr 2018, 6:37 PM
 */
public class HyperlinkWebviewEx1 extends Application
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

    final static String[] urls = new String[]{
            "http://www.oracle.com/us/products/index.html",
            "http://education.oracle.com/",
            "http://www.oracle.com/partners/index.html",
            "http://www.oracle.com/us/support/index.html"
    };

    final ImageView selectedImage = new ImageView();
    final Hyperlink[] hpls = new Hyperlink[captions.length];
    final Image[] images = new Image[imageFiles.length];

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage stage)
    {
        VBox vbox = new VBox();
        Scene scene = new Scene(vbox);
        stage.setTitle("Hyperlink Sample");
        stage.setWidth(570);
        stage.setHeight(550);

        selectedImage.setLayoutX(100);
        selectedImage.setLayoutY(10);

        final WebView browser = new WebView();
        final WebEngine webEngine = browser.getEngine();

        for (int i = 0; i < captions.length; i++) {
            final Hyperlink hpl = hpls[i] = new Hyperlink(captions[i]);
            final Image image = images[i] =
                    new Image(getClass().getClassLoader().getResourceAsStream(imageFiles[i]));
            hpl.setGraphic(new ImageView (image));
            hpl.setFont(Font.font("Arial", 14));
            final String url = urls[i];

            hpl.setOnAction((ActionEvent e) -> {
                webEngine.load(url);
            });
        }

        HBox hbox = new HBox();
        hbox.setAlignment(Pos.BASELINE_CENTER);
        hbox.getChildren().addAll(hpls);
        vbox.getChildren().addAll(hbox, browser);
        VBox.setVgrow(browser, Priority.ALWAYS);

        stage.setScene(scene);
        stage.show();
    }
}
