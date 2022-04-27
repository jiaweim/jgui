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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 09 Jan 2018, 3:08 PM
 */
public class TableViewMapDataEx1 extends Application
{
    private final String firstNameColumnKey = "firstName";
    private final String lastNameColumnKey = "lastName";

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage stage)
    {
        TableView<Map> table = new TableView<>();
        ObservableList<Map<String, Object>> items = this.getMapData();
        table.getItems().addAll(items);
        this.addColumns(table);

        table.setTableMenuButtonVisible(true);
        HBox root = new HBox(table);
        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Using a Map as items in a TableView");
        stage.setWidth(300);
        stage.setHeight(500);
        stage.show();
    }

    public ObservableList<Map<String, Object>> getMapData()
    {
        ObservableList<Map<String, Object>> items = FXCollections.observableArrayList();
        // Extract the person data, add the data to a Map, and add the Map to the items list
        ObservableList<Person> persons = PersonTableUtil.getPersonList();
        for (Person p : persons) {
            Map<String, Object> map = new HashMap<>();
            map.put(firstNameColumnKey, p.getFirstName());
            map.put(lastNameColumnKey, p.getLastName());
            items.add(map);
        }
        return items;
    }

    public void addColumns(TableView table)
    {
        TableColumn<Map, String> firstNameCol = new TableColumn<>("First Name");
        firstNameCol.setCellValueFactory(new MapValueFactory<>(firstNameColumnKey));

        TableColumn<Map, String> lastNameCol = new TableColumn<>("Last Name");
        lastNameCol.setCellValueFactory(new MapValueFactory<>(lastNameColumnKey));

        table.getColumns().addAll(firstNameCol, lastNameCol);
    }
}
