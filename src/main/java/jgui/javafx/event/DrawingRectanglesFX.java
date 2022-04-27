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

package jgui.javafx.event;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class DrawingRectanglesFX extends Application
{
    double starting_point_x, starting_point_y;

    Group group_for_rectangles = new Group();

    Rectangle new_rectangle = null;

    boolean new_rectangle_is_being_drawn = false;

    Color[] rectangle_colors = {Color.TEAL, Color.TOMATO, Color.TURQUOISE,
            Color.VIOLET, Color.YELLOWGREEN, Color.GOLD};

    int color_index = 0;

    //  The following method adjusts coordinates so that the rectangle
    //  is shown "in a correct way" in relation to the mouse movement.

    void adjust_rectangle_properties(double starting_point_x,
            double starting_point_y,
            double ending_point_x,
            double ending_point_y,
            Rectangle given_rectangle)
    {
        given_rectangle.setX(starting_point_x);
        given_rectangle.setY(starting_point_y);
        given_rectangle.setWidth(ending_point_x - starting_point_x);
        given_rectangle.setHeight(ending_point_y - starting_point_y);

        if (given_rectangle.getWidth() < 0) {
            given_rectangle.setWidth(-given_rectangle.getWidth());
            given_rectangle.setX(given_rectangle.getX() - given_rectangle.getWidth());
        }

        if (given_rectangle.getHeight() < 0) {
            given_rectangle.setHeight(-given_rectangle.getHeight());
            given_rectangle.setY(given_rectangle.getY() - given_rectangle.getHeight());
        }
    }


    public void start(Stage stage)
    {
        stage.setTitle("DrawingRectanglesFX.java");

        Scene scene = new Scene(group_for_rectangles, 800, 600);

        scene.setFill(Color.BEIGE);

        scene.setOnMousePressed((MouseEvent event) ->
        {
            if (!new_rectangle_is_being_drawn) {
//                starting_point_x = event.getSceneX();
//                starting_point_y = event.getSceneY();

                starting_point_x = event.getX();
                starting_point_y = event.getY();

                new_rectangle = new Rectangle();

                // A non-finished rectangle has always the same color.
                new_rectangle.setFill(Color.SNOW); // almost white color
                new_rectangle.setStroke(Color.BLACK);

                group_for_rectangles.getChildren().add(new_rectangle);

                new_rectangle_is_being_drawn = true;
            }
        });

        scene.setOnMouseDragged((MouseEvent event) ->
        {
            if (new_rectangle_is_being_drawn) {
//                double current_ending_point_x = event.getSceneX();
//                double current_ending_point_y = event.getSceneY();

                double current_ending_point_x = event.getX();
                double current_ending_point_y = event.getY();

                adjust_rectangle_properties(starting_point_x,
                        starting_point_y,
                        current_ending_point_x,
                        current_ending_point_y,
                        new_rectangle);
            }
        });

        scene.setOnMouseReleased((MouseEvent event) ->
        {
            if (new_rectangle_is_being_drawn) {
                // Now the drawing of the new rectangle is finished.
                // Let's set the final color for the rectangle.

                new_rectangle.setFill(rectangle_colors[color_index]);

                color_index++;  // Index for the next color to use.

                // If all colors have been used we'll start re-using colors from the
                // beginning of the array.

                if (color_index >= rectangle_colors.length) {
                    color_index = 0;
                }

                new_rectangle = null;
                new_rectangle_is_being_drawn = false;
            }
        });

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] command_line_parameters)
    {
        launch(command_line_parameters);
    }
}