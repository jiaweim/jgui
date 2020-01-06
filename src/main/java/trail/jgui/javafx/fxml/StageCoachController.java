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

package trail.jgui.javafx.fxml;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 14 Nov 2019, 6:08 PM
 */
public class StageCoachController
{
    public Rectangle blue;
    public VBox contentBox;
    public Text textStageX;
    public Text textStageY;
    public Text textStageH;
    public Text textStageW;
    public Text textStageF;
    public CheckBox checkBoxResizable;
    public CheckBox checkBoxFullScreen;
    public HBox titleBox;
    public Label titleLabel;
    public TextField titleTextField;
    public Button toBackButton;
    public Button toFrontButton;
    public Button closeButton;

    private Stage stage;
    private StringProperty title = new SimpleStringProperty();
    private double dragAnchorX;
    private double dragAnchorY;

    public Stage getStage()
    {
        return stage;
    }

    public void setupBinding(StageStyle stageStyle)
    {

    }

    public void mouseDraggedHandler(MouseEvent mouseEvent)
    {

    }

    public void mousePressedHandler(MouseEvent mouseEvent)
    {

    }

    public void toBackEventHandler(ActionEvent actionEvent)
    {

    }

    public void toFrontEventHandler(ActionEvent actionEvent)
    {

    }

    public void closeEventHandler(ActionEvent actionEvent)
    {

    }
}
