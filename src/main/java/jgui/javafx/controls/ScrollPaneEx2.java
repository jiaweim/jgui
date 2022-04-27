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
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author JiaweiMao
 * @version 1.0.0
 * @since Oct 30, 2018, 8:40:57 PM
 */
public class ScrollPaneEx2 extends Application {

	final ScrollPane sp = new ScrollPane();
	final Image[] images = new Image[5];
	final ImageView[] pics = new ImageView[5];
	final VBox vb = new VBox();
	final Label fileName = new Label();
	final String[] imageNames = new String[] { "fw1.jpg", "fw2.jpg", "fw3.jpg", "fw4.jpg", "fw5.jpg" };

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {

		VBox box = new VBox();
		Scene scene = new Scene(box, 180, 180);
		stage.setScene(scene);
		stage.setTitle("ScrollPaneSample");
		box.getChildren().addAll(sp, fileName);
		VBox.setVgrow(sp, Priority.ALWAYS);

		fileName.setLayoutX(30);
		fileName.setLayoutY(160);

		Image roses = new Image(getClass().getClassLoader().getResourceAsStream("img/roses.jpg"));
		sp.setContent(new ImageView(roses));
		sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

		for (int i = 0; i < 5; i++) {
			images[i] = new Image(getClass().getClassLoader().getResourceAsStream("img/" + imageNames[i]));
			pics[i] = new ImageView(images[i]);
			pics[i].setFitWidth(100);
			pics[i].setPreserveRatio(true);
			vb.getChildren().add(pics[i]);
		}

		sp.setVmax(440);
		sp.setPrefSize(115, 150);
		sp.setContent(vb);
		sp.vvalueProperty().addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
			fileName.setText(imageNames[(new_val.intValue() - 1) / 100]);
		});
		stage.show();
	}

}
