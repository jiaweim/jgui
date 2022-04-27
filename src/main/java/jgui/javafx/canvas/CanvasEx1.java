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
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.PixelFormat;
import javafx.scene.image.PixelWriter;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.nio.ByteBuffer;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 22 Dec 2017, 3:54 PM
 */
public class CanvasEx1 extends Application
{
    private static final int RECT_WIDTH = 20;
    private static final int RECT_HEIGHT = 20;

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        Canvas canvas = new Canvas(400, 100);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Set line width and fill color
        gc.setLineWidth(2.0);
        gc.setFill(Color.RED);

        // Draw a rounded rectangle
        gc.strokeRoundRect(10, 10, 50, 50, 10, 10);

        // Fill an oval
        gc.fillOval(70, 10, 50, 20);

        // Draw text
        gc.strokeText("Hello Canvas", 10, 85);

        // Draw an Image
        String imagePath = "http://91zhuti.com/uploads/allimg/131210/4-1312101432140-L.jpg";
        Image image = new Image(imagePath);
        gc.drawImage(image, 130, 10, 60, 80);

        // Writer custom pixels to create a pattern
        // Write custom pixels to create a pattern
        writePixels(gc);

        Pane root = new Pane();
        root.getChildren().add(canvas);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Drawing on a Canvas");
        primaryStage.show();

    }

    private void writePixels(GraphicsContext gc)
    {
        byte[] pixels = this.getPixelsData();
        PixelWriter pixelWriter = gc.getPixelWriter();
// Our data is in BYTE_RGB format
        PixelFormat<ByteBuffer> pixelFormat = PixelFormat.getByteRgbInstance();
        int spacing = 5;
        int imageWidth = 200;
        int imageHeight = 100;
// Roughly compute the number of rows and columns
        int rows = imageHeight / (RECT_HEIGHT + spacing);
        int columns = imageWidth / (RECT_WIDTH + spacing);
// Write the pixels to the canvas
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < columns; x++) {
                int xPos = 200 + x * (RECT_WIDTH + spacing);
                int yPos = y * (RECT_HEIGHT + spacing);
                pixelWriter.setPixels(xPos, yPos,
                        RECT_WIDTH, RECT_HEIGHT,
                        pixelFormat,
                        pixels, 0,
                        RECT_WIDTH * 3);
            }
        }
    }

    private byte[] getPixelsData()
    {
        // Each pixel in the w X h region will take 3 bytes
        byte[] pixels = new byte[RECT_WIDTH * RECT_HEIGHT * 3];

        // Height to width ration
        double ratio = 1.0 * RECT_HEIGHT / RECT_WIDTH;

        // Generate pixel data
        for (int y = 0; y < RECT_HEIGHT; y++) {
            for (int x = 0; x < RECT_WIDTH; x++) {
                int i = y * RECT_WIDTH * 3 + x * 3;
                if (x <= y / ratio) {
                    pixels[i] = -1; // red -1 means 255 (-1 & 0xff = 255)
                    pixels[i + 1] = 0; // green = 0
                    pixels[i + 2] = 0; // blue = 0
                } else {
                    pixels[i] = 0; // red = 0
                    pixels[i + 1] = -1; // Green 255
                    pixels[i + 2] = 0; // blue = 0
                }
            }
        }
        return pixels;
    }
}
