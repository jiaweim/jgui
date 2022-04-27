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

package jgui.javafx.fxml;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 12 Jan 2018, 8:56 PM
 */
public class SayHelloController
{
    // The reference of msgLbl will be injected by the FXML loader
    @FXML
    private Label msgLbl;

    // location and resources will be automatically injected by the FXML loader
    @FXML
    private URL location;

    @FXML
    private ResourceBundle resources;

    // Add a public no-args constructor explicitly just to
    // emphasize that it is needed for a controller
    public SayHelloController() { }

    @FXML
    private void initialize()
    {
        System.out.println("Initializing SayHelloController...");
        System.out.println("Location = " + location);
        System.out.println("Resources = " + resources);
    }

    @FXML
    private void sayHello()
    {
        msgLbl.setText("Hello from FXML!");
    }
}
