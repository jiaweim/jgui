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
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @date 2016.12.17, 11:07 AM
 */
public class ButtonEx extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        FlowPane root = new FlowPane();

        //A button with an empty text caption.
        Button button1 = new Button();
        // A button with the specified text caption.
        Button button2 = new Button("Accpet");
        // A button with the specified text caption and icon
        Image imageOk = new Image(getClass().getClassLoader().getResourceAsStream("ok.jpg"));
        Button button3 = new Button("Accept", new ImageView(imageOk));
        // Adding the shadow when the mouse cursor is on
        button3.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> button3.setEffect(new DropShadow()));

        // removing the shadow when the mouse cursor is off
        button3.addEventHandler(MouseEvent.MOUSE_EXITED, event -> {
            button3.setEffect(null);
        });

        root.getChildren().addAll(button1, button2, button3);


        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.setHeight(400);
        primaryStage.setWidth(600);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
