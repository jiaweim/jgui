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
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * setText(String text) - specifies the text caption for the label
 * setGraphic(Node graphic) - specifies the graphical icon
 * setTextFill - specifies the color to paint the text element of the label.
 * setGraphicTextGap() - set the gap between text and graphical content.
 * setTextAlignment - vary the position of the label content within its layout area
 * setContentDisplay - define the position of the graphic relative to the text
 *
 * @author JiaweiMao
 * @version 1.0.0
 * @date 2016.12.16, 10:16 PM
 */
public class LabelEx4 extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override public void start(Stage primaryStage) throws Exception {

        Image image = new Image(getClass().getClassLoader().getResourceAsStream("graphics/labels.jpg"));

        HBox root = new HBox();
        root.setSpacing(10);

        // An empty label
        Label label1 = new Label();
        // A label with the text element
        Label label2 = new Label("Search");
        label2.setGraphic(new ImageView(image));
        label2.setFont(new Font("Arial", 30));
        label2.setTextFill(Color.web("#0076a3"));
//        label2.setTextAlignment(TextAlignment.JUSTIFY);

        Label label4 = new Label("A label that needs to be wrapped");
        label4.setWrapText(true);
//        label4.setRotate(270);
        label4.setTranslateY(50);
        label4.setContentDisplay(ContentDisplay.BOTTOM);
        label4.setTextFill(Color.web("#0076a3"));
        label4.setFont(Font.font("Cambria", 32));
        label4.setPrefWidth(100);
        label4.setOnMouseEntered(event -> {
            label4.setScaleX(1.5);
            label4.setScaleY(1.5);
        });
        label4.setOnMouseExited(event -> {
            label4.setScaleX(1);
            label4.setScaleY(1);
        });


        root.getChildren().addAll(label1, label2, label4);

        Scene scene = new Scene(root, 600, 400);
        primaryStage.setTitle("Label Example");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
