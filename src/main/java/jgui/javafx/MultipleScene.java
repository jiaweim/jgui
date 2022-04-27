package jgui.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MultipleScene extends Application
{
    private Stage window;
    private Scene scene1, scene2;

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {

        this.window = primaryStage;

        Label label1 = new Label("Welcome to the first scene!");
        Button button1 = new Button("Go to scene 2");
        button1.setOnAction(e -> window.setScene(scene2));

        // Layout1, children are laid out in vertical column
        VBox layout1 = new VBox();
        layout1.getChildren().addAll(label1, button1);
        scene1 = new Scene(layout1, 200, 300);

        // Button 2
        Button button2 = new Button("This scene sucks, go back to scene 1");
        button2.setOnAction(e -> window.setScene(scene1));

        // layout 2
        StackPane layout2 = new StackPane();
        layout2.getChildren().add(button2);
        scene2 = new Scene(layout2, 400, 600);

        window.setScene(scene1);
        window.setTitle("Title here");
        window.show();
    }
}
