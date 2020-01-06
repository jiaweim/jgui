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

package trail.jgui.javafx.controls;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @date 2017.01.13, 9:36 AM
 */
public class NodeSizes extends Application {


    @Override
    public void start(Stage stage) throws Exception {
        Button btn = new Button("Hello JavaFX!");
        HBox root = new HBox();
        root.getChildren().addAll(btn);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Sizes of a Node");
        stage.show();
// Print button's sizes
        System.out.println("Before changing button properties:");
        printSizes(btn);
// Change button's properties
        btn.setWrapText(true);
        btn.setPrefWidth(80);
        stage.sizeToScene();
// Print button's sizes
        System.out.println("\nAfter changing button properties:");
        printSizes(btn);
    }

    public void printSizes(Button btn) {
        System.out.println("btn.getContentBias() = " + btn.getContentBias());
        System.out.println("btn.getPrefWidth() = " + btn.getPrefWidth() + ", btn.getPrefHeight() = " + btn.getPrefHeight());
        System.out.println("btn.getMinWidth() = " + btn.getMinWidth() + ", btn.getMinHeight() = " + btn.getMinHeight());
        System.out.println("btn.getMaxWidth() = " + btn.getMaxWidth() + ", btn.getMaxHeight() = " + btn.getMaxHeight());

        double prefWidth = btn.prefWidth(-1);
        System.out.println("btn.prefWidth(-1) = " + prefWidth + ", btn.prefHeight(prefWidth) = " + btn.prefHeight(prefWidth));

        double minWidth = btn.minWidth(-1);
        System.out.println("btn.minWidth(-1) = " + minWidth + ", btn.minHeight(minWidth) = " + btn.minHeight(minWidth));

        double maxWidth = btn.maxWidth(-1);
        System.out.println("btn.maxWidth(-1) = " + maxWidth + ", btn.maxHeight(maxWidth) = " + btn.maxHeight(maxWidth));
        System.out.println("btn.getWidth() = " + btn.getWidth() + ", btn.getHeight() = " + btn.getHeight());
    }
}
