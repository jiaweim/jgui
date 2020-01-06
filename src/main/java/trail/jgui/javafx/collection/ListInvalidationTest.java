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

// ListInvalidationTest.java
package trail.jgui.javafx.collection;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ListInvalidationTest {
    public static void main(String[] args) {
        // Create a list with some elements
        ObservableList<String> list = FXCollections.observableArrayList("one", "two");
        // Add an InvalidationListener to the list
        list.addListener(ListInvalidationTest::invalidated);

        System.out.println("Before adding three.");
        list.add("three");
        System.out.println("After adding three.");

        System.out.println("Before adding four and five.");
        list.addAll("four", "five");
        System.out.println("After adding four and five.");

        System.out.println("Before replacing one with one.");
        list.set(0, "one");
        System.out.println("After replacing one with one.");
    }

    public static void invalidated(Observable list) {
        System.out.println("List is invalid.");
    }
}