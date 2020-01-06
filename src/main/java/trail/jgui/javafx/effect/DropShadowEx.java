// Copyright (c) 2016 All rights reserved.
// Dalian Institute of Chemical Physics
//    Chinese Academy of Sciences
// Contact: jiaweiM_philo@hotmail.com

package trail.jgui.javafx.effect;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


/**
 * DropShadow is a high-level effect that renders a shadow behind the content with
 * specified color, radius, and offset.
 *
 * This program applies a DropShadow effect on a rectangle.
 *
 * @author JiaweiMao
 * @version 1.0.0
 * @date 2016.09.14, 2:35 PM
 */
public class DropShadowEx extends Application {

    @Override
    public void start(Stage stage) {

        initUI(stage);
    }

    private void initUI(Stage stage) {

        StackPane root = new StackPane();

        // A greenyellow rectangle shape is constructed.
        Rectangle rect = new Rectangle(0, 0, 100, 100);
        rect.setFill(Color.GREENYELLOW);

        // a DropShadow effect is created. The constructor accepts the radius and the color.
        DropShadow ds = new DropShadow(15, Color.DARKGREEN);

        // The effect is applied with the setEffect() method.
        rect.setEffect(ds);

        root.getChildren().add(rect);

        Scene scene = new Scene(root, 250, 200, Color.WHITESMOKE);

        stage.setTitle("DropShadow");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
