package trail.jgui.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * @author JiaweiMao on 2017.06.20
 * @since 1.0-SNAPSHOT
 */
public class CloseProgram extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    Stage window;
    Button button;

    @Override
    public void start(Stage primaryStage)
    {
        window = primaryStage;
        window.setTitle("JavaFX - window");
        window.setOnCloseRequest(e -> {
            e.consume();
            closeProgram();
        });

        button = new Button("Close Program");
        button.setOnAction(e -> closeProgram());

        StackPane layout = new StackPane();
        layout.getChildren().add(button);

        Scene scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }

    private void closeProgram()
    {
        Boolean answer = ConfirmBox.display("Title", "Sure you want to exit?");
        if (answer)
            window.close();
    }
}
