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

package jgui.javafx.tableview;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Pair;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 09 Jan 2018, 7:35 PM
 */
public class PairTable extends Application
{

    public static final String NAME = "Name";
    public static final String VALUE = "Value";

    final TableView<Pair<String, Object>> table = new TableView<>();

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        // model data
        ObservableList<Pair<String, Object>> data = FXCollections.observableArrayList(
                pair("Song", "Bach Cello Suite 2"),
                pair("Image", new Image("http://upload.wikimedia.org/wikipedia/en/9/99/Bach_Seal.jpg")),
                pair("Rating", 4),
                pair("Classic", true),
                pair("Song Data", new byte[]{})
        );

        table.getItems().setAll(data);
        table.setPrefHeight(275);

        TableColumn<Pair<String, Object>, String> nameCol = new TableColumn<>(NAME);
        TableColumn<Pair<String, Object>, Object> valueCol = new TableColumn<>(VALUE);

        nameCol.setPrefWidth(100);
        valueCol.setSortable(false);
        valueCol.setPrefWidth(150);

        nameCol.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getKey()));
        valueCol.setCellValueFactory(param -> {
            Object value = param.getValue().getValue();
            return (value instanceof ObservableValue) ? (ObservableValue) value : new ReadOnlyObjectWrapper(value);
        });

        table.getColumns().addAll(nameCol, valueCol);

        valueCol.setCellFactory(new Callback<TableColumn<Pair<String, Object>, Object>, TableCell<Pair<String, Object>, Object>>()
        {
            @Override
            public TableCell<Pair<String, Object>, Object> call(TableColumn<Pair<String, Object>, Object> param)
            {
                return new TableCell<Pair<String, Object>, Object>()
                {
                    @Override
                    protected void updateItem(Object item, boolean empty)
                    {
                        super.updateItem(item, empty);

                        if (item != null) {

                            if (item instanceof String) {
                                setText((String) item);
                                setTextFill(Color.RED);
                                setGraphic(null);
                            } else if (item instanceof Integer) {
                                setText(Integer.toString((Integer) item));
                                setGraphic(null);
                            } else if (item instanceof Boolean) {
                                CheckBox checkBox = new CheckBox();
                                checkBox.setSelected((boolean) item);
                                setGraphic(checkBox);
                            } else if (item instanceof Image) {
                                setText(null);
                                ImageView imageView = new ImageView((Image) item);
                                imageView.setFitWidth(100);
                                imageView.setPreserveRatio(true);
                                imageView.setSmooth(true);
                                setGraphic(imageView);
                            } else {
                                setText("N/A");
                                setGraphic(null);
                            }
                        }
                    }
                };
            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(table);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Pair<String, Object> pair(String name, Object value)
    {
        return new Pair<>(name, value);
    }
}
