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

package jgui.javafx;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.util.List;
import java.util.Map;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 05 Dec 2017, 4:38 PM
 */
public class FXParamDemo extends Application
{
    public static void main(String[] args)
    {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception
    {
        // 获得参数
        Parameters p = this.getParameters();
        Map<String, String> namedParams = p.getNamed();
        List<String> unnamedParams = p.getUnnamed();
        List<String> rawParams = p.getRaw();
        String paramStr = "Named Parameters: " + namedParams + "\n" +
                "Unnamed Parameters: " + unnamedParams + "\n" +
                "Raw Parameters: " + rawParams;
        TextArea ta = new TextArea(paramStr);
        Group root = new Group(ta);
        stage.setScene(new Scene(root));
        stage.setTitle("Application Parameters");
        stage.show();
    }
}
