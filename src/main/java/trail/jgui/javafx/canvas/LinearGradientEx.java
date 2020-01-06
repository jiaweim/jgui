/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 JiaweiMao
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software
 * and associated documentation files (the "Software"), to deal in the Software without
 * restriction, including without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package trail.jgui.javafx.canvas;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @date 2017.01.12, 4:59 PM
 */
public class LinearGradientEx extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        HBox root = new HBox();
        root.setSpacing(10);

        Rectangle r = new Rectangle(200, 100);
        r.setFill(create0());

        Rectangle r1 = new Rectangle(200, 100);
        r1.setFill(create1());

        Rectangle r2 = new Rectangle(200, 100);
        r2.setFill(create2());

        Rectangle r3 = new Rectangle(200, 100);
        r3.setFill(create3());

        Rectangle r4 = new Rectangle(200, 100);
        r4.setFill(create4());

        Rectangle r5 = new Rectangle(200, 100);
        r5.setFill(create5());

        Rectangle r6 = new Rectangle(200, 100);
        r6.setFill(create6());

//
//        Canvas canvas = new Canvas(300, 300);
//        GraphicsContext gc = canvas.getGraphicsContext2D();
//        doDrawing(gc);

        root.getChildren().addAll(r, r1, r2, r3, r4, r5, r6);

        Scene scene = new Scene(root, 200, 100, Color.WHITESMOKE);

        stage.setTitle("Linear gradient");
        stage.setScene(scene);
        stage.show();
    }

    private void doDrawing(GraphicsContext gc) {
        Stop[] stops1 = new Stop[]{new Stop(0.2, Color.BLACK), new Stop(0.5, Color.RED), new Stop(0.8, Color.BLACK)};
        LinearGradient lg1 = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops1);
        gc.setFill(lg1);
        gc.fillRect(50, 30, 200, 180);
    }

    private LinearGradient create0() {
        Stop[] stops = new Stop[]{new Stop(0, Color.WHITE), new Stop(1, Color.BLACK)};
        return new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops);
    }

    private LinearGradient create1() {
        Stop[] stops = new Stop[]{new Stop(0, Color.WHITE), new Stop(1, Color.BLACK)};
        return new LinearGradient(0, 0, 0.5, 0, true, CycleMethod.NO_CYCLE, stops);
    }

    private LinearGradient create2() {
        Stop[] stops = new Stop[]{new Stop(0, Color.WHITE), new Stop(1, Color.BLACK)};
        return new LinearGradient(0, 0, 0.5, 0, true, CycleMethod.REFLECT, stops);
    }

    private LinearGradient create3() {
        Stop[] stops = new Stop[]{new Stop(0, Color.WHITE), new Stop(1, Color.BLACK)};
        return new LinearGradient(0, 0, 0.1, 0, true, CycleMethod.REFLECT, stops);
    }

    private LinearGradient create4() {
        Stop[] stops = new Stop[]{new Stop(0, Color.WHITE), new Stop(1, Color.BLACK)};
        return new LinearGradient(0, 0, 0.5, 0, true, CycleMethod.REPEAT, stops);
    }

    private LinearGradient create5() {
        Stop[] stops = new Stop[]{new Stop(0, Color.RED),
                new Stop(0.25, Color.GREEN),
                new Stop(0.50, Color.BLUE),
                new Stop(0.75, Color.ORANGE),
                new Stop(1, Color.YELLOW)};
        return new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops);
    }

    private LinearGradient create6() {
        Stop[] stops = new Stop[]{new Stop(0, Color.WHITE),
                new Stop(1, Color.BLACK)};
        return new LinearGradient(0, 0, 1, 1, true, CycleMethod.NO_CYCLE, stops);
    }

}
