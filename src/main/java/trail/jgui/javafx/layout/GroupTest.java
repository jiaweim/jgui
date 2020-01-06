package trail.jgui.javafx.layout;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * @author JiaweiMao 2017-05-08
 * @since 1.0-SNAPSHOT
 */
public class GroupTest extends Application {

    @Override
    public void start(Stage stage) throws Exception {


        Button smallBtn = new Button("Small Button");
        Button bigBtn = new Button("This is a big button");

        Group root = new Group();
        root.getChildren().addAll(bigBtn, smallBtn);

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }
}
