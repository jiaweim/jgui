// Copyright (c) 2016 All rights reserved.
// Dalian Institute of Chemical Physics
//    Chinese Academy of Sciences
// Contact: jiaweiM_philo@hotmail.com

package trail.jgui.javafx.controls;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;


/**
 * ProgressBar is a control that indicates the processing of a particular task with a completion bar.
 *
 * This program presents the ProgressBar control.
 *
 * The example consists of a progress bar and a button. The button starts the progressbar that is
 * animated for a few seconds.
 *
 * @author JiaweiMao
 * @version 1.0.0
 * @date 2016.09.14, 10:51 AM
 */
public class ProgressBarEx extends Application {


    @Override
    public void start(Stage stage) {

        initUI(stage);
    }

    private void initUI(Stage stage) {

        HBox root = new HBox(15);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(10));

        // creates a ProgressBar with the given progress value.
        ProgressBar pbar = new ProgressBar(0);
        pbar.setPrefWidth(150);

        // creates a simple animation task. the animation consists of two frames. The animated properties are defined
        // as KeyValues.
        KeyFrame frame1 = new KeyFrame(Duration.ZERO, new KeyValue(pbar.progressProperty(), 0));

        KeyFrame frame2 = new KeyFrame(Duration.seconds(3), new KeyValue(pbar.progressProperty(), 1));

        Timeline task = new Timeline(frame1, frame2);

        // When fired, the button invokes the playFromStart() method, which plays the animation from
        // initial position in forward direction.
        Button btn = new Button("Start");
        btn.setOnAction((ActionEvent actionEvent) -> {
            task.playFromStart();
        });

        root.getChildren().addAll(pbar, btn);

        Scene scene = new Scene(root);

        stage.setTitle("ProgressBar");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
