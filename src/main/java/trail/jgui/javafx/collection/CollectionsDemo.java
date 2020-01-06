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

import javafx.collections.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @date 2016.12.18, 4:31 PM
 */
public class CollectionsDemo {

    @Test
    public void listTest(){
        // Use java collections to create the list.
        List<String> list = new ArrayList<>();

        // Now add observability by wrapping it with ObservableList.
        ObservableList<String> observableList = FXCollections.observableList(list);
        observableList.addListener((ListChangeListener<String>) c -> System.out.println("Detected a change!"));

        // Changes to the observableList WILL be reported.
        // This line will print out "Detected a change!"
        observableList.add("item one");

        // Changes to the underlying list will NOT be reported
        // Nothing will be printed as a result of the next line.
        list.add("item two");
        assertEquals(2, observableList.size());
        // 虽然监听器不监听，但是还是修改了列表
    }

    @Test
    public void mapTest(){

        Map<String, String> map = new HashMap<>();

        ObservableMap<String, String> observableMap = FXCollections.observableMap(map);
        observableMap.addListener((MapChangeListener<String, String>) change -> System.out.println("Detected a change!"));

        // Changes to the observableMap will be reported.
        observableMap.put("Key 1", "value 1");
        assertEquals(1, observableMap.size());

        // Changes to the underlying map will NOT be reported, but still changed.
        map.put("key 2", "value 2");
        assertEquals(2, observableMap.size());
    }

    @Test
    public void eventCompare(){

        // Use java collections to create the list
        List<String> list = new ArrayList<>();
        list.add("d");
        list.add("b");
        list.add("a");
        list.add("c");

        // Now add observaility by wrapping it with ObservableList
        ObservableList<String> observableList = FXCollections.observableList(list);
        observableList.addListener((ListChangeListener<String>) c -> System.out.println("Detected a change!"));

        // sort with FXCollections
        FXCollections.sort(observableList);
    }

}
