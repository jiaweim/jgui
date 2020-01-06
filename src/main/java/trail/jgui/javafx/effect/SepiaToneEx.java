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

package trail.jgui.javafx.effect;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.CacheHint;
import javafx.scene.Scene;
import javafx.scene.effect.Effect;
import javafx.scene.effect.SepiaTone;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * SepiaTone is a filter that produces a sepia tone effect, similar to antique photographs.
 * This program applies a SepiaTone effect on an Image when a mouse pointer is over the image.
 *
 * @author JiaweiMao
 * @version 1.0.0
 * @date 2016.12.11, 5:24 PM
 */
public class SepiaToneEx extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        initUI(primaryStage);
    }

    private void initUI(Stage stage){
        StackPane root = new StackPane();

        Image image = new Image("file:mushroom.png");
        ImageView iw = new ImageView(image);

        SepiaTone sepia = new SepiaTone();
        iw.effectProperty().bind(Bindings.when(iw.hoverProperty()).then((Effect)sepia).otherwise((Effect)null));

        iw.setCache(true);
        iw.setCacheHint(CacheHint.SPEED);

        root.getChildren().add(iw);

        Scene scene = new Scene(root);
        stage.setTitle("SepiaTone");
        scene.setFill(Color.WHITESMOKE);
        stage.setScene(scene);
        stage.show();
    }
}
