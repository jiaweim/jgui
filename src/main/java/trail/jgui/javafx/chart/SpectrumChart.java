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

package trail.jgui.javafx.chart;

import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.scene.AccessibleRole;
import javafx.scene.Node;
import javafx.scene.chart.Axis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.util.Iterator;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 14 Dec 2019, 9:43 PM
 */
public class SpectrumChart extends ScatterChart<Number, Number>
{

    public SpectrumChart(Axis<Number> numberAxis, Axis<Number> numberAxis2)
    {
        super(numberAxis, numberAxis2);
    }

    /**
     * @inheritDoc
     */
    @Override
    protected void dataItemAdded(Series<Number, Number> series, int itemIndex, Data<Number, Number> item)
    {
        Node symbol = createBar(series, getData().indexOf(series), item, itemIndex);
        // set symbol styles
        // add and fade in new symbol if animated
        if (shouldAnimate()) {
            symbol.setOpacity(0);
            getPlotChildren().add(symbol);
            FadeTransition ft = new FadeTransition(Duration.millis(500), symbol);
            ft.setToValue(1);
            ft.play();
        } else {
            getPlotChildren().add(symbol);
        }
    }

    private Node createBar(Series<Number, Number> series, int seriesIndex, final Data<Number, Number> item, int itemIndex)
    {
        Node bar = item.getNode();
        if (bar == null) {
            bar = new StackPane();
            bar.setAccessibleRole(AccessibleRole.TEXT);
            bar.setAccessibleRoleDescription("Bar");
            bar.focusTraversableProperty().bind(Platform.accessibilityActiveProperty());
            item.setNode(bar);
        }
        return bar;
    }

    /**
     * Gets the size of the data returning 0 if the data is null
     *
     * @return The number of items in data, or null if data is null
     */
    final int getDataSize()
    {
        final ObservableList<Series<Number, Number>> data = getData();
        return (data != null) ? data.size() : 0;
    }

    /**
     * @inheritDoc
     */
    @Override
    protected void layoutPlotChildren()
    {
        // update symbol positions
        for (int seriesIndex = 0; seriesIndex < getDataSize(); seriesIndex++) {
            Series<Number, Number> series = getData().get(seriesIndex);
            for (Iterator<Data<Number, Number>> it = getDisplayedDataIterator(series); it.hasNext(); ) {
                Data<Number, Number> item = it.next();
                double x = getXAxis().getDisplayPosition(item.getXValue());
                double y = getYAxis().getDisplayPosition(item.getYValue());
                if (Double.isNaN(x) || Double.isNaN(y)) {
                    continue;
                }
                Node symbol = item.getNode();
                if (symbol != null) {
                    final double w = symbol.prefWidth(-1);
                    final double h = symbol.prefHeight(-1);
                    symbol.resizeRelocate(x - (w / 2), y - (h / 2), w, h);
                }
            }
        }
    }
}
