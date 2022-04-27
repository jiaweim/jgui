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

package jgui.javafx.stage;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * 输出屏幕的详细信息。
 *
 * @author JiaweiMao
 * @version 1.0.0
 * @since 30 Dec 2017, 3:51 PM
 */
public class ScreenEx1 extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        ObservableList<Screen> screens = Screen.getScreens();
        System.out.println("Screens Count:" + screens.size());

        for (Screen screen : screens)
            print(screen);

        Platform.exit();
    }

    public void print(Screen s)
    {
        System.out.println("DPI: " + s.getDpi());

        System.out.println("Screen Bounds: ");
        ;
        Rectangle2D bounds = s.getBounds();
        print(bounds);

        System.out.println("Screen Visual Bounds: ");
        Rectangle2D visualBounds = s.getVisualBounds();
        print(visualBounds);

        System.out.println("-------------------");
    }

    public void print(Rectangle2D r)
    {
        System.out.format("minX=%.2f, minY=%.2f, width=%.2f, height=%.2f\n", r.getMinX(), r.getMinY(), r.getWidth(), r.getHeight());
    }
}
