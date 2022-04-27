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
import javafx.beans.value.ObservableValue;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ScrollBar;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since Oct 30, 2018, 7:53:06 PM
 */
public class ScrollBarEx1 extends Application {

	final ScrollBar sb = new ScrollBar();
	final Image[] images = new Image[5];
	final ImageView[] pics = new ImageView[5];
	final VBox vb = new VBox();

	DropShadow shadow = new DropShadow();

	@Override
	public void start(Stage stage) {
		Group root = new Group();
		Scene scene = new Scene(root, 180, 180);
		scene.setFill(Color.BLACK);
		stage.setScene(scene);
		stage.setTitle("Scrollbar");
		root.getChildren().addAll(vb, sb);

		shadow.setColor(Color.GREY);
		shadow.setOffsetX(2);
		shadow.setOffsetY(2);

		vb.setLayoutX(5);
		vb.setSpacing(10);

		sb.setLayoutX(scene.getWidth() - sb.getWidth());
		sb.setMin(0);
		sb.setOrientation(Orientation.VERTICAL);
		sb.setPrefHeight(180);
		sb.setMax(360);

		for (int i = 0; i < 5; i++) {
			images[i] = new Image(getClass().getClassLoader().getResourceAsStream("fw" + (i + 1) + ".jpg"));
			final ImageView pic = pics[i] = new ImageView(images[i]);
			pic.setEffect(shadow);
			vb.getChildren().add(pics[i]);
		}

		sb.valueProperty().addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> vb
				.setLayoutY(-new_val.doubleValue()));

		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
