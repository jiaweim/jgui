package jgui.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * @author JiaweiMao on 2017.06.19
 * @since 1.0-SNAPSHOT
 */
public class AlertBoxDemo extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        primaryStage.setTitle("Title of the window");

        Button button = new Button();
        button.setText("Click me");

        button.setOnAction(e -> {
            boolean display = ConfirmBox.display("Title of the window", "Are you sure to send your naked picts?");
            System.out.println(display);

        });

        StackPane layout = new StackPane();
        layout.getChildren().add(button);

        Scene scene = new Scene(layout, 300, 250);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
