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

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 06 Dec 2017, 9:12 AM
 */
public class Employee
{
    private String name;
    private double salary;
    private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public Employee()
    {
        this.name = "John Doe";
        this.salary = 1000.0;
    }

    public Employee(String name, double salary)
    {
        this.name = name;
        this.salary = salary;
    }

    public static void main(String[] args)
    {
        Employee e1 = new Employee("John Jacobs", 2000);
        // Compute the tax
        computeTax(e1.getSalary());

        // Add a property change listener to e1
        e1.addPropertyChangeListener(Employee::handlePropertyChange);

        // Change the salary
        e1.setSalary(3000.00);
        e1.setSalary(3000.00); // No change notification is sent.
        e1.setSalary(6000.00);
    }

    public static void handlePropertyChange(PropertyChangeEvent e)
    {
        String propertyName = e.getPropertyName();

        if ("salary".equals(propertyName)) {
            System.out.print("Salary has changed. ");
            System.out.print("Old:" + e.getOldValue());
            System.out.println(", New:" + e.getNewValue());
            computeTax((Double) e.getNewValue());
        }
    }

    public static void computeTax(double salary)
    {
        final double TAX_PERCENT = 20.0;
        double tax = salary * TAX_PERCENT / 100.0;
        System.out.println("Salary:" + salary + ", Tax:" + tax);
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public double getSalary()
    {
        return salary;
    }

    public void setSalary(double newSalary)
    {
        double oldSalary = this.salary;
        this.salary = newSalary;

        // Notify the registered listeners about the change
        pcs.firePropertyChange("salary", oldSalary, newSalary);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener)
    {
        pcs.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener)
    {
        pcs.removePropertyChangeListener(listener);
    }

    @Override
    public String toString()
    {
        return "name = " + name + ", salary = " + salary;
    }
}
