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
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 15 Apr 2018, 11:17 AM
 */
public class GridPaneColRowConstraints extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        GridPane root = new GridPane();
        root.setStyle("-fx-padding: 10;");
        root.setGridLinesVisible(true);

        // Add children
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                Button b = new Button(col + " " + row);
                root.add(b, col, row);
            }
        }

        // Set the fixed width for the first column to 100px
        ColumnConstraints cc1 = new ColumnConstraints(100);

        // Set the percent width for the second column to 30% and
        // the horizontal alignment to center
        ColumnConstraints cc2 = new ColumnConstraints();
        cc2.setPercentWidth(35);
        cc2.setHalignment(HPos.CENTER);

        // Set the percent width for the third column to 50%
        ColumnConstraints cc3 = new ColumnConstraints();
        cc3.setPercentWidth(35);

        // Add all column constraints to the column constraints list
        root.getColumnConstraints().addAll(cc1, cc2, cc3);

        // Create two RowConstraints objects
        RowConstraints rc1 = new RowConstraints();
        rc1.setPercentHeight(35);
        rc1.setValignment(VPos.TOP);

        RowConstraints rc2 = new RowConstraints();
        rc2.setPercentHeight(35);
        rc2.setValignment(VPos.BOTTOM);

        // Add RowConstraints for the first two rows
        root.getRowConstraints().addAll(rc1, rc2);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Setting Column/Row Constraints");
        primaryStage.show();
    }
}
