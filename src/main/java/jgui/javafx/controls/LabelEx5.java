/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 JiaweiMao
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software
 * and associated documentation files (the "Software"), to deal in the Software without
 * restriction, including without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package jgui.javafx.controls;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class LabelEx5 extends Application
{

    Label label3 = new Label("A label that needs to be wrapped");

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage stage)
    {
        Scene scene = new Scene(new Group());
        stage.setTitle("Label Sample");
        stage.setWidth(420);
        stage.setHeight(180);

        HBox hbox = new HBox();
        Image image = new Image(getClass().getClassLoader().getResourceAsStream("graphics/labels.jpg"));

        Label label1 = new Label("Search");
        label1.setGraphic(new ImageView(image));
        label1.setFont(new Font("Arial", 30));
        label1.setTextFill(Color.web("#0076a3"));
        label1.setTextAlignment(TextAlignment.JUSTIFY);

        Label label2 = new Label("Values");
        label2.setFont(Font.font("Cambria", 32));
        label2.setRotate(270);
        label2.setTranslateY(50);

        label3.setWrapText(true);
        label3.setTranslateY(50);
        label3.setPrefWidth(100);

        label3.setOnMouseEntered((MouseEvent e) -> {
            label3.setScaleX(1.5);
            label3.setScaleY(1.5);
        });

        label3.setOnMouseExited((MouseEvent e) -> {
            label3.setScaleX(1);
            label3.setScaleY(1);
        });

        hbox.setSpacing(10);
        hbox.getChildren().add((label1));
        hbox.getChildren().add(label2);
        hbox.getChildren().add(label3);
        ((Group) scene.getRoot()).getChildren().add(hbox);

        stage.setScene(scene);
        stage.show();
    }
}

