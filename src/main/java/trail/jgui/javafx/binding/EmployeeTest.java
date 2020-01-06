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

import java.beans.PropertyChangeEvent;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @date 2016.12.19, 10:41 PM
 */
public class EmployeeTest {

    public static void main(String[] args) {
        final Employee e1 = new Employee("John Jacobs", 2000);
        computeTax(e1.getSalary());

        // add a property change listener to e1
        e1.addPropertyChangeListener(EmployeeTest::handlePropertyChange);

        // change the salary
        e1.setSalary(3000);
        e1.setSalary(3000);// no change notification is sent
        e1.setSalary(6000);

    }

    public static void handlePropertyChange(PropertyChangeEvent e){
        String propertyName = e.getPropertyName();

        if("salary".equals(propertyName)){
            System.out.println("Salary has changed.");
            System.out.print("Old:"+e.getOldValue());
            System.out.println(", New:"+e.getNewValue());
            computeTax((Double) e.getNewValue());
        }
    }

    public static void computeTax(double salary) {
        final double TAX_PERCENT = 20.0;
        double tax = salary * TAX_PERCENT / 100;
        System.out.println("Salary:" + salary + ", Tax:" + tax);
    }

}
