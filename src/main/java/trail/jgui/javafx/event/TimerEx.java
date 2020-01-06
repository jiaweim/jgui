// Copyright (c) 2016 All rights reserved.
// Dalian Institute of Chemical Physics
//    Chinese Academy of Sciences
// Contact: jiaweiM_philo@hotmail.com

package trail.jgui.javafx.event;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.Timer;
import java.util.TimerTask;


/**
 * java.util.Timer schedules tasks for future execution in a background thread.
 * TimerTask is a task that can be scheduled for one-time or repeated execution by a timer.
 *
 * The example has two controls: a button and a spinner. The button starts a timer,
 * which shows a message dialog after a delay.The delay is chosen by the spinner control
 *
 * @author JiaweiMao
 * @version 1.0.0
 * @date 2016.09.14, 2:09 PM
 */
public class TimerEx extends Application {

    int delay = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        initUI(primaryStage);
    }

    private void initUI(Stage stage) {
        HBox root = new HBox(10);
        root.setPadding(new Insets(10));

        // An instance of the java.util.Timer is created.
        Timer timer = new Timer();

        // The Spinner control is used to choose the amount of the delay. Its parameters are
        // the minimum, maximum, and current values. The values are in millisecond.
        Spinner spinner = new Spinner(1, 60, 5);
        spinner.setPrefWidth(80);

        Button btn = new Button("Show message");

        // in the button's event handler, we get the spinner's current value with the getValue()
        // method and schedule the task with the timer's schedule() method.
        btn.setOnAction(event -> {
            delay = (int) spinner.getValue();
            timer.schedule(new MyTimerTaks(), delay * 1000);
        });

        root.getChildren().addAll(btn, spinner);

        // we cancel the timer when the application is terminated with the timer's cancel() method.
        stage.setOnCloseRequest(event -> {

            timer.cancel();
        });


        Scene scene = new Scene(root);

        stage.setTitle("Timer");
        stage.setScene(scene);
        stage.show();
    }

    private class MyTimerTaks extends TimerTask {

        /**
         * The runLater() method executes the task on the JavaFX application thread.
         * We show a message dialog informing about the elapsed time.
         */
        @Override public void run() {
            Platform.runLater(() -> {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information dialog");
                alert.setHeaderText("Time elapsed information");

                String context;
                if (delay == 1) {
                    context = "1 second has elapsed";
                } else {
                    context = String.format("%d seconds have slapsed", delay);
                }

                alert.setContentText(context);
                alert.showAndWait();
            });
        }
    }
}
