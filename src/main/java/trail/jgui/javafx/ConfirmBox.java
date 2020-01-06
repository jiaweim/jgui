package trail.jgui.javafx;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * @author JiaweiMao on 2017.06.20
 * @since 1.0-SNAPSHOT
 */
public class ConfirmBox
{

    static boolean answer;

    public static boolean display(String title, String msg)
    {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(300);

        Label label = new Label();
        label.setText(msg);

        Button closeBtn = new Button("Close the window");
        closeBtn.setOnAction(e -> window.close());

        Button yesBtn = new Button("Yes");
        Button noBtn = new Button("No");

        yesBtn.setOnAction(e -> {
            answer = true;
            window.close();
        });

        noBtn.setOnAction(e -> {
            answer = false;
            window.close();
        });

        VBox layout = new VBox();
        layout.setSpacing(10);
        layout.getChildren().addAll(label, yesBtn, noBtn);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

        return answer;
    }

}
