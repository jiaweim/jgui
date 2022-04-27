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

package jgui.javafx.chart;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 14 Dec 2019, 10:02 PM
 */
public class ScatterChartTest extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        NumberAxis xAxis = new NumberAxis();
        xAxis.setLabel("Year");

        xAxis.setAutoRanging(false);
        xAxis.setLowerBound(1900);
        xAxis.setUpperBound(2300);
        xAxis.setTickUnit(50);

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Population (in millions)");

        ScatterChart<Number, Number> chart = new ScatterChart<>(xAxis, yAxis);
        chart.setTitle("Population by Year and Country");

        ObservableList<XYChart.Series<Number, Number>> chartData = XYChartDataUtil.getCountrySeries();
        chart.setData(chartData);

        StackPane root = new StackPane(chart);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("A Scatter Chart");
        primaryStage.show();
    }
}
