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

package jgui.javafx.binding;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 17 Jan 2018, 1:13 PM
 */
public class MyNumber
{
    private DoubleProperty number;

    public final double getNumber()
    {
        if (number != null)
            return number.get();
        return 0;
    }

    public final void setNumber(double number)
    {
        numberProperty().set(number);
    }

    public final DoubleProperty numberProperty()
    {
        if (number == null)
            number = new SimpleDoubleProperty(0);
        return number;
    }
}
