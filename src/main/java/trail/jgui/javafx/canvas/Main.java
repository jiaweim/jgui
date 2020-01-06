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

package trail.jgui.javafx.canvas;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        Rectangle rectBound = new Rectangle();

        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 400, 400);

        Canvas c = new Canvas(400, 400);
        root.setCenter(c);

        c.addEventFilter(MouseEvent.ANY, new EventHandler<MouseEvent>()
        {
            boolean shouldDraw = false;
            double dX, dY;

            @Override
            public void handle(MouseEvent arg0)
            {
                if (arg0.getEventType() == MouseEvent.MOUSE_PRESSED) {
                    shouldDraw = rectBound.contains(arg0.getX(), arg0.getY());
                    if (shouldDraw) {
                        dX = arg0.getX();
                        dY = arg0.getY();
                    }
                } else if (arg0.getEventType() == MouseEvent.MOUSE_DRAGGED) {
                    if (shouldDraw) {
                        double x = (arg0.getX() + rectBound.getX() - dX),
                                y = (arg0.getY() + rectBound.getY() - dY);

                        c.getGraphicsContext2D().clearRect(rectBound.getX(),
                                rectBound.getY(), rectBound.getWidth(),//50
                                rectBound.getHeight());

                        rectBound.setY(y);
                        rectBound.setX(x);

                        dX = arg0.getX();
                        dY = arg0.getY();
                    }
                }
            }
        });

        c.getGraphicsContext2D().setFill(Color.AQUAMARINE);

        rectBound.xProperty().addListener(new ChangeListener<Number>()
        {//since they go together
            @Override
            public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2)
            {
                c.getGraphicsContext2D().fillRect(rectBound.getX(), rectBound.getY(), rectBound.getWidth(), rectBound.getHeight()); //just an example
            }
        });

        primaryStage.setScene(scene);
        primaryStage.show();

        rectBound.setWidth(50);
        rectBound.setHeight(50);
        rectBound.setY(50);
        rectBound.setX(10);//because of the listener x is last
    }
}