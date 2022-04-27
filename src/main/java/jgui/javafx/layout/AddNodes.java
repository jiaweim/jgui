package jgui.javafx.layout;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * @author JiaweiMao 2017-05-08
 * @since 1.0-SNAPSHOT
 */
public class AddNodes extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create two buttons
        Button okBtn = new Button("OK");
        Button cancelBtn = new Button("Cancel");

        // Create an HBox with two buttons in its children
        HBox hBox1 = new HBox(okBtn, cancelBtn);

        // Create an HBox with two buttons with 20px horizontal spacing between them
        double hSpacing = 20;
        HBox hBox2 = new HBox(hSpacing, okBtn, cancelBtn);

        // Create an empty HBox, and afterwards, add two buttons to it
        HBox hBox3 = new HBox();
        hBox3.getChildren().addAll(okBtn, cancelBtn);

        FlowPane root = new FlowPane(hBox1, hBox2, hBox3);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
