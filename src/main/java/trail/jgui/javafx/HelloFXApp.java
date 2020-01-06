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

package trail.jgui.javafx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @author JiaweiMao
 * @version 1.0.0
 */
public class HelloFXApp extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        // Create the root node
        VBox root = new VBox();
        // set the vertical spacing between children to 5 px
        root.setSpacing(5);

        Label nameLbl = new Label("Enter your name:");
        TextField nameFld = new TextField();

        Label messg = new Label();
        messg.setStyle("-fx-text-fill:blue;");

        Button sayHelloBtn = new Button("Say Hello");

        sayHelloBtn.setOnMouseEntered(event -> {
            String name = nameFld.getText();
            if (!name.trim().isEmpty()) {
                messg.setText("Hello " + name);
            } else {
                messg.setText("Hello there");
            }
        });

        // Create a button with "Exit" text
        Button exitBtn = new Button("Exit");
        exitBtn.setOnAction(event -> Platform.exit());

        root.getChildren().addAll(nameLbl, nameFld, messg, sayHelloBtn, exitBtn);

        Scene scene = new Scene(root, 400, 300);

        primaryStage.setScene(scene);
        // Set a title for the state
        primaryStage.setTitle("Hello JavaFX Application with a Scene");

        // show the stage
        primaryStage.show();
    }


    public static void main(String[] args)
    {
        launch(args);
    }
}
