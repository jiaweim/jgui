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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @date 2017.01.13, 9:22 AM
 */
public class NodeSizeSentinelValues extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Button okBtn = new Button("OK");
        Button calcleBtn = new Button("Cancel");
        calcleBtn.setPrefWidth(100);

        VBox root = new VBox();
        root.getChildren().addAll(okBtn, calcleBtn);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("sentinel value demo");
        primaryStage.show();

        System.out.println("ok prefWidth " + okBtn.getPrefWidth());
        System.out.println("ok minWidth " + okBtn.getMinWidth());
        System.out.println("ok maxWidth " + okBtn.getMaxWidth());

        System.out.println("cancel prefWidth " + +calcleBtn.getPrefWidth());
        System.out.println("cancel minWidth " + +calcleBtn.getMinWidth());
        System.out.println("cancel maxWidth " + +calcleBtn.getMaxWidth());
    }
}
