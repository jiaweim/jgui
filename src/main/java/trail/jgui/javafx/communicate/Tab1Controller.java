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

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 18 Jan 2018, 3:54 PM
 */
public class Tab1Controller
{
    @FXML
    public Label lbl1;
    @FXML
    public TextField txt1;
    private MainController mainController;

    public void btnSaveClicked(ActionEvent actionEvent)
    {
        System.out.println("Btn 1 save clicked");
        lbl1.setText(txt1.getText());
    }


    public void btn1SendClicked(ActionEvent actionEvent)
    {
        System.out.println("Btn 1 send clicked");
        mainController.setTab2LabelText(txt1.getText());
    }

    public void init(MainController mainController)
    {
        this.mainController = mainController;
    }
}
