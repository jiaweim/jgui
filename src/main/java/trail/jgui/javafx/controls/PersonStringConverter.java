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

import javafx.util.StringConverter;
import trail.javafx.tableview.Person;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 23 Jan 2018, 4:01 PM
 */
public class PersonStringConverter extends StringConverter<Person>
{
    @Override
    public String toString(Person object)
    {
        return object == null ? null : object.getLastName() + ", " + object.getFirstName();
    }

    @Override
    public Person fromString(String string)
    {
        Person p = null;
        if (string == null)
            return p;

        int commaIndex = string.indexOf(",");
        if (commaIndex == -1) {
            p = new Person(string, null);
        } else {
            String firstName = string.substring(commaIndex + 2);
            String lastName = string.substring(0, commaIndex);
            p = new Person(firstName, lastName);
        }

        return p;
    }
}
