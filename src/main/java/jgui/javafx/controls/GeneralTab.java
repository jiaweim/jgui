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

package jgui.javafx.controls;

import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 14 Jan 2018, 3:40 PM
 */
public class GeneralTab extends Tab
{
    TextField firstNameFld = new TextField();
    TextField lastNameFld = new TextField();
    DatePicker dob = new DatePicker();

    public GeneralTab(String text, Node graphic)
    {
        this.setText(text);
        this.setGraphic(graphic);
        init();
    }

    public void init()
    {
        dob.setPrefWidth(200);
        GridPane grid = new GridPane();
        grid.addRow(0, new Label("First Name:"), firstNameFld);
        grid.addRow(1, new Label("Last Name:"), lastNameFld);
        grid.addRow(2, new Label("DOB:"), dob);
        this.setContent(grid);
    }

}
