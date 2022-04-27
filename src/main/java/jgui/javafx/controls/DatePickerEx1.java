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

package jgui.javafx.controls;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.time.LocalDate;
import java.time.chrono.HijrahChronology;
import java.time.chrono.ThaiBuddhistChronology;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 04 Apr 2018, 5:45 PM
 */
public class DatePickerEx1 extends Application
{
    private Stage stage;
    private DatePicker checkInDatePicker;
    private DatePicker checkOutDatePicker;

    public static void main(String[] args)
    {
        Locale.setDefault(Locale.US);
        launch(args);
    }

    @Override
    public void start(Stage stage)
    {
        this.stage = stage;
        stage.setTitle("DatePickerSample ");
        initUI();
        stage.show();
    }

    private void initUI()
    {
        VBox vbox = new VBox(20);
        vbox.setStyle("-fx-padding: 10;");
        Scene scene = new Scene(vbox, 400, 400);
        stage.setScene(scene);

        checkInDatePicker = new DatePicker();
        checkOutDatePicker = new DatePicker();
        checkInDatePicker.setValue(LocalDate.now());

        final Callback<DatePicker, DateCell> dayCellFactory =
                new Callback<DatePicker, DateCell>()
                {
                    @Override
                    public DateCell call(final DatePicker datePicker)
                    {
                        return new DateCell()
                        {
                            @Override
                            public void updateItem(LocalDate item, boolean empty)
                            {
                                super.updateItem(item, empty);

                                if (item.isBefore(
                                        checkInDatePicker.getValue().plusDays(1))
                                        ) {
                                    setDisable(true);
                                    setStyle("-fx-background-color: #ffc0cb;");
                                }
                                long p = ChronoUnit.DAYS.between(
                                        checkInDatePicker.getValue(), item
                                );
                                setTooltip(new Tooltip(
                                        "You're about to stay for " + p + " days")
                                );
                            }
                        };
                    }
                };

        checkOutDatePicker.setDayCellFactory(dayCellFactory);
        checkOutDatePicker.setValue(checkInDatePicker.getValue().plusDays(1));
        checkInDatePicker.setChronology(ThaiBuddhistChronology.INSTANCE);
        checkOutDatePicker.setChronology(HijrahChronology.INSTANCE);

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        Label checkInlabel = new Label("Check-In Date:");
        gridPane.add(checkInlabel, 0, 0);
        GridPane.setHalignment(checkInlabel, HPos.LEFT);

        gridPane.add(checkInDatePicker, 0, 1);

        Label checkOutlabel = new Label("Check-Out Date:");
        gridPane.add(checkOutlabel, 0, 2);
        GridPane.setHalignment(checkOutlabel, HPos.LEFT);

        gridPane.add(checkOutDatePicker, 0, 3);

        vbox.getChildren().add(gridPane);

    }
}
