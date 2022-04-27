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

package jgui.javafx.binding;

import javafx.beans.property.ReadOnlyProperty;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @date 2016.12.20, 9:25 AM
 */
public class BookPropertyTest {
    public static void main(String[] args) {
        Book book = new Book("Harnessing JavaFX", 9.99, "0123456789");

        System.out.println("After creating the Book object...");

        // Print Property details
        printDetails(book.titleProperty());
        printDetails(book.priceProperty());
        printDetails(book.ISBNProperty());

        // Change the book's properties
        book.setTitle("Harnessing JavaFX 8.0");
        book.setPrice(9.49);
        System.out.println("\nAfter changing the Book properties...");

        // Print Property details
        printDetails(book.titleProperty());
        printDetails(book.priceProperty());
        printDetails(book.ISBNProperty());
    }

    public static void printDetails(ReadOnlyProperty<?> p) {

        Object bean = p.getBean();
        String beanClassName = (bean == null) ? "null" : bean.getClass().getSimpleName();
        String propClassName = p.getClass().getSimpleName();
        System.out.print(propClassName);
        System.out.print("[Name:" + p.getName());
        System.out.print(", Bean Class:" + beanClassName);
        System.out.println(", Value:" + p.getValue() + "]");
    }
}
