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

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 08 Jan 2018, 3:26 PM
 */
public class Person
{
    private StringProperty firstName = new SimpleStringProperty(this, "firstName");
    private StringProperty lastName = new SimpleStringProperty(this, "lastName");

    public Person(String firstName, String lastName)
    {
        this.firstName.set(firstName);
        this.lastName.set(lastName);
    }

    public String getFirstName() { return firstNameProperty().get(); }

    public void setFirstName(String value) { firstNameProperty().set(value); }

    public StringProperty firstNameProperty()
    {
        return firstName;
    }

    public String getLastName() { return lastNameProperty().get(); }

    public void setLastName(String value) { lastNameProperty().set(value); }

    public StringProperty lastNameProperty()
    {
        return lastName;
    }
}
