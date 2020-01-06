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
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 09 Jan 2018, 9:26 AM
 */
public class TableViewEx1 extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage stage)
    {
        TableView<UserAccount> table = new TableView<>();
        // Create column UserName (Data type of String).
        TableColumn<UserAccount, String> userNameCol = new TableColumn<>("User Name");

        // Create column Email (Data type of String).
        TableColumn<UserAccount, String> emailCol = new TableColumn<>("Email");

        // Create column FullName (Data type of String).
        TableColumn<UserAccount, String> fullNameCol = new TableColumn<>("Full Name");

        // Create 2 sub column for FullName.
        TableColumn<UserAccount, String> firstNameCol = new TableColumn<>("First Name");

        TableColumn<UserAccount, String> lastNameCol = new TableColumn<>("Last Name");

        fullNameCol.getColumns().addAll(firstNameCol, lastNameCol);
        // Active Column
        TableColumn<UserAccount, Boolean> activeCol = new TableColumn<>("Active");

        // fill value with property of UserAccount
        userNameCol.setCellValueFactory(new PropertyValueFactory<>("userName"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        activeCol.setCellValueFactory(new PropertyValueFactory<>("active"));

        userNameCol.setSortType(TableColumn.SortType.DESCENDING);
        lastNameCol.setSortable(false);

        table.setItems(UserAccount.getUserList());

        table.getColumns().addAll(userNameCol, emailCol, fullNameCol, activeCol);

        StackPane root = new StackPane();
        root.setPadding(new Insets(5));
        root.getChildren().add(table);

        stage.setTitle("TableView");
        Scene scene = new Scene(root, 600, 400);

        stage.setScene(scene);
        stage.show();
    }
}
