/*
 * MIT License
 * Copyright (c) 2018 JiaweiMao
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package jgui.javafx.controls;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since Nov 1, 2018, 1:14:56 PM
 */
public class TooltipEx1 extends Application {

	@Override
	public void start(Stage stage) {
		Label nameLbl = new Label("Name:");
		TextField nameFld = new TextField();
		Button saveBtn = new Button("Save");
		Button closeBtn = new Button("Close");
		// Set an ActionEvent handler
		closeBtn.setOnAction(e -> stage.close());
		// Add tooltips for Name field and Save button
		nameFld.setTooltip(new Tooltip("Enter your name\n(Max. 10 chars)"));
		saveBtn.setTooltip(new Tooltip("Saves the data"));

		// Create and configure the Tooltip for Close button
		Tooltip closeBtnTip = new Tooltip("Closes the window");
		closeBtnTip.setStyle("-fx-background-color: yellow; " + " -fx-text-fill: black;");
		// Display the icon above the text
		closeBtnTip.setContentDisplay(ContentDisplay.TOP);
		Label closeTipIcon = new Label("X");
		closeTipIcon.setStyle("-fx-text-fill: red;");
		closeBtnTip.setGraphic(closeTipIcon);
		// Set its Tooltip for Close button
		closeBtn.setTooltip(closeBtnTip);
		HBox root = new HBox(nameLbl, nameFld, saveBtn, closeBtn);
		root.setSpacing(10);
		root.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
				+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: blue;");
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Using Tooltip Controls");
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
