package trail.jgui.javafx.layout;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * @author JiaweiMao 2017-05-08
 * @since 1.0-SNAPSHOT
 */
public class PaneTest extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Button okBtn = new Button("OK");
        Button cancelBtn = new Button("Cancel");
        okBtn.relocate(10, 10);
        cancelBtn.relocate(60, 10);

        Pane root = new Pane();
        root.getChildren().addAll(okBtn, cancelBtn);
        root.setStyle("-fx-border-style: solid inside;" +
                "-fx-border-width: 3;" +
                "-fx-border-color: red;");

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Using Panes");
        stage.show();
    }
}
