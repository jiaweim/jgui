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

package trail.jgui.javafx.tableview;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 24 Jan 2018, 10:55 AM
 */
public class NestedHeader extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        TableView table = new TableView();
        table.setEditable(true);

        TableColumn firstNameCol = new TableColumn("First Name");
        TableColumn lastNameCol = new TableColumn("Last Name");
        TableColumn addressCol = new TableColumn("Email");

        table.getColumns().addAll(firstNameCol, lastNameCol, addressCol);

        TableColumn cityCol = new TableColumn("City");
        TableColumn stateCol = new TableColumn("State");

        addressCol.getColumns().addAll(cityCol, stateCol);

        StackPane root = new StackPane();
        root.getChildren().add(table);

        primaryStage.setScene(new Scene(root, 200, 250));
        primaryStage.show();
    }
}
