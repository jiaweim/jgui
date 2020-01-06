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

package trail.jgui.javafx.communicate;

import javafx.fxml.FXML;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 18 Jan 2018, 3:59 PM
 */
public class MainController
{

    @FXML
    Tab1Controller tab1Controller;
    @FXML
    Tab2Controller tab2Controller;

    public void initialize()
    {
        System.out.println("Application started");
        tab1Controller.init(this);
        tab2Controller.init(this);
    }

    public String loadLbl1TextFromTab1()
    {
        return tab1Controller.lbl1.getText();
    }

    public void setTab2LabelText(String text)
    {
        tab2Controller.lbl2.setText(text);
    }
}
