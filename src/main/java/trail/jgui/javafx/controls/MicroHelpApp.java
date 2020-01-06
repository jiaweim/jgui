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
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MicroHelpApp extends Application {
    // An instance variable to store the Text node reference
    private Text helpText = new Text();

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        TextField fName = new TextField();
        TextField lName = new TextField();
        TextField salary = new TextField();

        Button closeBtn = new Button("Close");
        closeBtn.setOnAction(e -> Platform.exit());

        fName.getProperties().put("microHelpText", "Enter the first name");
        lName.getProperties().put("microHelpText", "Enter the last name");
        salary.getProperties().put("microHelpText", "Enter a salary greater than $2000.00.");

        // The help text node is unmanaged
        helpText.setManaged(false);
        helpText.setTextOrigin(VPos.TOP);
        helpText.setFill(Color.RED);
        helpText.setFont(Font.font(null, 9));
        helpText.setMouseTransparent(true);

        // Add all nodes to a GridPane
        GridPane root = new GridPane();
        root.add(new Label("First Name:"), 1, 1);
        root.add(fName, 2, 1);
        root.add(new Label("Last Name:"), 1, 2);
        root.add(lName, 2, 2);
        root.add(new Label("Salary:"), 1, 3);
        root.add(salary, 2, 3);
        root.add(closeBtn, 3, 3);
        root.add(helpText, 4, 3);
        Scene scene = new Scene(root, 300, 100);

        // Add a change listener to the scene, so you know when the focus owner
        // changes and display the micro help
        scene.focusOwnerProperty().addListener(
                (ObservableValue<? extends Node> value, Node oldNode, Node newNode)
                        -> focusChanged(value, oldNode, newNode));
        stage.setScene(scene);
        stage.setTitle("Showing Micro Help");
        stage.show();
    }

    public void focusChanged(ObservableValue<? extends Node> value, Node oldNode, Node newNode) {
// Focus has changed to a new node
        String microHelpText = (String) newNode.getProperties().get("microHelpText");
        if (microHelpText != null && microHelpText.trim().length() > 0) {
            helpText.setText(microHelpText);
            helpText.setVisible(true);
// Position the help text node
            double x = newNode.getLayoutX() +
                    newNode.getLayoutBounds().getMinX() -
                    helpText.getLayoutBounds().getMinX();
            double y = newNode.getLayoutY() +
                    newNode.getLayoutBounds().getMinY() +
                    newNode.getLayoutBounds().getHeight() -
                    helpText.getLayoutBounds().getMinX();
            helpText.setLayoutX(x);
            helpText.setLayoutY(y);
            helpText.setWrappingWidth(newNode.getLayoutBounds().getWidth());
        } else {
            helpText.setVisible(false);
        }
    }
}