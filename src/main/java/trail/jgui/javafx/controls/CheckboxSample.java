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
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class CheckboxSample extends Application {

    Rectangle rect = new Rectangle(90, 30);
    final String[] names = new String[]{"Security", "Project", "Chart"};
    final Image[] images = new Image[names.length];
    final ImageView[] icons = new ImageView[names.length];
    final CheckBox[] cbs = new CheckBox[names.length];

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Checkbox Sample");
        stage.setWidth(250);
        stage.setHeight(150);

        rect.setArcHeight(10);
        rect.setArcWidth(10);
        rect.setFill(Color.rgb(41, 41, 41));

        for (int i = 0; i < names.length; i++) {
            final Image image = images[i] =
                    new Image(getClass().getClassLoader().getResourceAsStream("graphics/"+names[i] + ".png"));
            final ImageView icon = icons[i] = new ImageView();
            final CheckBox cb = cbs[i] = new CheckBox(names[i]);
            cb.selectedProperty().addListener(
                    (ObservableValue<? extends Boolean> ov,
                            Boolean old_val, Boolean new_val) -> icon.setImage(new_val ? image : null));
        }

        VBox vbox = new VBox();
        vbox.getChildren().addAll(cbs);
        vbox.setSpacing(5);

        HBox hbox = new HBox();
        hbox.getChildren().addAll(icons);
        hbox.setPadding(new Insets(0, 0, 0, 5));

        StackPane stack = new StackPane();

        stack.getChildren().add(rect);
        stack.getChildren().add(hbox);
        StackPane.setAlignment(rect, Pos.TOP_CENTER);

        HBox root = new HBox();
        root.getChildren().add(vbox);
        root.getChildren().add(stack);
        root.setSpacing(40);
        root.setPadding(new Insets(20, 10, 10, 20));

        ((Group) scene.getRoot()).getChildren().add(root);

        stage.setScene(scene);
        stage.show();
    }
}
