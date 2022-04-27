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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since Dec 3, 2018, 3:40:37 PM
 */
public class PieChartEx2_Event extends Application {

	@Override
	public void start(Stage primaryStage) {
		   ObservableList<PieChart.Data> dataList =
	                FXCollections.observableArrayList(new PieChart.Data("Grapefruit", 13),
				new PieChart.Data("Oranges", 25), new PieChart.Data("Plums", 10), new PieChart.Data("Pears", 22),
				new PieChart.Data("Apples", 30));
		final PieChart chart = new PieChart(dataList);
		chart.setTitle("Imported Fruits");

		final Label caption = new Label("");
		caption.setTextFill(Color.DARKORANGE);
		caption.setStyle("-fx-font: 24 arial;");

		for(final Data data : chart.getData()) {
			data.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					caption.setTranslateX(event.getSceneX());
					caption.setTranslateY(event.getSceneY());
					caption.setText(String.valueOf(data.getPieValue()) + "%");
				}
			});
		}
		
		primaryStage.setTitle("Imported Fruits");
		primaryStage.setWidth(500);
		primaryStage.setHeight(500);

		Group root = new Group();
		root.getChildren().add(chart);
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
