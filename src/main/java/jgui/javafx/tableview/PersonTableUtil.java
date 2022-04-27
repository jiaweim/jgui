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

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 08 Jan 2018, 3:25 PM
 */
public class PersonTableUtil
{
    /* Returns an observable list of persons */
    public static ObservableList<Person> getPersonList()
    {
        Person p1 = new Person("Ashwin", "Sharan");
        Person p2 = new Person("Advik", "Sharan");
        Person p3 = new Person("Layne", "Estes");
        Person p4 = new Person("Mason", "Boyd");
        Person p5 = new Person("Babalu", "Sharan");
        return FXCollections.observableArrayList(p1, p2, p3, p4, p5);
    }

    /* Returns First Name TableColumn */
    public static TableColumn<Person, String> getFirstNameColumn()
    {
        TableColumn<Person, String> fNameCol = new TableColumn<>("First Name");
        fNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        return fNameCol;
    }

    /* Returns Last Name TableColumn */
    public static TableColumn<Person, String> getLastNameColumn()
    {
        TableColumn<Person, String> lastNameCol = new TableColumn<>("Last Name");
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        return lastNameCol;
    }
}
