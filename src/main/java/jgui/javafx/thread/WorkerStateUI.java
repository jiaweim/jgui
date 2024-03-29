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

package jgui.javafx.thread;

import javafx.beans.binding.When;
import javafx.collections.ObservableList;
import javafx.concurrent.Worker;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 15 Jan 2018, 4:37 PM
 */
public class WorkerStateUI extends GridPane
{
    private final Label title = new Label("");
    private final Label message = new Label("");
    private final Label running = new Label("");
    private final Label state = new Label("");
    private final Label totalWork = new Label("");
    private final Label workDone = new Label("");
    private final Label progress = new Label("");
    private final TextArea value = new TextArea("");
    private final TextArea exception = new TextArea("");
    private final ProgressBar progressBar = new ProgressBar();

    public WorkerStateUI()
    {
        addUI();
    }

    public WorkerStateUI(Worker<ObservableList<Long>> worker)
    {
        addUI();
        bindToWorker(worker);
    }

    private void addUI()
    {
        value.setPrefColumnCount(20);
        value.setPrefRowCount(3);
        exception.setPrefColumnCount(20);
        exception.setPrefRowCount(3);
        this.setHgap(5);
        this.setVgap(5);
        addRow(0, new Label("Title:"), title);
        addRow(1, new Label("Message:"), message);
        addRow(2, new Label("Running:"), running);
        addRow(3, new Label("State:"), state);
        addRow(4, new Label("Total Work:"), totalWork);
        addRow(5, new Label("Work Done:"), workDone);
        addRow(6, new Label("Progress:"), new HBox(2, progressBar, progress));
        addRow(7, new Label("Value:"), value);
        addRow(8, new Label("Exception:"), exception);
    }

    public void bindToWorker(final Worker<ObservableList<Long>> worker)
    {
        // Bind Labels to the properties of the worker
        title.textProperty().bind(worker.titleProperty());
        message.textProperty().bind(worker.messageProperty());
        running.textProperty().bind(worker.runningProperty().asString());
        state.textProperty().bind(worker.stateProperty().asString());
        totalWork.textProperty().bind(new When(worker.totalWorkProperty().isEqualTo(-1))
                .then("Unknown")
                .otherwise(worker.totalWorkProperty().asString()));
        workDone.textProperty().bind(new When(worker.workDoneProperty().isEqualTo(-1))
                .then("Unknown")
                .otherwise(worker.workDoneProperty().asString()));

        // 这个不错...
        progress.textProperty().bind(new When(worker.progressProperty().isEqualTo(-1))
                .then("Unknown")
                .otherwise(worker.progressProperty().multiply(100.0)
                        .asString("%.2f%%")));
        progressBar.progressProperty().bind(worker.progressProperty());
        value.textProperty().bind(worker.valueProperty().asString());

        // Display the exception message when an exception occurs in the worker
        worker.exceptionProperty().addListener((prop, oldValue, newValue) -> {
            if (newValue != null) {
                exception.setText(newValue.getMessage());
            } else {
                exception.setText("");
            }
        });
    }
}
