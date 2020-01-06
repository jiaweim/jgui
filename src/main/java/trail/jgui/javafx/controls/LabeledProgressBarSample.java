/*
 * Copyright 2017 JiaweiMao jiaweiM_philo@hotmail.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package trail.jgui.javafx.controls;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.property.ReadOnlyDoubleWrapper;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class LabeledProgressBarSample extends Application
{
    public static void main(String[] args) { launch(args); }

    @Override public void start(final Stage stage)
    {
        stage.setScene(new Scene(createResettableProgressIndicatorBar()));
        stage.show();
    }

    private VBox createResettableProgressIndicatorBar()
    {
        final int TOTAL_WORK = 18;
        final String WORK_DONE_LABEL_FORMAT = "%.0f";

        final ReadOnlyDoubleWrapper workDone = new ReadOnlyDoubleWrapper();

        final ProgressIndicatorBar bar = new ProgressIndicatorBar(
                workDone.getReadOnlyProperty(),
                TOTAL_WORK,
                WORK_DONE_LABEL_FORMAT
        );

        final Timeline countDown = new Timeline(
                new KeyFrame(Duration.seconds(0), new KeyValue(workDone, TOTAL_WORK)),
                new KeyFrame(Duration.seconds(10), new KeyValue(workDone, 0))
        );
        countDown.play();

        final Button resetButton = new Button("Reset");
        resetButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent actionEvent)
            {
                countDown.playFromStart();
            }
        });

        final VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color: cornsilk; -fx-padding: 20px;");
        layout.getChildren().addAll(bar, resetButton);

        return layout;
    }
}

class ProgressIndicatorBar extends StackPane
{
    final private ReadOnlyDoubleProperty workDone;
    final private double totalWork;

    final private ProgressBar bar = new ProgressBar();
    final private Text text = new Text();
    final private String labelFormatSpecifier;

    final private static int DEFAULT_LABEL_PADDING = 5;

    ProgressIndicatorBar(final ReadOnlyDoubleProperty workDone, final double totalWork, final String labelFormatSpecifier)
    {
        this.workDone = workDone;
        this.totalWork = totalWork;
        this.labelFormatSpecifier = labelFormatSpecifier;

        syncProgress();
        workDone.addListener(new ChangeListener<Number>()
        {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2)
            {
                syncProgress();
            }
        });

        bar.setMaxWidth(Double.MAX_VALUE); // allows the progress bar to expand to fill available horizontal space.

        getChildren().setAll(bar, text);
    }

    // synchronizes the progress indicated with the work done.
    private void syncProgress()
    {
        if (workDone == null || totalWork == 0) {
            text.setText("");
            bar.setProgress(ProgressBar.INDETERMINATE_PROGRESS);
        } else {
            text.setText(String.format(labelFormatSpecifier, Math.ceil(workDone.get())));
            bar.setProgress(workDone.get() / totalWork);
        }

        bar.setMinHeight(text.getBoundsInLocal().getHeight() + DEFAULT_LABEL_PADDING * 2);
        bar.setMinWidth(text.getBoundsInLocal().getWidth() + DEFAULT_LABEL_PADDING * 2);
    }
}