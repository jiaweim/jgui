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

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Map;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 16 Jan 2018, 4:21 PM
 */
public class JavaFXThreadsExample extends Application implements EventHandler<ActionEvent>, ChangeListener<Number>
{
    private Model model;
    private View view;

    public JavaFXThreadsExample()
    {
        model = new Model();
    }

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage stage)
    {
        view = new View(model);
        hookupEvents();
        stage.setTitle("JavaFX Threads Information");
        stage.setScene(view.scene);
        stage.show();
    }

    @Override
    public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue)
    {
        int index = (Integer) newValue;
        if (index >= 0) {
            view.stackTrace.setText(model.stackTraces.get(index));
        }
    }

    private void hookupEvents()
    {
        view.updateButton.setOnAction(this);
        view.threadNames.getSelectionModel().selectedIndexProperty().addListener(this);
    }

    @Override
    public void handle(ActionEvent event)
    {
        model.update();
    }

    public static class Model
    {
        public ObservableList<String> threadNames;
        public ObservableList<String> stackTraces;

        public Model()
        {
            threadNames = FXCollections.observableArrayList();
            stackTraces = FXCollections.observableArrayList();
            update();
        }

        public void update()
        {
            threadNames.clear();
            stackTraces.clear();
            final Map<Thread, StackTraceElement[]> map = Thread.getAllStackTraces();
            for (Map.Entry<Thread, StackTraceElement[]> entry : map.entrySet()) {
                threadNames.add("\"" + entry.getKey().getName() + "\"");
                stackTraces.add(formatStackTrace(entry.getValue()));
            }
        }

        private String formatStackTrace(StackTraceElement[] value)
        {
            StringBuilder sb = new StringBuilder("StackTrace: \n");
            for (StackTraceElement stackTraceElement : value) {
                sb.append(" at ").append(stackTraceElement.toString()).append("\n");
            }
            return sb.toString();
        }
    }

    private static class View
    {
        public ListView<String> threadNames;
        public TextArea stackTrace;
        public Button updateButton;
        public Scene scene;

        private View(Model model)
        {
            threadNames = new ListView<>(model.threadNames);
            stackTrace = new TextArea();
            updateButton = new Button("Update");
            VBox vBox = new VBox(10, threadNames, stackTrace, updateButton);
            vBox.setPadding(new Insets(10, 10, 10, 10));
            scene = new Scene(vBox, 440, 640);
        }
    }
}
