package trail.jgui.javafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LayoutMain extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        primaryStage.setTitle("GridPane test");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        // Name label
        Label nameLable = new Label("Username:");
        GridPane.setConstraints(nameLable, 0, 0);

        // Name input
        TextField nameInput = new TextField("Bucky");
        GridPane.setConstraints(nameInput, 1, 0);

        // password label
        Label passLabel = new Label("Password:");
        GridPane.setConstraints(passLabel, 0, 1);

        // password input
        TextField passInput = new TextField();
        passInput.setPromptText("password");
        GridPane.setConstraints(passInput, 1, 1);

        Button loginButton = new Button("Log In");
        GridPane.setConstraints(loginButton, 1, 2);

        grid.getChildren().addAll(nameLable, nameInput, passLabel, passInput, loginButton);

        Scene scene = new Scene(grid, 300, 200);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
