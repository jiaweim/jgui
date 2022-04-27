package jgui.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 * @author JiaweiMao on 2017.06.16
 * @since 1.0-SNAPSHOT
 */
public class EventHandlerLambda extends Application
{
    private Button button;

    public static void main(String[] args)
    {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {

        button = new Button();
        button.setText("Hey girls");

        button.setOnAction(e -> {
            System.out.println("Hey boniu");
        });

        StackPane layout = new StackPane();
        layout.getChildren().add(button);

        Scene scene = new Scene(layout, 300, 250);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
