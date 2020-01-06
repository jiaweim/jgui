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

package trail.jgui.javafx;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 05 Dec 2017, 9:27 PM
 */
public class FXLifeCycleApp extends Application
{
    public FXLifeCycleApp()
    {
        String name = Thread.currentThread().getName();
        System.out.println("constructor: " + name);
    }

    public static void main(String[] args)
    {
        Application.launch(args);
    }

    @Override
    public void init() throws Exception
    {
        String name = Thread.currentThread().getName();
        System.out.println("init(): " + name);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        String name = Thread.currentThread().getName();
        System.out.println("start(): " + name);

        Scene scene = new Scene(new Group(), 200, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX Application Life Cycle");
        primaryStage.show();
    }

    @Override
    public void stop()
    {
        String name = Thread.currentThread().getName();
        System.out.println("stop(): " + name);
    }
}
