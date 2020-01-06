/*
 * Copyright (c) 2016 JiaweiMao. All rights reserved.
 * Dalian Institute of Chemical Physics
 *    Chinese Academy of Sciences
 * Contact: jiaweiM_philo@hotmail.com
 */

package trail.jgui.javafx.chart;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @date 2016.10.19, 10:43 AM
 */
public class BarChartMirror extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Mirror Bar Chart Sample");

        VBox root = new VBox();

        final NumberAxis xAxis1 = new NumberAxis();
        final NumberAxis yAxis1 = new NumberAxis();
        final BarChart<Number, Number> bc1 = new BarChart<>(xAxis1, yAxis1);

        XYChart.Series<Number, Number> series1 = new XYChart.Series<>();
        series1.getData().add(new XYChart.Data<>(114.0913391, 1.0));
        series1.getData().add(new XYChart.Data<>(114.0913391, 1.0));
        series1.getData().add(new XYChart.Data<>(161.1284485, 1.0));
        series1.getData().add(new XYChart.Data<>(245.1318207, 1.0));
        series1.getData().add(new XYChart.Data<>(275.1713867, 1.0));
        series1.getData().add(new XYChart.Data<>(358.2158813, 1.0));
        series1.getData().add(new XYChart.Data<>(404.2139893, 1.0));
        series1.getData().add(new XYChart.Data<>(487.2584839, 1.0));
        series1.getData().add(new XYChart.Data<>(505.2616577, 1.0));
        series1.getData().add(new XYChart.Data<>(562.2831421, 1.0));
        series1.getData().add(new XYChart.Data<>(602.2854004, 1.0));
        series1.getData().add(new XYChart.Data<>(659.3068848, 1.0));
        series1.getData().add(new XYChart.Data<>(677.3100586, 1.0));
        series1.getData().add(new XYChart.Data<>(760.3545532, 1.0));
        series1.getData().add(new XYChart.Data<>(806.3526611, 1.0));
        series1.getData().add(new XYChart.Data<>(889.3971558, 1.0));
        series1.getData().add(new XYChart.Data<>(919.4367065, 1.0));
        series1.getData().add(new XYChart.Data<>(1003.440063, 1.0));
        series1.getData().add(new XYChart.Data<>(1050.477173, 1.0));

        bc1.getData().add(series1);

        final NumberAxis xAxis2 = new NumberAxis();
        final NumberAxis yAxis2 = new NumberAxis();
        final BarChart<Number, Number> bc2 = new BarChart<>(xAxis2, yAxis2);

        root.getChildren().add(bc1);

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
