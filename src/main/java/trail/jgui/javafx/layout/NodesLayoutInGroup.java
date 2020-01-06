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

package trail.jgui.javafx.layout;

import javafx.application.Application;
import javafx.beans.binding.NumberBinding;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @date 2017.01.10, 9:14 PM
 */
public class NodesLayoutInGroup extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        // create two buttons
        Button okBtn = new Button("OK");
        Button cancelBtn = new Button("Cancel");

        // Set the location of the OK button, 绝对位置(10,10)
        okBtn.setLayoutX(10);
        okBtn.setLayoutY(10);

        // set the location of the Cancel button relative to the ok button
        NumberBinding layoutXBinding = okBtn.layoutXProperty().add(okBtn.widthProperty().add(10));
        cancelBtn.layoutXProperty().bind(layoutXBinding);
        cancelBtn.layoutYProperty().bind(okBtn.layoutYProperty());

        Group root = new Group();
        root.getChildren().addAll(okBtn, cancelBtn);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Positioning Nodes in a Group");
        primaryStage.show();
    }
}
