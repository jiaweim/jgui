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
package trail.jgui.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since Nov 1, 2018, 9:46:41 AM
 */
public class DraggingStage extends Application {

	private Stage stage;
	private double dragOffsetX;
	private double dragoffsetY;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		this.stage = stage;
		Label msgLabel = new Label("Press the mouse button and drag.");
		Button closeButton = new Button("Close");
		closeButton.setOnAction(e -> stage.close());

		VBox root = new VBox();
		root.getChildren().addAll(msgLabel, closeButton);

		Scene scene = new Scene(root, 300, 200);

		scene.setOnMousePressed(this::handleMousePressed);
		scene.setOnMouseDragged(this::handleMouseDragged);

		stage.setScene(scene);
		stage.setTitle("Moving a Stage");
		stage.initStyle(StageStyle.UNDECORATED);
		stage.show();
	}

	protected void handleMousePressed(MouseEvent e) {
		this.dragOffsetX = e.getSceneX() - stage.getX();
		this.dragoffsetY = e.getSceneY() - stage.getY();
	}

	protected void handleMouseDragged(MouseEvent e) {
		stage.setX(e.getSceneX() - this.dragOffsetX);
		stage.setY(e.getSceneY() - this.dragoffsetY);
	}
}
