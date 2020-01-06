// Copyright (c) 2016 All rights reserved.
// Dalian Institute of Chemical Physics
//    Chinese Academy of Sciences
// Contact: jiaweiM_philo@hotmail.com

package trail.jgui.javafx.controls;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


/**
 * TabPane is a control that allows switching between a group of Tabs. Only one tab is visible
 * at a time. Tabs in a TabPane can be positioned at any of the four side of the window. The
 * default side is the top side.
 *
 * The example contains a TabPane control with three tabs. Each tab contains a geometric shape.
 * The second tab is selected when the application starts.
 *
 * @author JiaweiMao
 * @version 1.0.0
 * @date 2016.09.14, 1:11 PM
 */
public class TabPaneEx extends Application {

    @Override
    public void start(Stage stage) {

        initUI(stage);
    }

    private void initUI(Stage stage) {

        StackPane root = new StackPane();
        // a TabPane control is created
        TabPane tabPane = new TabPane();

        // A Tab is created. Its text label is set with the setText() method. THe content is set with the
        // setContent() method.
        Tab tab1 = new Tab();
        tab1.setText("Rectangle");
        tab1.setContent(new Rectangle(100, 100, Color.LIGHTSTEELBLUE));

        Tab tab2 = new Tab();
        tab2.setText("Line");
        tab2.setContent(new Line(0, 0, 100, 100));

        Tab tab3 = new Tab();
        tab3.setText("Circle");
        tab3.setContent(new Circle(0, 0, 50));

        // The TabPane's selection model handles the selection of tabs. The model's select() method
        // selects the second tab.
        tabPane.getSelectionModel().select(1);
        // the tabs are inserted into the tab pane. The internal list of tabs is retrieved with the getTabs method.
        tabPane.getTabs().addAll(tab1, tab2, tab3);

        root.getChildren().add(tabPane);

        Scene scene = new Scene(root, 300, 250);

        stage.setTitle("TabPane");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
