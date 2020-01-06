/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 JiaweiMao
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software
 * and associated documentation files (the "Software"), to deal in the Software without
 * restriction, including without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package trail.jgui.javafx.binding;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @date 2016.12.20, 10:08 AM
 */
public class StrongListener {

    public static IntegerProperty counter = new SimpleIntegerProperty(100);

    public static void main(String[] args) {
        // Add a change listener to the property
        addStrongListener();
        // Change counter value. It will fire a change event.
        counter.set(300);
    }

    public static void addStrongListener() {
        ChangeListener<Number> listener = StrongListener::changed;
        counter.addListener(listener);
        // Change the counter value
        counter.set(200);
    }

    public static void changed(ObservableValue<? extends Number> prop, Number oldValue, Number newValue) {
        System.out.print("Counter changed: ");
        System.out.println("old = " + oldValue + ", new = " + newValue);
    }
}
