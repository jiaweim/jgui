package jgui.javafx.layout;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

import java.time.Month;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 18 Jan 2018, 12:28 PM
 */
public class TilePaneTest extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        double hgap = 5.0;
        double vgap = 5.0;
        TilePane root = new TilePane(hgap, vgap);
        root.setPrefColumns(5);

        for (Month month : Month.values()) {
            Button b = new Button(month.toString());
            b.setMaxHeight(Double.MAX_VALUE);
            b.setMaxWidth(Double.MAX_VALUE);
            root.getChildren().add(b);
        }

        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("A Horizontal TilePane");
        primaryStage.show();
    }
}
