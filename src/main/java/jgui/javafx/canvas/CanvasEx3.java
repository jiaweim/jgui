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

package jgui.javafx.canvas;

import javafx.application.Application;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.stage.Stage;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 25 Dec 2017, 1:01 PM
 */
public class CanvasEx3 extends Application
{
    private Canvas canvas = new Canvas(200, 200);

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        moveCanvas(0, 0);

        GraphicsContext gc = canvas.getGraphicsContext2D();
        drawDShape(gc);

        primaryStage.setTitle("Canvas Demo");
    }

    /**
     * 移动 Canvas 到一个新的位置，即平移操作。
     */
    private void moveCanvas(int x, int y)
    {
        canvas.setTranslateX(x);
        canvas.setTranslateY(y);
    }

    private void drawDShape(GraphicsContext gc)
    {
        gc.beginPath();
        gc.moveTo(50, 50);
        gc.bezierCurveTo(150, 20, 150, 150, 75, 150);
        gc.closePath();
    }

    private void drawRadicalGradient(GraphicsContext gc, Color firstColor, Color lastColor)
    {
        gc.setFill(new RadialGradient(0, 0, 0.5, 0.5, 0.1, true, CycleMethod.REFLECT, new Stop(0.0, firstColor), new Stop(1.0, lastColor)));
        gc.fill();
    }
}
