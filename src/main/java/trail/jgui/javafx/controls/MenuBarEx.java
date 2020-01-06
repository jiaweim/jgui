// Copyright (c) 2016 All rights reserved.
// Dalian Institute of Chemical Physics
//    Chinese Academy of Sciences
// Contact: jiaweiM_philo@hotmail.com

package trail.jgui.javafx.controls;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


/**
 * MenuBar consists of Menu objects, which hold MenuItem objects - the commands of the application. It is
 * traditionally placed at the top of the application window.
 *
 * This program creates a MenuBar with one menu and four menu items.
 *
 * The example contains one menu in the menubar. THe menu holds four menu items and one separator.
 *
 * @author JiaweiMao
 * @version 1.0.0
 * @date 2016.09.14, 10:57 AM
 */
public class MenuBarEx extends Application {

    @Override
    public void start(Stage stage) {

        initUI(stage);
    }

    private void initUI(Stage stage) {

        HBox root = new HBox();

        // MenuBar control is created. Inside a horizontal box, it is large enough to show its
        // single menu. By binding it to the stage's widthProperty, the menubar is stretched from left to right.
        MenuBar mbar = new MenuBar();
        mbar.prefWidthProperty().bind(stage.widthProperty());

        // it is shared by three menu items.
        MyMenuHandler handler = new MyMenuHandler();

        // The File menu is Created and added to the menubar
        Menu fileMenu = new Menu("File");
        mbar.getMenus().add(fileMenu);

        MenuItem nmi = new MenuItem("New");
        nmi.setOnAction(handler);
        fileMenu.getItems().add(nmi);

        MenuItem omi = new MenuItem("Open");
        omi.setOnAction(handler);
        fileMenu.getItems().add(omi);

        MenuItem smi = new MenuItem("Save");
        smi.setOnAction(handler);
        fileMenu.getItems().add(smi);

        // SeparatorMenuItem is a horizontal separator which is sued to visually separate related menu items.
        fileMenu.getItems().add(new SeparatorMenuItem());

        // The Exit menu item terminates the applicaiton with the PlatForm.exit() method call.
        MenuItem emi = new MenuItem("Exit");
        emi.setOnAction((ActionEvent event) -> {
            Platform.exit();
        });

        fileMenu.getItems().add(emi);

        root.getChildren().add(mbar);

        Scene scene = new Scene(root, 300, 250);

        stage.setTitle("MenuBar");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The EventHandler's handle() method is invoked when the menu item with this handler is selected.
     * The method invokes the doShowMessageDialog() method, which shows a message dialog.
     */
    private class MyMenuHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {

            doShowMessageDialog(event);
        }

        /**
         * Create an information dialog with the Alert control. From the event source we determine
         * the name of the menu item, which is used to create the content text.
         */
        private void doShowMessageDialog(ActionEvent event) {

            MenuItem mi = (MenuItem) event.getSource();
            String item = mi.getText();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information dialog");
            alert.setHeaderText("Menu item selection information");
            alert.setContentText(item + " menu item selected");

            alert.showAndWait();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
