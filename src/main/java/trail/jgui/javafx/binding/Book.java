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

package trail.jgui.javafx.binding;

import javafx.beans.property.*;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 06 Dec 2017, 10:57 AM
 */
public class Book
{

    private StringProperty title = new SimpleStringProperty(this, "title", "Unknown");
    private DoubleProperty price = new SimpleDoubleProperty(this, "price", 0.0);
    private ReadOnlyStringWrapper ISBN = new ReadOnlyStringWrapper(this, "ISBN", "Unknown");

    public Book()
    {
    }

    public Book(String title, double price, String ISBN)
    {
        this.title.set(title);
        this.price.set(price);
        this.ISBN.set(ISBN);
    }

    public final String getTitle()
    {
        return title.get();
    }

    public final void setTitle(String title)
    {
        this.title.set(title);
    }

    public final StringProperty titleProperty()
    {
        return title;
    }

    public final double getPrice()
    {
        return price.get();
    }

    public final void setPrice(double price)
    {
        this.price.set(price);
    }

    public final DoubleProperty priceProperty()
    {
        return price;
    }

    public final String getISBN()
    {
        return ISBN.get();
    }

    public final ReadOnlyStringProperty ISBNProperty()
    {
        return ISBN.getReadOnlyProperty();
    }
}
