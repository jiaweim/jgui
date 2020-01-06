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

package trail.jgui.javafx.layout;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

import java.util.function.Function;

public class TableWithAddDialog extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        TableView<Person> table = new TableView<>();

        table.getColumns().add(column("First Name", Person::firstNameProperty));
        table.getColumns().add(column("Last Name", Person::lastNameProperty));
        table.getColumns().add(column("Email", Person::emailProperty));


        TextField firstNameTextField = new TextField();
        TextField lastNameTextField = new TextField();
        TextField emailTextField = new TextField();

        GridPane editPane = new GridPane();
        editPane.setAlignment(Pos.CENTER);
        editPane.setPadding(new Insets(10));
        editPane.setHgap(5);
        editPane.setVgap(10);
        ColumnConstraints leftCol = new ColumnConstraints();
        ColumnConstraints rightCol = new ColumnConstraints();
        leftCol.setHalignment(HPos.RIGHT);
        rightCol.setHgrow(Priority.ALWAYS);
        editPane.getColumnConstraints().addAll(leftCol, rightCol);

        editPane.addRow(0, new Label("First Name:"), firstNameTextField);
        editPane.addRow(1, new Label("Last Name:"), lastNameTextField);
        editPane.addRow(2, new Label("Email:"), emailTextField);

        Button addButton = new Button("New...");

        DialogPane dialogPane = new DialogPane();
        dialogPane.setContent(editPane);
        dialogPane.setHeaderText("Add new contact");

        Dialog<Person> dialog = new Dialog<Person>();
        dialog.setDialogPane(dialogPane);
        dialog.setResultConverter(buttonType -> buttonType == ButtonType.OK
                ? new Person(getAndClear(firstNameTextField), getAndClear(lastNameTextField), getAndClear(emailTextField))
                : null);
        dialogPane.getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

        addButton.setOnAction(e ->
                dialog.showAndWait().ifPresent(table.getItems()::add));

        BorderPane.setAlignment(addButton, Pos.CENTER);
        BorderPane.setMargin(addButton, new Insets(10));

        BorderPane root = new BorderPane(table, null, null, addButton, null);
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private String getAndClear(TextField tf)
    {
        String result = tf.getText();
        tf.setText("");
        return result;
    }

    private <S, T> TableColumn<S, T> column(String title, Function<S, ObservableValue<T>> property)
    {
        TableColumn<S, T> col = new TableColumn<>(title);
        col.setCellValueFactory(cellData -> property.apply(cellData.getValue()));
        return col;
    }

    public static class Person
    {
        private final StringProperty firstName = new SimpleStringProperty();
        private final StringProperty lastName = new SimpleStringProperty();
        private final StringProperty email = new SimpleStringProperty();

        public Person(String firstName, String lastName, String email)
        {
            setFirstName(firstName);
            setLastName(lastName);
            setEmail(email);
        }

        public final StringProperty firstNameProperty()
        {
            return this.firstName;
        }

        public final String getFirstName()
        {
            return this.firstNameProperty().get();
        }

        public final void setFirstName(final String firstName)
        {
            this.firstNameProperty().set(firstName);
        }

        public final StringProperty lastNameProperty()
        {
            return this.lastName;
        }

        public final String getLastName()
        {
            return this.lastNameProperty().get();
        }

        public final void setLastName(final String lastName)
        {
            this.lastNameProperty().set(lastName);
        }

        public final StringProperty emailProperty()
        {
            return this.email;
        }

        public final String getEmail()
        {
            return this.emailProperty().get();
        }

        public final void setEmail(final String email)
        {
            this.emailProperty().set(email);
        }


    }
}