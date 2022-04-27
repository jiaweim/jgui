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

package jgui.javafx.layout;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 18 Jan 2018, 1:10 PM
 */
public class TilePaneTileAlignment extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        TilePane tileAlignCenter = createTilePane(Pos.CENTER);
        TilePane tileAlignTopRight = createTilePane(Pos.TOP_LEFT);

        HBox root = new HBox(tileAlignCenter, tileAlignTopRight);
        root.setFillHeight(false);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("The tileAlignment property for TilePane");
        primaryStage.show();
    }

    private TilePane createTilePane(Pos tileAlignment)
    {
        Button[] buttons = new Button[]{new Button("Tile"),
                new Button("are"), new Button("aligned"), new Button("at"), new Button(tileAlignment.toString())};
        TilePane pane = new TilePane(5, 5, buttons);
        pane.setTileAlignment(tileAlignment);
        pane.setPrefColumns(3);
        pane.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fxborder-color: blue;");
        return pane;
    }
}
