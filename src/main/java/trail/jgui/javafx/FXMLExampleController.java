// Copyright (c) 2016 All rights reserved.
// Dalian Institute of Chemical Physics
//    Chinese Academy of Sciences
// Contact: jiaweiM_philo@hotmail.com

package trail.jgui.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @date 2016.12.04, 10:02 PM
 */
public class FXMLExampleController {

    // this annotation is used to tag nonpublic controller member fields and handle methods for use by FXML markup.
    @FXML
    private Text actiontarget;

    @FXML
    protected void handleSubmitButtonAction(ActionEvent event) {
        actiontarget.setText("Sign in button pressed");
    }
}
