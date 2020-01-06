// Copyright (c) 2016 All rights reserved.
// Dalian Institute of Chemical Physics
//    Chinese Academy of Sciences
// Contact: jiaweiM_philo@hotmail.com

package trail.jgui.javafx.event;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


/**
 * EventHandler handles events of a specific class or type. The event handler is set to the event source.
 * It has a handle() method, where we put the code that is invoked in reaction to the generated event.
 *
 * This program uses two EventHandler for two different Events.
 *
 * @author JiaweiMao
 * @version 1.0.0
 * @date 2016.09.14, 1:35 PM
 */
public class EventHandlerEx extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        initUI(primaryStage);
    }

    private void initUI(Stage stage){
        HBox root = new HBox();

        // ContextMenu is a popup control containing an list of menu items
        ContextMenu conMenu = new ContextMenu();

        // two menu items are created and added to the context menu
        MenuItem noopMi = new MenuItem("No op");
        MenuItem exitMi = new MenuItem("Exit");
        conMenu.getItems().addAll(noopMi, exitMi);

        // with setOnAction() method, we set an event handler for an ActionEvent. The EventHandler's handle()
        // method exist the application with the Platform.exit() method
        exitMi.setOnAction(event -> Platform.exit());

        // with the setOnMousePressed() method, we set an event handler for a MouseEvent. When we click
        // the secondary mouse button (usually the right one), the context menu is shown on the screen;
        // it is displayed below the x and y coordinates of the mouse click
        root.setOnMousePressed(event -> {
            if(event.isSecondaryButtonDown()){
                conMenu.show(root, event.getScreenX(), event.getScreenY());
            }
        });

        Scene scene = new Scene(root, 300,250);

        stage.setTitle("EventHandle");
        stage.setScene(scene);
        stage.show();
    }

}
