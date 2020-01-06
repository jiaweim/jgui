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

package trail.jgui.javafx.collection;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @date 2016.12.20, 10:36 AM
 */
public class ObservableListTest {

    public static void main(String[] args) {

        // Create a list with some elements
        ObservableList<String> list = FXCollections.observableArrayList("one", "two");
        System.out.println("After creating list: " + list);

        // Add some more elements to the list
        list.addAll("three", "four");
        System.out.println("After adding elements: " + list);

        // You have four elements, remove the middle two from [1,3)
        list.remove(1, 3);
        System.out.println("After removing elements: " + list);

        // Retain only the element "one"
        list.retainAll("one");
        System.out.println("After retaining \"one\":" + list);

        // Create another ObservableList
        ObservableList<String> list2 = FXCollections.observableArrayList("1", "2", "3");

        // Set list2 to list
        list.addAll(list2);
        System.out.println("After setting list2 to list:" + list);

        // Create another list
        ObservableList<String> list3 = FXCollections.observableArrayList("ten", "twenty", "thirty");

        // Concatenate elements of list2 and list3
        ObservableList<String> list4 = FXCollections.concat(list2, list3);
        System.out.println("list2 is " + list2);
        System.out.println("list3 is " + list3);
        System.out.println("After concatenating list2 and list3:" + list4);
    }

}
