// Copyright (c) 2016 All rights reserved.
// Dalian Institute of Chemical Physics
//    Chinese Academy of Sciences
// Contact: jiaweiM_philo@hotmail.com

package trail.jgui.javafx.effect;

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 * Lighting simulates a light source shining on the given content, which can be used to given flat
 * objects a more realistic, three-dimensional appearance. The setAzimuth() method of the Light source sets
 * the azimuth - the direction angle for the light source.
 *
 * This program applies a Lighting effect on a Text control. The azimuth of the light is controlled by a Slider.
 *
 * @author JiaweiMao
 * @version 1.0.0
 * @date 2016.09.14, 2:38 PM
 */
public class LightingEx extends Application {

    @Override
    public void start(Stage stage) {

        initUI(stage);
    }

    private void initUI(Stage stage) {

        VBox root = new VBox(30);
        root.setPadding(new Insets(10));

        DoubleProperty azimuth = new SimpleDoubleProperty(0);

        // A Light source is created.
        Light.Distant light = new Light.Distant();
        light.setAzimuth(0);

        // This line creates a new instance of a Lighting with the specified light.
        Lighting lighting = new Lighting(light);
        lighting.setSurfaceScale(5.0);

        // This is the Text control on which the Lighting effect is set.
        Text text = new Text();
        text.setText("ZetCode");
        text.setFill(Color.LIGHTSKYBLUE);
        text.setFont(Font.font(null, FontWeight.BOLD, 60));

        // THe slider control manages the azimuth of the light source.
        Slider slider = new Slider(1, 360, 0);
        azimuth.bind(slider.valueProperty());

        slider.valueProperty().addListener(event -> {
            light.setAzimuth(azimuth.get());
            lighting.setLight(light);
            text.setEffect(lighting);
        });

        text.setEffect(lighting);

        root.getChildren().addAll(slider, text);

        Scene scene = new Scene(root, 300, 250, Color.WHITESMOKE);

        stage.setTitle("Lighting");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
