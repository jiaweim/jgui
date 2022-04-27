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

package jgui.javafx.stage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

import static javafx.stage.Modality.APPLICATION_MODAL;
import static javafx.stage.Modality.WINDOW_MODAL;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @date 2016.12.20, 7:45 PM
 */
public class StageModalityApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Buttons to display each kind of modal stage
        Button ownedNoneButton = new Button("Owned None");
        ownedNoneButton.setOnAction(event -> showDialog(primaryStage, Modality.NONE));

        Button nonOwnedNoneButton = new Button("Non-owned None");
        nonOwnedNoneButton.setOnAction(event -> showDialog(null, Modality.NONE));

        Button ownedWinButton = new Button("Owned Window Modal");
        ownedWinButton.setOnAction(e -> showDialog(primaryStage, WINDOW_MODAL));

        Button nonOwnedWinButton = new Button("Non-owned Window Modal");
        nonOwnedWinButton.setOnAction(e -> showDialog(null, WINDOW_MODAL));

        Button ownedAppButton = new Button("Owned Application Modal");
        ownedAppButton.setOnAction(e -> showDialog(primaryStage, APPLICATION_MODAL));

        Button nonOwnedAppButton = new Button("Non-owned Application Modal");
        nonOwnedAppButton.setOnAction(e -> showDialog(null, APPLICATION_MODAL));
        VBox root = new VBox();
        root.getChildren().addAll(ownedNoneButton, nonOwnedNoneButton,
                ownedWinButton, nonOwnedWinButton,
                ownedAppButton, nonOwnedAppButton);
        Scene scene = new Scene(root, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("The Primary Stage");
        primaryStage.show();
    }

    private void showDialog(Window owner, Modality modality) {
        // Create a Stage with specified owner and modality
        Stage stage = new Stage();
        stage.initOwner(owner);
        stage.initModality(modality);

        Label modalityLabel = new Label(modality.toString());
        Button closeButton = new Button("Close");
        closeButton.setOnAction(event -> stage.close());

        VBox root = new VBox();
        root.getChildren().addAll(modalityLabel, closeButton);
        Scene scene = new Scene(root, 200, 100);
        stage.setScene(scene);
        stage.setTitle("A Dialog Box");
        stage.show();
    }
}
